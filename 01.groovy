pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/qwqw1314/JenkinsTest.git'

                // Run Maven on a Unix agent.
                sh "cd JenkinsTest"
                sh "go build ."

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    echo 'success'
                }
            }
        }
    }
}

