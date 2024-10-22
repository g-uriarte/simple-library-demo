# Book Registration Console Application
This is a simple console application that allows users to perform CRUD operations using an external book API. 
The application fetches book data from the Gutendex API and persists it in a PostgreSQL database. It supports 
the registration of books and provides several useful features for querying and managing the registered data.

## Features

- Search and Register Book by Title: Fetch book details by title from the Gutendex API and register them in the database.
- List Registered Books: Display all books that have been registered.
- List Registered Authors: Show a list of all authors whose books have been registered.
- List Living Authors on a Specific Date: Display authors who were alive on a given date.
- List Books by Language: Show books filtered by their language.

## Key Characteristics

- External API Integration: Uses the Gutendex API to search and retrieve book data.
- Data Persistence: All book, author, and language data is stored in a PostgreSQL database for long-term persistence.
- Entity Structure:
  - Book - Represents a registered book.
  - Author - Represents the authors of registered books.
  - Language - Represents the languages of the books.
  
- Duplicate Prevention: The application prevents the registration of duplicate books, authors, or languages.
  

## Technologies Used 

- Database: PostgreSQL
- External API: Gutendex API for book data

## How to Use

- Search for a Book: Use the search functionality to find a book by title.
- Register a Book: Once a book is found, you can register it into the system.
- List Data: You can list all registered books, authors, or filter books by language.
- Check Living Authors: Input a specific date to see which registered authors were alive on that day.