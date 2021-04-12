## Investment Fund Rest API

Investment API allows investor to create, update, delete and list investments record. Inverstors have to sign up system in order to use the API.

### Requiremets 🔧

- Java version 8 or higher.
- Maven.

## Installation 🔌

1. Press the Fork button (top right the page) to save copy of this project on your account.
2. Download the repository files (project) from the download section or clone this project by typing in the bash the following command:

```
git clone https://github.com/esra888/InvestmentFund.git
```

1. Imported it in Intellij IDEA or any other Java IDE.
2. Run the application :D

### Available Services

| HTTP METHOD | PATH                     | USAGE                                                        |
| ----------- | ------------------------ | ------------------------------------------------------------ |
| GET         | /investments/all         | after login, get all investments that specific investor has. |
| POST        | /investors/sign-up       | sign up the system as a investor.                            |
| POST        | /investments/add         | after login, add investment to existing investments that specific investor has. |
| POST        | /login                   | server assign JWT to investor who are signed up system before. |
| PUT         | /investments/update/{id} | after login, update existing investment that specific investor has. |
| DELETE      | /investments/delete/{id} | after login, delete existing investment that specific investor has. |

### Http Status

- 200 OK: The request has succeeded
- 403 Forbidden : The server understood the request, but is refusing to authorize it. 
- 400 Bad Request: The request could not be understood by the server
- 404 Not Found: The requested resource cannot be found
- 500 Internal Server Error: The server encountered an unexpected condition.

#### Sample JSON 

Sign-up the system :

```json
{ "username" :"someone","password" : "password" }
```

Add Investment :

```json
{
    "name" :"Bank Investment Fund",
    "description" : "risk free",
    "amount": 1000,
    "date" : "20-06-2021"
}
```

