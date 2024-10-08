FROM seanly/toolset:openjdk-8u372-b07-2 AS build
WORKDIR /code

ARG VERSION=2.4.1
RUN git clone -b ${VERSION} https://github.com/seanly/nacos.git /code/nacos

RUN <<EOF
cp -r /maven-wrapper/mvnw /code/nacos/
cp -r /maven-wrapper/.mvn /code/nacos/
cd /code/nacos
./mvnw -B -e -U -Prelease-nacos -DskipTests \
    clean install -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn
EOF

COPY ./ /code/kingbase8

RUN <<EOF
cd /code/kingbase8
./mvnw -B -e -U -DskipTests clean install
EOF
