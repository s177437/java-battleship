Battleship 

This is the java implementation of the game battleship. 

This program is built using Maven. To be able to recompile this program, one must have the following software installed: 

- Java 1.8 or later 
- Maven 3.5.0 or later

The game is built and compiled using maven. In order to build a working jar-file. Clone the repository and execute the command
`mvn package` from root level to build a working jar-file. To execute the program issue the following command 

`java -jar target/java-battleship-1.0-SNAPSHOT.jar `
  
 
 It is possible to adjust the speed of the gamemplay. In the file `Main.java`, change the variable 
 
 `long speed = 0;` to `long speed = <desired interval step>;`
 
 Run the command 
 
 `mvn clean install` and execute 
 
 `java -jar target/java-battleship-1.0-SNAPSHOT.jar `

 
  
