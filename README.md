# Reserveration

A project with Springboot, Java SE 17, Gradle, Postgres, docker, junittest

curl -d '{"performanceId":1,"costumerId":15,"reservationAmount":3}' -H 'Content-Type: application/json' http://127.0.0.1:8080/api/reservation

curl -d '{"performanceId":1,"totalBooking":3}' -H 'Content-Type: application/json' http://127.0.0.1:8080/api/sumBooking
