# Credit Application System

I developed an application that customers can apply for credit.  

In application, customers can be added,exist customers can be updated
and deleted.

Only customers can apply for credit with identity number and customer credit
score is created randomly and stored in Customer Credit Score table.
Then without viewing this application customer can not apply for another
credit. And also identity number is used to view application.
Customer applications and results are stored in database but customers can 
only see unviewed applications.
A customer can apply for credit as much as he/she wants.

When a customer apply for credit, this application is stored in 
Credit Application table, after viewing this application, in this table credit
application status will be 1 and this application also stored in 
Credit Application Result table. 

I used Spring Boot framework for backend, PostgreSQL for database 
and HTML for frontend.

I preferred Layered Architecture Pattern because this pattern can provides
to write organized code.

## Frontend

[Frontend link after run this project](http://localhost:8080)








