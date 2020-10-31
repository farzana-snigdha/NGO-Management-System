-------------employee
create TABLE EMPLOYEE(
emp_id number ,
name varchar2(100) not null,
password  varchar2(100) not null,
email varchar2(50) not null,
dob date ,
gender varchar2(10) ,
address varchar2(200) ,
phone varchar2(20),
DESIGNATION number,
constraint emp_gender check (gender in ('Male','Female','Others')),
CONSTRAINT EMP_ID_PK PRIMARY KEY(EMP_ID),
CONSTRAINT designation_ID_fK foreign KEY(DESIGNATION) references designation(id)
);
--insert into employee(name,email,password) values('a','q@d.cpm','q');
--SELECT  max(emp_ID) FROM employee;

---- generate emp_id
set serveroutput on;
CREATE OR REPLACE FUNCTION GET_ID(emp_name varchar2,email_p varchar2)
RETURN number
IS
V_ID number;
yr number;
mn number;

BEGIN
SELECT  max(emp_ID) INTO V_ID
FROM employee;

dbms_output.put_line(v_id);

select substr(extract (year from sysdate),-2,2) into yr from dual;

select extract (month from sysdate) into mn from dual;

IF V_ID IS NULL --- Does not exist
THEN
	V_ID := to_number(TO_CHAR( yr) || TO_CHAR(mn) || '1001');
	
ELSE
	V_ID := V_ID + 1;
	
END IF;

RETURN NVL(V_ID,-1); --- -1 IS THE ERROR FLAG

END GET_ID;
/

--- Calling this from a trigger

CREATE OR REPLACE TRIGGER TRG_GEN_ID
BEFORE INSERT ON employee
FOR EACH ROW
BEGIN

:NEW.emp_ID := GET_ID(:NEW.name,:NEW.email);

END;
/


----------doctor
CREATE TABLE DOCTOR(
DOCTOR_ID NUMBER PRIMARY KEY,
EMP_ID NUMBER NOT NULL,
 specialty varchar2(100) NOT NULL,
  Available_hr date ,
QUALIFICATION VARCHAR2(100) ,
CONSTRAINT DOCTOR_EMP_ID FOREIGN KEY (EMP_ID) REFERENCES EMPLOYEE
);

CREATE SEQUENCE DOCTOR_SEQ START WITH 20989001;

CREATE OR REPLACE TRIGGER DOCTOR_TRIGGER 
BEFORE INSERT ON DOCTOR
FOR EACH ROW

BEGIN
  SELECT DOCTOR_SEQ.NEXTVAL
  INTO   :new.DOCTOR_ID
  FROM   dual;
END;
/
--------------designation------
create table designation(
id number GENERATED BY DEFAULT ON NULL AS IDENTITY,
designation_name varchar2(100),
amount number,
primary key(id)
);


select * from staff;
select name,password from employee;
SELECT staff_id,designation,e.* FROM STAFF s,employee e where s.emp_id=e.emp_id;
insert into employee(name,email,password) values('a','a','a');
commit;


----------------------drop schemas-------------------------
drop table doctor;
drop table employee;
drop table designation;
drop sequence emp_SEQ;
drop sequence doctor_SEQ;