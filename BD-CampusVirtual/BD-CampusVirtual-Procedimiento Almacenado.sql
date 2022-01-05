CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_Cargar_Curso`(in doc int, in mat int, in sem int, in año char(4))
BEGIN
	declare leg varchar(10);
    
    select legajo_cur into leg from curso
		where docente_cur = doc and materia_cur = mat and semestre_cur = sem and año_cur = año;
    if leg is null
	then
		insert into curso (legajo_cur, docente_cur, materia_cur, semestre_cur, año_cur)
			value
				(concat(doc, mat, sem, año), doc, mat, sem, año);
	end if;
END