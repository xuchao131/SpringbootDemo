FROM java:8-jre

ADD demo-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/demo-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080