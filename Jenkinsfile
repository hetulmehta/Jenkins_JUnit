pipeline {

    agent any
    stages {

        stage('Checkout Codebase'){
            steps{
                cleanWs()
                checkout scm: [$class: 'GitSCM', branches: [[name: '*/master']],userRemoteConfigs:
                [[url: 'https://github.com/hetulmehta/Jenkins_JUnit.git']]]
            }
        }

        stage('Build'){
            steps{
        
                bat 'javac -classpath lib/junit-platform-console-standalone-1.7.0-all.jar CarTest.java Car.java App.java'
            }
        }

        stage('Test'){
            steps{
                bat 'java -jar lib/junit-platform-console-standalone-1.7.0-all.jar -cp "." --select-class CarTest --reports-dir="reports"'
                junit 'reports/*-jupiter.xml'
            }
        }

        stage('Deploy'){
            steps{
                bat 'java App' 
            }
        }
    }

}