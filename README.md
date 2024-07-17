# Java Movie Catalog Application

## Description

This project is a Java-based movie catalog application that allows users to manage a collection of movies. It demonstrates the use of interfaces, file handling, and the service pattern in object-oriented programming. The application provides options to add movies, list all movies, search for specific movies, and supports two different implementations: one using an in-memory list and another using a text file for persistent storage.

## Features

- Add new movies to the catalog
- List all movies in the catalog
- Search for a specific movie
- Two implementation options:
    1. In-memory list storage
    2. Text file storage for data persistence
- User-friendly terminal interface

## Technologies Used

- Java

## Project Structure

The project consists of several key components:

1. `IServicioPeliculas` (Interface): Declares methods for listing, adding, and searching movies
2. `ServicioPeliculasLista`: Implements the service using an in-memory list
3. `ServicioPeliculasArchivo`: Implements the service using a text file for storage
4. Main application class that provides the user interface and interactions

## How to Run

1. Ensure you have Java installed on your system.
2. Clone this repository to your local machine.
3. Navigate to the project directory in your terminal.
4. Compile the Java files.
5. Run the compiled program.

## Usage

Upon running the program, you'll be presented with a menu in the terminal:

1. Enter a number to select an operation:
- 1: Add a new movie
- 2: List all movies
- 3: Search for a movie
- 4: Exit the application
2. Follow the prompts to interact with the movie catalog.
3. The program will continue running until you choose to exit.

## Project Status

This project is completed but may be updated with additional features in the future.

## Learning Objectives

This project demonstrates advanced Java concepts including:
- Interface design and implementation
- File I/O operations
- Service pattern in Object-Oriented Programming
- Command-line interface design
- Data persistence strategies

## Implementation Details

- The `IServicioPeliculas` interface defines the contract for catalog operations.
- `ServicioPeliculasLista` implements the service using a List object.
- `ServicioPeliculasArchivo` implements the service using a text file, providing data persistence.
- The application automatically generates and manages the text file for storing movie data.
- Users can switch between in-memory and file-based storage by modifying the main class.

## Note

The code comments and variable names in this project are written in Spanish as it was developed for personal learning purposes. The logic and structure of the code remain universal.

---

This project serves as an excellent example of applying interface-based design and different data storage strategies in Java. Feel free to explore, contribute, or use it as a learning resource!