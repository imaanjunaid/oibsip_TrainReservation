# Train Reservation System

A basic command-line train reservation system in Java. This program allows users to register, log in, view available seats, reserve seats, and cancel reservations.

## Features

- **User Registration and Login**
- **View Available Seats**
- **Reserve a Seat**
- **Cancel a Reservation**

## Key Methods

- **registerNewUser()**: Registers a new user by taking input for a username and password.
- **authenticateUser()**: Authenticates the user by verifying the provided credentials against the registered user.
- **displayMenu()**: Displays the main menu and handles user selections for available actions.
- **showAvailableSeats()**: Displays the current status of seats, showing available and reserved seats.
- **reserveSeat()**: Reserves a seat based on user input if it is available.
- **cancelReservation()**: Cancels a reservation for a seat if it was previously reserved.

### User Class Methods
- **getName()**: Returns the username of the user.
- **getPassword()**: Returns the password of the user.
