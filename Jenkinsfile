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
                dir('jenkinsCiCD') {
                    bat 'gradlew.bat clean test'
                }
            }
        }
        // stage('Build'){
        //     steps{
        //         bat 'echo "building the app"'
        //     }
        // }
        // stage('Test'){
        //     steps{
        //         bat 'echo "Running tests"'
        //     }
        // }
        // stage('Deploy'){
        //     steps{
        //         bat 'echo "deploying"'
        //     }
        // }
        
    }
}
// post{
//     success{
//         bat 'echo "build successful"'
//     }
//     failure{
//         bat 'echo "build failed"'
//     }
// }
    

