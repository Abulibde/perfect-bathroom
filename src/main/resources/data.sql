INSERT INTO users (id, username, full_name, active, email, phone_number, password)
VALUES (1, 'poli', 'Poli Anulibde', 1, 'poli@abu.bon', '0883555797',
        '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151'),
       (2, 'qwe', 'abuuuuu', 1, 'aluuu@abu.bon', '0993921922',
        '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151');


INSERT INTO user_role (id, role)
VALUES (1, 'ADMIN'),
       (2, 'USER');

INSERT INTO users_roles(user_id, role_id)
VALUES (1, 1),
       (1, 2),
       (2, 2);

INSERT INTO products(id, added_date, brand, category, description, discount, img_url, model, name, price)
VALUES (1, (now()), 'ideal', 'SHOWER', 'ala bala nica', 0,
        'https://banya-bg.com/image/data/smesiteli-za-bania-kuhnia/grohe/EUPHORIA1-dush-za-bania-Grh.jpg', 'je211j1',
        'top shower', 350),
       (2, (now()), 'bochko', 'SHOWER', 'alwwwwwwwwwwwwwwca', 0,
        'https://banya-bg.com/image/data/smesiteli-za-bania-kuhnia/grohe/EUPHORIA1-dush-za-bania-Grh.jpg', 'je33j1',
        'top shower', 380),
       (3, (now()), 'rea', 'SHOWER_ENCLOSURES', 'asssssssssssa', 0,
        'https://banya-bg.com/image/data/smesiteli-za-bania-kuhnia/grohe/EUPHORIA1-dush-za-bania-Grh.jpg', 'jej2331',
        'top shower', 340),
       (4, (now()), 'vicard', 'SHOWER', 'ala zzzzzzzzzzzca', 0,
        'https://banya-bg.com/image/data/smesiteli-za-bania-kuhnia/grohe/EUPHORIA1-dush-za-bania-Grh.jpg', 'je2j1',
        'top shower', 320),
       (5, (now()), 'zombie', 'SHOWER', 'awwwwwwwwwwwwqqqwdqwa', 0,
        'https://banya-bg.com/image/data/smesiteli-za-bania-kuhnia/grohe/EUPHORIA1-dush-za-bania-Grh.jpg', 'je213j1',
        'top shower', 310),
       (6, (now()), 'vicard', 'SHOWER', 'ala bala nica', 0,
        'https://banya-bg.com/image/data/smesiteli-za-bania-kuhnia/grohe/EUPHORIA1-dush-za-bania-Grh.jpg', 'jej1',
        'top shower', 30);
