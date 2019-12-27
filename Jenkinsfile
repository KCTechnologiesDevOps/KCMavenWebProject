node(){
    
    stage("checkout from SCM"){
        
      git 'https://github.com/KCTechnologiesDevOps/KCMavenWebProject.git'  
    }
    stage("Maven build"){
        def mvnHome = tool name: 'M2_HOME', type: 'maven'
        def mvnCMD = "${mvnHome}/bin/mvn"
        sh "${mvnCMD} clean package"
    }
    stage("Build docker image"){
        
        sh "docker build -t kctechnologiesdevops/batch17:1.0 ."
    }
    stage("Push image"){
        withCredentials([string(credentialsId: 'DOCKERHUB_CREDENTIALS', variable: 'DOCKERHUB_CREDENTIALS')]) {
          sh "docker login -u kctechnologiesdevops -p ${DOCKERHUB_CREDENTIALS}"
      }
      sh "docker push kctechnologiesdevops/batch17:1.0"
    }

     stage("Remove existing container"){
 	def removeContainer = "docker rm -f MyBatch17Ctr"
          try{
	sshagent(['ec2-user-pem']) {
   	 sh "ssh -o StrictHostKeyChecking=no ec2-user@13.127.66.53 ${removeContainer}"
	}
          }catch(error){
		sh "echo No contianer exists"
	}

	}
    
    stage("Create container"){
        def runContainer = "docker run -itd --name MyBatch17Ctr -p 8080:8080 kctechnologiesdevops/batch17:1.0"
	sshagent(['ec2-user-pem']) {
   	 sh "ssh -o StrictHostKeyChecking=no ec2-user@13.127.66.53 ${runContainer}"
	}

     }
    
}
