FROM openjdk:8-alpine3.9
# 作者信息
MAINTAINER first Docker springboot "ming@tianbohaomiao.com"
# 修改源
RUN echo "http://mirrors.aliyun.com/alpine/latest-stable/main/" > /etc/apk/repositories && \
echo "http://mirrors.aliyun.com/alpine/latest-stable/community/" >> /etc/apk/repositories
#修改镜像为东八区时间
ENV TZ Asia/Shanghai
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 7000
ENTRYPOINT ["java","-jar","/app.jar"]
