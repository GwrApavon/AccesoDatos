BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Libro" (
	"Codigo"	INTEGER NOT NULL,
	"Titulo"	TEXT,
	"Autor"	TEXT,
	"Editorial"	TEXT,
	"Agno"	INTEGER,
	"ISBN"	TEXT NOT NULL UNIQUE,
	"Numero_Ejemplares"	INTEGER,
	"Numero_Paginas"	INTEGER,
	PRIMARY KEY("Codigo")
);
CREATE TABLE IF NOT EXISTS "Socio" (
	"Codigo"	INTEGER NOT NULL,
	"Nombre"	TEXT,
	"Apellidos"	INTEGER,
	"Fecha_Nacimiento"	TEXT,
	"Domicilio"	TEXT,
	"Telefono"	TEXT,
	PRIMARY KEY("Codigo")
);
CREATE TABLE IF NOT EXISTS "Prestamo" (
	"Codigo_Libro"	INTEGER NOT NULL,
	"Codigo_Socio"	INTEGER NOT NULL,
	"Fecha_Inicio_Prestamo"	TEXT,
	"Fecha_Fin_Prestamo"	TEXT,
	PRIMARY KEY("Codigo_Libro","Codigo_Socio"),
	FOREIGN KEY("Codigo_Libro") REFERENCES "Libro"("Codigo"),
	FOREIGN KEY("Codigo_Socio") REFERENCES "Socio"("Codigo")
);
INSERT INTO "Libro" VALUES (585,'Aprende BBDD','David Gracia','PabloSr',2020,'194BBDD',5,140);
INSERT INTO "Libro" VALUES (647,'Aprende Java','Antonio Cepero','PabloSerrano',2020,'942PLSQ',10,1059);
INSERT INTO "Libro" VALUES (914,'Aprende Java','Antonio Cepero','PabloSr',2020,'340JAVA',10,1059);
INSERT INTO "Socio" VALUES (1,'María','Ramirez','1999-05-30','Plaza de España, 22','638823912');
INSERT INTO "Socio" VALUES (2,'Jose','Martinez','2001-01-14','Dr. Iranzo 58','638945659');
INSERT INTO "Socio" VALUES (3,'Rusaffa','Carpintero','1997-05-10','Calle Europa, n15, casa 3','876514359');
INSERT INTO "Socio" VALUES (4,'Tobias','Fate','1995-07-28','Calle Francia, n10,casa 8','76549768');
INSERT INTO "Prestamo" VALUES (914,1,'2022-9-29','2022-10-26');
INSERT INTO "Prestamo" VALUES (585,2,'26-10-2022',NULL);
COMMIT;
