pipeline {
    agent any
    tools{
        maven 'Maven 3.6.1'
        jdk 'jdk8'
    }
    stages {
        stage('Initialize') {
            steps {
                sh '''
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage('Build') {
                    steps {
                        sh 'mvn -B -DskipTests clean package'
                    }
                }
    }
}