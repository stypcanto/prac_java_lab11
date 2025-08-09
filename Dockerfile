FROM tomcat:10.1-jdk17

# Limpia la app por defecto
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia el WAR renombrado como ROOT.war
COPY target/Lab11.war /usr/local/tomcat/webapps/ROOT.war