insert into buyer (id, name, certified_buyer) values (1, 'Rohan', true);
insert into buyer (id, name, certified_buyer) values (2, 'Harsh', true);
insert into buyer (id, name, certified_buyer) values (3, 'Shrey', true);
insert into buyer (id, name, certified_buyer) values (4, 'RR1', false);
insert into buyer (id, name, certified_buyer) values (5, 'RR@', false);
insert into buyer (id, name, certified_buyer) values (6, 'TRGF', true);
insert into buyer (id, name, certified_buyer) values (7, 'FDFD', false);
insert into buyer (id, name, certified_buyer) values (8, 'FDF33D', true);
insert into buyer (id, name, certified_buyer) values (9, 'EWD', false);
insert into buyer (id, name, certified_buyer) values (10, 'GV@13', true);
insert into seller (id, name) values (1, 'FK');
insert into seller (id, name) values (2, 'AMZ');
insert into seller (id, name) values (3, 'MT');

insert into product (id, name, specifications, seller_id, price, product_category) values (1, 'IPHONE', '8GB - 128GB', 1, 500, 'MOBILE');
insert into product (id, name, specifications, seller_id, price, product_category) values (2, 'MAC', '16GB - 128GB', 1, 5000, 'LAPTOP');
insert into product (id, name, specifications, seller_id, price, product_category) values (3, 'SHIRT', 'XXL', 1, 50, 'FASHION');
insert into product (id, name, specifications, seller_id, price, product_category) values (4, 'BOOK', 'PAPERBACK', 2, 10, 'BOOKS');
insert into product (id, name, specifications, seller_id, price, product_category) values (5, 'CYCLE', 'MEDIUM', 2, 700, 'SPORTS');
insert into product (id, name, specifications, seller_id, price, product_category) values (6, 'DELL-DESKTOP', '15*30', 2, 100, 'COMPUTER');
insert into product (id, name, specifications, seller_id, price, product_category) values (7, 'JEANS', 'Black-36', 3, 150, 'FASHION');
insert into product (id, name, specifications, seller_id, price, product_category) values (8, 'VIVO', '6GB-64GB', 3, 300, 'MOBILE');
insert into product (id, name, specifications, seller_id, price, product_category) values (9, 'ACER-WINDOWS', '8GB - 1TB', 3, 1000, 'LAPTOP');


--insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (1, 4, 'Comment', 100, 10, 1, 1);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (2, 3, 'Comment', 50, 10, 1, 2);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (3, 2, 'Comment', 10, 10, 1, 3);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (4, 1, 'Comment', 70, 10, 1, 4);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (5, 5, 'Comment', 30, 10, 1, 5);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (6, 5, 'Comment', 55, 10, 1, 6);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (7, 4, 'Comment', 12, 10, 1, 7);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (8, 3, 'Comment', 43, 10, 1, 8);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (9, 4, 'Comment', 1, 10, 1, 9);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (10, 5, 'Comment', 43, 10, 1, 10);

insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (11, 4, 'Comment', 100, 100, 2, 1);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (12, 3, 'Comment', 50, 150, 2, 2);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (13, 3, 'Comment', 10, 50, 2, 3);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (14, 1, 'Comment', 70, 10, 2, 4);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (15, 5, 'Comment', 30, 10, 2, 5);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (16, 2, 'Comment', 55, 1, 2, 6);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (17, 4, 'Comment', 12, 19, 2, 7);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (18, 1, 'Comment', 43, 10, 2, 8);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (19, 4, 'Comment', 1, 15, 2, 9);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (20, 5, 'Comment', 43, 10, 2, 10);


insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (21, 5, 'Comment', 100, 100, 3, 1);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (22, 3, 'Comment', 50, 150, 3, 2);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (23, 1, 'Comment', 10, 50, 3, 3);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (24, 1, 'Comment', 7, 10, 3, 4);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (25, 5, 'Comment', 3, 10, 3, 5);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (26, 2, 'Comment', 52, 1, 3, 6);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (27, 4, 'Comment', 12, 19, 3, 7);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (28, 3, 'Comment', 43, 14, 3, 8);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (29, 5, 'Comment', 100, 15, 3, 9);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (30, 5, 'Comment', 43, 10, 3, 10);

insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (31, 5, 'Comment', 10, 10, 4, 1);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (32, 1, 'Comment', 50, 150, 4, 2);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (33, 1, 'Comment', 10, 5, 4, 3);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (34, 2, 'Comment', 7, 10, 4, 4);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (35, 5, 'Comment', 3, 10, 4, 5);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (36, 2, 'Comment', 52, 18, 4, 6);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (37, 4, 'Comment', 12, 19, 4, 7);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (38, 3, 'Comment', 43, 14, 4, 8);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (39, 3, 'Comment', 100, 78, 4, 9);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (40, 5, 'Comment', 43, 10, 4, 10);

insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (41, 5, 'Comment', 10, 10, 5, 1);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (42, 3, 'Comment', 50, 150, 5, 2);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (43, 1, 'Comment', 1, 5, 5, 3);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (44, 2, 'Comment', 7, 10, 5, 4);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (45, 5, 'Comment', 3, 10, 5, 5);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (46, 4, 'Comment', 2, 18, 5, 6);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (47, 4, 'Comment', 12, 19, 5, 7);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (48, 1, 'Comment', 43, 4, 5, 8);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (49, 3, 'Comment', 100, 78, 5, 9);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (50, 5, 'Comment', 43, 10, 5, 10);

insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (51, 5, 'Comment', 10, 10, 6, 1);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (52, 3, 'Comment', 50, 15, 6, 2);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (53, 3, 'Comment', 1, 5, 6, 3);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (54, 2, 'Comment', 7, 10, 6, 4);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (55, 3, 'Comment', 3, 10, 6, 5);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (56, 4, 'Comment', 2, 8, 6, 6);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (57, 4, 'Comment', 12, 19, 6, 7);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (58, 2, 'Comment', 43, 4, 6, 8);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (59, 1, 'Comment', 100, 8, 6, 9);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (60, 5, 'Comment', 43, 11, 6, 10);

insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (61, 4, 'Comment', 10, 10, 7, 1);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (62, 3, 'Comment', 50, 150, 7, 2);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (63, 1, 'Comment', 1, 5, 7, 3);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (64, 2, 'Comment', 7, 10, 7, 4);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (65, 1, 'Comment', 3, 10, 7, 5);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (66, 4, 'Comment', 2, 18, 7, 6);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (67, 3, 'Comment', 12, 19, 7, 7);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (68, 1, 'Comment', 43, 4, 7, 8);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (69, 3, 'Comment', 100, 78, 7, 9);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (70, 5, 'Comment', 43, 10, 7, 10);


insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (71, 4, 'Comment', 10, 10, 8, 1);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (72, 3, 'Comment', 50, 150, 8, 2);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (73, 1, 'Comment', 1, 5, 8, 3);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (74, 2, 'Comment', 7, 10, 8, 4);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (75, 5, 'Comment', 3, 10, 8, 5);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (76, 4, 'Comment', 2, 18, 8, 6);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (77, 1, 'Comment', 12, 19, 8, 7);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (78, 1, 'Comment', 43, 4, 8, 8);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (79, 2, 'Comment', 100, 78, 8, 9);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (80, 5, 'Comment', 43, 10, 8, 10);


insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (81, 4, 'Comment', 10, 10, 9, 1);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (82, 3, 'Comment', 50, 150, 9, 2);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (83, 3, 'Comment', 1, 5, 9, 3);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (84, 2, 'Comment', 7, 14, 9, 4);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (85, 5, 'Comment', 3, 1, 9, 5);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (86, 4, 'Comment', 2, 8, 9, 6);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (87, 2, 'Comment', 12, 19, 9, 7);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (88, 1, 'Comment', 43, 4, 9, 8);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (89, 3, 'Comment', 100, 78, 9, 9);
insert into review (id, rating, comment, like_count, dislike_count, product_id, buyer_id) values (90, 5, 'Comment', 43, 10, 9, 10);

