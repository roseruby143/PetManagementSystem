pipeline {
	agent any
	
	stages {
		stage('Build') {
			steps {
				git 'https://github.com/roseruby143/PetManagementSystem.git'
				
				sh "./mvnw compile"
				
				echo 'Building the project'
			}
		}
		
		stage('Test') {
			steps {
				sh "./mvnw test"
			
				echo 'Testing the project'
			}
		}
		
		stage('Build') {
			steps {
				sh "./mvnw package"
			
				echo 'Packaging the project'
			}
		}
	}
}