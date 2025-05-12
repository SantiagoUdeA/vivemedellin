FROM openjdk:17
EXPOSE 8080
AND target/valoracion_comentarios.jar valoracion_comentarios.jar
LABEL authors="Santiago Zapata Barahona"

ENTRYPOINT ["top", "-b"]