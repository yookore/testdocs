package com.yookos.countryservice.DAO.Impl;

import com.yookos.countryservice.DAO.CountryRepository;
import com.yookos.countryservice.models.City;
import com.yookos.countryservice.models.Country;
import com.yookos.countryservice.models.Region;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tshiamotaukobong on 15/05/19.
 */
public class CountryRepositoryImpl implements CountryRepository {
    private Connection con;
    private ResultSet resultSet;
    private Statement statement;

    public CountryRepositoryImpl(){connetToDB();}

    @Override
    public void connetToDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("driver true");
            //con = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net",
            //	"sql677701", "uQ9%lZ1*");
            con = DriverManager.getConnection("jdbc:mysql://localhost/countryservice",
                    "root", "");


            if (!con.isClosed()) {
                System.out.println("Successfully connected to "
                        + "MySQL server using TCP/IP...");

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

    @Override
    public List<City> getCitiesByRegionCountry(String country, String region) {
        List<City> citiesList = new ArrayList<City>();
        try {
            System.out.println(":: about to make a connection to our repo ::");
            if(con != null && !con.isClosed()) {
                statement = con.createStatement();
                resultSet = statement.executeQuery("SELECT con_city, con_id FROM country " +
                        "where UPPER(con_name) = UPPER('"+country+"') " +
                        "and UPPER(con_region) = UPPER('"+region+"') "+
                        "order by con_region");
                while (resultSet.next()) {
                    citiesList.add(new City(resultSet.getInt(2), resultSet.getString(1)));
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return citiesList;
    }

    @Override
    public List<Region> getRegionsByCountry(String country) {
        List<Region> regionsList = new ArrayList<Region>();
        try {
            System.out.println(":: about to make a connection to our repo ::");
            if(con != null && !con.isClosed()) {
                statement = con.createStatement();
                resultSet = statement.executeQuery("SELECT con_region, con_id FROM country " +
                        "where UPPER(con_name) = UPPER('"+country+"') " +
                        "group by con_region " +
                        "order by con_region");
                while (resultSet.next()) {
                    regionsList.add(new Region(resultSet.getInt(2), resultSet.getString(1)));
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return regionsList;
    }

    @Override
    public List<Country> getCountries() {
        List<Country> countryList = new ArrayList<Country>();
        try {
            System.out.println(":: about to make a connection to our repo ::");
            if(con != null && !con.isClosed()) {
                statement = con.createStatement();
                resultSet = statement.executeQuery("SELECT con_name, con_id FROM country group by con_name" +
                        " order by con_name");
                while (resultSet.next()) {
                    countryList.add(new Country(resultSet.getInt(2), resultSet.getString(1)));
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return countryList;
    }
}
