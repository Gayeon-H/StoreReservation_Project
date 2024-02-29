#!/usr/bin/env bash

REPOSITORY=/home/ec2-user/cicd
cd $REPOSITORY

APP_NAME=StoreReservation_Project
JAR_NAME=$(ls $REPOSITORY/build/libs/ | grep 'SNAPSHOT.jar' | tail -n 1)
JAR_PATH=$REPOSITORY/build/libs/$JAR_NAME

CURRENT_PID=$(pgrep -f $APP_NAME)

if [ -z $CURRENT_PID ]
then
  echo "> nothing kill"
else
  echo "> kill -9 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> $JAR_PATH cd"
nohup java -jar $JAR_PATH > /dev/null 2> /dev/null < /dev/null &