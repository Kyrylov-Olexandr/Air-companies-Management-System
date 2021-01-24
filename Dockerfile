FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=out/artifacts/main_jar/main.jar
COPY ${JAR_FILE} /main.jar
ENTRYPOINT ["java","-jar","main.jar"]