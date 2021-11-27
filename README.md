# RAVN Challenge

First I created a database named CHALLENGE
```sql
CREATE DATABASE CHALLENGE
```
Then I created the 3 tables that were sent on the challenge, but I modified the `item_price` field type from `money` to `numeric` on the table `sale_items` so it can be easier to map in the REST API project and also is a good practice to not use `money`.
```sql
CREATE TABLE authors (
  id serial PRIMARY KEY,
  name text,
  date_of_birth timestamp
);
						
CREATE TABLE books (
  id serial PRIMARY KEY,
  author_id integer REFERENCES authors (id),
  isbn text
);
						
CREATE TABLE sale_items (
  id serial PRIMARY KEY,
  book_id integer REFERENCES books (id),
  customer_name text,
  item_price numeric,			
  quantity integer
);	
```
Then I inserted this example data:
```sql
INSERT INTO public.authors (id, name, date_of_birth) VALUES (1, 'J.R.R. Tolkien', '1892-01-03 00:00:00.000000');
INSERT INTO public.authors (id, name, date_of_birth) VALUES (2, 'JK Rowling', '1965-07-31 00:00:00.000000');
INSERT INTO public.authors (id, name, date_of_birth) VALUES (4, 'Lorelai Gilmore', '1954-12-31 00:00:00.000000');
INSERT INTO public.authors (id, name, date_of_birth) VALUES (5, 'Jose Mauro de Vasconcelos', '1954-12-31 00:00:00.000000');
INSERT INTO public.authors (id, name, date_of_birth) VALUES (6, 'Noah Gordon', '1954-12-31 00:00:00.000000');
INSERT INTO public.authors (id, name, date_of_birth) VALUES (7, 'Rick Griles', '1954-12-31 00:00:00.000000');
INSERT INTO public.authors (id, name, date_of_birth) VALUES (8, 'Carl Grimes', '1954-12-31 00:00:00.000000');
INSERT INTO public.authors (id, name, date_of_birth) VALUES (9, 'Lucas Leon', '1954-12-31 00:00:00.000000');
INSERT INTO public.authors (id, name, date_of_birth) VALUES (10, 'Steve Jobs', '1954-12-31 00:00:00.000000');
INSERT INTO public.authors (id, name, date_of_birth) VALUES (11, 'Vargas Llosa', '1954-12-31 00:00:00.000000');
INSERT INTO public.authors (id, name, date_of_birth) VALUES (12, 'García Marquez', '1954-12-31 00:00:00.000000');
INSERT INTO public.authors (id, name, date_of_birth) VALUES (13, 'Jaime Bayly', '1954-12-31 00:00:00.000000');
INSERT INTO public.authors (id, name, date_of_birth) VALUES (14, 'Bil l Bryson', '1954-12-31 00:00:00.000000');
INSERT INTO public.authors (id, name, date_of_birth) VALUES (16, 'Davod Seaworth', '1954-12-31 00:00:00.000000');
INSERT INTO public.authors (id, name, date_of_birth) VALUES (15, 'Rosa Montero', '1953-06-30 00:00:00.000000');
```
```sql
INSERT INTO public.books (id, author_id, isbn) VALUES (1, 1, '1');
INSERT INTO public.books (id, author_id, isbn) VALUES (2, 1, '2');
INSERT INTO public.books (id, author_id, isbn) VALUES (3, 1, '3');
INSERT INTO public.books (id, author_id, isbn) VALUES (4, 2, '4');
INSERT INTO public.books (id, author_id, isbn) VALUES (5, 2, '5');
INSERT INTO public.books (id, author_id, isbn) VALUES (6, 4, '6');
INSERT INTO public.books (id, author_id, isbn) VALUES (7, 5, '7');
INSERT INTO public.books (id, author_id, isbn) VALUES (8, 6, '8');
INSERT INTO public.books (id, author_id, isbn) VALUES (9, 7, '9');
INSERT INTO public.books (id, author_id, isbn) VALUES (10, 8, '10');
INSERT INTO public.books (id, author_id, isbn) VALUES (11, 9, '11');
INSERT INTO public.books (id, author_id, isbn) VALUES (12, 10, '12');
INSERT INTO public.books (id, author_id, isbn) VALUES (13, 11, '13');
INSERT INTO public.books (id, author_id, isbn) VALUES (14, 12, '14');
INSERT INTO public.books (id, author_id, isbn) VALUES (15, 13, '15');
INSERT INTO public.books (id, author_id, isbn) VALUES (16, 14, '16');
INSERT INTO public.books (id, author_id, isbn) VALUES (17, 15, '17');
```
```sql
INSERT INTO public.sale_items (id, book_id, customer_name, item_price, quantity) VALUES (4, 3, 'client', 30, 3);
INSERT INTO public.sale_items (id, book_id, customer_name, item_price, quantity) VALUES (3, 2, 'client', 10, 4);
INSERT INTO public.sale_items (id, book_id, customer_name, item_price, quantity) VALUES (2, 5, 'client', 20, 1);
INSERT INTO public.sale_items (id, book_id, customer_name, item_price, quantity) VALUES (1, 1, 'client', 10, 2);
INSERT INTO public.sale_items (id, book_id, customer_name, item_price, quantity) VALUES (5, 4, 'client', 30, 1);
INSERT INTO public.sale_items (id, book_id, customer_name, item_price, quantity) VALUES (6, 5, 'client', 10, 2);
INSERT INTO public.sale_items (id, book_id, customer_name, item_price, quantity) VALUES (7, 6, 'client', 20, 3);
INSERT INTO public.sale_items (id, book_id, customer_name, item_price, quantity) VALUES (8, 7, 'client', 50.5, 1);
INSERT INTO public.sale_items (id, book_id, customer_name, item_price, quantity) VALUES (9, 8, 'client', 70, 1);
INSERT INTO public.sale_items (id, book_id, customer_name, item_price, quantity) VALUES (10, 9, 'client', 100, 1);
INSERT INTO public.sale_items (id, book_id, customer_name, item_price, quantity) VALUES (11, 10, 'client', 90, 1);
INSERT INTO public.sale_items (id, book_id, customer_name, item_price, quantity) VALUES (12, 11, 'client', 10, 1);
INSERT INTO public.sale_items (id, book_id, customer_name, item_price, quantity) VALUES (13, 12, 'client', 20.6, 1);
INSERT INTO public.sale_items (id, book_id, customer_name, item_price, quantity) VALUES (14, 13, 'client', 30.5, 1);
INSERT INTO public.sale_items (id, book_id, customer_name, item_price, quantity) VALUES (15, 14, 'client', 40.99, 2);
INSERT INTO public.sale_items (id, book_id, customer_name, item_price, quantity) VALUES (16, 15, 'client', 18.2, 3);
INSERT INTO public.sale_items (id, book_id, customer_name, item_price, quantity) VALUES (17, 16, 'client', 13.6, 8);
INSERT INTO public.sale_items (id, book_id, customer_name, item_price, quantity) VALUES (18, 17, 'client', 18.7, 4);
```
Then I used these queries to solve the part 1 of the challenge

###### Who are the first 10 authors ordered by date_of_birth?

```sql
SELECT * 
FROM authors
ORDER BY date_of_birth 
LIMIT 10
```
###### What is the sales total for the author named “Lorelai Gilmore”?

```sql
SELECT a.name as author, sum(s.quantity) as sales
FROM authors a
INNER JOIN books b
ON b.author_id = a.id
INNER JOIN sale_items s
ON b.id = s.book_id
WHERE a.name= 'Lorelai Gilmore'
GROUP BY a.name
```

###### What are the top 10 performing authors, ranked by sales revenue?	

```sql
SELECT a.name as author, sum(s.item_price * s.quantity) as revenue
FROM authors a
INNER JOIN books b
ON b.author_id = a.id
INNER JOIN sale_items s
ON b.id = s.book_id
GROUP BY a.name 
ORDER BY revenue desc
LIMIT 10
```

For the second part of the challenge I used Java + SpringBoot because I feel more comfortable with that language and framework




