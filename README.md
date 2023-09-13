Environment variable Setup

	Java
	Ensure that JAVA_HOME environment variable is set to the java 8 sdk installation location.

	Maven
	Ensure that MAVEN_HOME environment variable is set to the maven 3 installation location.


 How to clone the project?

	Open the IDE (eclipse) and right click in the left (package explorer) pane.
	   
	Click Import > Git > Projects from Git > Clone URI > Fill Details > Next > Select Import as general project > Next > Finish.

 How to run the project?
	 
	IDE
	For compilation and unit test errors, right click the project That was imported as a maven project and select Run As > Maven Install > Maven Test  > Run.
 
	CMD
	1. Open command prompt
	2. cd {Projectpath} 
 	3. mvn install
	4. mvn test  



 NOTE : Post lanuching browser, in case if accept cookies button doent appear, it may throws an exception error.
 Solution : To avoid this - open step definition class \src\test\java\stepDefinitions\SearchPageStepDefinition.java and comment the line number 31.
 
