FROM eclipse-temurin:26-jdk AS buildstage

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .
COPY src /app/src
COPY Wallet_V7JIWTC8VM7OBWQW /app/wallet

ENV TNS_ADMIN=/app/wallet

RUN mvn clean package -DskipTests

FROM eclipse-temurin:26-jdk

COPY --from=buildstage /app/target/tienda-0.0.1-SNAPSHOT.jar /app/tienda.jar

COPY Wallet_V7JIWTC8VM7OBWQW /app/wallet

ENV TNS_ADMIN=/app/wallet
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/tienda.jar"]
