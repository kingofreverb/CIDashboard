CREATE TABLE `app_table` (
	`APP_ID` MEDIUMINT(9) NOT NULL AUTO_INCREMENT,
	`APP_TITLE` VARCHAR(100) NULL DEFAULT NULL,
	`APP_TYPE_CODE` VARCHAR(30) NULL DEFAULT NULL,
	`APP_USER_ID` VARCHAR(50) NULL DEFAULT NULL,
	`APP_USER_NM` VARCHAR(50) NULL DEFAULT NULL,
	`APP_STS_CODE` VARCHAR(30) NULL DEFAULT NULL,
	`VERSION_NO` VARCHAR(15) NULL DEFAULT NULL,
	`APP_CHARGE_USER_ID` VARCHAR(50) NULL DEFAULT NULL,
	`APP_CHARGE_USER_NM` VARCHAR(50) NULL DEFAULT NULL,
	`APP_TIME` DATETIME NULL DEFAULT NULL,
	`UPD_TIME` DATETIME NULL DEFAULT NULL,
	`APP_MEMO` VARCHAR(500) NULL DEFAULT NULL,
	PRIMARY KEY (`APP_ID`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=6
;