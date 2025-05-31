# To dockerise an app you need what is called a base image
# this image contains everything your programing language needs to run
# think of it as installing java onto the image to run code in it
FROM eclipse-temurin:21-jdk-alpine

# These two lines just create two folders on the docker
WORKDIR /app
VOLUME /tmp

# This will copy our jar into a jar with a normal name
# no other reason but simplicity
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

# This is the same exact command we ran in our terminal
# The jar is just replaced with the app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]