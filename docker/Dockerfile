FROM alpine:3.19.1
RUN apk update && \
    apk --no-cache add openjdk11 tzdata && \
    cp /usr/share/zoneinfo/America/New_York /etc/localtime && \
    echo "America/New_York" > /etc/timezone && \
    apk del tzdata && \
    rm -rf /var/cache/apk/*
ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk
WORKDIR /usr/project
COPY . .
RUN javac *.java
CMD ["java", "Main"]
