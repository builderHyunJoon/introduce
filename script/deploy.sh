#!/bin/bash

APPLICATION_DIR=/home/ubuntu/application
cd $APPLICATION_DIR

# 압축 해제
unzip -o introduce.zip

# JAR 파일 경로 찾기
JAR_PATH=$APPLICATION_DIR/introduce-0.0.1-SNAPSHOT.jar

# 현재 실행 중인 애플리케이션 프로세스 ID 찾기
CURRENT_PID=$(netstat -tulpn | grep :8080 | awk '{print $7}' | cut -d'/' -f1)

if [ -n "$CURRENT_PID" ]; then
    echo "애플리케이션이 실행 중이지 않습니다."
else
    echo "> kill -9 $CURRENT_PID"
    kill -9 $CURRENT_PID
    sleep 5
fi

echo "> $JAR_PATH 에 실행 권한 추가"
chmod +x $JAR_PATH

echo "> $JAR_PATH 배포"
java -jar -Duser.timezone=Asia/Seoul $JAR_PATH &