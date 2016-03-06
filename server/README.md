## Spring Boot security example

## / request
call  : curl localhost:8080
result: HaHa
No authentication is required

## /simple
call  : curl localhost:8080/simple
result: {"timestamp":1457177619440,"status":401,"error":"Unauthorized","message":"Full authentication is required to access this resource","path":"/simple"}
No sucsess without any authentication

curl user:user@localhost:8080/simple
{"timestamp":1457177716535,"status":403,"error":"Forbidden","message":"Access is denied","path":"/simple"}
No sucsess with USER Role

## Shutdown
call  : curl -X POST osecom:secure@localhost:8080/shutdown
result: {"message":"Shutting down, bye..."}
POST call for /shutdown with spring.security.user & pass successful

call  : curl -X POST admin:admin@localhost:8080/shutdown
result: {"timestamp":1457177331615,"status":401,"error":"Unauthorized","message":"Bad credentials","path":"/shutdown"}

call  : curl -X POST user:user@localhost:8080/shutdown
result: {"timestamp":1457177490142,"status":401,"error":"Unauthorized","message":"Bad credentials","path":"/shutdown"}