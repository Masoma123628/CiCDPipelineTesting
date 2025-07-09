pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Masoma123628/jenkinsCiCD.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh './gradlew clean test'
            }
        }
    }
}
