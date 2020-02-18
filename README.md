# EME_Rest_API_auth
This project builds the Rest API for Patient/Auth

# Getting Started
There are 2 ways to run this project:
1. Run project on local system
2. Run project on spring cloud system

## Prerequisites
See details in pom.xml

##Installing

# Running the tests
There is a automated test for this project in EME_Rest_API_auth/restapi/TA
## How tests works
The test is a bash script send HTTP requests to current project port

# Data structures

MODEL NAME | data/type | data/type | data/type | data/type | data/type
-----------|-----------|-----------|-----------|-----------|----------
Address    | address1/String | address2/String | city/String | state/String | postal/Integer


MODEL NAME | data/type | data/type | data/type | data/type | data/type | data/type
-----------|-----------|-----------|-----------|-----------|-----------|-----------
Contact    | firstName/String | middleName/String | lastName/String | suffix/String | gender/String | dateOfBirth/String


MODEL NAME | data/type | data/type | data/type 
-----------|-----------|-----------|-----------
PatientIdentifier | patientId | identifierTypeId | identifierValue


MODEL NAME | data/type | data/type | data/type 
-----------|-----------|-----------|-----------

#API 
## Contact API 
## PatientIdentifier API
## Auth API 
### /Authorization/v1/getAuthorization 
#### input
exaple: 
{
}
#### output