#!/bin/bash

REPOSITORY=/home/ubuntu/action
cd $REPOSITORY

# JAR 파일 경로 찾기
JAR_NAME=$(find $REPOSITORY -name '*.jar' | tail -n 1)
JAR_PATH=$JAR_NAME

# 현재 실행 중인 애플리케이션 프로세스 ID 찾기
CURRENT_PID=$(pgrep -fl java | grep $JAR_NAME | awk '{print $1}')

if [ -z "$CURRENT_PID" ]; then
    echo "애플리케이션이 실행 중이지 않습니다."
else
    echo "> kill -15 $CURRENT_PID"
    kill -15 $CURRENT_PID
    sleep 5
fi

echo "> $JAR_PATH 에 실행 권한 추가"
chmod +x $JAR_PATH

echo "> $JAR_PATH 배포"
nohup java -jar -Duser.timezone=Asia/Seoul $JAR_PATH &
