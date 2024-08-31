#!/bin/bash
source ~/.bashrc
APPLICATION_DIR=/home/ubuntu/application
cd $APPLICATION_DIR

JAR_NAME=$(find $APPLICATION_DIR -name '*.jar' | tail -n 1)
JAR_PATH=$JAR_NAME

CURRENT_PID=$(pgrep -fl java | grep $JAR_NAME | awk '{print $1}')

if [ -z "$CURRENT_PID" ]; then
    echo "No application is running."
else
    echo "> kill -9 $CURRENT_PID"
    kill -9 $CURRENT_PID
    sleep 5
fi

echo "> $JAR_PATH add auth"
chmod +x $JAR_PATH

echo "> $JAR_PATH deploy"
nohup java -jar -Duser.timezone=Asia/Seoul $JAR_PATH > /dev/null 2>&1 &
