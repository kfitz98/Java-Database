# Java-Assignment
JDBC driver used: https://dev.mysql.com/downloads/connector/j/
Database used: https://data.gov.ie/dataset/2016-make-model-year-failures-at-nct
YouTube demo: https://youtu.be/eSlzQXHRmfM
The purpose of this project is to connect to a database using Java. 

The database.class connects to the database using the MySQL connector JDBC driver. The database was made using phpMyAdmin and the data taken from https://data.gov.ie/. The database used holds data on 2016 NCT pass/fail rates for each test centre in Ireland. It contains the test centre name, total number of cars that passed,failed, failed dangerously, and a total count.

The screen class creates a GUI that displays a JTable containing data from the database and multiple JButtons with different functions. The screen class is also responsible for getting specific data and calling it when needed. 

The nct class holds different variables used to store information from the database such as the name of the test centre, pass rates, fail rates etc. 

When launched the gui displays table, and allows the user to sort by highest/lowest. A search function allows the user to search for a specific test centre which displays all the information relating to that test centre. Other buttons display interesting information from the database such as which test centre has the highest pass/fail rates.
