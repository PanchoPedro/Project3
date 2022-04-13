CREATE TABLE `categories` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `category` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `companies` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `company` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `shoes` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `modelname` varchar(255) NOT NULL,
  `company` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `price` int NOT NULL,
  `imagelink` varchar(255) NOT NULL,
  `size` int NOT NULL
);

CREATE TABLE `users` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `email` varchar(255) UNIQUE NOT NULL,
  `phone` varchar(255) UNIQUE,
  `dateofbirth` date NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` varchar(255)
);

CREATE TABLE `orders` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `userid` int NOT NULL,
  `shoeid` int NOT NULL,
  `date` date NOT NULL,
  `numberofshoes` int NOT NULL
);

ALTER TABLE `shoes` ADD FOREIGN KEY (`category`) REFERENCES `categories` (`category`);

ALTER TABLE `shoes` ADD FOREIGN KEY (`company`) REFERENCES `companies` (`company`);

ALTER TABLE `orders` ADD FOREIGN KEY (`userid`) REFERENCES `users` (`id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`shoeid`) REFERENCES `shoes` (`id`);

insert into users (firstname,surname,email,dateofbirth,password,type) 
values ("admin","admin","admin@sportyshoes.com","1970-01-01","admin","admin");

Insert into companies (company)
values ("NIKE"),("Adidas"),("Puma"),("Geox"),("Reebok");

Insert into categories (category)
values ("Running"),
("Basket"),
("Soccer"),
("Voley"),
("Walking"),
("Fashion");

insert into shoes (modelname,company,category,price,imagelink,size)
values ("Cord","Adidas","Fashion","90","https://assets.adidas.com/images/w_600,f_auto,q_auto/6f03cf3d3209426aa765ad5c0088feea_9366/Sapatilhas_Cord_Laranja_H01822.jpg","36"),
("Cord","Adidas","Fashion","90","https://assets.adidas.com/images/w_600,f_auto,q_auto/6f03cf3d3209426aa765ad5c0088feea_9366/Sapatilhas_Cord_Laranja_H01822.jpg","37"),
("Cord","Adidas","Fashion","90","https://assets.adidas.com/images/w_600,f_auto,q_auto/6f03cf3d3209426aa765ad5c0088feea_9366/Sapatilhas_Cord_Laranja_H01822.jpg","38"),
("Zoom Freak 3","NIKE","Basket","125","https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/a5c165db-f019-420f-9c59-bb11ce1c56c9/sapatilhas-de-basquetebol-zoom-freak-3-MZpJZF.png","37"),
("Zoom Freak 3","NIKE","Basket","125","https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/a5c165db-f019-420f-9c59-bb11ce1c56c9/sapatilhas-de-basquetebol-zoom-freak-3-MZpJZF.png","38"),
("Zoom Freak 3","NIKE","Basket","125","https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/a5c165db-f019-420f-9c59-bb11ce1c56c9/sapatilhas-de-basquetebol-zoom-freak-3-MZpJZF.png","39");
