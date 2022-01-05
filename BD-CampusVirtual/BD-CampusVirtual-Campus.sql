drop schema if exists campusvirtual;
create schema campusvirtual;

use campusvirtual;

drop table if exists Admin;
create table Admin
(
	usuario varchar(25) not null,
    pass varchar(10) not null,
    
    primary key PK_Administrador (usuario, pass)
);
drop table if exists Localidad;
/*create table Localidad
(
	legajo_loc int not null auto_increment,
    nombre_loc varchar(25) not null unique,
    
    primary key PK_Localidad (legajo_loc, nombre_loc)
);*/
drop table if exists Nacionalidad;
/*create table Nacionalidad
(
	legajo_nac int not null auto_increment,
    nombre_nac varchar(25) not null unique,
    
    primary key PK_Nacionalidad (legajo_nac, nombre_nac)
);*/
drop table if exists Docente;
create table Docente
(
	legajo_doc int not null auto_increment,
    nombres_doc varchar(30) not null,
    apellidos_doc varchar(35) not null,
    dni_doc varchar(10) not null unique,
    nacimiento_doc varchar(10) not null,
    mail_doc varchar(50),
    telefono_doc varchar(15),
    localidad_doc varchar(50) not null,
    direccion_doc varchar(50) not null,
    nacionalidad_doc varchar(50) not null,
    pass_doc varchar(10) not null,
    estatus_doc	boolean not null default 1,
    
    primary key PK_Docente (legajo_doc, pass_doc)/*,
    foreign key FK_Docente_Localidad (localidad_doc)
		references Localidad (legajo_loc),
	foreign key FK_Docente_Nacionalidad (nacionalidad_doc)
		references Nacionalidad (legajo_nac)*/
);
drop table if exists Provincia;
/*create table Provincia
(
	legajo_pro int not null auto_increment,
    nombre_pro varchar(25) not null unique,
    
    primary key PK_Provincia (legajo_pro, nombre_pro)
);*/
drop table if exists Alumno;
create table Alumno
(
	legajo_alu int not null auto_increment,
    nombres_alu varchar(30) not null,
    apellidos_alu varchar(35) not null,
    dni_alu varchar(10) not null,
    nacimiento_alu varchar(10) not null,
    mail_alu varchar(50),
    telefono_alu varchar(15),
    provincia_alu varchar(50) not null,
    direccion_alu varchar(50) not null,
    nacionalidad_alu varchar(50) not null,
    estatus_alu	boolean not null default 1,
    
    primary key PK_Alumno (legajo_alu, dni_alu)/*,
    foreign key FK_Alumno_Provincia (provincia_alu)
		references Provincia (legajo_pro),
	foreign key FK_Alumno_Nacionalidad (nacionalidad_alu)
		references Nacionalidad (legajo_nac)*/
);
drop table if exists Materia;
create table Materia
(
	legajo_mat int not null auto_increment,
    nombre_mat varchar(20) not null,
    
    primary key PK_Materia (legajo_mat, nombre_mat)
);
drop table if exists Semestre;
create table Semestre
( 
	legajo_sem int auto_increment,
	nombre_sem varchar(16) not null,
    
    primary key PK_Semestre (legajo_sem, nombre_sem)
);
drop table if exists Curso;
create table Curso
(
	legajo_cur varchar(10) not null,
    docente_cur int not null,
	materia_cur int not null,
    semestre_cur int not null,
    año_cur char(4) not null,
    
    primary key PK_Curso (legajo_cur),
    foreign key FK_Curso_Docente (docente_cur)
		references Docente (legajo_doc),
    foreign key FK_Curso_Materia (materia_cur)
		references Materia (legajo_mat),
	foreign key FK_Curso_Semestre (semestre_cur)
		references Semestre (legajo_sem)
);
drop table if exists Estado;
create table Estado
(
	legajo_est int not null auto_increment,
    nombre_est varchar(7) not null,
    
    primary key PK_Estado (legajo_est, nombre_est)
);
drop table if exists CursoAlumno;
create table CursoAlumno
(
	curso_curAl varchar(10) not null,
    alumno_curAl int not null,
    nota1_curAl decimal,
    nota2_curAl decimal,
    nota3_curAl decimal,
    nota4_curAl decimal,
    estado_curAl int default 1,
    
    primary key PK_CursoAlumno (curso_curAl, alumno_curAl),
    foreign key FK_CursoAlumno_Curso (curso_curAl)
		references Curso (legajo_cur),
    foreign key FK_CursoAlumno_Alumno (alumno_curAl)
		references Alumno (legajo_alu),
	foreign key FK_CursoAlumno_Estado (estado_curAl)
		references Estado (legajo_est)
)