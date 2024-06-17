/**************
* Author: Lucho Robles
* Date: 2024-03-23
* Join for books starting with Authors LastName
**************/
SELECT 
	bk.id as 'Id_Book', bk.Name as 'Book_Name', bk.ISBN13, au.Name as 'Authors name', au.Lastname as 'Authors last name', CONCAT(au.Name, ' ', au.Lastname) as 'Author'
FROM Authors au

JOIN Books bk ON bk.author_id = au.id

WHERE 
	au.Lastname = 'Garcia Marquez'; -- == .equals


/**************
* Author: Lucho Robles
* Date: 2024-03-23
* Join for books starting with Authors LastName using wildcard.
**************/
SELECT 
	bk.id as 'Id_Book', bk.Name as 'Book_Name', bk.ISBN13, au.Name as 'Authors name', au.Lastname as 'Authors last name', CONCAT(au.Name, ' ', au.Lastname) as 'Author'
FROM Authors au

JOIN Books bk ON bk.author_id = au.id

WHERE 
	au.Lastname LIkE '%Garcia%'; -- Contains, donde el porcentaje equivale a espacio. % == Wildcard