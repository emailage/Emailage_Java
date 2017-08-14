[logo]: https://emailage.com/Content/Images/logo.svg "Emailage Logo"

![alt text][logo](https://www.emailage.com)

The Emailage&#8482; API is organized around REST (Representational State Transfer). The API was built to help companies integrate with our highly efficient fraud risk and scoring system. By calling our API endpoints and simply passing us an email and/or IP Address, companies will be provided with real-time risk scoring assessments based around machine learning and proprietary algorithms that evolve with new fraud trends.

## Getting Started

### Requirements

* JVM 1.7 and above

### Installation

Emailage can be installed directly from the source code:

```
$ git clone https://github.com/emailage/Emailage_Java.git
```
You can directly import this project to eclispe.

## Usage

Please refer to the below class for for full code example.

```Java
com.emailage.javawrapper.test.TestClient.java
```

### Settings

In the client class, you can first set up the result format, signatureMethod, user_email and environment for the query.
```Java
		/* Results can be in JSON or XML format */
		Enums.Format resultFormat = Enums.Format.Json;
		Enums.SignatureMethod signatureMethod = Enums.SignatureMethod.HMAC_SHA256;

		/*
		 * OPTIONAL FIELD. Use this field if you want to associate the API call
		 * to a specific Emailage user.
		 */
		String user_email = null;
		Enums.Environment environment = Enums.Environment.Production;
```

In the com.emailage.javawrapper.utilities.EmailageClient.java you can update your AccountSID and AuthToken provided by Emailage.
```Java

	/*
	 * ACCOUNT SID. You can find the Account SID in the Settings menu -> API Key
	 * Info.
	 */
	private static final String AccountSID = "INPUT--SID";

	/*
	 * AUTH TOKEN. You can find the AUTH TOKEN in the Settings menu -> API Key
	 * Info.
	 */
	private static final String AuthToken = "INPUT--KEY";

```

### Email Validation

```Java

			String validResult = EmailageClient.QueryEmail("test@test.com", resultFormat, signatureMethod, user_email,
					environment);

```
### Email and IP Validation

```Java

			String validResult = EmailageClient.QueryEmailAndIP("test@test.com", "147.12.12.13", resultFormat,
					signatureMethod, user_email, environment);

```

### Email and IP Validation with extra input parameters

```Java
			ExtraInputParameter extraArgs = new ExtraInputParameter();
			extraArgs.setbillpostal("85225");
			extraArgs.setbillcity("Chandler");

			String validResult = EmailageClient.QueryEmailAndIPPlusExtraArgs("test@test.com", "147.12.12.13", extraArgs,
					resultFormat, signatureMethod, user_email, environment);

```
### Mark email as fraud/good.

```Java
			int fraudCodeID = 1;
			/*
			 * fraudcodeID parameter Reference: 
			 *1 Card Not Present Fraud 
			 *2 Customer Dispute (Chargeback) 
			 *3 First PartyFraud 
			 *4 First Payment Default 
			 *5 Identify Theft (Fraud Application) 
			 *6 Identify Theft (Account Take Over) 
			 *7 SuspectedFraud (Not Confirmed) 
			 *8 Synthetic ID 
			 *9 Other
			 */
			String validResult = EmailageClient.MarkEmailAsFraud("test@test.com", Enums.FraudFlag.Fraud, fraudCodeID,
					resultFormat, signatureMethod, user_email, environment);
```

## Frequent asked integration problems.

1. Using the wrong AccountSID/AUTHToken for different environments. Sandbox and Production have different AccountSID and AUTHToken.
2. Using a wrong JVM version. JVM 1.7 is required for the client.


