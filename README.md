# Mail_OTP_Sender

A lightweight Spring Boot application that sends One-Time Passwords (OTPs) via email—ideal for quick authentication flows without heavy infrastructure.

## Table of Contents
- [Features](#features)  
- [Architecture](#architecture)  
- [Getting Started](#getting-started)  
- [Configuration](#configuration)  
- [Usage](#usage)  
- [Contributing](#contributing)  
- [License](#license)  

## Features
- Generate random alphanumeric OTPs of configurable length  
- Send OTPs via SMTP/email using Spring Boot’s mail support  
- REST API endpoints for requesting and validating OTPs  
- Minimal setup required—focus on adding authentication logic  
- Easily extendable to other delivery channels (SMS, push notifications)  

## Architecture
This application uses:
- Spring Boot (Spring Web, Java Mail Sender)
- A simple in-memory storage for OTPs (with configurable expiry)  
- Externalized configuration via `application.properties` 
- RESTful API design for request/validate operations  

## Getting Started
### Prerequisites
- Java 17+ (or your required version)  
- Maven build
- A working SMTP/email account to send OTPs  (can generated using google app password (works only if you enabled the 2FA) )

### Build and Run
```bash
# Clone the repo
git clone https://github.com/PraneshOptimus/Mail_OTP_Sender.git
cd Mail_OTP_Sender

# Build the application
./mvnw clean package   # if using Maven

# Run the application
java -jar target/Mail_OTP_Sender-<version>.jar
