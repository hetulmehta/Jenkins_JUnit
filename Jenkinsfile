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
                bat 'mkdir lib'
                bat 'cd lib/'
                bat' curl https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.7.0/junit-platform-console-standalone-1.7.0-all.jar'
                bat 'tree /f'
                bat 'javac -classpath lib/junit-platform-console-standalone-1.7.0-all.jar src/CarTest.java src/Car.java src/App.java'
            }
        }

        stage('Test'){
            steps{
                bat 'cd src/'
                bat 'java -jar ../lib/junit-platform-console-standalone-1.7.0-all.jar -cp "." --select-class CarTest --reports-dir="reports"'
                junit 'src/reports/*-jupiter.xml'
            }
        }

        stage('Deploy'){
            steps{
                bat 'cd src/'
                bat 'java App' 
            }
        }
    }

}