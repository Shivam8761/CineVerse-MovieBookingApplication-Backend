# CineVerse-MovieBookingApplication-Backend
CineVerse is a Movie Booking REST API built with Spring Boot, Spring Security JWT, JPA, and MySQL. It supports user authentication, role-based access control, movie &amp; theater management, show scheduling, and seat booking functionality.


CineVerse – Movie Booking Application Backend

Project Overview

CineVerse is a RESTful Movie Ticket Booking Backend Application developed using Spring Boot, Spring Security (JWT), Spring Data JPA (Hibernate), and MySQL.

The application provides a secure and scalable backend system for managing movies, theaters, shows, and ticket bookings. It follows REST API architecture and implements Role-Based Access Control (RBAC) using JWT Authentication.

The system allows users to register, authenticate, browse available movies and shows, book seats, confirm bookings, and cancel bookings. Administrators can manage movies, theaters, shows, and other system resources through secured endpoints.

⸻

Key Features

Authentication & Authorization

* User Registration
* Admin Registration
* User Login
* JWT Token Generation
* JWT Token Validation
* Role-Based Access Control (USER / ADMIN)

Movie Management

* Add New Movies
* Update Existing Movies
* Delete Movies
* Search Movies by Title
* Filter Movies by Genre
* Filter Movies by Language
* Retrieve All Movies

Theater Management

* Add Theaters
* Update Theater Information
* Delete Theaters
* Search Theaters by Location

Show Management

* Create Movie Shows
* Update Show Details
* Delete Shows
* View Shows by Movie
* View Shows by Theater
* Retrieve All Available Shows

Booking Management

* Create Ticket Bookings
* Seat Selection Support
* Duplicate Seat Validation
* Booking Confirmation
* Booking Cancellation
* Retrieve User Bookings
* Retrieve Show Bookings
* Retrieve Bookings by Status

Business Logic Implementations

* Seat Availability Validation
* Duplicate Seat Detection
* Theater Capacity Validation
* Booking Status Management
* Cancellation Time Restrictions
* Total Ticket Price Calculation

⸻

Technology Stack

Backend

* Java
* Spring Boot

Security

* Spring Security
* JWT (JSON Web Token)

Database

* MySQL
* Spring Data JPA
* Hibernate ORM

Build Tool

* Maven

Additional Libraries

* Lombok

⸻

REST API Architecture

The application follows RESTful API design principles and exposes multiple endpoints for managing resources.

Authentication APIs

* Register User
* Register Admin
* Login

Movie APIs

* Create Movie
* Update Movie
* Delete Movie
* Get Movies
* Search Movies

Theater APIs

* Create Theater
* Update Theater
* Delete Theater
* Search Theater by Location

Show APIs

* Create Show
* Update Show
* Delete Show
* Get Shows by Movie
* Get Shows by Theater

Booking APIs

* Create Booking
* Confirm Booking
* Cancel Booking
* View User Bookings
* View Show Bookings
* View Booking Status

⸻

Security Implementation

The application uses JWT-based authentication to secure REST endpoints.

* Stateless Authentication
* JWT Token Generation
* JWT Token Validation
* Spring Security Filter Chain
* Custom JWT Authentication Filter
* Role-Based Authorization
* Protected Admin Endpoints

⸻

Database Relationships

User ↔ Booking

* One User can have multiple Bookings
* 
Movie ↔ Show

* One Movie can have multiple Shows

Theater ↔ Show

* One Theater can host multiple Shows

Show ↔ Booking

* One Show can have multiple Bookings

⸻

Future Enhancements

* Payment Gateway Integration
* Email Notifications
* Seat Layout Visualization
* Booking History Reports
* Swagger API Documentation
* Docker Deployment
* Microservices Architecture
* Redis Caching
* Kafka Event Processing

⸻

Author

Shivam Vishwakarma

Backend Developer | Java | Spring Boot | Spring Security | REST APIs | MySQL
