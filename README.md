# Web-Student-Mangement
Student management sytem

## Setup Instructions

To get started with this project, follow these steps:

1. **Clone the repository**:
- git clone <repository_url>
- cd <project_directory>
- npm install

2. **Prerequisites**:
 - Java Development Kit (JDK) 11 or higher
 - Integrated Development Environment (IDE) such as Eclipse or IntelliJ IDEA
 - MySQL Server 9.0
 - MySQL Workbench (optional, for database management)
 - Maven (for dependency management)
 - Tomcat (8/9)

3. **Database Setup**:
- create schema web_student;
- CREATE TABLE Student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE
  );
- Insert few student details in db
    INSERT INTO Student (name, email) VALUES  
    ('Alice Johnson', 'alice.johnson@example.com'),
    ('Bob Smith', 'bob.smith@example.com'),
    ('Charlie Davis', 'charlie.davis@example.com'),
    ('Diana Evans', 'diana.evans@example.com'),
    ('Ethan Brown', 'ethan.brown@example.com');

- Create user and grant privileges


  CREATE USER 'webstudent'@'%' IDENTIFIED BY 'webstudent';
  GRANT ALL PRIVILEGES ON web_student.* TO 'webstudent'@'%';
  FLUSH PRIVILEGES;
  ALTER USER 'webstudent'@'localhost' IDENTIFIED BY 'webstudent';
  FLUSH PRIVILEGES;

- Update the context.xml file with database details

4. **Running the Application**:
- Select StudentControllerServlet file and run as -> Run on server


## Author
Shravani Mahendrakar (@shravanimahendrakar)
