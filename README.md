# spring-boot-openjpa-postgres
This is a spring boot example application that uses openjpa with a postgres database. The main purpose of this app is
to replace the JPA implemenation from hibernate to openjpa. In this example postgres is the DB of choice but could easily 
be replace by any other DB such as MySql, Oracle, H2 etc.

#### Loadtime Weaving Activated
With the use of openjpa enhancemwnt to the source entity classes after they have been compiled is required and to do so 
the maven plugin `openjpa-maven-plugin` is introduced to do just that. For more on enhancing of entity classes visit here
http://openjpa.apache.org/enhancement-with-maven.html



```bash
<plugin>
				<groupId>org.apache.openjpa</groupId>
				<artifactId>openjpa-maven-plugin</artifactId>
				<configuration>
					<includes>**/entity/*.class</includes>
					<addDefaultConstructor>true</addDefaultConstructor>
					<enforcePropertyRestrictions>true</enforcePropertyRestrictions>
					<sqlFile>src/main/resources/schema.sql</sqlFile>
					<persistenceXmlFile>src/main/resources/META-INF/persistence.xml</persistenceXmlFile>
				</configuration>
				<executions>
					<execution>
						<id>enhancer</id>
						<phase>process-classes</phase>
						<goals>
							<goal>enhance</goal>
						</goals>
					</execution>
				</executions>
				<dependencies>
					<dependency>
						<groupId>org.apache.openjpa</groupId>
						<artifactId>openjpa</artifactId>
						<version>${openjpa.version}</version>
					</dependency>
				</dependencies>
			</plugin>
			
			```

#### Unit Testing and Runtime Enhancing

In order for the unit test to run successful you will need to set up a java agent. If you are using eclipse IDE
you will need to a startup parameters by opening the following: 
Run -> Run Configurations -> Your application -> Arguments. The “VM arguments” field is the place for adding 
the -javaagent startup parameter. See an example below where I'm using the Spring instrument jar that is located
in my maven repository. You can replace `${user-home}` with the path to your user home folder. `${spring.version}` 
and `${openjpa.version}` should be based on the versions of spring and openjpa you are using in your `pom.xml` respectively.

```bash
-javaagent:${user.home}.m2/repository/org/springframework/spring-instrument/${spring.version}/spring-instrument-${spring.version}.jar

or
-javaagent:"${user.home}/.m2/repository/org/apache/openjpa/openjpa/${openjpa.version}/openjpa-${openjpa.version}.jar"
```


