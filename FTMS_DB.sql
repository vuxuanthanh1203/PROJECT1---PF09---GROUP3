CREATE DATABASE project;
USE project;
CREATE TABLE users(
	user_id INT AUTO_INCREMENT,
    user_email VARCHAR(255) NOT NULL,
    user_pass VARCHAR(225) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    user_tel VARCHAR(10) NOT NULL,
    user_address VARCHAR(255) NOT NULL,
    roll INT,
    PRIMARY KEY(user_id)
);
-- CREATE TABLE admins(
-- 	ad_id INT AUTO_INCREMENT,
--     ad_email VARCHAR(255) NOT NULL,
--     ad_pass VARCHAR(225) NOT NULL,
-- 	ad_name VARCHAR(255) NOT NULL,
--     ad_tel VARCHAR(10) NOT NULL,
--     ad_address VARCHAR(255) NOT NULL,
--     PRIMARY KEY(ad_id)
-- );

CREATE TABLE ticketType(
	type_id INT AUTO_INCREMENT NOT NULL,
    type_name VARCHAR(2),
    ticket_price INT,
    PRIMARY KEY(type_id)
);

CREATE TABLE flights(
	flight_id INT AUTO_INCREMENT,
    flight_no VARCHAR(255),
    flight_date DATE,
    flight_time TIME,
    starting_point VARCHAR(255) NOT NULL,
    destination VARCHAR(255) NOT NULL,
    takeoff_time TIME,
    landing_time TIME,
    user_id INT,
    PRIMARY KEY(flight_id),
    FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE ticket(
    flight_id INT,
    type_id INT,
    FOREIGN KEY(type_id) REFERENCES ticketType(type_id),
    FOREIGN KEY(flight_id) REFERENCES flights(flight_id)
);

CREATE TABLE booking(
	booking_id INT AUTO_INCREMENT,
    flight_id INT,
    type_id INT,
    user_id INT,
    booking_date DATETIME,
    quantity INT, 
    total_price INT,
    PRIMARY KEY(booking_id),
    FOREIGN KEY(flight_id) REFERENCES flights(flight_id),
    FOREIGN KEY(type_id) REFERENCES ticketType(type_id),
    FOREIGN KEY(user_id) REFERENCES users(user_id)
);

/* Insert customer */
INSERT INTO users VALUES
(null, 'dna@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Duong Nhat Anh', '0987654321', 'Bình Thạnh, TP.Hồ Chí Minh', '2'),
(null, 'pta@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Pham Trung Anh', '0987654321', 'Yên Thành, Nghệ An', '2'),
(null, 'nvd@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Nguyen Van Dat', '0987654321', 'Quỳnh Lưu, Nghệ An', '2'),
(null, 'nmd@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Nghiem Minh Duc', '0987654321', 'Bố Trạch, Quảng Bình', '2'),
(null, 'tvd@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Trinh Van Duc', '0987654321', 'Mê Linh, Hà Nội', '2'),
(null, 'vhd@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Vu Hai Duong', '0987654321', 'Cẩm Xuyên, Hà Tĩnh', '2'),
(null, 'pdh@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Phan Duc Hai', '0987654321', 'Thảo Điền, Quận 2, TP.Hồ Chí Minh', '2'),
(null, 'pgh@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Phung Gia Hau', '0987654321', 'Lục Nam, Bắc Giang', '2'),
(null, 'bth@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Bui Trong Hieu', '0987654321', 'Tam Dương, Vĩnh Phúc', '2'),
(null, 'pth@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Pham Trung Hieu', '0987654321', 'Thạch Hà, Hà Tĩnh', '2'),
(null, 'nmh@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Nguyen Minh Hoang', '0987654321', 'Buôn Đôn, Đăk Lăk', '2'),
(null, 'nth@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Nguyen Thu Huyen', '0987654321', 'Diễn Châu, Nghệ An', '2'),
(null, 'dtk@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Dam Trung Kien', '0987654321', 'Bà Rịa, Vũng Tàu', '2'),
(null, 'ntl@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Nguyen Trong Lam', '0987654321', 'Na Rì, tỉnh Bắc Kạn', '2'),
(null, 'pdn@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Pham Duy Nghia', '0987654321', 'An Dương, Hải Phòng', '2'),
(null, 'nhn@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Nguyen Hong Nhung', '0987654321', 'Hải Hậu, Nam Định', '2'),
(null, 'dbq@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Dang Ba Quang', '0987654321', 'Long Biên, Hà Nội', '2'),
(null, 'ddt@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Dao Duy Thang ', '0987654321', 'Phú Xá, Thái Nguyên', '2'),
(null, 'vxt@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Vu Xuan Thanh', '0987654321', 'Quỳnh Phụ, Thái Bình', '2'),
(null, 'lmt@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Luong Manh Tinh ', '0987654321', 'Thanh Oai, Hà Nội', '2'),
(null, 'tqt@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Tran Quoc Toan', '0987654321', 'Hưng Hà, Thái Bình', '2'),
(null, 'nbt@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Nguyen Ba Tuan', '0987654321', 'Đống Đa, Hà Nội', '2'),
(null, 'ndt@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Nguyen Duong Tung', '0987654321', 'Can Lộc, Hà Tĩnh', '2'),
(null, 'ntt@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Nguyen Thanh Tung', '0987654321', 'Long Biên, Hà Nội', '2'),
(null, 'ltm@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Le Thanh Mai', '0987654321', 'Nông Cống, Thanh Hóa', '2'),
(null, 'dta@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Dang Tuan Anh', '0987654321', 'Mỹ Đức, Hà Nội', '2'),
(null, 'nla@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Nguyen Lan Anh', '0987654321', 'Tây Hồ, Hà Nội', '2'),
(null, 'pta@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Pham Tuan Anh', '0987654321', 'Đông La, Hoài Đức', '2'),
(null, 'tnb@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Trinh Ngoc Bao', '0987654321', 'Phúc Yên, Vĩnh Phúc', '2'),
(null, 'nhd@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Nguyen Hong Duc', '0987654321', 'Trung Hòa, Cầu Giấy', '1'),
(null, 'ttd@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Tran Thai Duong', '0987654321', 'Mỹ Đức, Hà Nội', '1'),
(null, 'thanhvx@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Vu Xuan Thanh', '0987654321', 'Giáp Bát, Hà Nội', '1'),
(null, 'pdh@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Pham Duc Huy', '0987654321', 'quận 10, TP. Hồ Chí Minh', '1'),
(null, 'ntk@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'Nguyen Tran Khanh', '0987654321', 'Long Biên, Hà Nội', '1');


/* Insert admins */
-- INSERT INTO admins VALUES 
-- (null, 'nhd@gmail.com', '1234', 'Nguyen Hong Duc', '0987654321', 'Trung Hòa, Cầu Giấy'),
-- (null, 'ttd@gmail.com', '1234', 'Tran Thai Duong', '0987654321', 'Mỹ Đức, Hà Nội'),
-- (null, 'thanhvx@gmail.com', '1234', 'Vu Xuan Thanh', '0987654321', 'Giáp Bát, Hà Nội'),
-- (null, 'pdh@gmail.com', '1234', 'Pham Duc Huy', '0987654321', 'quận 10, TP. Hồ Chí Minh'),
-- (null, 'ntk@gmail.com', '1234', 'Nguyen Tran Khanh', '0987654321', 'Long Biên, Hà Nội');

/* Insert flights */
INSERT INTO flights VALUES 
(null,'VN 4899', '2020/08/30', '02:15:00', 'Ha Noi', 'TP.Ho Chi Minh', '07:45:00', '10:00:00', '1'),
(null,'VN 227', '2020/08/30', '02:15:00', 'Ha Noi', 'TP.Ho Chi Minh', '10:00:00', '12:15:00', '1'),
(null,'VN 239', '2020/08/30', '02:15:00', 'Ha Noi', 'TP.Ho Chi Minh', '14:00:00', '16:15:00', '1'),
(null,'VN 257', '2020/08/30', '02:15:00', 'Ha Noi', 'TP.Ho Chi Minh', '16:30:00', '18:45:00', '1'),
(null,'VN 271', '2020/08/30', '02:15:00', 'Ha Noi', 'TP.Ho Chi Minh', '19:30:00', '21:45:00', '1'),
(null,'VN 285', '2020/08/30', '02:15:00', 'Ha Noi', 'TP.Ho Chi Minh', '21:00:00', '23:15:00', '2'),
(null,'VN 220', '2020/08/30', '02:10:00', 'TP.Ho Chi Minh','Ha Noi', '08:00:00', '10:10:00', '2'),
(null,'VN 226', '2020/08/30', '02:10:00', 'TP.Ho Chi Minh','Ha Noi', '09:00:00', '11:10:00', '2'),
(null,'VN 236', '2020/08/30', '02:10:00', 'TP.Ho Chi Minh','Ha Noi', '12:00:00', '14:10:00', '2'),
(null,'VN 4920', '2020/08/30', '02:10:00', 'TP.Ho Chi Minh','Ha Noi', '15:15:00', '17:25:00', '2'),
(null,'VN 276', '2020/08/30', '02:10:00', 'TP.Ho Chi Minh','Ha Noi', '20:00:00', '22:10:00', '3'),
(null,'VN 284', '2020/08/30', '02:10:00', 'TP.Ho Chi Minh','Ha Noi', '21:00:00', '23:10:00', '3'),
(null,'VN 155', '2020/08/30', '01:20:00', 'Ha Noi', 'Da Nang', '09:00:00', '10:20:00', '3'),
(null,'VN 177', '2020/08/30', '01:20:00', 'Ha Noi', 'Da Nang', '15:30:00', '16:50:00', '3'),
(null,'VN 197', '2020/08/30', '01:20:00', 'Ha Noi', 'Da Nang', '20:00:00', '21:20:00', '3'),
(null,'VN 158', '2020/08/30', '01:20:00', 'Da Nang', 'Ha Noi', '08:00:00', '09:20:00', '3'),
(null,'VN 168', '2020/08/30', '01:20:00', 'Da Nang', 'Ha Noi', '11:00:00', '12:20:00', '4'),
(null,'VN 4836', '2020/08/30', '01:20:00', 'Da Nang', 'Ha Noi', '18:15:00', '19:35:00', '4'),
(null,'VN 4858', '2020/08/30', '01:20:00', 'TP.Ho Chi Minh', 'Da Nang', '08:30:00', '09:50:00', '4'),
(null,'VN 124', '2020/08/30', '01:20:00', 'TP.Ho Chi Minh', 'Da Nang', '12:00:00', '13:20:00', '4'),
(null,'VN 136', '2020/08/30', '01:20:00', 'TP.Ho Chi Minh', 'Da Nang', '17:00:00', '18:20:00', '5'),
(null,'VN 117', '2020/08/30', '01:30:00', 'Da Nang', 'TP.Ho Chi Minh', '10:00:00', '11:30:00', '5'),
(null,'VN 133', '2020/08/30', '01:30:00', 'Da Nang', 'TP.Ho Chi Minh', '15:30:00', '17:00:00', '5'),
(null,'VN 4881', '2020/08/30', '01:30:00', 'Da Nang', 'TP.Ho Chi Minh', '21:30:00', '23:00:00', '5');

/* Insert ticket type */
INSERT INTO ticketType VALUES
(null, 'A', '300000'),
(null, 'B', '600000'),
(null, 'C', '900000');

DELIMITER //
CREATE PROCEDURE search_user (IN search INT)
BEGIN
	SELECT *
	FROM users
    WHERE user_id = search;
END //
DELIMITER ;

-- DELIMITER //
-- CREATE PROCEDURE search_ad (IN search INT)
-- BEGIN
-- 	SELECT *
-- 	FROM admins
--     WHERE ad_id = search;
-- END //
-- DELIMITER ;

DELIMITER //
CREATE PROCEDURE search_flight (IN search VARCHAR(255))
BEGIN
	SELECT *
	FROM flights
    WHERE flight_no = search;
END //
DELIMITER ;

-- drop procedure search_flight;

/* SEARCH */
DELIMITER //
CREATE PROCEDURE search (IN startpoint VARCHAR(255), IN des VARCHAR(255))
BEGIN
	SELECT f.flight_no, f.flight_date, f.flight_time, f.starting_point, f.destination, f.takeoff_time, f.landing_time
	FROM flights AS f
    -- WHERE starting_point LIKE concat('%', startpoint, '%') AND destination LIKE concat('%', des, '%');
    WHERE starting_point = startpoint AND destination = des;
END //
DELIMITER ;
--  drop procedure search;

-- call search('ha noi','da nang');

/* SEARCH TICKET*/
DELIMITER //
CREATE PROCEDURE search_ticket (IN book_id INT)
BEGIN
	SELECT f.flight_no, f.flight_date, f.flight_time, f.starting_point, f.destination, f.takeoff_time, f.landing_time, u.user_name, u.user_email, u.user_address, tt.type_name, b.booking_id
	FROM flights AS f INNER JOIN booking AS b ON f.flight_id = b.flight_id
    INNER JOIN ticketType AS tt ON b.type_id = tt.type_id
    INNER JOIN users AS u ON b.user_id = u.user_id
    WHERE booking_id = book_id;
END //
DELIMITER ;


/* SEARCH TICKET*/
DELIMITER //
CREATE PROCEDURE view_ticket (IN cus_key VARCHAR(255))
BEGIN
SELECT b.booking_id, f.flight_no, f.flight_date, f.flight_time, f.starting_point, f.destination, f.takeoff_time, f.landing_time, u.user_name, u.user_email, u.user_address, tt.type_name
FROM flights AS f INNER JOIN booking AS b ON f.flight_id = b.flight_id
INNER JOIN ticketType AS tt ON b.type_id = tt.type_id
INNER JOIN users AS u ON b.user_id = u.user_id
WHERE u.user_id = cus_key;
END //
DELIMITER ;

-- drop procedure view_ticketID;

/* SEARCH ID TICKET*/
DELIMITER //
CREATE PROCEDURE view_ticketID (IN cus_key VARCHAR(255), IN tID VARCHAR(255))
BEGIN
SELECT b.booking_id, f.flight_no, f.flight_date, f.flight_time, f.starting_point, f.destination, f.takeoff_time, f.landing_time, u.user_name, u.user_email, u.user_address, tt.type_name
FROM flights AS f INNER JOIN booking AS b ON f.flight_id = b.flight_id
INNER JOIN ticketType AS tt ON b.type_id = tt.type_id
INNER JOIN users AS u ON b.user_id = u.user_id
WHERE u.user_id = cus_key AND b.booking_id = tID;
END //
DELIMITER ;





-- select * from flights where flight_no = 'vn 231';

-- call view_ticketID('vxt@gmail.com','2');
-- drop procedure view_ticketID;
-- select * from users;
-- select * from users where user_email = 'ttt@gmail.com';
-- DROP DATABASE project;
