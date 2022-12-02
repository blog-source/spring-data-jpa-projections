INSERT INTO student (id, email, first_name, last_name)
VALUES(1, 'gurgen@mail.com', 'Gurgen', 'Aloyan');

INSERT INTO address (id, student_id, state, city, street, zip_code)
VALUES(1, 1, 'AR', 'Armavir', 'Test', '00001');

INSERT INTO course (id, author, description, number, title)
VALUES(1, 'James Gosling', 'course description', 1, 'Java');

INSERT INTO student_course (course_id, student_id)
VALUES(1,1);