CREATE TABLE `app_request_msa` (
	`APP_ID` MEDIUMINT(9) NOT NULL DEFAULT '0',
	`REPOSITORY_NAME` VARCHAR(50) NULL DEFAULT NULL,
	`CI_CHARGE_PERSON` VARCHAR(50) NULL DEFAULT NULL,
	`GIT` VARCHAR(30) NULL DEFAULT NULL,
	`TEST_START_DATE` DATE NULL DEFAULT NULL,
	PRIMARY KEY (`APP_ID`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
