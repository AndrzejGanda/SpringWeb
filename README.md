

## Prerequirements

1. Java 17
2. Maven 3.6.3

## Build & run
Run in project root directory:  
`mvn spring-boot:run`

## Api documentation
Aplication runs on port 8080.
### 1. Endpoint to get sum of user stars from all repos 
**Request**  
Method: GET 
http://localhost:8080/github/users/{userName}/repositories/sumstars

**Response**  
```json
[
  { 
    "html_url": " ",
    "stargazers_count": 0
  }
]
```  
Example:
http://localhost:8080/github/users/octocat/repositories/sumstars

### 2. Endpoint to get all user repositories

**Request**  
Method: GET  
http://localhost:8080/github/users/{userName}/repositories  

**Response** 
```json
{
  "stargazers_count": 0
}
```
Example:  
http://localhost:8080/github/users/octocat/repositories