pipeline {
environment {
registry = "devaraj1234/microservice-registry"
registryCredential = 'docker_hub_id'
dockerImage = ''
}
agent any
stages {
stage('Building image') {
steps{
script {
dockerImage = docker build -t registry+ ":$BUILD_NUMBER"
}
}
}
stage('Deploy image') {
steps{
script {
docker.withRegistry( '', registryCredential ) {
dockerImage.push()
}
}
}
}
stage('Cleaning up') {
steps{
sh "docker rmi $registry:$BUILD_NUMBER"
}
}
}
}