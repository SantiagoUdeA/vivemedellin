FROM openjdk:17
EXPOSE 8080
ADD target/valoracion_comentarios.jar valoracion_comentarios.jar
LABEL authors="Santiago Zapata Barahona"

ENTRYPOINT ["java", "-jar", "/valoracion_comentarios.jar"]