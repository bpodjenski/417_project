pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Checkout') {
            echo "Checking out code..."
            steps {
                // Checkout your source code from version control
                git 'https://github.com/bpodjenski/417_project.git'
            }
        }
        stage('Build') {
            echo "Building Code..."
            steps {
                // Compile your Java code using Maven
                sh 'mvn clean package'
            }
            echo "Build Commplete!"

        }
        stage('Test') {
            echo "Running tests..."
            steps {
                // Run tests using Maven and collect test reports
                sh 'mvn test'
                junit 'target/surefire-reports/**/*.xml'
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