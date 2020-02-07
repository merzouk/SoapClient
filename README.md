if you deploy you soap servie, you indicate the new url in pom.xml if you have change port et context name service

generate client  :

mvn package

build project :

mvn install

you can test code for ClientManageApplication class with command line :

1) java -jar target\clientManage-0.0.1-SNAPSHOT.jar

Or 

mvn spring-boot:run

if you have deployed service, you car run junit test client
