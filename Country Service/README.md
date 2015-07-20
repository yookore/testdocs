# CountryService

VM IP:
>http://192.168.10.20:8081

CF IP:
> (currently not provisioned for CF)

All queries are preceded with the server domain and port in the format
``http://<server_ip>:<server_port>``

The CountryService is able to search for cities from it's database of cities, returning a city with it's Country and Region/Province. It is also able to add new Cities and update existing ones to it's  database (along with the new city's country and region). 

## Queries

### Get searched cities data
This method retrieves the json array payload representing list of matched cities data.
+ Request
    + Method
      ```
        **GET** /api/v1/countryservice/cities/{cityname} HTTP/1.1
      ```
    + Headers
      ```
      Content-Type : application/json
      ```
      
    + Params
    	```
        - limit (optional; default=40) 
	- page (optional; default=1)
    	```
    
    ```
    + Response Payload
    [
        ...
        {
            "city": {"id": 491707,"name": "“Joburg”","regionId": 4814},
            "region": {"id": 4814,"name": "Other","countryId": 190},
            "country": {"id": 190,"name": "South Africa"}
        },
        {
            "city": {"id": 491707,"name": "“Joburg”","regionId": 4814},
            "region": {"id": 4814,"name": "Other","countryId": 190},
            "country": {"id": 190,"name": "South Africa"}
        }
        ...
    ]
    ```    

------------------------------------------------------------------------------

### Get searched cities data under specific country
This method retrieves the json array payload representing list of matched cities data.
+ Request
    + Method
      ```
        **GET** /api/v1/countryservice/countries/{countryId}/cities/{cityname} HTTP/1.1
      ```
    + Headers
      ```
      Content-Type : application/json
      ```
      
    + Params
    	```
        - limit (optional; default=40) 
	- page (optional; default=1)
    	```
    
    ```
    + Response Payload
    [
        ...
        {
            "city": {"id": 491707,"name": "“Joburg”","regionId": 4814},
            "region": {"id": 4814,"name": "Other","countryId": 190},
            "country": {"id": 190,"name": "South Africa"}
        },
        {
            "city": {"id": 491707,"name": "“Joburg”","regionId": 4814},
            "region": {"id": 4814,"name": "Other","countryId": 190},
            "country": {"id": 190,"name": "South Africa"}
        }
        ...
    ]
    ```    

------------------------------------------------------------------------------


### Add a new City
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
    Content-Disposition: raw json; city, country, region(OPTIONAL)
    Content-Type: application/json;charset=UTF-8
    
    {"country":"South Africa","region":"Gauteng","city":"Joburg"}
    ```

    ```
    + Response Payload (newly added city data)
    {
        "city": {"id": 491707,"name": "“Joburg”","regionId": 4814},
        "region": {"id": 4814,"name": "Other","countryId": 190},
        "country": {"id": 190,"name": "South Africa"}
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
        {
        "id": 3,
        "name": "Algeria",
        "iso": "DZ",
        "dialCode": "+213",
        "_links": {
            "regions": {
                "href": "http://localhost:8081/api/v1/countryservice/countries/3/regions"
            }
        }
    	},
    	{
        "id": 4,
        "name": "American Samoa",
        "iso": "AS",
        "dialCode": "+1",
        "_links": {
            "regions": {
                "href": "http://localhost:8081/api/v1/countryservice/countries/4/regions"
            }
        }
        ...
    ]
    ```

------------------------------------------------------------------------------

### Get list of regions under specific country
This method retrieves the json array payload representing list of regions.
+ Request
    + Method
      ```
      **GET** /api/v1/countryservice/countries/{regionId}/regions HTTP/1.1
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
        {
        "id": 4024,
        "name": "Gauteng",
        "countryId": 190,
        "_links": {
            "cities": {
                "href": "http://localhost:8081/api/v1/countryservice/regions/4024/cities"
            }
        }
        },
        {
        "id": 4025,
        "name": "KwaZulu Natal",
        "countryId": 190,
        "_links": {
            "cities": {
                "href": "http://localhost:8081/api/v1/countryservice/regions/4025/cities"
            }
        }
    }
        ...
    ]
    ```

------------------------------------------------------------------------------
