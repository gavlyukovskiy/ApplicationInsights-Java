#!/bin/bash
cp /ApplicationInsights-Java/test/webapps/bookstore-spring/build/libs/bookstore-spring.war /tomcat/apache-tomcat-8.0.36/webapps/
/tomcat/apache-tomcat-8.0.36/bin/catalina.sh  run