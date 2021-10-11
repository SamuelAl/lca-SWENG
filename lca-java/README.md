## Introduction

Implementation of n-ary tree Lowest Common Ancestor algorithm in Java.
This is done as part of an assignment for the Sofware Engineering course, Year 3, Trinity College Dublin.

## Testing

This project uses Bazel to build and run tests. In order to facilitate usage, I have prepared a Dockerfile to prepare a docker image with a working environment. 

To build the docker image on your own machine, run: 

```console
docker build -t samalarco/bazel:latest .
```

This image can also be downloaded from Docker Hub:

```console
docker pull samalarco/bazel
```

In order to run the testing environment, first run the above docker image. We mount our work directory to have access to our Java source files.

```console
docker run --rm -it -v $PWD/:/usr/src/app samalarco/bazel
```

Once we have our testing environment running, we can use Bazel to run and test the project:

```console
bazel test //:lca_test
```



