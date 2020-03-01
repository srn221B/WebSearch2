//データベースを作る
create database "データベース名";
use "データベース名";

//リンククリック数を管理するテーブル
create table Link_History(
Link_ID int AUTO_INCREMENT PRIMARY KEY,
Link_Jumpdate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
LInk_Column VARCHAR(15)
);

//アクセス数を管理するテーブル
create table Access(
Access_ID int AUTO_INCREMENT PRIMARY KEY,
Access_Jumpdate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);
