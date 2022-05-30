A complaint system
Technology stack used: Java 8, Spring, Kafka, MongoDB

In order to run the project, download/clone the project to your local machine
you need to run the docker-compose file which creates and running Kafka & Mongo, command:
  docker-compose -f docker-compose.yaml up -d

than run the craft demo in another terminal window, command:
  java -jar craft-mock.jar

