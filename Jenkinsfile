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
				
				echo 'Building the project'
			}
		}
		
		stage('Maven Package Building') {
			steps {
				sh './mvnw package'
			
				echo 'Packaging the project'
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
                (if  [ $(docker ps -a | grep petms-service-app-container | cut -d " " -f1) ]; then \
                        echo $(docker rm -f petms-service-app-container); \
                        echo "---------------- successfully removed petms-service-app-container ----------------"
                     else \
                    echo OK; \
                 fi;);
            	docker container run --network petms-app-network -p 9070:9070 --name petms-service-app-container -d petms-service-app
            	'''
			}
		}
	}
}
