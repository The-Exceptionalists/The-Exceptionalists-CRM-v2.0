CREATE SCHEMA crm_exceptionalists;
USE crm_exceptionalists;
CREATE TABLE IF NOT EXISTS `accounts` (
                                          `id` INT NOT NULL AUTO_INCREMENT,
                                          `city` VARCHAR(255) NULL DEFAULT NULL,
                                          `company_name` VARCHAR(255) NULL DEFAULT NULL,
                                          `country` VARCHAR(255) NULL DEFAULT NULL,
                                          `employee_count` INT NOT NULL,
                                          `industry` VARCHAR(255) NULL DEFAULT NULL,
                                          PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `contacts` (
                                          `id` INT NOT NULL,
                                          `account_id` INT NULL DEFAULT NULL,
                                          PRIMARY KEY (`id`),
                                          INDEX `FKl4tvq8qk7x11e16v2cnp1mja8` (`account_id` ASC) VISIBLE,
                                          CONSTRAINT `FK919o4dqu6vc2amoqtvifp1pp7`
                                              FOREIGN KEY (`id`)
                                                  REFERENCES `crm-latest`.`items` (`id`),
                                          CONSTRAINT `FKl4tvq8qk7x11e16v2cnp1mja8`
                                              FOREIGN KEY (`account_id`)
                                                  REFERENCES `crm-latest`.`accounts` (`id`));

CREATE TABLE IF NOT EXISTS `items` (
                                       `id` INT NOT NULL AUTO_INCREMENT,
                                       `company_name` VARCHAR(255) NULL DEFAULT NULL,
                                       `email` VARCHAR(255) NULL DEFAULT NULL,
                                       `name` VARCHAR(255) NULL DEFAULT NULL,
                                       `phone_number` VARCHAR(255) NULL DEFAULT NULL,
                                       PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `leads` (
                                       `id` INT NOT NULL,
                                       `sales_rep_id` INT NULL DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       INDEX `FKfxo14wqvkc8ba27nyy13owb14` (`sales_rep_id` ASC) VISIBLE,
                                       CONSTRAINT `FKfxo14wqvkc8ba27nyy13owb14`
                                           FOREIGN KEY (`sales_rep_id`)
                                               REFERENCES `crm-latest`.`sales_rep` (`id`),
                                       CONSTRAINT `FKmplheine5gemdfrxr1o2bm4en`
                                           FOREIGN KEY (`id`)
                                               REFERENCES `crm-latest`.`items` (`id`));

CREATE TABLE IF NOT EXISTS `opportunities` (
                                               `id` INT NOT NULL AUTO_INCREMENT,
                                               `product` VARCHAR(255) NULL DEFAULT NULL,
                                               `quantity` INT NOT NULL,
                                               `status` VARCHAR(255) NULL DEFAULT NULL,
                                               `account_id` INT NULL DEFAULT NULL,
                                               `decision_maker_id` INT NULL DEFAULT NULL,
                                               `sales_rep_id` INT NULL DEFAULT NULL,
                                               PRIMARY KEY (`id`),
                                               INDEX `FKeyutus9ng4fxunsxib6elbxrt` (`account_id` ASC) VISIBLE,
                                               INDEX `FKm2r9f7fkemlc1ku8vxqan6hll` (`decision_maker_id` ASC) VISIBLE,
                                               INDEX `FKajd23elxn1a79ydvpks3noab0` (`sales_rep_id` ASC) VISIBLE,
                                               CONSTRAINT `FKajd23elxn1a79ydvpks3noab0`
                                                   FOREIGN KEY (`sales_rep_id`)
                                                       REFERENCES `crm-latest`.`sales_rep` (`id`),
                                               CONSTRAINT `FKeyutus9ng4fxunsxib6elbxrt`
                                                   FOREIGN KEY (`account_id`)
                                                       REFERENCES `crm-latest`.`accounts` (`id`),
                                               CONSTRAINT `FKm2r9f7fkemlc1ku8vxqan6hll`
                                                   FOREIGN KEY (`decision_maker_id`)
                                                       REFERENCES `crm-latest`.`contacts` (`id`));

CREATE TABLE IF NOT EXISTS `sales_rep` (
                                           `id` INT NOT NULL AUTO_INCREMENT,
                                           `name` VARCHAR(255) NULL DEFAULT NULL,
                                           PRIMARY KEY (`id`));
