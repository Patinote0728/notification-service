Verificar:
java -version
mvn -version
docker --version

En la raíz: 
docker compose up -d
mvn test
mvn spring-boot:run

En Postman: 
POST http://localhost:8080/api/v1/notifications
GET http://localhost:8080/api/v1/notifications/user/user-123
Content-Type: application/json

{
  "userId": "user-123",
  "recipient": "estudiante@uco.edu.co",
  "message": "Tu inscripción al evento fue confirmada"
}