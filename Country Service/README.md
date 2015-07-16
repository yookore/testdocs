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
            “city”: “{“cityId”:”2983712”,“cityName”:”Joburg”,”regionId”:”20181”}”,
            “region”: “{“regionId”:”20181”,”regionName”:”Gauteng”,”countryId”:”213”}”,
            “country”: “{“countryId”:”213”,”countryName”:”South Africa”}”
        },
        {
            “city”: “{“cityId”:”2983712”,“cityName”:”Joburg”,”regionId”:”20181”}”,
            “region”: “{“regionId”:”20181”,”regionName”:”Gauteng”,”countryId”:”213”}”,
            “country”: “{“countryId”:”213”,”countryName”:”South Africa”}”
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
        “city”: “{“cityId”:”2983712”,”regionId”:”20181”,“cityName”:”Joburg”}”,
        “region”: “{“regionId”:”20181”,”countryId”:”213”,”regionName”:”Gauteng”}”,
        “country”: “{“countryId”:”213”,”countryName”:”South Africa”}”
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
        {"countryId":1,"countryName":"Afghanistan","countryCode":"ZA","countryDialCode":"+27","_links":
            {"regions":
                {"href":"http://localhost:8080/countryservice/countries/1/regions"}
            }
        },
        {"countryId":2,"countryName":"Albania","countryCode":"ZA","countryDialCode":"+27","_links":
            {"regions":
                {"href":"http://localhost:8080/countryservice/countries/2/regions"}
            }
        }
        ...
    ]
    ```

------------------------------------------------------------------------------
