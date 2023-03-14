# Tariff Showcase

Prerequisites
-----------

* Installed Java JDK 17
* Installed Maven
* Installed Docker
* Installed Postman (for sending http requests and get responses)
* Installed Git (optional, to clone from repository)
* Some text editor/IDE for editing configuration files (optional)

How to run application locally
------------

1. Clone java-test-task repository from GitHub \
   [git@github.com:GlebKl1/java-test-task.git] (https://github.com/GlebKl1/java-test-task.git)
2. Run `docker-compose up --build
3. The application is not available on localhost port 8080
4. Use requests from Specification to send requests to the server and get response from it

## Requests(API usage)
1. curl http://localhost:8080/tariffs - returns Set of unarchived tariffs.
2. curl http://localhost:8080/tariffs?isArchived=true - returns Set of archived tariffs
3. curl http://localhost:8080/tariffs/internet/unlimited - returns Set of tariffs, that have unlimited internet included
4. curl http://localhost:8080/tariffs/calls/unlimited - returns Set of tariffs, that have unlimited calls included
5. curl -H "Content-Type: application/json" -XPOST -d '{                     
   "name": "testName",
   "packageServices": [
   {                  
   "name": "name",
   "category": "CALLS",
   "value": -1
   }
   ]                             
   }' 'http://localhost:8080/tariffs' - save the resource
