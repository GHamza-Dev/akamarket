FROM tomcat:10-jdk17

ADD target/akaMarket-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/marjane.war

EXPOSE 8080

CMD ["catalina.sh","run"]