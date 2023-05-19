FROM openjdk:17

RUN mkdir /petmgmtsys-app

COPY target/ /petmgmtsys-app

WORKDIR /petmgmtsys-app

CMD java -jar PetManagementSystem-0.0.1-SNAPSHOT.jar --spring.config.name=application.properties