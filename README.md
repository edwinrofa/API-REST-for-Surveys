"# API-REST-for-Surveys" 
The api rest can run with H2 database, or mysql.

1. Comand line:
user> mvn spring-boot:run

2. The API can be tested with swagger. Go to browser and enter:
http://localhost:8080/swagger-ui.html

The url for test:

http://localhost:8080/survey/show-survey

http://localhost:8080/survey/survey-register

http://localhost:8080/survey/view-all-survey-responses

3. Using swagger and the Rest service: http://localhost:8080/survey/survey-register, the survey register can be tested by checking the functional test folder

4. Using the terminal, you can try the following commands:

curl -X GET "http://localhost:8080/survey/show-survey" -H "accept: application/json;charset=UTF-8"

curl -X POST "http://localhost:8080/survey/survey-register" -H "accept: text/plain" -H "Content-Type: application/json;charset=UTF-8" -d "{ \"dateSurvey\": \"2022-01-06T04:52:58.877Z\", \"customer\": { \"id\": 0, \"name\": \"Eduardo\", \"lastname\": \"Salazar\", \"identification\": \"1324564\", \"registrationDate\": \"2022-01-06T04:52:58.877Z\" }, \"surveyId\": 1, \"customerResponseList\": [ { \"openResponse\": \"Me gusta el salmón frito\", \"questionId\": 1 }, { \"openResponse\": \"Sí le hablaría a mis amigos y familia\", \"questionId\": 2 }, { \"openResponse\": \"Sí compartiría en redes sociales el restaurante\", \"questionId\": 3 }, { \"option\": { \"id\": 2, \"optionMultipleSelection\": \"Martes\", \"questionId\": 4 }, \"questionId\": 4 }, { \"option\": { \"id\": 9, \"optionMultipleSelection\": \"Medio día\", \"questionId\": 5 }, \"questionId\": 5 }, { \"openResponse\": \"La presentación de las comidas es muy buena\", \"questionId\": 6 }, { \"openResponse\": \"El tiempo de entrega es muy rápido\", \"questionId\": 7 } ] }"


curl -X GET "http://localhost:8080/survey/view-all-survey-responses" -H "accept: application/json;charset=UTF-8"

5. The default questions are initialized inside the object: 

https://github.com/edwinrofa/API-Rest-of-Surveys/blob/main/src/main/java/com/consumersurvey/ConsumerSurveyApplication.java


