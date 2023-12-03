




INSERT INTO users (id, username, full_name, active, email, phone_number, password)
VALUES
    (1, 'poli', 'Poli Anulibde', 1, 'poli@abu.bon', '0883555797', '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151'),
    (2, 'qwe', 'abuuuuu', 1,  'aluuu@abu.bon', '0993921922', '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151');


INSERT INTO user_role (id, role)
VALUES
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO users_roles(user_id, role_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2);