# Reserveration


A project with Springboot, Java SE 17, Gradle, Postgres, docker, junittest

## Create performance 

 curl -d '{"title" : "performance1"}' -H 'Content-Type: application/json' http://127.0.0.1:8080/api/performance

A TotalBooking should be registed first because of if statement ind i saveReservation

## Create TotalBooking 

curl -d '{"performanceId":1,"totalBooking":0}' -H 'Content-Type: application/json' http://127.0.0.1:8080/api/sumBooking

## Create Reservation 

curl -d '{"performanceId":1,"costumerId":15,"reservationAmount":3}' -H 'Content-Type: application/json' http://127.0.0.1:8080/api/reservation







