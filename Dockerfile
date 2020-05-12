FROM openjdk:8-jre-alpine

COPY target/music_room-0.0.1-SNAPSHOT.jar /music_room-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8666", "-jar","music_room-0.0.1-SNAPSHOT.jar"]