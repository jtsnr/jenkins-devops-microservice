pipeline {
	agent any
	environment {
		dockerHome = tool 'myDocker'
		mavenHome = tool 'myMaven'
		PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
	}
	stages {
		stage('Checkout') {
			steps {
				echo "Build"
				echo "$PATH"
				sh "docker version"
				echo "BUILD_NUMBER - $env.BUILD_NUMBER"
				echo "JOB_NAME - $env.JOB_NAME"
				echo "BUILD_TAG - $env.BUILD_TAG"
			}
		}
		stage('Compile') {
			steps {
				sh "mvn clean compile"
			}
		}
		stage('Unit Tests') {
			steps {
				sh "mvn test"
			}
		}

		stage('Integration Tests') {
			steps {
				sh "mvn failsafe:integration-test failsafe:verify"
			}
		}		
	}
	post {
		always {
			echo "Stages complete"
		}
		success {
			echo "Stages success"
		}
		failure {
			echo "Stages failed"
		}
	}
}
