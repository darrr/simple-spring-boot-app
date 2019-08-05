pipeline {
    agent any
    tools{
        maven 'Maven 3.6.1'
        jdk 'jdk8'
    }
    stages {
        stage('Initialize') {
            steps {
                bat '''
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage('Code check') {
            steps {
                bat '''
                mvn clean validate
                '''
            }
        }

         stage('Database migration') {
            steps {
                bat 'mvn liquibase:update'
            }
         }
    }
}