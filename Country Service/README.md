# CountryService

VM IP:
>http://192.168.10.20:8081

CF IP:
>http://

All queries are preceded with the server domain and port in the format
``http://<server_ip>:<server_port>``

The CountryService is able to search a cities from the database returning with their Country and Region/Province; Also able to add/update new Cities which are not available in  database together with their countries and regions. And is able to get a list of countries with links pointing to their list of regions and list of regions with links pointing to their list of cities.

## Queries

### Get searched cities data
This method retrieves the json array payload representing list of matched cities data.
+ Request
    + Method
      ```
        **GET** /api/v1/countryservice/cities/:cityname HTTP/1.1
      ```
    + Headers
      ```
      Content-Type : application/json
      ```
      
    -——-Params——--
    <br/>
    ```
        optional query params with default values:
        limit=“40”; page=“1”;
    ```
    
    ```
    + Response Payload
    [
        ...
        {
            “city”: “{“city_id”:”2983712”,“city_name”:”Joburg”,”region_id”:”20181”}”,
            “region”: “{“region_id”:”20181”,”region_name”:”Gauteng”,”country_id”:”213”}”,
            “country”: “{“country_id”:”213”,”country_name”:”South Africa”}”
        },
        {
            “city”: “{“city_id”:”2983712”,“city_name”:”Joburg”,”region_id”:”20181”}”,
            “region”: “{“region_id”:”20181”,”region_name”:”Gauteng”,”country_id”:”213”}”,
            “country”: “{“country_id”:”213”,”country_name”:”South Africa”}”
        }
        ...
    ]
    ```

------------------------------------------------------------------------------


### Adds a new City
This method method adds a new City together with the given country in the params(region optional param) or updates the country’s cities if the country already exists.

+ Request
    + Method
      ```
      **POST** /api/v1/countryservice/cities HTTP/1.1
      ```
    + Headers
      ```
      Content-Type : application/json;charset=UTF-8
      ```
    + Payload
    
    ```
                            ------WebKitFormBoundaryNFVXSZm2W1vSnnBy-------
    Content-Disposition: raw json; city, country, region(OPTIONAL)
    Content-Type: application/json;charset=UTF-8
    
    {"country":"South Africa","region":"Gauteng","city":"Joburg"}
    ```

    ```
    + Response Payload (newly added city data)
    {
        “city”: “{“city_id”:”2983712”,”region_id”:”20181”,“city_name”:”Joburg”}”,
        “region”: “{“region_id”:”20181”,”country_id”:”213”,”region_name”:”Gauteng”}”,
        “country”: “{“country_id”:”213”,”country_name”:”South Africa”}”
    }
    ```

------------------------------------------------------------------------------


### Get list of world countries
This method retrieves the json array payload representing list of world countries.
+ Request
    + Method
      ```
      **GET** /api/v1/countryservice/countries HTTP/1.1
      ```
    + Headers
      ```
      Content-Type : application/json
      ```
    + Payload
    
    ```
    + Response Payload
    [
        ...
        {"country_id":1,"country_name":"Afghanistan","_links":
            {"regions":
                {"href":"http://localhost:8080/countryservice/countries/1/regions"}
            }
        },
        {"country_id":2,"country_name":"Albania","_links":
            {"regions":
                {"href":"http://localhost:8080/countryservice/countries/2/regions"}
            }
        }
        ...
    ]
    ```

------------------------------------------------------------------------------
