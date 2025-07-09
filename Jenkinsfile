pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Masoma123628/jenkinsCiCD.git'
            }
        }

        stage('Check Files') {
            steps {
                bat 'dir'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'gradlew.bat clean test'
            }
        }
    }
}

