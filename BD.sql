DROP SEQUENCE PRUEBASCRUDMICROSERVICIOS.USUARIO_ID_SEQ;
DROP SEQUENCE PRUEBASCRUDMICROSERVICIOS.PERFIL_ID_SEQ;
DROP SEQUENCE PRUEBASCRUDMICROSERVICIOS.APLICACION_ID_SEQ;

DROP TABLE PRUEBASCRUDMICROSERVICIOS.USUARIO;
DROP TABLE PRUEBASCRUDMICROSERVICIOS.PERFIL;
DROP TABLE PRUEBASCRUDMICROSERVICIOS.APLICACION;


CREATE SEQUENCE PRUEBASCRUDMICROSERVICIOS.APLICACION_ID_SEQ START WITH 1 MAXVALUE 1000000000 INCREMENT BY 1;
CREATE TABLE PRUEBASCRUDMICROSERVICIOS.APLICACION (
	ID NUMBER NOT NULL,
	NOMBRE VARCHAR2 (255)
);
ALTER TABLE PRUEBASCRUDMICROSERVICIOS.APLICACION ADD CONSTRAINT "APLICACION_ID_PK" PRIMARY KEY (ID);


CREATE SEQUENCE PRUEBASCRUDMICROSERVICIOS.PERFIL_ID_SEQ START WITH 1 MAXVALUE 1000000000 INCREMENT BY 1;
CREATE TABLE PRUEBASCRUDMICROSERVICIOS.PERFIL (
	ID NUMBER NOT NULL,
	NOMBRE VARCHAR2 (255),
	ID_APLICACION NUMBER NOT NULL
);
ALTER TABLE PRUEBASCRUDMICROSERVICIOS.PERFIL ADD CONSTRAINT "PERFIL_ID_PK" PRIMARY KEY (ID);
ALTER TABLE PRUEBASCRUDMICROSERVICIOS.PERFIL ADD CONSTRAINT "PERFIL_APLICACION_FK" FOREIGN KEY (ID_APLICACION) 
REFERENCES PRUEBASCRUDMICROSERVICIOS.APLICACION(ID);



CREATE SEQUENCE PRUEBASCRUDMICROSERVICIOS.USUARIO_ID_SEQ START WITH 1 MAXVALUE 1000000000 INCREMENT BY 1;
CREATE TABLE PRUEBASCRUDMICROSERVICIOS.USUARIO (
	ID NUMBER NOT NULL,
	NOMBRE VARCHAR2 (255),
	ID_PERFIL NUMBER NOT NULL
);
ALTER TABLE PRUEBASCRUDMICROSERVICIOS.USUARIO ADD CONSTRAINT "USUARIO_ID_PK" PRIMARY KEY (ID);
ALTER TABLE PRUEBASCRUDMICROSERVICIOS.USUARIO ADD CONSTRAINT "USUARIO_PERFIL_FK" FOREIGN KEY (ID_PERFIL) 
REFERENCES PRUEBASCRUDMICROSERVICIOS.PERFIL(ID);

INSERT INTO PRUEBASCRUDMICROSERVICIOS.APLICACION (ID, NOMBRE) VALUES 
(PRUEBASCRUDMICROSERVICIOS.APLICACION_ID_SEQ.NEXTVAL, 'APLICACION1');
INSERT INTO PRUEBASCRUDMICROSERVICIOS.APLICACION (ID, NOMBRE) VALUES 
(PRUEBASCRUDMICROSERVICIOS.APLICACION_ID_SEQ.NEXTVAL, 'APLICACION2');

INSERT INTO PRUEBASCRUDMICROSERVICIOS.PERFIL (ID, NOMBRE, ID_APLICACION) VALUES 
(PRUEBASCRUDMICROSERVICIOS.PERFIL_ID_SEQ.NEXTVAL, 'ADMIN', 1);
INSERT INTO PRUEBASCRUDMICROSERVICIOS.PERFIL (ID, NOMBRE, ID_APLICACION) VALUES 
(PRUEBASCRUDMICROSERVICIOS.PERFIL_ID_SEQ.NEXTVAL, 'USER', 1);
INSERT INTO PRUEBASCRUDMICROSERVICIOS.PERFIL (ID, NOMBRE, ID_APLICACION) VALUES 
(PRUEBASCRUDMICROSERVICIOS.PERFIL_ID_SEQ.NEXTVAL, 'ADMIN', 2);
INSERT INTO PRUEBASCRUDMICROSERVICIOS.PERFIL (ID, NOMBRE, ID_APLICACION) VALUES 
(PRUEBASCRUDMICROSERVICIOS.PERFIL_ID_SEQ.NEXTVAL, 'USER', 2);

INSERT INTO PRUEBASCRUDMICROSERVICIOS.USUARIO (ID, NOMBRE, ID_PERFIL) VALUES 
(PRUEBASCRUDMICROSERVICIOS.USUARIO_ID_SEQ.NEXTVAL, 'USERADMIN', 1);
INSERT INTO PRUEBASCRUDMICROSERVICIOS.USUARIO (ID, NOMBRE, ID_PERFIL) VALUES 
(PRUEBASCRUDMICROSERVICIOS.USUARIO_ID_SEQ.NEXTVAL, 'USER', 1);
INSERT INTO PRUEBASCRUDMICROSERVICIOS.USUARIO (ID, NOMBRE, ID_PERFIL) VALUES 
(PRUEBASCRUDMICROSERVICIOS.USUARIO_ID_SEQ.NEXTVAL, 'USERADMIN', 2);
INSERT INTO PRUEBASCRUDMICROSERVICIOS.USUARIO (ID, NOMBRE, ID_PERFIL) VALUES 
(PRUEBASCRUDMICROSERVICIOS.USUARIO_ID_SEQ.NEXTVAL, 'USER', 2);
INSERT INTO PRUEBASCRUDMICROSERVICIOS.USUARIO (ID, NOMBRE, ID_PERFIL) VALUES 
(PRUEBASCRUDMICROSERVICIOS.USUARIO_ID_SEQ.NEXTVAL, 'USERADMIN', 3);
INSERT INTO PRUEBASCRUDMICROSERVICIOS.USUARIO (ID, NOMBRE, ID_PERFIL) VALUES 
(PRUEBASCRUDMICROSERVICIOS.USUARIO_ID_SEQ.NEXTVAL, 'USER', 3);
INSERT INTO PRUEBASCRUDMICROSERVICIOS.USUARIO (ID, NOMBRE, ID_PERFIL) VALUES 
(PRUEBASCRUDMICROSERVICIOS.USUARIO_ID_SEQ.NEXTVAL, 'USERADMIN', 4);
INSERT INTO PRUEBASCRUDMICROSERVICIOS.USUARIO (ID, NOMBRE, ID_PERFIL) VALUES 
(PRUEBASCRUDMICROSERVICIOS.USUARIO_ID_SEQ.NEXTVAL, 'USER', 4);


SELECT * FROM APLICACION A;
SELECT * FROM PERFIL P;
SELECT * FROM USUARIO U;

SELECT * FROM APLICACION A
INNER JOIN PERFIL P ON A.ID = P.ID_APLICACION 
INNER JOIN USUARIO U ON P.ID  = U.ID_PERFIL;










