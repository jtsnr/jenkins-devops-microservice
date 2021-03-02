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

		stage('Package') {
			steps {
				sh "mvn package -DskipTests"
			}
		}

		stage('Build Docker Image') {
			steps {
				//docker build -t jsturnbull/currency-exchange-devops:$env.BUILD_TAG
				script {
					dockerImage = docker.build("jsturnbull/currency-exchange-devops:${env.BUILD_TAG}");
				}
			}
		}

		stage('Push Docker Image') {
			steps {
				script {
					docker.withRegistry('', 'dockerhub') {
						dockerImage.push();
						dockerImage.push('latest');
					}
				}
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
