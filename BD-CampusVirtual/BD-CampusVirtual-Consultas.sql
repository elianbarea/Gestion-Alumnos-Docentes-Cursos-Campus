use campusvirtual;

/*OBTENER CURSOS DE UN DOCENTE_FORMA-INDICES*/
select legajo_cur, docente_cur, materia_cur, semestre_cur, año_cur from curso
	where docente = 1;
/*OBTENER CURSOS DE UN DOCENTE_FORMA-NOMBRES*/
select legajo_cur, nombres_doc, nombre_mat, nombre_sem, año_cur from curso
	inner join docente
		on legajo_doc = docente_cur and docente_cur = 1
	inner join materia
		on legajo_mat = materia_cur
	inner join semestre
		on legajo_sem = semestre_cur;
/*OBTENER  CURSOS DE UN DOCENTE_FORMA-TODO*/
select * from curso
	inner join docente
		on legajo_doc = docente_cur and docente_cur = 1
	inner join materia
		on legajo_mat = materia_cur
	inner join semestre
		on legajo_sem = semestre_cur;

/*OBTENER ALUMNOS DE UN CURSO_FORMA-INDICES*/
select curso_curAl, alumno_curAl, nota1_curAl, nota2_curAl, nota3_curAl, nota4_curAl, estado_curAl from cursoalumno
	where curso_curAl = '1112021';
/*OBTENER ALUMNOS DE UN CURSO_FORMA-NOMBRES*/
select curso_curAl, apellidos_alu,nombres_alu, nota1_curAl, nota2_curAl, nota3_curAl, nota4_curAl, nombre_est from cursoalumno
    inner join alumno
		on alumno_curAl = legajo_alu and estatus_alu = 1 and curso_curAl = '1112021'
	inner join estado
		on estado_curAl = legajo_est;
/*OBTENER ALUMNOS DE UN CURSO_FORMA-TODO*/		
select * from cursoalumno
    inner join alumno
		on alumno_curAl = legajo_alu and estatus_alu = 1 and curso_curAl = '1112021'
	inner join estado
		on estado_curAl = legajo_est;
/*OBTENER DOCENTES*/
select * from docente
	inner join localidad
		on localidad_doc = legajo_loc and estatus_doc = 1
	inner join nacionalidad
		on nacionalidad_doc = legajo_nac;
/*OBTENER UN DOCENTE*/
select * from docente
	inner join localidad
		on localidad_doc = legajo_loc and estatus_doc = 1 and legajo_doc = 1
	inner join nacionalidad
		on nacionalidad_doc = legajo_nac;
/*OBTENER ALUMNOS*/
select * from alumno
	inner join provincia
		on provincia_alu = legajo_pro and estatus_alu = 1
	inner join nacionalidad
		on nacionalidad_alu = legajo_nac;
/*OBTENER UN ALUMNO*/
select * from alumno
	inner join provincia
		on provincia_alu = legajo_pro and estatus_alu = 1 and legajo_alu = 1
	inner join nacionalidad
		on nacionalidad_alu = legajo_nac;

        
