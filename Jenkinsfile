pipeline{
    agent any
	triggers {
        pollSCM('*/5 * * * *')
    }
    stages{
       stage('SCM Checkout'){
          steps{
             echo 'SCM Checkout'
  		     git credentialsId: 'GitHubCredentials', url: 'https://github.com/harilearning1989/SpringReadWriteFiles.git'
          }
       }
       stage('Gradle Package'){
       	   steps{
       	      echo 'Gradle Package'
       		 script{
       		    def grdlHome = tool name: 'Gradle', type: 'gradle'
       		    bat "gradlew build"
       			//def grdlHome = tool name: 'MAVEN_HOME', type: 'maven'
       			//echo "Gradle Home ${grdlHome}"
       			//def mvnCMD = "${mvnHome}/bin/mvn"
       			//echo "MVN CMD  ${mvnCMD}"
       			//bat "${mvnCMD} clean install"
       		 }
       	   }
       }
	   stage('compile'){
          steps{
           echo 'compiling the application'
         }
       }
       stage('build'){
          steps{
           echo 'building the application'
         }
       }
       stage('test'){
          steps{
           echo 'testing the application'
          }
       }
       stage('deploy'){
          steps{
            echo 'deploying the application'
        }
      }
    }
	post{
		always{
			echo 'this will run always'
		}
		success{
			echo 'this will run success'
		}
		failure{
			echo 'this will run failure'
		}
		unstable{
			echo 'this will run unstable'
		}
		changed{
			echo 'this will run changed'
		}
	}
}
