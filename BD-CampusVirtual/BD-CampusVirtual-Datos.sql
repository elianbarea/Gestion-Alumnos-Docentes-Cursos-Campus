use campusvirtual;

#Botón de auto destrucción
#truncate table cursodocente;
#truncate table cursoalumno;
#truncate table curso;
#truncate table materia;
#truncate table docente;
#truncate table alumno;
#truncate table carrera;
#truncate table admin;

Insert into admin (usuario, pass)
	values 
		('Ainz','momon'),
		('Claudio', 'frnandez');
     
/*Insert into localidad (nombre_loc)
	values 
		('Azul'),
        ('Bolivar'),
        ('Campana'),
        ('Cañuelas'),
		('Chivilcoy'),
        ('Crnl. Pringles'),
        ('Escobar'),
        ('Gral. Belgrano'),
        ('Junin'),
		('Lujan'),
        ('Maipu'),
        ('Pilar'),
        ('San Isidro'),
        ('Tigre'),
        ('Torcuato');

Insert into provincia (nombre_pro)
	values
		('Bs. As.'),
        ('CABA'),
        ('Catamarca'),
        ('Chaco'),
        ('Chubut'),
        ('Cordoba'),
        ('Corrientes'),
        ('Entre Rios'),
        ('Formosa'),
        ('Jujuy'),
        ('La Pampa'),
        ('La Rioja'),
        ('Mendoza'),
        ('Misiones'),
        ('Nequén'),
        ('Rio Negro'),
        ('Salta'),
        ('San Luis'),
        ('San Juan'),
        ('Santa Fe'),
        ('Santa Cruz'),
        ('Santiago del Estero'),
        ('Tierra del Fuego'),
        ('Tucuman');

Insert into nacionalidad (nombre_nac)
	values
		('Argentina'),
        ('Boliviana'),
        ('Brasileña'),
        ('Chilena'),
        ('Colombiana'),
        ('Cubana'),
        ('Española'),
        ('Estado Unidense'),
        ('Mexicana'),
        ('Panameña'),
        ('Paraguaya'),
        ('Peruana'),
        ('Puerto Riquense'),
        ('Uruguaya'),
        ('Venezolana'),
        ('Sudafricana'),
        ('Japonesa');*/

Insert into docente (nombres_doc, apellidos_doc, dni_doc, nacimiento_doc, mail_doc, telefono_doc, localidad_doc, direccion_doc, nacionalidad_doc, pass_doc)
	values
		('Minta', 'Suzumaru', '36897412', '4/3/1999','bell_minta@yahoo.com.jp','011 33413847', 'Escobar', 'Santiago del Estero 300', 'Argentina', 'blenyojer'),
        ('Eduardo', 'Azaro', '34775413', '12/3/1987','Edua@yahoo.com','011 43129765', 'Escobar', 'Cuba 24', 'Argentina', 'DameEl10'),
        ('Pablo', 'Cufre', '40197643', '15/2/1976','pabloc@gmail.com','011 33254476', 'Escobar', 'Ecuador 51', 'Argentina', 'Jajaja'),
        ('Fernando', 'Hernandez', '39765503', '23/12/1988','ferh@yahoo.com','011 09768544', 'Escobar', 'Castellar 763', 'Argentina', 'Algo34'),
        ('Ignacio', 'Rodriguez', '36215543', '23/2/1997','IgiR@gmail.com','011 05432197', 'Escobar', 'España 23', 'Argentina', 'NoSeNada'),
        ('Ezaquie Pablo', 'Fernandez', '38756633', '14/6/1995','Ezepf@yahoo.com','011 06774523', 'Escobar', 'Mexico 233', 'Argentina', 'LaClave'),
        ('Juan Jose', 'Tro', '32119017', '6/5/1978','jjtro@gmail.com','011 09654327', 'Escobar', 'Suiza 1233', 'Argentina', 'clavex12'),
        ('Jose Maria', 'Rossi', '39652217', '22/8/1987','jmrossi@yahoo.com','011 55564399', 'Escobar', 'El Tala 32', 'Argentina', 'MessiRey'),
        ('Maria Jose', 'Conte', '33657766', '15/2/1976','elconte@gmail.com','011 32166544', 'Escobar', 'Suiza 24', 'Argentina', 'Docente41'),
        ('Lucia', 'Perez', '38099984', '10/10/1986','luciaperez@yahoo.com','011 66778855', 'Escobar', 'Jujuy 22', 'Argentina', 'Anime'),
        ('Ana Maria', 'De Jesus', '39445512', '8/8/1998','Anamdj@gmail.com','011 43949865', 'Escobar', 'Salta 345', 'Argentina', 'ElUwu'),
        ('Sofia', 'Mahl', '37331243', '13/3/1978','mahlso@yahoo.com','011 09800764', 'Escobar', 'Don Jose 33', 'Argentina', 'Vamos45'),
        ('Claudia', 'Chavez', '39316577', '12/6/1994','claudita7@gmail.com','011 87567880', 'Escobar', 'Cuyo 387', 'Argentina', 'Queso81'),
        ('Jesus', 'Martines', '38666533', '23/12/1986','jesus10@gmail.com','011 08776549', 'Escobar', 'Junin 32', 'Argentina', 'ReyJ231'),
        ('Matias Javier', 'Tremoceiro', '36998812', '21/11/1994', 'tremoM@gmail.com', '348 45379876', 'Escobar', 'Cochabamba 3000', 'Argentina', 'kiriEiji');
        
