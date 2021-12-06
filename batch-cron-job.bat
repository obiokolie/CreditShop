@echo off

mysql -h localhost -u root -p
USE psystem
UPDATE CustomerTBL set CustomerCreditLimit=0, isLimitSet='No', LastSetDate=Now();
EXIT
echo Exit from MYSQL...
