# Construcción
FROM gradle:8.4.0-jdk21 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN #gradle build --no-daemon
RUN gradle bootJar --no-daemon


# Ejecución
FROM eclipse-temurin:21-jre-alpine
RUN mkdir /app

EXPOSE ${PORT}

COPY --from=build /home/gradle/src/build/libs/*.jar /app/barcamp-2024.jar

ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-Dorg.gradle.daemon=false", "-jar", "/app/barcamp-2024.jar"]