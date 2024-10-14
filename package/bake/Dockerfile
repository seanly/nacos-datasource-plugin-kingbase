ARG VERSION=2.4.1-2
FROM docker.opsbox.dev/seanly/toolset:openjdk-8u372-b07-2 AS build

WORKDIR /code/kingbase8
COPY ./ ./

RUN <<EOF
cp -r /maven-wrapper/mvnw ./
cp -r /maven-wrapper/.mvn ./

./mvnw install:install-file -Dfile=./libs/kingbase8-9.0.0.jar \
    -DgroupId=kingbase8 -DartifactId=kingbase8-driver -Dversion=9.0.0 \
    -Dpackaging=jar

./mvnw -B -e -U -DskipTests clean install
cp -r target/*.jar libs/
EOF

FROM docker.opsbox.dev/seanly/appset:nacos-${VERSION}

LABEL maintainer="seanly <seanly@opsbox.dev>"
COPY --from=build /code/kingbase8/libs/ /home/nacos/plugins/

EXPOSE 8848

ENTRYPOINT ["bash", "bin/start.sh"]