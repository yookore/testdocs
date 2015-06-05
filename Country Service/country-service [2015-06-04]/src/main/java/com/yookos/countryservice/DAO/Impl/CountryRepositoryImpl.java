package com.yookos.countryservice.DAO.Impl;

import com.yookos.countryservice.DAO.CountryRepository;
import com.yookos.countryservice.models.City;
import com.yookos.countryservice.models.CityData;
import com.yookos.countryservice.models.Country;
import com.yookos.countryservice.models.Region;
import org.springframework.hateoas.ResourceSupport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tshiamotaukobong on 15/05/19.
 * Private methods(Not included in javadoc) are helper methods for public called methods
 */
public class CountryRepositoryImpl implements CountryRepository {
    private Connection con;
    private ResultSet resultSet;
    private Statement statement;

    private String dbDriver = "com.mysql.jdbc.Driver";
    private String dbUrl = "jdbc:mysql://localhost/countryservice";
    private String dbUsername = "root";
    private String dbPassword = "";


    public Connection getCon() {
        return con;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public CountryRepositoryImpl() {
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    @Override
    public void connetToDB() {
        try {
            Class.forName(dbDriver).newInstance();
            System.out.println("driver true");
            //con = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net",
            //	"sql677701", "uQ9%lZ1*");
            con = DriverManager.getConnection(dbUrl,
                    dbUsername, dbPassword);


            if (!con.isClosed()) {
                System.out.println("Successfully connected to "
                        + "database using TCP/IP...");

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Exception: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    //con.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public void closeConnection()
    {
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<City> getCitiesByRegion(int rig_id) {
        List<City> citiesList = new ArrayList<City>();
        try {
            System.out.println(":: about to make a connection to our repo ::");
            if (con != null && !con.isClosed()) {
                statement = con.createStatement();
                resultSet = statement.executeQuery("SELECT cit_id, cit_name, rig_id FROM City " +
                        " WHERE rig_id = " + rig_id +
                        " order by cit_name");
                while (resultSet.next()) {
                    citiesList.add(new City(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return citiesList;
    }

    @Override
    public List<Region> getRegionsByCountry(int con_id) {
        List<Region> regionsList = new ArrayList<Region>();
        try {
            System.out.println(":: about to make a connection to our repo ::");
            if (con != null && !con.isClosed()) {
                statement = con.createStatement();
                resultSet = statement.executeQuery("SELECT rig_id, rig_name, con_id FROM Region " +
                        " where con_id = " + con_id +
                        " order by rig_name");
                while (resultSet.next()) {
                    regionsList.add(new Region(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return regionsList;
    }

    @Override
    public List<Country> getCountries() {
        List<Country> countryList = new ArrayList<Country>();
        try {
            System.out.println(":: about to make a connection to our repo ::");
            if (con != null && !con.isClosed()) {
                statement = con.createStatement();
                resultSet = statement.executeQuery("SELECT con_id, con_name FROM Country" +
                        " order by con_name");
                while (resultSet.next()) {
                    countryList.add(new Country(resultSet.getInt(1), resultSet.getString(2)));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countryList;
    }

    @Override
    public List<CityData> searchCities(String name, int limit, int page) {
        List<CityData> cityDataList = new ArrayList<CityData>();
        limit = limit<1?1:limit;
        page = page<1?1:page;
        name = name.trim();
        try {
            System.out.println(":: about to make a connection to our repo ::");
            if (con != null && !con.isClosed()) {
                statement = con.createStatement();
                String sqlQ = "SELECT cit_id, cit_name, City.rig_id, Region.con_id," +
                        " rig_name, con_name " +
                        " FROM Country, Region, City " +
                        " WHERE UPPER(cit_name) like UPPER('%" + name + "%') " +
                        " AND City.rig_id = Region.rig_id AND Region.con_id = Country.con_id " +
                        " ORDER BY LENGTH(cit_name) " +
                        " LIMIT " + (limit*page) + " OFFSET " + ((page*limit)-limit) + (page!=1?1:0);
                resultSet = statement.executeQuery(sqlQ);

                System.out.print(sqlQ);
                while (resultSet.next()) {
                    cityDataList.add(new CityData(new City(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)),
                            new Region(resultSet.getInt(3),resultSet.getString(5),resultSet.getInt(4)),
                                    new Country(resultSet.getInt(4),resultSet.getString(6))));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cityDataList;
    }

    /**
     * Inserts a new record for: City or (City and Region) or All 3 entities
         depending on what is found in the database */
    @Override
    public CityData addCityData(String cit_name, String rig_name, String con_name) {


        cit_name = toInitCap(cit_name.trim());
        rig_name = toInitCap(rig_name.trim());
        con_name = toInitCap(con_name.trim());
        Country country = findCountry(con_name);
        if(country!=null) // If country is not found, new Record for all entities.
        {
            City city = findCity(cit_name,country);
            if(city!=null) // If city is found with the found Country, obviously Region exists.--No new Records
                return new CityData(city,findRegion(city.getRig_id()),country);
            else //A region is attempted to be found by name, either as default 'Other' if not provided
            {
                Region region = findRegion(rig_name,country);
                if(region!=null)//If region is found, only city is inserted as a new record
                   return insertCityRecord(cit_name,region,country);
                else//Only country is found so City and Region are new records
                    return insertCityRecord(cit_name,rig_name,country);
            }
        }

        return insertCityRecord(cit_name,rig_name,con_name);
    }

    /**
     * Inserts all 3 entities with a relationship among them*/
    private CityData insertCityRecord(String cit_name, String rig_name, String con_name)
    {


        City city = null;
        Region region = null;
        Country country = null;
        try {
            System.out.println(":: about to make a connection to our repo ::");
            if (con != null && !con.isClosed()) {
                statement = con.createStatement();
                String sqlQ = "\nINSERT INTO Country (con_name) VALUES ('"+con_name+"')";
                int inserted = statement.executeUpdate(sqlQ);

                System.out.print(sqlQ);
                if (inserted!=0) {
                    country = getResentInsertedCountry(con_name);
                    statement = con.createStatement();
                    sqlQ = "\nINSERT INTO Region (rig_name,con_id) VALUES ('"+rig_name+"', "+country.getCon_id()+")";
                    inserted = statement.executeUpdate(sqlQ);
                    if(inserted!=0) {
                        region = getResentInsertedRegion(rig_name, country.getCon_id());
                        statement = con.createStatement();
                        sqlQ = "\nINSERT INTO City (cit_name,rig_id) VALUES ('"+cit_name+"', "+region.getRig_id()+")";
                        inserted = statement.executeUpdate(sqlQ);
                        if (inserted!=0)
                            return new CityData(city=getResentInsertedCity(cit_name,region.getRig_id()),region,country);
                    }
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
    *Gets the resent inserted country
    */
    private Country getResentInsertedCountry(String con_name)
    {

        Country country = null;
        try {
            if (con != null && !con.isClosed()) {
                statement = con.createStatement();
                String sqlQ = "\nSELECT con_id FROM Country " +
                        " WHERE con_name = '"+con_name+"'";
                resultSet = statement.executeQuery(sqlQ);
                System.out.print(sqlQ);
                resultSet.next();
                country = new Country(resultSet.getInt(1),con_name);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return country;
    }

    /**
    *Gets the resent inserted country
     */
    private Region getResentInsertedRegion(String rig_name, int con_id)
    {

        Region region = null;
        try {
            if (con != null && !con.isClosed()) {
                statement = con.createStatement();
                String sqlQ = "\nSELECT rig_id FROM Region " +
                        " WHERE con_id = "+con_id+" AND " +
                        " rig_name = '"+rig_name+"'";
                resultSet = statement.executeQuery(sqlQ);
                System.out.print(sqlQ);
                resultSet.next();
                region = new Region(resultSet.getInt(1),rig_name, con_id);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return region;
    }

    /**
     * Gets the resent inserted city*/
    private City getResentInsertedCity(String cit_name, int rig_id)
    {

        City city = null;
        try {
            if (con != null && !con.isClosed()) {
                statement = con.createStatement();
                String sqlQ = "\nSELECT cit_id FROM City " +
                        " WHERE rig_id = "+rig_id+" AND " +
                        " cit_name = '"+cit_name+"'";
                resultSet = statement.executeQuery(sqlQ);
                System.out.print(sqlQ);
                resultSet.next();
                city = new City(resultSet.getInt(1),cit_name, rig_id);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return city;
    }

    /**
     * Inserts two new records(City, Region) linked with the provided country*/
    private CityData insertCityRecord(String cit_name, String rig_name, Country country)
    {

        City city = null;
        Region region = null;

        try {
            if (con != null && !con.isClosed()) {

                statement = con.createStatement();
                String sqlQ = "\nINSERT INTO Region (rig_name,con_id) VALUES ('"+rig_name+"', "+country.getCon_id()+")";
                int inserted = statement.executeUpdate(sqlQ);
                if(inserted!=0) {
                    region = getResentInsertedRegion(rig_name, country.getCon_id());
                    statement = con.createStatement();
                    sqlQ = "\nINSERT INTO City (cit_name,rig_id) VALUES ('"+cit_name+"', "+region.getRig_id()+")";
                    inserted = statement.executeUpdate(sqlQ);
                    if (inserted!=0)
                        return new CityData(city=getResentInsertedCity(cit_name,region.getRig_id()),region,country);

                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    private CityData insertCityRecord(String cit_name, Region region, Country country)
    {
        /*Inserts one new records(City) linked with the provided Region and Country*/
        City city = null;

        try {
            if (con != null && !con.isClosed()) {
                statement = con.createStatement();
                String sqlQ = "\nINSERT INTO City (cit_name,rig_id) VALUES ('"+cit_name+"', "+region.getRig_id()+")";
                int inserted = statement.executeUpdate(sqlQ);
                if (inserted!=0)
                    return new CityData(city=getResentInsertedCity(cit_name,region.getRig_id()),region,country);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Country findCountry(String con_name)
    {
        try {
            if (con != null && !con.isClosed()) {
                statement = con.createStatement();
                String sqlQ = "\nSELECT con_id, con_name FROM Country" +
                        " WHERE UPPER(con_name) = UPPER('"+con_name+"')";
                System.out.print(sqlQ);
                resultSet = statement.executeQuery(sqlQ);
                if(resultSet.next())
                    return new Country(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Finds the exact match of the region name with the corresponding country
     */
    private Region findRegion(String rig_name, Country country)
    {

        try {
            if (con != null && !con.isClosed()) {
                statement = con.createStatement();
                String sqlQ = "\nSELECT rig_id FROM Region " +
                        " WHERE con_id = "+country.getCon_id()+" AND " +
                        " UPPER(rig_name) = UPPER('"+rig_name+"')";
                resultSet = statement.executeQuery(sqlQ);
                System.out.print(sqlQ);
                if(resultSet.next())
                    return new Region(resultSet.getInt(1),rig_name, country.getCon_id());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Finds the exact region
     */
    private Region findRegion(int rig_id)
    {

        try {
            if (con != null && !con.isClosed()) {
                statement = con.createStatement();
                String sqlQ = "\nSELECT rig_name, con_id FROM Region " +
                        " WHERE rig_id = "+rig_id;
                resultSet = statement.executeQuery(sqlQ);
                System.out.print(sqlQ);
                if(resultSet.next())
                    return new Region(rig_id,resultSet.getString(1), resultSet.getInt(2));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private City findCity(String cit_name, Country country)
    {
        try {
            if (con != null && !con.isClosed()) {
                statement = con.createStatement();
                String sqlQ = "\nSELECT cit_id, Region.rig_id FROM City, Country, Region " +
                        " WHERE City.rig_id = Region.rig_id AND " +
                        " Region.con_id = "+country.getCon_id()+" AND " +
                        " UPPER(cit_name) = UPPER('"+cit_name+"')";
                resultSet = statement.executeQuery(sqlQ);
                System.out.print(sqlQ);
                if(resultSet.next())
                    return new City(resultSet.getInt(1),cit_name, resultSet.getInt(2));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String toInitCap(String param) {
        if(param != null && param.length()>0){
            char[] charArray = param.toCharArray(); // convert into char array
            charArray[0] = Character.toUpperCase(charArray[0]); // set capital letter to first postion
            return new String(charArray); // return desired output
        }else{
            return "";
        }
    }
}