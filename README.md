# Secure Notes Application

This is a Spring Security notes application built using Spring Boot. It allows users to create, read, update, and delete their personal notes. The application features an admin role with elevated privileges.

## Technologies Used

<p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java,spring,mysql,docker&theme=light" />
  </a>
</p>

## Key Features:

* **User Authentication:** Secure user registration and login.
* **Note Management:** Users can create, view, edit, and delete their own notes.
* **Role-Based Authorization:**
    * Regular users can manage their own notes.
    * Admin users have access to additional administrative functionalities (as implied by the `AdminController`).
* **Spring Security:** Implemented for authentication and authorization, leveraging concepts such as:
    * Form-based authentication
    * Basic authentication
    * Custom user details service (`UserDetailsServiceImpl`)
    * Role-based access control
    * URL-based restrictions
    * Method-level security
* **Database Persistence:** Uses MySQL to store user and note data.
* **RESTful API:** Provides a RESTful API for interacting with the application.

## Technology Stack:

* Java
* Spring Boot
* Spring Security
* MySQL
* Maven
* Docker

## Project Structure:

* `com.secure.notes`: Main application class.
* `com.secure.notes.controllers`: REST controllers for handling user and note requests (`NoteController`, `AdminController`).
* `com.secure.notes.dtos`: Data Transfer Objects for request and response bodies (`UserDTO`).
* `com.secure.notes.models`: Domain entities representing the application's data (`Role`, `User`, `Note`, `AppRole`).
* `com.secure.notes.repositories`: Spring Data JPA repositories for database interaction (`UserRepository`, `RoleRepository`, `NoteRepository`).
* `com.secure.notes.security`: Security configuration classes (`SecurityConfig`).
* `com.secure.notes.security.services`: Custom security-related services (`UserDetailsImpl`, `UserDetailsService`).
* `com.secure.notes.services`: Application-specific service interfaces (`UserService`, `NoteService`).
* `com.secure.notes.services.impl`: Implementations of the service interfaces (`UserServiceImpl`, `NoteServiceImpl`).
* `resources`: Application configuration and other resources.

## Setup Instructions:

1.  **run MySQL:** 
    ```bash
    docker-compose up -d
    ```
4.  **Build the Project:** Use Maven to build the project:
    ```bash
    mvn clean install
    ```
5.  **Run the Application:** Run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```

## API Endpoints:

**Admin Controller (`/api/admin`)**

* `GET /api/admin/getusers`: Retrieves all users. Requires the `ROLE_ADMIN` role.
* `PUT /api/admin/update-role`: Updates the role of a specified user. Requires the `ROLE_ADMIN` role.
* `GET /api/admin/user/{id}`: Retrieves a specific user by their ID. Requires the `ROLE_ADMIN` role.

**Note Controller (`/api/notes`)**

* `POST /api/notes`: Creates a new note for the currently authenticated user.
* `GET /api/notes`: Retrieves all notes belonging to the currently authenticated user.
* `PUT /api/notes/{noteId}`: Updates a specific note for the currently authenticated user.