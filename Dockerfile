# Usando imagem do Java 21 (Temurin é a mais estável)
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copia o projeto para dentro do container
COPY . .

# Build do jar com Maven
RUN ./mvnw clean package -DskipTests

# ----------- Runtime image (menor, só o necessário) -----------
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copia o JAR gerado na fase anterior
COPY --from=build /app/target/cadastro-jogador-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java","-jar","app.jar"]