Insert into alumno (nombres_alu, apellidos_alu, dni_alu, nacimiento_alu, mail_alu, telefono_alu, provincia_alu, direccion_alu, nacionalidad_alu)
	values
		('Lucila Elis', 'Huertas','42101010', '23/5/2000', 'eliLu@gmail.com', '011 11111111', 'BsAs', '25 de Mayo 1800', 'Argentina'),
        ('Sofia Joahana', 'Casmuz','41101010', '25/3/1999', 'joySof@gmail.com', '011 11111122', 'BsAs', '9 de Julio', 'Argentina'),
        ('Pablo Sebastian', 'Castañeda','40231010', '23/5/1997', 'pabloS@gmail.com', '011 11234111', 'BsAs', 'Sarmiento 2000', 'Argentina'),
        ('Jose Luis', 'Di Maria','43448956', '12/6/1998', 'Jluis@gmail.com', '011 96432064', 'BsAs', 'Rivadavia 11', 'Argentina'),
        ('Juan Carlos', 'Cruz','49225302', '26/2/2002', 'elCruz@gmail.com', '011 08532097', 'BsAs', 'San Martin 22', 'Argentina'),
        ('Ana', 'Rodriguez','41035981', '14/4/1999', 'AnitaR@gmail.com', '011 39654104', 'BsAs', 'Zapiola 98', 'Argentina'),
        ('Juana', 'Sanchez','42994052', '15/5/2003', 'JuaSan@gmail.com', '011 05978132', 'BsAs', 'Sarmiento 984', 'Argentina'),
        ('Dibu', 'Matinez','42119526', '15/3/1999', 'ElDibu@gmail.com', '011 05492156', 'BsAs', 'Chile 26', 'Argentina'),
        ('Leonel', 'Messi','40428721', '21/7/1994', 'Messirve@gmail.com', '011 09876543', 'BsAs', 'Patagonia 100', 'Argentina'),
        ('Martin', 'Hernandez','42119015', '15/6/1989', 'TinchoH@gmail.com', '011 12345670', 'BsAs', 'Bogota 1233', 'Argentina'),
        ('Elsa', 'Nieves','41560393', '18/8/1995', 'FrioEN@gmail.com', '011 99553211', 'BsAs', 'Lima 600', 'Argentina'),
        ('Ricardo Alberto', 'Perez','41114506', '9/9/1999', 'PerezRA@gmail.com', '011 03291854', 'BsAs', 'Sucre 643', 'Argentina'),
        ('Miriam Maria', 'Fernandez','48334051', '12/1/1998', 'mmfernandez@gmail.com', '011 03214321', 'BsAs', 'Montevideo 93', 'Argentina'),
        ('Rocio Belen', 'Rosario','42334566', '23/2/2000', 'rociolagrosa@gmail.com', '011 09885433', 'BsAs', 'Viamomnte 65', 'Argentina'),
        ('Elian Francisco', 'Barea','42134510', '23/2/2001', 'eliBar@gmail.com', '011 11123241', 'BsAs', 'Carpincho 26', 'Argentina');

Insert into materia (nombre_mat)
	values
		('Programación I'),
        ('Programación II'),
        ('Programación III'),
        ('Programación IV'),
        ('Laboratorio I'),
        ('Laboratorio II'),
        ('Laboratorio III'),
		('Estadistica'),
        ('Matematicas'),
        ('Ingles I'),
        ('Ingles II'),
        ('Ingles Avanzado'),
        ('Robotica'),
        ('Legislacion'),
        ('Cyber seguridad'),
        ('SPD'),
        ('ArSO'),
        ('Diseño de Bases'),
        ('Org. Empresarial'),
        ('EIO'),
        ('Metodología de Sist.'),
        ('Org. Contable');

Insert into semestre (nombre_sem)
	values
		('Primer Semestre'),
        ('Segundo Semestre');
        
Insert into estado (nombre_est)
	values
		('Regular'),
        ('Libre');

call PA_Cargar_Curso(1,1,1,'2021');
call PA_Cargar_Curso(1,1,2,'2021');
call PA_Cargar_Curso(1,2,1,'2021');
call PA_Cargar_Curso(1,2,2,'2021');
call PA_Cargar_Curso(1,5,1,'2021');
call PA_Cargar_Curso(1,5,2,'2021');
call PA_Cargar_Curso(1,6,1,'2021');
call PA_Cargar_Curso(1,6,2,'2021');
call PA_Cargar_Curso(2,1,1,'2021');
call PA_Cargar_Curso(2,1,2,'2021');
call PA_Cargar_Curso(2,2,1,'2021');
call PA_Cargar_Curso(2,2,2,'2021');
call PA_Cargar_Curso(15,13,1,'2021');
call PA_Cargar_Curso(15,13,2,'2021');
call PA_Cargar_Curso(15,15,1,'2021');
call PA_Cargar_Curso(15,15,2,'2021');
call PA_Cargar_Curso(3,10,1,'2021');
call PA_Cargar_Curso(3,10,2,'2021');
call PA_Cargar_Curso(3,11,1,'2021');
call PA_Cargar_Curso(3,11,2,'2021');
call PA_Cargar_Curso(3,12,1,'2021');
call PA_Cargar_Curso(3,12,2,'2021');

insert into cursoalumno (curso_curAl, alumno_curAl)
	values
		('1112021',15),
        ('1112021',14),
        ('1112021',13),
        ('1112021',12),
        ('1112021',11),
        ('1112021',10),
        ('1122021',9),
        ('1122021',8),
        ('1122021',7),
        ('1122021',6),
        ('1122021',5),
        ('1122021',4),
        ('1122021',3),
        ('1122021',2),
        ('1122021',1),
        ('1222021',15),
        ('1222021',14),
        ('1222021',13),
        ('1222021',12),
        ('1222021',11),
        ('1222021',10);
