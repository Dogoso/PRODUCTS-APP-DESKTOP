# PRODUCTS-APP-DESKTOP
MVC using Swing to view.

# HOW TO START
First things first, update the Strings in com.doglab.factory.ConnectionFactory with you own configurations to your database. 

The database has to have two tables 'produtos' and 'categorias'.

This tables have the lines:
  - produtos:
    1. id int
    2. nome varchar(20)
    3. descricao varchar(50)
    4. categoria foreign key(categorias.id)
  - categorias:
    1. id int
    2. categoria varchar(50)

So, start the application by the 'com.doglab.main.Main' class.
