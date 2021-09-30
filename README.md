# MealTracker

_MealTracker_  project lets you track your macros and calories that you eat everyday.
After creating your diet plan you can configure specific meals by adding specific food products. (food products source is an external open api which MelaTracker connects to).
So once you've done that - see how you doing with macros and calories fulfillment on the progress bar.
Project is a web app, secured with login and password.
Still underconstuction. 
For now only on gitHub. Soon to be published.


## Data - external API
https://pl.openfoodfacts.org/discover
MealTracker is connected to external API where from it takes the food products data and nutrition details.


## Features

* login <br>
![Screen Shot 2021-09-29 at 2 43 18 pm](https://user-images.githubusercontent.com/83308656/135272280-5c06a6b4-b7d0-45f4-8552-91ca3786a8c2.png)


* register <br>
![Screen Shot 2021-09-29 at 2 44 24 pm](https://user-images.githubusercontent.com/83308656/135272312-a18c7930-0f8c-4c34-836f-54c473a13897.png)


* search for product - connected to external web API - realtime search <br>
![Screen Shot 2021-09-29 at 2 47 29 pm](https://user-images.githubusercontent.com/83308656/135272345-a28c3a4e-5c52-40af-b0ec-e0c14b5336d0.png)


* plans management
    * create a new nutrition plan, just enter your details such as:
      *  height
      *  weight
      *  age
      *  gender
      *  percentage of particular macros you want to split your daily caloric demand for
      *  number of meals per day <br>
![Screen Shot 2021-09-29 at 2 50 01 pm](https://user-images.githubusercontent.com/83308656/135272431-36b68dbe-cd59-4178-ae66-fdb5b8dfe277.png)


    * plans management:
      * edit plan
      * delete plan
      * set active (just one plan can be active at the time) <br>
![Screen Shot 2021-09-29 at 2 51 52 pm](https://user-images.githubusercontent.com/83308656/135272460-7758655d-f5eb-4016-bd36-9ae18e4545a1.png)


 * build your day meals - according to your active nutrition plan you can add particular product items to 
 particular meals and set the quantity of each. <br>
 ![image](https://user-images.githubusercontent.com/83308656/135272972-f5581fa6-46a8-4e3a-befb-190e2a183804.png)

 
 * Mealtracker recounts all macros and calories amount and presents it at the progress bar <br>
 ![image](https://user-images.githubusercontent.com/83308656/135273057-6f31165e-b0c9-416d-953a-b99d06192f81.png)



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
2. Create a table roles <br>
CREATE TABLE roles (
role_id INT AUTO_INCREMENT PRIMARY KEY,
role varchar);
3. Insert user role into the roles table <br>
INSERT INTO roles VALUES (1, 'ROLE_USER');
4. Open repository in your IDE
5. Make sure to change your mysql login details in code (persistence.xml and application.properties)
6. Once having that done - visit http://localhost:8080
7. Register yourself as new user.
8. Now you can log in.
9. Enjoy using _MealTracker_


**Have a nice time working with the app**


## Next stages of development

1. Product delete
2. Meal delete
3. Some more specific details when building a plan (for example: training activity, work activeness, weight reduction, ....)
4. User weight tracking
5. Some graphs presenting weight development
6. .....
