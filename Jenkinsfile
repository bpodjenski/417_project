pipeline {
    agent {
        docker {
            // Reference the label of the Docker agent template
            label 'docker-mvn-agent'
            // Specify the Docker image to use
            image 'maven:latest'
            // Mount the Maven cache directory to speed up builds
            args '-v $HOME/.m2:/root/.m2'
        }
    }
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        // stage('Checkout') {
        //     echo "Checking out code..."
        //     steps {
        //         // Checkout your source code from version control
        //         git 'https://github.com/bpodjenski/417_project.git'
        //     }
        // }
        stage('Build') {
            steps {
                echo "Building Code..."
                // Compile your Java code using Maven
                sh '''
                cd triangle-example
                mvn clean package
                '''
                echo "Build Commplete!"
            }

        }
        stage('Test') {
            steps {
                echo "Running tests..."
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