# CountryService

VM Country Server:
>http://192.168.10.20:8081

POC Country Server:
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
        **GET** /countryserivce/cities/:cityname HTTP/1.1
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
            “city”: “{“cit_id”:”2983712”,“cit_name”:”Joburg”,”rig_id”:”20181”}”,
            “region”: “{“rig_id”:”20181”,”rig_name”:”Gauteng”,”con_id”:”213”}”,
            “country”: “{“con_id”:”213”,”con_name”:”South Africa”}”
        },
        {
            “city”: “{“cit_id”:”2983712”,“cit_name”:”Joburg”,”rig_id”:”20181”}”,
            “region”: “{“rig_id”:”20181”,”rig_name”:”Gauteng”,”con_id”:”213”}”,
            “country”: “{“con_id”:”213”,”con_name”:”South Africa”}”
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
      **POST** /countryservice/cities HTTP/1.1
      ```
    + Headers
      ```
      Content-Type : multipart/form-data
      ```
    + Payload
    
    ```
                            ------WebKitFormBoundaryNFVXSZm2W1vSnnBy-------
    Content-Disposition: form-data; city=“Joburg”; country="South Africa“; region=“Gauteng”(OPTIONAL)
    Content-Type: multipart/form-data
    ```

    ```
    + Response Payload (newly added city data)
    {
        “city”: “{“cit_id”:”2983712”,”rig_id”:”20181”,“cit_name”:”Joburg”}”,
        “region”: “{“rig_id”:”20181”,”con_id”:”213”,”rig_name”:”Gauteng”}”,
        “country”: “{“con_id”:”213”,”con_name”:”South Africa”}”
    }
    ```

------------------------------------------------------------------------------


### Get list of world countries
This method retrieves the json array payload representing list of world countries.
+ Request
    + Method
      ```
      **GET** /countryserivce/countries HTTP/1.1
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
        {"con_id":1,"con_Name":"Afghanistan","_links":
            {"regions":
                {"href":"http://localhost:8080/countryservice/countries/1/regions"}
            }
        },
        {"con_id":2,"con_Name":"Albania","_links":
            {"regions":
                {"href":"http://localhost:8080/countryservice/countries/2/regions"}
            }
        }
        ...
    ]
    ```

------------------------------------------------------------------------------
