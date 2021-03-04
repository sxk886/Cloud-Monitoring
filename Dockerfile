FROM gcr.io/iaas-gcr-reg-prd-ad3d/golden/openjre:8-jre-slim

# remove the SUID from all binaries (none in alpine)
RUN for file in `find / -not \( -path /proc -prune \) -type f -perm /6000`; \
      do \
        echo "remove SUID for $file"; \
        chmod a-s $file; \
      done

#Arguments for Build Metadata
ARG GIT_COMMIT
ARG GIT_URL
ARG GIT_BRANCH
ARG BUILD_NUMBER
ARG BUILD_URL

LABEL maintainer="niran.v@equifax.com" \
      GIT_COMMIT="${GIT_COMMIT}" \
      GIT_URL="${GIT_URL}" \
      GIT_BRANCH="${GIT_BRANCH}" \
      BUILD_NUMBER="${BUILD_NUMBER}" \
      BUILD_URL="${BUILD_URL}"

WORKDIR /app

# Argument for Jar file
ARG JAR_FILE

COPY target/${JAR_FILE} /app/online-packaging-logging.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/online-packaging-logging.jar"]