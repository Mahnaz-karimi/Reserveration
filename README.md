# Reserveration

A project with intelliJ SpringBoot, Java JDK 18 , Gradle 7.5.1, Postgres, docker, junittest

## To connect the project to Database
File/ Setting/ Plugins -> add DB Navigator -> Restart intelliJ
DB Navigator -> Setting -> add conections

## Create performance 
curl -d '{"title" : "performance1", "totalbooking" : 1}' -H 'Content-Type: application/json' http://127.0.0.1:8080/api/performance

A TotalBooking should be register first because of if statement ind i saveReservation

## Create TotalBooking 

In GitBash:

curl -d '{"performanceId":1,"totalBooking":0}' -H 'Content-Type: application/json' http://127.0.0.1:8080/api/sumBooking

## Create Reservation 

curl -d '{"performanceId":1,"costumerId":15,"reservationAmount":3}' -H 'Content-Type: application/json' http://127.0.0.1:8080/api/reservation

## Configuration of Gradle

![image](https://user-images.githubusercontent.com/72239384/222308815-597bb045-3e70-450c-8bc4-ba86a48228e8.png)

## Update Gradle version

gradlew wrapper --gradle-version <gradle-version>

## For at clean and build gradle manually

./gradlew clean build

## Adding a JDK

File/Project Structure SDK's 

## Project run configuration 

![image](https://user-images.githubusercontent.com/72239384/222249108-58e2c0a7-d278-470d-b3c9-d61fd47a1044.png)

## Add a Gradle dependency
Inside of build.gradle file in the editor -> Alt+Insert -> Add dependency.

## To fix Error "TestEngine"
File -> Invalidate Cache -> Invalidate and Restart
