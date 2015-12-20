CREATE TABLE `student` (
 `serialId` int(5) NOT NULL AUTO_INCREMENT,
 `studentId` varchar(25) NOT NULL,
 `name` varchar(25) DEFAULT NULL,
 `dob` varchar(25) DEFAULT NULL,
 `status` varchar(25) DEFAULT NULL,
 `cpi` decimal(3,2) DEFAULT NULL,
 PRIMARY KEY (`serialId`),
 UNIQUE KEY (`studentId`));
 
 CREATE TABLE `grade` (
 `id` varchar(25) NOT NULL,
 `year` varchar(25) NOT NULL,
 `gpi` decimal(3,2) DEFAULT NULL,
 `year_result` varchar(25) DEFAULT NULL,
 `subject1` varchar(25) DEFAULT NULL,
 `subject2` varchar(25) DEFAULT NULL,
 `subject3` varchar(25) DEFAULT NULL,
 `subject4` varchar(25) DEFAULT NULL,
 `subject5` varchar(25) DEFAULT NULL,
 PRIMARY KEY (`id`,`year`),
 FOREIGN KEY (`id`) REFERENCES student(`studentId`) ON DELETE CASCADE);