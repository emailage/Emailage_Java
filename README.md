
The [Emailage](https://risk.lexisnexis.co.uk/products/lexisnexis-emailage)&#8482; API is organized around REST (Representational State Transfer). The API was built to help companies integrate with our highly efficient fraud risk and scoring system. By calling our API endpoints and simply passing us an email and/or IP Address, companies will be provided with real-time risk scoring assessments based around machine learning and proprietary algorithms that evolve with new fraud trends.


## Getting Started

### Requirements

* JVM 1.8 and above
* Maven 3 and above for dependencies

### Installation

Emailage can be installed directly from the source code:

```
$ git clone https://github.com/emailage/Emailage_Java.git
```
Or you can use the Maven dependency:
```xml
<dependency>
  <groupId>com.emailage</groupId>
  <artifactId>classic-api-client</artifactId>
  <version>X.X.X</version>
</dependency>
```

## Usage

Please refer to the below class for for full code example.

```Java
com.emailage.javawrapper.test.TestClient.java
```

### Settings

Before using the API, you will need to populate the configuration parameters:

```Java
ConfigurationParameters configuration = new ConfigurationParameters();
parameters.setUserEmail(/*Email associated with the emailage user making the request*/);
parameters.setAcccountToken(/*Emailage authentication token*/);
parameters.setAccountSecret(/*Emailage account secret*/);
parameters.setEnvironment(/*Environment for the Requetst Production/Sandbox*/);
parameters.setHashAlgorithm(/*Signature Hashing algorithm*/);
parameters.setResultFormat(/*Xml or JSON*/);
```

### Email Validation

```Java
String validResult = EmailageClient.QueryEmail("test@test.com", configuration);
```
### Email and IP Validation

```Java
String validResult = EmailageClient.QueryEmailAndIP("test@test.com", "147.12.12.13", configuration);
```

### Email and IP Validation with extra input parameters

```Java
ExtraInputParameter extraArgs = new ExtraInputParameter();
		extraArgs.setBillPostal("85225");
		extraArgs.setBillCity("Chandler");
String validResult = EmailageClient.QueryEmailAndIPPlusExtraArgs("test@test.com", "147.12.12.13", extraArgs,
					configuration);
```
### Mark email as fraud/good.

```Java
String validResult = EmailageClient.MarkEmailAsFraud("test@test.com", Enums.FraudFlag.Fraud, Enums.FraudType.Good,
					configuration);
```

## Frequent asked integration problems.

1. Using the wrong AccountSID/AUTHToken for different environments. Sandbox and Production have different AccountSID and AUTHToken.
2. Using a wrong JVM version. JVM 1.8 and above is required for the client.

## Option for Running Test Client Locally

Recommendation for running the application locally against the `example/TestClient.java` is packaging the application into a Maven JAR file and running it in a docker dev container. In this example it is running in Visual Studio Code.

**Step 1**: Include the necessary marven jar dependencies and configuration plugins into the `pom.xml` file

```xml
<plugin>
    <!-- Build an executable JAR -->
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-jar-plugin</artifactId>
    <version>3.1.0</version>
    <configuration>
        <archive>
            <manifest>
                <mainClass>com.emailage.javawrapper.example.TestClient</mainClass>
            </manifest>
        </archive>
    </configuration>
</plugin>
<plugin>
 	<!-- Configure a uber JAR to package all dependencies -->
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-shade-plugin</artifactId>
    <version>3.2.4</version>
    <executions>
        <execution>
            <phase>package</phase>
            <goals>
                <goal>shade</goal>
            </goals>
            <configuration>
                <transformers>
                    <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                         <mainClass>com.emailage.javawrapper.example.TestClient</mainClass>
                    </transformer>
                </transformers>
             </configuration>
        </execution>
    </executions>
</plugin>
```

**Step 2**: Configure `TestClient.java` file

The test client has hardcoded the production environment and the email query `test@test.com` which you are free to change.

For credentials you will need to change the following fields for validate credentials to the environment you are targeting: Sandbox or Production
```Java
String accountSid = "replace-here"; //Consumer Key
String authToken = "replace-here"; //Consumer Secret
```

**Step 3**: For added convience install docker and the Dev Container extension and run the application inside a dev container. The extention should give you an option for creating a configuration file but here is an example which will run

```Json
// For format details, see https://aka.ms/devcontainer.json. For config options, see the
// README at: https://github.com/devcontainers/templates/tree/main/src/java
{
    "name": "Java",
    // Or use a Dockerfile or Docker Compose file. More info: https://containers.dev/guide/dockerfile
    "image": "mcr.microsoft.com/devcontainers/java:1-21-bullseye",
 
    "features": {
        "ghcr.io/devcontainers/features/java:1": {
            "version": "none",
            "installMaven": "true",
            "installGradle": "false"
        }
    }
}
```

This file should be added from the root under `.devcontainer/devcontainer.json`