ARG BUILD_IMAGE=maven:3.6-jdk-11-slim
ARG RUNTIME_IMAGE=openjdk:11-jdk-slim

#####################################################

FROM ${BUILD_IMAGE} AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests=true

#####################################################


FROM ${RUNTIME_IMAGE} AS runtime
COPY --from=build /usr/src/app/target/employee-management-system-server-0.0.1-SNAPSHOT.jar /usr/app/
EXPOSE 9000
ENTRYPOINT [ "java","-jar","/usr/app/employee-management-system-server-0.0.1-SNAPSHOT.jar" ]