def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t mohamed222/hadoop:1.1 ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push mohamed222/hadoop:1.1"
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this