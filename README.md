# bidding-system
Supports the auction system

Tech stack:
1. Spring boot
2. Java 8
3. Embedded Tomcat server
4. H2 database
5. REST
6. Maven as building tool
7. Log4j2 as logging framework

I choose this stack as spring boot is very flexible and easy to integrate with any of the spring modules and it provides embedded tomcat server, H2 in memory database and so many benefits.

Selected Maven as the dependency satisfaction and building tool as it is easy to handle and work with and also it is using everywhere in the corporate world.

REST for endpoint exposure as it has no strict contract rather it works on the basis of HTTP methods and resource identifier

Log4j as logging framework as it is also used widely for logging.

Used ConcurrentHashMap to eliminate calls in which item code not exist, place bid is less than the current bid and auction is in OVER state.

H2 DB is in memory so, no changes needs to do.

For tomcat access log and application log needs to change the local path in application.yml for access log and log4j2.xml for application log.

To run the application:

One needs to import the project into IDE(IntelliJ) and build it with the test cases and run the application. It will run the test cases and will up the application.

I used H2 DB so data will be lost once shutdown the application.

Testing Framework:

I used spring boot testing framework and tried to cover different scenarios:
1. Item code not exist
2. Place bid amount is less than the current amount
3. Auction for a given item code is not in RUNNING state.
4. Place bid amount is less than the current bid rate plus step rate
5. Get all the bids with RUNNING state
6. Get all the bids with OVER state

Note: Unfortunately, @RequestBody is not working, I tried everything but didn't work, that's why I used @RequestParam for place bid payload. Sorry for that.

Please find the attached Curl to get Running auctions:

curl -X GET \
  'http://localhost:9100/auction?state=RUNNING' \
  -H 'accept: application/json' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'limit: 10' \
  -H 'offset: 0' \
  -H 'postman-token: 13e0532b-7f59-c6b4-be34-eba2d25a1ac1'


Curl to place the bid request:

curl -X POST \
  'http://localhost:9100/auction/X/bid?bidAmount=200' \
  -H 'accept: application/json' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 249ae0a7-4a1a-ec42-3cc6-18983369859c' \
  -H 'usertoken: token1'


Note: Users gets populated at application startup from the user.csv. so assuming that are the logged users only not maintaining any onboarding cycle for the user

Used the observer pattern to notify all the logged in users which is good to have in the pdf statement
