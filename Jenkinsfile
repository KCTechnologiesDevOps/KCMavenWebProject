#!groovy

node {
  
	   
       stage('Checkout'){

          checkout scm
       }

       stage('Compiling'){

          sh 'mvn deploy'
       }
	   
      stage('Sonar') {
                    //add stage sonar
                    sh 'mvn sonar:sonar'
                }
       
}
