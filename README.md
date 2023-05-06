## Valorant Pro Players App 

## About the Project
This project is about the Valorant pro players and their stats. It is a web application that allows users to view and add players to a database.
You can sort and search the players by their name, team, and country. You can also add a new player to the database.

to access the deployed app go to: https://finalproject-java3-tylerhand.azurewebsites.net

## Viewing and Adding Players App

This is a web application that allows users to view and add players to a database.
Requirements

    Java 8 or later
    Apache Tomcat 9 or later
    MySQL 8 or later
    Maven

## Setup

    Clone the repository
    Import the project in your favorite IDE
    Run mvn clean install to build the project
    Deploy the target/players.war file to your Tomcat instance

## Usage

## Registering

If you do not have an administrator account, you can register for one by clicking the "Register" link on the login page. After registering, you will be redirected to the login page to log in with your new account.


## Viewing Players

To view the players, simply go to the homepage URL. You will be able to see all the players in the database.
## Adding Players

To add a player, you will need to log in to the application. Here are the steps to login:

Go to the login page URL
Enter your email and password
Click the "Login" button
You will First need to make an .env file in the root directory of the project and add the following lines to it:
   
```
DB_FULL_DRIVER
DB_DRIVER     
DB_SERVER_NAME
DB_HOST       
DB_PORT       
DB_SCHEMA     
DB_PROPERTIES
DB_USER       
DB_PASSWORD

```

Then you will need to add your database credentials to the .env file like so:
    
``` 
DB_FULL_DRIVER=com.mysql.cj.jdbc.Driver
DB_DRIVER=com.mysql.cj.jdbc.Driver
DB_SERVER_NAME=your_server_name
DB_HOST=your_host
DB_PORT=your_port
DB_SCHEMA=your_schema
DB_PROPERTIES=useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
DB_USER=your_username
DB_PASSWORD=your_password
``` 
Then you will need to make a MySql connection in your IDE then run the following command in the MySql command line:

```
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  status enum('inactive', 'active', 'locked') NOT NULL,
  privileges enum('none', 'editor', 'admin', 'premium') NOT NULL
);

DELIMITER $$
CREATE PROCEDURE sp_add_user(
    IN p_first_name VARCHAR(100),
    IN p_last_name VARCHAR(100),
    IN p_email VARCHAR(100),
    IN p_password VARCHAR(255)
)
BEGIN
    INSERT INTO users (first_name, last_name, email, password)
    VALUES (p_first_name,p_last_name,p_email,p_password);
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE sp_get_all_users()
BEGIN
    SELECT id, first_name, last_name, email, status, privileges
    FROM users;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_get_user_by_id(
    IN p_id int
)
BEGIN
    SELECT id, first_name, last_name, email, status, privileges
    FROM users
    WHERE id = p_id;
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE sp_update_user(
    IN p_id int(11),
    IN p_first_name VARCHAR(100),
    IN p_last_name VARCHAR(100),
    IN p_email VARCHAR(100),
    IN p_status VARCHAR(100),
    IN p_privileges VARCHAR(100)
)
BEGIN
    UPDATE users
    SET first_name =  p_first_name,
        last_name =  p_last_name,
        email =  p_email,
        status = p_status,
        privileges = p_privileges
    WHERE id = p_id;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_update_user_password(
    IN p_id int(11),
    IN p_password VARCHAR(255)
)
BEGIN
    UPDATE users
    SET password =  p_password
    WHERE id = p_id;
END$$
DELIMITER ;

select * from users;

update users set privileges = 'premium' where id = 1;

```
After that you will be able to run the application and login with the following credentials:

After you register a new user you will need to go into your MySql command line and run the following command:

``` 
update users set privileges = 'premium' where id = 1;

```
then you will be able to Log in and add players 
    

If your credentials are correct, you will be redirected to the "Home" page where you can add a player to the database.

If your credentials are incorrect, you will stay on the login page with an error message.
Logging Out

To logout, simply close the browser or click the "Logout" button.

I hope you Enjoy the app!
