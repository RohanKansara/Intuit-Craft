package com.rohan.intuit.review.config;

public class Temp {

    /*
    Get reviews by product id - SELECT r.comment, r.like_count, r.dislike_count, r.rating, b.name as buyerName, p.name as productName FROM REVIEW r inner join product p on r.product_id=p.id and p.id = 1 inner join buyer b on r.buyer_id=b.id;

    Get accumulated product review - SELECT product_id, avg(rating) FROM REVIEW where product_id = 1;

    Get product, name review - SELECT p.id, p.name, avg(r.rating) FROM REVIEW r inner join product p on r.product_id = p.id and p.id=2 group by p.id

    Get product name, rating, its count - SELECT p.id, p.name, r.rating, count(r.rating) FROM REVIEW r inner join product p on r.product_id = p.id and p.id=1 group by p.id, r.rating

    Get review comment, name, rating ordered by rating desc - SELECT p.id, p.name, r.comment, r.rating, FROM REVIEW r inner join product p on r.product_id = p.id and p.id=1 order by r.rating desc

    Get review comment, name, rating and certified buyer review - SELECT p.id, p.name, r.comment, r.rating, FROM REVIEW r inner join product p on r.product_id = p.id and p.id=1 inner join buyer b on r.buyer_id=b.id and b.CERTIFIED_BUYER=true order by r.rating desc

    Get name, comment, rating - SELECT b.name, r.comment, r.rating, FROM REVIEW r inner join buyer b on r.buyer_id=b.id and b.id = 1
     */
}
