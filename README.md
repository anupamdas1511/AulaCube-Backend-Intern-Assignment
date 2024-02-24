# Role Based Auth Application

This is a Role Based Authentication Application written in Java using Spring Boot. 

## Usage

- Clone the repository ```git clone https://github.com/anupamdas1511/AulaCube-Backend-Intern-Assignment.git```
- Open the folder with any Java IDEs like IntelliJ, Eclipse, VS Code etc.
- Install necessary maven dependency. You can use the command ```mvn dependency:resolve``` if you can use CLI for maven.
- Run the application in your IDE. You can also run the application using command ```mvn spring-boot:run```.
- Your application is live with base url `http://localhost:8081`

## Endpoints
### Auth Endpoints

- `/auth/login` - POST

    This endpoint is used to login to the application using the ADMIN credentials. You can add the Admin Credentials in the application.properties file.
  
    JSON body(url = "http://localhost:8081/auth/login")
    ```
    {
        "username": {admin-username},
        "password": {admin-password}
    }
    ```
  As a response you will get a **token** and your **username**. You can use this token later for any other operations.

### Home Endpoints
- `/home/add-user` - POST

    This endpoint is used to add a new user with role USER in the Database. You need to pass the **token** as Authorization Header.
    
    **Header:
    Authorization: Bearer {your_token}**

    JSON body(url = "http://localhost:8081/home/add-user")
    ```
    {
        "name": "John Doe",
        "email": "john@example.com",
        "username": "johndoe2024",
        "phoneNumber": "8787678776",
        "password": "johndoe1234"
    }
    ```

- `/home/users` - GET

  This endpoint is used to get all existing users in the Database. You need to pass the **token** as Authorization Header.

  **Header:
  Authorization: Bearer {your_token}**

  (url = "http://localhost:8081/home/users")
  
    As a response, you get the list of all users in the database.


- `/home/edit-user` - PATCH

  This endpoint is used to update an existing user with role USER in the Database. You need to pass the **token** as Authorization Header.

  **Header:
  Authorization: Bearer {your_token}**

  JSON body(url = "http://localhost:8081/home/edit-user?username={username}")
    ```
    {
        "name": "New John Doe",
        "email": "john-new@example.com",
        "username": "johndoe2024new",
        "phoneNumber": "8787678776",
        "password": "johndoe1234"
    }
    ```

- `/home/remove-user` - GET

  This endpoint is used to delete an existing user from the Database. You need to pass the **token** as Authorization Header.

  **Header:
  Authorization: Bearer {your_token}**

  (url = "http://localhost:8081/home/remove-user?username={username}")