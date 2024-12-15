show databases;
use gpu;
select * from gpu;
commit;
show tables;

CREATE TABLE gpu (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- 고유번호
    이름 VARCHAR(100) NOT NULL,  -- 이름
    제조사 VARCHAR(50),  -- 제조사
    출시일 DATE,  -- 출시일
    가격 VARCHAR(50),  -- 가격
    메모리_크기 VARCHAR(10),  -- 메모리 크기
    TDP VARCHAR(20),  -- TDP
    평점 DECIMAL(3, 1),  -- 평점
    가성비 ENUM('추천', '비추천', '') DEFAULT ''  -- 가성비
);
INSERT INTO gpu (name, manufacturer, release_date, price, memory_size, tdp, rating, value_for_money)
VALUES 
('NVIDIA GeForce RTX 4060 Ti', 'NVIDIA', '2023-05-24', '399.99$', '8GB', '160W', 4.6, '추천'),
('NVIDIA GeForce RTX 2060', 'NVIDIA', '2019-01-07', '349.99$', '6GB', '160W', 4.5, '비추천'),
('NVIDIA GeForce RTX 4090', 'NVIDIA', '2022-10-12', '1599.99$', '24GB', '450W', 4.9, '추천'),
('AMD Radeon RX 6600', 'AMD', '2021-08-30', '299.99$', '8GB', '132W', 4.2, '비추천'),
('AMD Radeon RX 7900 XTX', 'AMD', '2022-12-13', '999.99$', '24GB', '355W', 4.8, '추천'),
('AMD Radeon RX 7600', 'AMD', '2023-05-25', '269.99$', '8GB', '165W', 4.3, ''),
('NVIDIA GeForce RTX 3050', 'NVIDIA', '2022-01-27', '249.99$', '8GB', '130W', 4.2, ''),
('NVIDIA GeForce GTX 1660 Ti', 'NVIDIA', '2019-02-22', '279.99$', '6GB', '120W', 4.3, '비추천'),
('NVIDIA GeForce RTX 4070 Ti', 'NVIDIA', '2022-12-13', '799.99$', '12GB', '285W', 4.7, '추천'),
('AMD Radeon RX 5700 XT', 'AMD', '2019-07-07', '399.99$', '8GB', '225W', 4.4, '비추천'),
('NVIDIA GeForce RTX 3060', 'NVIDIA', '2021-02-25', '329.99$', '12GB', '170W', 4.4, ''),
('AMD Radeon RX 6700 XT', 'AMD', '2021-03-18', '479.99$', '12GB', '230W', 4.3, '');


ALTER TABLE gpu
    CHANGE COLUMN name 이름 VARCHAR(100) NOT NULL,
    CHANGE COLUMN manufacturer 제조사 VARCHAR(50),
    CHANGE COLUMN release_date 출시일 DATE,
    CHANGE COLUMN price 가격 VARCHAR(50),
    CHANGE COLUMN memory_size 메모리_크기 VARCHAR(10),
    CHANGE COLUMN tdp TDP VARCHAR(20),
    CHANGE COLUMN rating 평점 DECIMAL(3, 1),
    CHANGE COLUMN value_for_money 가성비 ENUM('추천', '비추천', '') DEFAULT '';
