REM Installation script for all modules
call mvn clean install -DskipTests
cd template-poc
call npm i
cd ../spring-web-poc/src/main/webapp
call npm i
cd ../../../../spring-react-flux-poc/src/main/webapp
call npm install
cd ../webapp-client
call npm i
call gulp build
cd ../../../../