#Use JDK 6 as minimum supported Java version
FROM openjdk:6
RUN apt-get update  && \
apt-get install -y git && \
apt-get clean

#Use Tomcat7, as Tomcat 8 doesn't support JDK 7
ENV TOMCAT_MAJOR 7
ENV TOMCAT_VERSION 7.0.70
ENV TOMCAT_TGZ_URL https://www.apache.org/dist/tomcat/tomcat-$TOMCAT_MAJOR/v$TOMCAT_VERSION/bin/apache-tomcat-$TOMCAT_VERSION.tar.gz
EXPOSE 8080

RUN mkdir /tomcat && curl -SL $TOMCAT_TGZ_URL | tar -xzC /tomcat
RUN git clone --branch features/dockerenv git://github.com/Microsoft/ApplicationInsights-Java
WORKDIR ApplicationInsights-Java
RUN chmod +x gradlew && ./gradlew assemble war prepare
RUN chmod +x /ApplicationInsights-Java/docker/startup/default.sh
ENTRYPOINT ["/ApplicationInsights-Java/docker/startup/default.sh"]