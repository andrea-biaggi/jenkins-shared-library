#!/user/bin/env groovy

def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-docker-repo', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh 'docker build -t 192.168.88.151:8083/demo-app:jma-2.0 .'
        sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin 192.168.88.151:8083'
        sh 'docker push 192.168.88.151:8083/demo-app:jma-2.0'
    }
}