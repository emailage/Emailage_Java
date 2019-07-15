[logo]: https://www.emailage.com/wp-content/uploads/2018/01/logo-dark.svg "Emailage Logo"

![alt text][logo](https://www.emailage.com)

The Emailage&#8482; API is organized around REST (Representational State Transfer). The API was built to help companies integrate with our highly efficient fraud risk and scoring system. By calling our API endpoints and simply passing us an email and/or IP Address, companies will be provided with real-time risk scoring assessments based around machine learning and proprietary algorithms that evolve with new fraud trends.


## Getting Started

### Requirements

* JVM 1.7 and above
* Maven 3+
    * Maven is used to maintain all dependencies

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
  <version>1.0.2</version>
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
		extraArgs.setbillpostal("85225");
		extraArgs.setbillcity("Chandler");
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
2. Using a wrong JVM version. JVM 1.7 and above is required for the client.


