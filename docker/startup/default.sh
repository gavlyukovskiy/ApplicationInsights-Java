#!/bin/bash
if [$# -eq 1]
    git checkout $1
    git pull
    gradlew assemble war 
fi
cp /ApplicationInsights-Java/test/webapps/bookstore-spring/build/libs/bookstore-spring.war /tomcat/apache-tomcat-$TOMCAT_VERSION/webapps/
