pipeline{
     environment
     {
		 FOO = "foo"
		 javaHome = tool name: 'JAVA_HOME', type: 'jdk'
		 javaCMD = "${javaHome}/bin/java"

		 mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
		 mvnCmd = "${mvnHome}/bin/mvn"

		 gradleHome = tool name: 'GRADLE_HOME', type: 'gradle'
		 grdlCmd = "${gradleHome}/bin/gradle"

		 imagename = "harilearning1989/spring-rest-oracle-jquery"
     }
    agent any
	triggers
	{
        pollSCM '*/5 * * * *'
    }
    stages
    {
       stage('Gradle')
       {
          steps
          {
             withEnv(["JAVA_HOME=${tool 'JAVA_HOME'}", "PATH=${tool 'JAVA_HOME'}/bin:${env.PATH}"])
             {
                git 'https://github.com/harilearning1989/spring-rest-oracle-jquery.git'
                sh 'java -version'
                echo "Gradle"
                sh "${grdlCmd} -v"
                sh "${grdlCmd} clean build"
             }
          }
       }
       stage('Build Docker Image')
       {
          steps
          {
             //bat 'docker build -t spring-rest-oracle-jquery .'
             sh 'docker build -t harilearning1989/spring-rest-oracle-jquery:latest .'
          }
       }
       stage('Push Docker Image')
       {
          steps
          {
             //bat 'docker push harilearning1989/spring-rest-maven'
             sh 'docker push harilearning1989/spring-rest-oracle-jquery:latest'
          }
       }
       stage('compile')
       {
          steps
          {
             echo 'compiling the application'
          }
       }
       stage('build')
       {
          steps
          {
             echo 'building the application'
          }
       }
       stage('test')
       {
          steps
          {
             echo 'testing the application'
          }
       }
       stage('deploy')
       {
          steps
          {
             echo 'deploying the application'
          }
       }
    }
	post
	{
		always
		{
			echo 'this will run always'
		}
		success
		{
			echo 'this will run success'
		}
		failure
		{
			echo 'this will run failure'
		}
		unstable
		{
			echo 'this will run unstable'
		}
		changed
		{
			echo 'this will run changed'
		}
	}
}