pipeline {
    agent any
    tools{
        maven 'Maven 3.6.1'
        jdk 'jdk8'
    }
    stages {
        stage('Code check') {
            steps {
                sh 'mvn validate'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build') {
            steps {
                sh '''
                    mvn clean package
                    '''
            }
        }

         stage('Database migration') {
            steps {
                sh 'mvn liquibase:update'
            }
         }
    }
}