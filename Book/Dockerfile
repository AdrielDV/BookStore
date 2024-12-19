# Use uma imagem base com Java 17
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho
WORKDIR /usr/src/app

# Copie o JAR da aplicação para dentro do container
COPY target/Book-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta usada pela sua aplicação (por padrão, 8080 em Spring Boot)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]