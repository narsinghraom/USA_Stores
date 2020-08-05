create database USA_Stores;

create table storetable (storeId int, storeName varchar(40), storeArea varchar(40), zipcode int, distanceInMiles float);
ALTER TABLE storetable MODIFY storeId INT PRIMARY KEY AUTO_INCREMENT;