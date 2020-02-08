if you deploy you soap servie, you indicate the new url in pom.xml if you have change port et context name service

generate client  :

1) mvn package

build project :

2) mvn install

you can test code for ClientManageApplication class with command line :

1) java -jar target\clientManage-0.0.1-SNAPSHOT.jar

Or 

2) mvn spring-boot:run

if you have deployed service, you car run junit test client
