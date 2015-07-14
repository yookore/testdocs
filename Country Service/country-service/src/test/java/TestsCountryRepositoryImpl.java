/**
 * Created by tshiamotaukobong on 15/05/28.
 */
import com.yookos.countryservice.Application;
import com.yookos.countryservice.DAO.CountryRepository;
import com.yookos.countryservice.models.City;
import com.yookos.countryservice.models.CityData;
import com.yookos.countryservice.models.Country;
import com.yookos.countryservice.models.Region;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TestsCountryRepositoryImpl {

    @Autowired
    private CountryRepository conRepository;

    /**
     *An embedded database(SQLite) is used for testing purpose. It is created during test and deleted just before the test completes.
      The file is test.db created in root directory of the Intellij Spring Webservice project.
    <br/>
     *It used the SQLite depedencey .jar file for database driver pulled by gradle(See gradle dependancies file ‘build.gradle’).
    <br/>
     *Basic records are inserted into the SQLite database test.db to test all the persistence methods that uses the MySQL
      at the actual application runtime.
     <p/>
     Input - provided by setter, not accepted by the method connectToDB<br/>
     —-<br/>
     1.Database absolute URL including Database name: String URL<br/>
     2.Databse driver String<br/>
     3.Database username not used in testing as SQLite does not support authentication<br/>
     4.Database password not used in testing as SQLite does not support authentication<br/>
    */
    @Before
    public void initializes()
    {


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

        Connection con = conRepository.getCon();
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
     *Tests the databaseConnect to method, assert if the Connection is not null and is open.
     */
    @Test
    public  void testConnectToDB() throws SQLException {
        assertNotNull("Database Connection is null", conRepository.getCon());
        assertTrue("Database Connection is not open", !conRepository.getCon().isClosed());
    }

    /**
     *Tests the searchCity sql queries by parsing "Ba " String and and assert the array list if it's not null
      and retrived records.
     */
    @Test
    public void testSearchCity()
    {
        List<CityData> cityData = conRepository.searchCities("Ba ", 30, 1);
        assertNotNull("List of CityData is null",cityData);
        assertTrue(cityData.size()>0);
    }

    /**
     *Tests the addCity sql, logic and syntax together with several private methods called.
     <br/>
     * Tests the add all records, City Region and Country if Country was not found.
     <br/>
     * Tests the add only City if country was found. City not found.
     <br/>
     * Tests if it will return same records if the city exits in the database. Region doesn't have to be passed.
     It is retrieved based on the found country and city.
     */
    @Test
    public void testAddCityData()
    {
        CityData cityData = conRepository.addCityData("Johannesburg", "Gauteng", "South Africa");
        assertEquals("City returned unexpected results", "Johannesburg",cityData.getCity().getCity_name());
        assertEquals("City returned unexpected results", "Gauteng",cityData.getRegion().getRegion_name());
        assertEquals("City returned unexpected results", "South Africa", cityData.getCountry().getCountry_name());

        cityData = conRepository.addCityData("Randburg", "Gauteng", "South Africa");
        assertEquals("City returned unexpected results", "Randburg",cityData.getCity().getCity_name());
        assertEquals("City returned unexpected results", "Gauteng",cityData.getRegion().getRegion_name());
        assertEquals("City returned unexpected results", "South Africa", cityData.getCountry().getCountry_name());

        cityData = conRepository.addCityData("Johannesburg", "Other", "South Africa");
        assertEquals("City returned unexpected results", "Johannesburg",cityData.getCity().getCity_name());
        assertEquals("City returned unexpected results", "Gauteng",cityData.getRegion().getRegion_name());
        assertEquals("City returned unexpected results", "South Africa", cityData.getCountry().getCountry_name());
    }

    /**
     *Assert if the get all Countries List is null
     * and retrieved records
     */
    @Test
    public void testGetCountries()
    {
        List<Country> countriesList = conRepository.getCountries();
        assertNotNull(countriesList);
        assertTrue(countriesList.size()>0);
    }

    /**
     *Assert if the get Regions by Country Id List is null
     * and retrieved records some records
     */
    @Test
    public void testGetRegionsByCountry()
    {
        List<Region> regionList = conRepository.getRegionsByCountry(3);
        assertNotNull(regionList);
        assertTrue(regionList.size()>0);
    }

    /**
     *Assert if the get Cities by Region Id List is null
     * and retrieved records some records
     */
    @Test
    public void testCitiesByRegion()
    {
        List<City> citiesList = conRepository.getCitiesByRegion(127);
        assertNotNull(citiesList);
        assertTrue(citiesList.size()>0);
    }

    /**
     * Close the SQLite database and deletes the test.db file
     */
    @After
    public void closes()
    {
        conRepository.closeConnection();
        File databaseFile = new File("test.db");
        if(databaseFile.exists()) {
            databaseFile.delete();
            System.out.println("test.db is deleted");
        }else System.out.println("test.db is not deleted");
    }
}
