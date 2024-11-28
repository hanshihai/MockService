FROM sapmachine:17.0.12
COPY out/artifacts/DefaultMockService_jar/*.jar /usr/share
WORKDIR /usr/share
CMD ["/bin/bash"]
EXPOSE 80
ENTRYPOINT ["java","-jar","DefaultMockService.jar", "80"]