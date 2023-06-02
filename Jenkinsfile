pipeline {
	agent any

    triggers {
        pollSCM('* * * * *')
    }
	
	stages {
		stage('Build') {
			steps {
				git 'https://github.com/roseruby143/PetManagementSystem.git'
				
				sh './mvnw compile'
				
				echo '----------------- Building the project -----------------'
			}
		}
		
		stage('Maven Package Building') {
			steps {
				sh './mvnw package'
			
				echo '----------------- Packaging the project -----------------'
			}
		}
		
		stage('Docker Build Image') {
			steps {
				echo '----------------- This is a build docker image phase ----------'
                sh '''
                    docker build -t petms-service-app .
                '''
			}
		}
		
		stage('Docker Deploy') {
			steps {
				echo '----------------- This is a docker deploment phase ----------'
                sh '''
            		docker run --network=petms-app-network -p 9091:9090 --name petms-service-app-container -d petms-service-app
            	'''
			}
		}
	}
}
