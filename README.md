
# User Management System

**Objective:** The User Management System is a Spring Boot-based application designed to manage user information. It provides CRUD (Create, Read, Update, Delete) operations for user data, including attributes such as User ID, Username, Date of Birth, Email, Phone Number, Creation Date, and Creation Time.


## Tech Stack
Before you begin, make sure you have the following tools and dependencies installed:

**Java Development Kit (JDK)**

**Languages & FrameWorks :** Java, SpringBoot

**Data Storage :** Data Base

**Tools Used :** IntelliJ, PostMan, Swagger

**Maven or Gradle (for project build management)**


## Documentation Dataflow

In your User Management System project, the data flows between different components as follows:

### Adding a User:
`Data Access Layer (with Database Interaction):`

1. Client: 
The client sends a POST request to the endpoint with user data in the request body (e.g., JSON).

2. Controller:
 The UserController in the Spring Boot application receives the HTTP request.

3. Service Layer (optional): 
In a more complex system, there could be a service layer that performs additional business logic. In this simple example, it may not be necessary.

4. Repository
 The UserController delegates the task of saving the user data to the UserRepository. The UserRepository uses Spring Data JPA to interact with the database.
`
5. Database: 
The user data, provided in the request, is persisted in the database (e.g., MySQL, PostgreSQL, etc.).

6. Response: 
A response is sent back to the client, indicating the successful addition of the user or any errors encountered.

### Retrieving a User:

1. Client: The client sends a GET request to the endpoint, specifying the userId in the URL.

2. Controller: The UserController receives the HTTP request.

3. Repository: The UserController delegates the task of retrieving the user data to the UserRepository. The UserRepository queries the database using Spring Data JPA.

4. Database: The database retrieves the user data based on the provided userId.

5. Response: The retrieved user data is sent back to the client as an HTTP response, or an error response is sent if the user is not found.

#### Updating a User:

1. Client: 
The client sends a PUT request to the endpoint, specifying the userId in the URL and providing updated user data in the request body.

2. Controller: 
The UserController receives the HTTP request.

3. Repository: 
The UserController delegates the task of updating the user data to the UserRepository. The UserRepository updates the corresponding record in the database.

4. Database: 
The database updates the user data with the new information.

5. Response: 
A response is sent back to the client, indicating the successful update or any errors encountered.

#### Deleting a User:

1. Client: 
The client sends a DELETE request to the endpoint, specifying the userId in the URL.

2. Controller:
The UserController receives the HTTP request.

3. Repository: 
The UserController delegates the task of deleting the user to the UserRepository. The UserRepository deletes the corresponding record from the database.

4. Database:
The database removes the user data associated with the specified userId.

5. Response: A response is sent back to the client, indicating the successful deletion or any errors encountered.



## Key Components:

1. User Entity: The project defines a User entity class representing the user data with appropriate attributes. This entity is managed using Spring Data JPA.

2. UserRepository: A repository interface is created for User entities, allowing for database operations such as saving, retrieving, updating, and deleting user records. Spring Data JPA generates the implementation automatically.

3. UserController: This REST controller handles HTTP requests related to user management. It provides the following endpoints:

- /api/api/users: Adds a new user to the system.
- /api/user/{userId}: Retrieves user information by User ID.
- /api/allUsers: Retrieves a list of all users in the system.
- /api/UserInfo/userId/{userId}: Updates user information based on User ID.
- /api/user/id/{userId}: Deletes a user by User ID.

4. Database Configuration: The project uses database with configuration settings in the application.properties file. You can easily switch to a different database by modifying the configuration.

**Usage:**

Users can interact with the system through HTTP requests to the defined endpoints.
The system supports operations to create, retrieve, update, and delete user records.

## API Reference


#### Add multiple Users

```http
  POST localhost:8080/api/users
```

| Parameter | Request Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Array of JSON objects` | `Request Body` | **Required**. User objects with user details |

### Example
#### Request Body:
```
[
    {
        "userId": 1,
        "username": "john_doe",
        "dateOfBirth": "1990-05-15",
        "email": "john.doe@example.com",
        "phoneNumber": "123456789012",
        "date": "2023-09-23",
        "time": "14:30:00"
    },
    {
        "userId": 2,
        "username": "jane_smith",
        "dateOfBirth": "1985-08-22",
        "email": "jane.smith@example.com",
        "phoneNumber": "987654321098",
        "date": "2023-09-23",
        "time": "09:45:00"
    }
]
```
#### Response:
2 Users added

#### Get User

```http
  GET localhost:8080/api/user/{userId}

```

| Parameter | Request Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `Path parameter` | **Required**.  userId of the user to fetch |

### Example
#### Response
```
{
  "userId": 1,
  "username": "john_doe",
  "dateOfBirth": "1990-05-15",
  "email": "john123.doe@example.com",
  "phoneNumber": "443456789012",
  "date": "2023-09-23",
  "time": "14:30:00"
}
```

#### Get All Users

```http
  GET localhost:8080/api/allUsers

```

| Parameter | Request Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `N/A`      | `N/A` | **Required**. Nothing |

### Example
#### Response
```
[
    {
        "userId": 1,
        "username": "john_doe",
        "dateOfBirth": "1990-05-15",
        "email": "john.doe@example.com",
        "phoneNumber": "123456789012",
        "date": "2023-09-23",
        "time": "14:30:00"
    },
    {
        "userId": 2,
        "username": "jane_smith",
        "dateOfBirth": "1985-08-22",
        "email": "jane.smith@example.com",
        "phoneNumber": "987654321098",
        "date": "2023-09-23",
        "time": "09:45:00"
    }
]
```
#### Update User

```http
  PUT localhost:8080/api/UserInfo/userId/{userId}
```

| Parameter | Request Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `Path parameter` | **Required**.  userId of the user to Update |
| `JSON`      | `Request Body` | **Required**.  Body of the user to Update |

### Example
#### Request
```
{
    "userId": 1,
    "username": "john_doe",
    "dateOfBirth": "1990-05-15",
    "email": "john.doe@example.com",
    "phoneNumber": "553456789012",
    "date": "2023-09-23",
    "time": "14:30:00"
}
```
#### Response
User with ID 1 updated

#### Delete a User

```http
  DELETE localhost:8080/api/user/id/{userId}

```
| Parameter | Request Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `Path parameter` | **Required**. userId of the user to delete User |

### Example
#### Response:
User with ID 20 deleted

## Support

For support, email abc@gmail.com or join our Slack channel.


## Acknowledgements

- [Awesome Readme Templates](https://awesomeopensource.com/project/elangosundar/awesome-README-templates)
- [Awesome README](https://github.com/matiassingers/awesome-readme)
- [How to write a Good readme](https://bulldogjob.com/news/449-how-to-write-a-good-readme-for-your-github-project)

