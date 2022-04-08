FROM openjdk:11
ADD target/es-banco-1.0.0.jar es-banco-1.0.0.jar
RUN mkdir -p /usr/src/es-banco
WORKDIR /usr/src/es-banco
EXPOSE 8081
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Duser.timezone=EC", "-jar", "UsuarioES-1.0.0.jar"]
