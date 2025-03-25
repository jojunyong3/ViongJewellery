CREATE DATABASE viongJewellery; -- DB 생성

CREATE USER 'viongJewellery'@'%' IDENTIFIED BY 'viongJewellery';  -- 계정 생성

GRANT ALL PRIVILEGES ON viongJewellery.* TO 'viongJewellery'@'%'; -- 권한부여

FLUSH PRIVILEGES; -- 권한 즉시 적용