import com.yookos.countryservice.Application;
import com.yookos.countryservice.DAO.CountryRepository;
import com.yookos.countryservice.DAO.Impl.CountryRepositoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by tshiamotaukobong on 15/06/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestCountryServiceIT {
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
    private CountryRepository service =  new CountryRepositoryImpl();

    private MockMvc mockMvc;
    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    private static int RIG_ID = 0, CON_ID = 0;
    private static String CITY = null;


    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     *An embedded database(SQLite) is used for testing purpose. It is created during test and deleted just before the test completes.
     The file is test.db created in root directory of the Intellij Spring Webservice project.
     <br>
     *It used the SQLite depedencey .jar file for database driver pulled by gradle(See gradle dependancies file ‘build.gradle’).
     <br>
     *Basic records are inserted into the SQLite database test.db to test all the persistence methods that uses the MySQL
     at the actual application runtime.
     <p>
     Input - provided by setter, not accepted by the method connectToDB<br>
     —-<br>
     1.Database absolute URL including Database name: String URL<br>
     2.Databse driver String<br>
     3.Database username not used in testing as SQLite does not support authentication<br>
     4.Database password not used in testing as SQLite does not support authentication<br>
     */
    @Before
    public void initializes()
    {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        service.setDbDriver("org.sqlite.JDBC");
        service.setDbUrl("jdbc:sqlite:test.db");
        service.setDbPassword("123");

        File databaseFile = new File("test.db");
        if(databaseFile.exists()) {
            databaseFile.delete();
            System.out.println("test.db is deleted");
        }
        service.connetToDB();


        String createCitySql = "CREATE TABLE IF NOT EXISTS `City` (\n" +
                "  `cit_id` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  `cit_name` varchar(100) NOT NULL,\n" +
                "  `rig_id` bigint(20) NOT NULL,\n" +
                "  `cit_creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                "  `cit_modification_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP\n" +
                ") ";

        String createCountrySql = "CREATE TABLE IF NOT EXISTS `Country` (\n" +
                "  `con_id` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  `con_name` varchar(100) NOT NULL,\n" +
                "  `con_creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                "  `con_modification_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP\n" +
                ") ";

        String createRegionSql = "CREATE TABLE IF NOT EXISTS `Region` (\n" +
                "  `rig_id` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  `rig_name` varchar(100) NOT NULL,\n" +
                "  `con_id` bigint(20) NOT NULL,\n" +
                "  `rig_creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                "  `rig_modification_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP\n" +
                ") ";



        Connection con = service.getCon();
        if(con!=null)
        {
            try {
                Statement stmt = con.createStatement();
                if(stmt.executeUpdate(createCitySql)>0)
                    System.out.println("City Table Created");
                else System.out.println("City Table failed to create");

                if(stmt.executeUpdate(createRegionSql)>0)
                    System.out.println("Region Table Created");
                else  System.out.println("Region Table failed to create");

                if(stmt.executeUpdate(createCountrySql)>0)
                    System.out.println("Country Table Created");
                else  System.out.println("Country Table failed to create");

                String insertCities = "INSERT INTO `City` (`cit_id`, `cit_name`, `rig_id`, `cit_creation_date`, `cit_modification_date`) VALUES\n" +
                        "(1, 'Ekaem', 1, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(2, 'Fayzbd', 1, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(3, 'Handd', 1, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(4, 'Jurm', 1, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(5, 'Qal''eh-ye Panjeh', 1, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(8, 'Balh', 2, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(9, 'Dawltbd', 2, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(10, 'Mazr-e arf', 2, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(11, 'Qarchi Gak', 2, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(12, 'Ta Gozar', 2, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(13, 'ulgara', 2, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(15, 'Andarb', 3, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(16, 'Baln', 3, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(17, 'Dahaneh-ye awri', 3, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(18, 'Nahrn', 3, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(19, 'Pol-e Humr', 3, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(22, 'Bl Morb', 4, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(23, 'Qal''eh-ye Naw', 4, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(25, 'Bmyn', 5, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(26, 'Panjb', 5, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(27, 'Qil Qal''eh', 5, '2015-05-28 15:49:40', '2015-05-28 15:49:40')," +
                        "(153, 'Berat', 64, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(154, 'Polian', 64, '2015-05-28 15:49:40', '2015-05-28 15:49:40')," +
                        "(156, 'Bulqiz', 65, '2015-05-28 15:49:40', '2015-05-28 15:49:40')," +
                        "(157, 'Delvin', 66, '2015-05-28 15:49:40', '2015-05-28 15:49:40')," +
                        "(239, 'Adrar', 127, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(240, 'Akabli', 127, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(241, 'Aougrout', 127, '2015-05-28 15:49:40', '2015-05-28 15:49:40')," +
                        "(270, 'Ain Bouyahia', 128, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(271, 'Ain Defla', 128, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(272, 'Ain Soltane', 128, '2015-05-28 15:49:40', '2015-05-28 15:49:40')," +
                        "(301, 'Aghlal', 129, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(302, 'Ain Temouchent', 129, '2015-05-28 15:49:40', '2015-05-28 15:49:40'),\n" +
                        "(303, 'Aoubellil', 129, '2015-05-28 15:49:40', '2015-05-28 15:49:40')";

                String insertRegions = "INSERT INTO `Region` (`rig_id`, `rig_name`, `con_id`, `rig_creation_date`, `rig_modification_date`) VALUES\n" +
                        "(1, 'Badahan', 1, '2015-05-28 15:52:08', '2015-05-28 15:52:08'),\n" +
                        "(2, 'Balh', 1, '2015-05-28 15:52:08', '2015-05-28 15:52:08'),\n" +
                        "(3, 'Baln', 1, '2015-05-28 15:52:08', '2015-05-28 15:52:08'),\n" +
                        "(4, 'Bdgs', 1, '2015-05-28 15:52:08', '2015-05-28 15:52:08'),\n" +
                        "(5, 'Bmiyn', 1, '2015-05-28 15:52:08', '2015-05-28 15:52:08')," +
                        "(64, 'Berat', 2, '2015-05-28 15:52:08', '2015-05-28 15:52:08'),\n" +
                        "(65, 'Bulqiz', 2, '2015-05-28 15:52:08', '2015-05-28 15:52:08'),\n" +
                        "(66, 'Delvin', 2, '2015-05-28 15:52:08', '2015-05-28 15:52:08')," +
                        "(127, 'Adrar', 3, '2015-05-28 15:52:08', '2015-05-28 15:52:08'),\n" +
                        "(128, 'Ain Defla', 3, '2015-05-28 15:52:08', '2015-05-28 15:52:08'),\n" +
                        "(129, 'Ain Temouchent', 3, '2015-05-28 15:52:08', '2015-05-28 15:52:08')";

                String insertCountries = "INSERT INTO `Country` (`con_id`, `con_name`, `con_creation_date`, `con_modification_date`) VALUES\n" +
                        "(1, 'Afghanistan', '2015-05-28 15:51:09', '2015-05-28 15:51:09'),\n" +
                        "(2, 'Albania', '2015-05-28 15:51:09', '2015-05-28 15:51:09'),\n" +
                        "(3, 'Algeria', '2015-05-28 15:51:09', '2015-05-28 15:51:09')";

                if(stmt.executeUpdate(insertCities)>0)
                    System.out.println("Cities inserted");
                else System.out.println("Cities failed to insert");

                if(stmt.executeUpdate(insertRegions)>0)
                    System.out.println("Regions inserted");
                else  System.out.println("Region failed to insert");

                if(stmt.executeUpdate(insertCountries)>0)
                    System.out.println("Countries inserted");
                else  System.out.println("Countries failed to insert");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * /countryservice/{rig_id}/cities<br>
     * Asserts that the Json array index 0, 1, 2 contains cit_id, cit_name, rig_id respectively
     * @throws Exception Exception
     */
    @Test
    public void getCitiesByRegion() throws Exception {
        this.RIG_ID = 1;
        mockMvc.perform(get("/countryservice/"+this.RIG_ID+"/cities"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.[0]", hasKey("cit_id")))
                .andExpect(jsonPath("$.[1]", hasKey("cit_name")))
                .andExpect(jsonPath("$.[2]", hasKey("rig_id")));
    }

    /**
     * /countryservice/{con_id}/regions<br>
     * Asserts that the Json array index 1, 2, 3 contains con_id, rig_name, rig_id respectively
     * @throws Exception Exception
     */
    @Test
    public void getRegionsByCountry() throws Exception {
        this.CON_ID = 1;
        mockMvc.perform(get("/countryservice/"+this.CON_ID+"/regions"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.[1]", hasKey("con_id")))
                .andExpect(jsonPath("$.[2]", hasKey("rig_name")))
                .andExpect(jsonPath("$.[3]", hasKey("rig_id")));
    }

    /**
     * /countryservice/countries<br>
     * Asserts that the Json array index 1, 2 contains con_id, con_name respectively
     * @throws Exception Exception
     */
    @Test
    public void getCountries() throws Exception {

        mockMvc.perform(get("/countryservice/countries"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.[1]", hasKey("con_id")))
                .andExpect(jsonPath("$.[2]", hasKey("con_name")));
    }

    /**
     * /countryservice/city/{city} <br>
     * Asserts that the Json array index 0, 1, 1 and 4 zeros contains city, region, country respectively and <br>
       inside city, contaions cit_name and cit_name contains a matching string of 'Ain' as passed on the search.<br>
     * Asserts that region and country has keys rig_name and con_name respectively.
     * @throws Exception Exception
     */
    @Test
    public void searchCities() throws Exception {
        mockMvc.perform(get("/countryservice/city/Ain"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.[0]", hasKey("city")))
                .andExpect(jsonPath("$.[1]", hasKey("region")))
                .andExpect(jsonPath("$.[1]", hasKey("country")))
                .andExpect(jsonPath("$.[0].city", hasKey("cit_name")))
                .andExpect(jsonPath("$.[0].city.cit_name", containsString("Ain")))
                .andExpect(jsonPath("$.[0].region", hasKey("rig_name")))
                .andExpect(jsonPath("$.[0].country", hasKey("con_name")));
    }

    /**
     * /countryservice/city <br>
     * Assert that the post of adding a new city returns the added results
     * @throws Exception Exception
     */
    @Test
    public void addCityData() throws Exception {
        mockMvc.perform(post("/countryservice/city")
        .contentType(contentType)
                        .param("city","Kwamhlanga")
                .param("region","Mpumalanga")
                .param("country","South Africa")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.city", hasKey("cit_id")))
                .andExpect(jsonPath("$.region", hasKey("rig_name")))
                .andExpect(jsonPath("$.country", hasKey("con_name")))
                .andExpect(jsonPath("$.city.cit_name", is("Kwamhlanga")))
                .andExpect(jsonPath("$.region.rig_name", is("Mpumalanga")))
                .andExpect(jsonPath("$.country.con_name", is("South Africa")));
    }

    /**
     * Close the SQLite database and deletes the test.db file
     */
    @After
    public void closes()
    {
        service.closeConnection();
        File databaseFile = new File("test.db");
        if(databaseFile.exists()) {
            databaseFile.delete();
            System.out.println("test.db is deleted");
        }else System.out.println("test.db is not deleted");
    }
}
