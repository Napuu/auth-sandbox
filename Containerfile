FROM clojure:temurin-8-lein-jammy as clojure-build
COPY . .
RUN lein uberjar
RUN mv /tmp/target/*standalone.jar /tmp/out.jar
FROM openjdk:8-alpine
WORKDIR /app
COPY --from=clojure-build /tmp/out.jar .
CMD ["java", "-jar", "out.jar"]
