
# Microservice for send Mail
## Requirements
- JDK 11
- Apache Maven 3

## Before running the project
- Put email credentials in `application.properties`
- Make sure your email provider is configured to accept SMTP connections. If not, configure in your email provider.

## Run the project with Docker

```bash
# Build the MS
mvn clean package

# Build
docker build -t ms-mail-sender .

# Run
docker run -p 8080:8080 ms-mail-sender
```

## Run the project without Docker

```bash
# Build the MS
mvn clean package

#Start the MS
java -jar target/ms-mail-sender-1.0.2.jar
```

## Endpoint
- In the project there is only one Endpoint: `POST /mail`
### Body `POST /mail`
```json
{
  "to": "jhones@email.com",
  "subject": "Hello Jhones!",
  "content": "<h1>Welcome to the team!</h1>",
  "cc": [
    "carina@email.com",
    "patrick@email.com"
  ],
  "isHtml": true,
  "isAsync": false
}
```

- Required fields `to`, `subject`, `content`
- Optional fields `cc`, `isHtml`, `isAsync`
#### Default values
- `cc` is empty array`[]`
- `isHtml` is `false`
- `isAsync` is `false`

#### Description of fields
- `cc` is a list of mails to copy in email
- `isHtml` is to inform if the `content` field is an HTML
- `isAsync` is to inform if the sending of the Email will be in asynchronous or synchronous way. If it is synchronous, the user will have feedback if there was an error in sending the email

## Thanks🖖
#### Created by https://github.com/henriquemrc12
#### Issues and doubts: henriquemarcel2244@gmail.com