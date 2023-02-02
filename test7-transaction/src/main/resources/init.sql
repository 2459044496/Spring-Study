/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 8.0.21
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `account` (
	`id` int (11),
	`name` varchar (60),
	`money` int (11)
);
insert into `account` (`id`, `name`, `money`) values('1','cui','200000000');
insert into `account` (`id`, `name`, `money`) values('2','pai','100000000');
