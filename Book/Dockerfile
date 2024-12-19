FROM openjdk:17-jdk-slim

# Criar usuário não-root
RUN addgroup --system javauser && adduser --system --ingroup javauser javauser

WORKDIR /usr/src/app

# Copiar o JAR
COPY target/Book-0.0.1-SNAPSHOT.jar app.jar

# Definir propriedade do arquivo para o usuário não-root
RUN chown javauser:javauser app.jar

# Mudar para usuário não-root
USER javauser

EXPOSE 8080

# Adicionar healthcheck
HEALTHCHECK --interval=30s --timeout=3s \
  CMD wget -q --spider http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]