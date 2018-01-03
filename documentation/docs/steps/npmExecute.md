# npmExecute

## Description

Executes a command inside a Docker container. 
In the default configuration a docker container is used, which already contains a node installation.
The step is similar to dockerExecute but comes with a predefined docker image for node. 

## Parameters

| parameter            | mandatory | default                      |
| ---------------------|-----------|------------------------------|
| `dockerImage`        | no        | 's4sdk/docker-node-browsers' |
| `dockerOptions`      | no        |                              |


* `dockerImage` Name of the docker image that should be used.
* `dockerOptions` Docker options to be set when starting the container. 


## Global Configuration
The following parameters can also be specified using the global configuration file:
* `dockerImage`

## Exceptions

None

## Example

```groovy
npmExecute(script: this) {
    sh 'npm install'
}
```




