FROM tomcat:8.0-jre8
MAINTAINER KrishnaChaitanya kctechnologies@gmail
COPY target/*.war /usr/local/tomcat/webapps/jenkins.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
