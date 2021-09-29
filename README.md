# MealTracker

_MealTracker_  project lets you track your macros and calories that you eat everyday.
Project is a web app, secured with login and password.


## Data - external API
https://pl.openfoodfacts.org/discover
MealTracker is connected to external API where from it takes the food products data and nutritin details.


## Features

* search for product - connected to external web API - realtime search
* plans management
    * create a new nutrition plan, just enter your details such as:
      *  height
      *  weight
      *  age
      *  gender
      *  percentage of particular macros you want to split your daily caloric demand for
      *  number of meals per day
    * plans management:
      * delete plan
      * set active (just one plan can be active at the time)
 * build your day meals - according to your active nutrition plan you can add particular product items to 
 particular meals and set the quantity of each.
 * Mealtracker recounts all macros and calories amount and presents it at the progress bar


## Data validation

The app provides some data validations.<br>


## Technologies and methodologies

* Spring Boot
* Hibernate
* Spring security
* jsp
* jstl
* MVC

## Start Applicaiton

1. Create a database named mealtracker <br>
CREATE DATABASE mealtracker
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci; 
2. Create a table roles (role_id, role) <br>
CREATE TABLE roles (
role_id INT AUTO_INCREMENT PRIMARY KEY,
role varchar);
3. Insert user role into the roles table <br>
INSERT INTO roles VALUES (1, 'ROLE_USER');
4. Once having that done - visit http://localhost:8080
5. Register yourself as new user.
6. Now you can log in.
7. Enjoy using _MealTracker_


**Have a nice time working with the app**
