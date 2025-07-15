# Use uma imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Copie o arquivo JAR da sua aplicação para o contêiner
COPY target/api-gateway-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta que a aplicação vai utilizar
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

