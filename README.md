# CreditCardValidator

##### Problem Summary

You are required to produce a class to perform credit card validation according to the Luhn algorithm below. This will be used for web-based validations and therefore should be tolerant of edge conditions and invalid data scenarios which can be exhibited on a website.

In addition, it is required to support the entry of credit card numbers both with spaces and without spaces and to validate each of these appropriately.

##### The Luhn Algorithm
The formula verifies a number against its included check-digit, which is usually appended to a partial account number to generate the full account number. This account number must pass the following test:

Counting from the check digit, which is the rightmost, and moving left, double the value of every second digit.
Sum the digits of the products together with the un-doubled digits from the original number.
If the total ends in 0 (put another way, if the total modulo 10 is congruent to 0), then the number is valid according to the Luhn formula; else it is not valid.

As an illustration, if the account number is **49927398716**, it will be validated as follows:

Double every second digit, from the rightmost: **(1×2) = 2, (8×2) = 16, (3×2) = 6, (2×2) = 4, (9×2) = 18**
Sum all digits (digits in parentheses are the products from Step 1): **6 + (2) + 7 + (1 + 6) + 9 + (6) + 7 + (4) + 9 + (1 + 8) + 4 = 70**
Take the sum modulo 10: **70 mod 10 = 0**; the account number is **valid**.

##### Approach
We expect solution to follow good design principles and TDD practices
Our preference would be to build the solution in Java, but you may use other language say Python
You can use your own development environment

##### Solution
The solution has been writen in Java please download the file and run `mvn clean install` to build,`mvn javadoc:jar` to build javadoc and 


`mvn package spring-boot:repackage` to build a single jar in the target diectory of the service module that can be executed as `java -jar CreditCardValidate.jar`


The API has two endoints;

1. `creditcard/validate` that accepts `ccardNumber` as a parameter and returns a reponce as `xxx xxx xxx xxx is invalid`
2. `creditcard/isValid/{cardnumber}`  and returns a reponce either `200` for valid numbers or `406` for invalid`

and the validator can be tested using the following curl commands 


+ curl --request POST --url 'http://localhost:8080/creditcard/validate?ccardNumber=222222222' `Invalid`
+ curl --request POST --url 'http://localhost:8080/creditcard/validate?ccardNumber=4012%208888%208888%201881' `Valid`


+ curl --request GET  --url http://localhost:8080/creditcard/isValid/2222222222222 `Invalid`
+ curl --request GET  --url http://localhost:8080/creditcard/isValid/4012%208888%208888%201881 `Valid`

