# Etapa de construção
FROM maven:3.8.7 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos de configuração do Maven e o código fonte
COPY pom.xml .
COPY src ./src

# Executa o build do Maven
RUN mvn clean package -DskipTests

# Etapa de execução
FROM openjdk:17-jdk

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado no estágio de construção
COPY --from=build /app/target/grades-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta em que a aplicação vai rodar
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]