FROM openjdk:6
RUN apt-get update  && \
apt-get install -y git && \
apt-get clean
RUN mkdir /tomcat && curl -SL http://www-eu.apache.org/dist/tomcat/tomcat-8/v8.0.36/bin/apache-tomcat-8.0.36.tar.gz | tar -xzC /tomcat
RUN git clone --branch features/dockerenv git://github.com/Microsoft/ApplicationInsights-Java
WORKDIR ApplicationInsights-Java
RUN chmod +x gradlew && ./gradlew assemble war prepare
RUN chmod +x /ApplicationInsights-Java/docker/startup/default.sh
ENTRYPOINT ["/ApplicationInsights-Java/docker/startup/default.sh"]