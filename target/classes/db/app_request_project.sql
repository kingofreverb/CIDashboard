CREATE TABLE `app_request_project` (
	`APP_ID` MEDIUMINT(9) NOT NULL DEFAULT '0',
	`PROJECT_NAME` VARCHAR(50) NULL DEFAULT NULL,
	`GIT` VARCHAR(30) NULL DEFAULT NULL,
	`MASTER_MAIL_ADDRESS` VARCHAR(50) NULL DEFAULT NULL,
	`PURPOSE` VARCHAR(200) NULL DEFAULT NULL,
	`PROJECT_TYPE_CODE` VARCHAR(30) NULL DEFAULT NULL,
	`DEPENDENCY_CODE` VARCHAR(30) NULL DEFAULT NULL,
	PRIMARY KEY (`APP_ID`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
