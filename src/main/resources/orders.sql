CREATE TABLE orders (
                        idx number(6) PRIMARY KEY,
                        email varchar2(30),
                        pcode varchar2(20) NOT NULL,
                        quantity number(3) NOT NULL,
                        orderdate DATE DEFAULT sysdate
);
CREATE SEQUENCE order_seq START WITH 1;

SELECT * FROM orders;