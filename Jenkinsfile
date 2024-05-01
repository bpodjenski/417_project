pipeline {
    agent { 
        node {
            label 'docker-mvn-agent'
            }
      }
    triggers {
        pollSCM '*/5 * * * *'
    }
    stages {
        stage('Build') {
            steps {
                echo "Building Code..."
                // Compile your Java code using Maven
                sh '''
                cd triangle-example
                mvn clean
                mvn build
                '''
                echo "Build Commplete!"
            }

        }
        stage('Test') {
            steps {
                echo "Running tests..."
                // Run tests using Maven and collect test reports
                sh '''
                cd triangle-example
                mvn test
                '''
            }
        }
        // You can add additional stages as needed, such as deployment or notification stages
    }
    
    // You can also define post-build actions or notifications here
    post {
        always {
            echo "Sucessfull run!"
        }
    }
}