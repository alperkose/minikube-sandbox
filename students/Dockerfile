FROM eclipse-temurin:17-jdk as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw verify --fail-never

COPY src src
RUN ./mvnw install -DskipTests

FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /workspace/app/target/students-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","./students-0.0.1-SNAPSHOT.jar"]