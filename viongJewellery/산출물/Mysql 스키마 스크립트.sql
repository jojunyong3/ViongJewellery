CREATE DATABASE viongJewellery; -- DB 생성

CREATE USER 'viongJewellery'@'%' IDENTIFIED BY 'viongJewellery';  -- 계정 생성

GRANT ALL PRIVILEGES ON viongJewellery.* TO 'viongJewellery'@'%'; -- 권한부여

FLUSH PRIVILEGES; -- 권한 즉시 적용


CREATE TABLE CODE (
    CODE VARCHAR(15) PRIMARY KEY COMMENT '코드',
    CODE_NAME VARCHAR(100) NOT NULL COMMENT '코드명',
    UP_CODE VARCHAR(15) COMMENT '상위코드',
    SORT NUMERIC(3) COMMENT '정렬',
    ETC01 VARCHAR(100) COMMENT '기타1',
    ETC02 VARCHAR(100) COMMENT '기타2',
    USE_YN CHAR(1) COMMENT '사용여부'
)COMMENT='공통코드 테이블';

CREATE TABLE METAL_PRICES (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '기본 키 (자동 증가)',
    METAL_TYPE VARCHAR(15) NOT NULL COMMENT '금속 종류 (MT001 하위코드들)',
    PRICE_DATE DATE NOT NULL COMMENT '시세 기준 날짜',
    OFFICIAL_PRICE DECIMAL(10, 2) NOT NULL COMMENT '공식 시세 가격 (공시가)',
    BUY_PRICE DECIMAL(10, 2) NOT NULL COMMENT '매입가 (공시가보다 낮음)',
    SELL_PRICE DECIMAL(10, 2) NOT NULL COMMENT '판매가 (공시가보다 높음)',
    UNIT VARCHAR(10) DEFAULT 'g' COMMENT '단위 (기본값: g)',
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '레코드 생성 시각',
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '레코드 수정 시각',
    
    UNIQUE KEY UQ_METAL_DATE_TYPE (PRICE_DATE, METAL_TYPE)
) COMMENT='금은방 금속 시세 정보 테이블';




CREATE TABLE PRODUCT (
   SEQ INT AUTO_INCREMENT PRIMARY KEY COMMENT '번호',
  NAME varchar(30) NOT NULL COMMENT '제품이름',
  HAND_EXPENSES int NOT NULL COMMENT '수공비',
  WEIGHT int NOT NULL COMMENT '중량',
  SIZE int NOT NULL COMMENT '사이즈',
  STOCK int NOT NULL COMMENT '재고',
  CONTENT varchar(100) NOT NULL COMMENT '제품설명',
  IMAGE varchar(100) NOT NULL COMMENT '제품이미지',
  STATUS_CODE varchar(10) NOT NULL COMMENT '제품상태',
  CATEGORY_CODE varchar(10) NOT NULL COMMENT '제품분류'
  );
  
  
  
  
CREATE TABLE NOTICE (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '기본 키 (자동 증가)',
    TITLE VARCHAR(100) NOT NULL COMMENT '제목',
    CONTENT VARCHAR(500) NOT NULL COMMENT '내용',
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '공지 계시일'
) COMMENT='공지사항';
