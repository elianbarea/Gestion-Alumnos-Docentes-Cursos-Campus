package datosImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import datos.CursoAluDao;
import entidad.CursoAlu;


public class CursoAluDaoImpl implements CursoAluDao{

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "campusvirtual";
	
	public CursoAluDaoImpl()
	{
		
	}
	
	public int agregarCursoAlu(CursoAlu alu)
	{
		System.out.println(alu.getCurso());
		System.out.println(alu.getAlumno());
		String consulta = "insert into cursoalumno(curso_curAl, alumno_curAl)\r\n" + 
				"	values\r\n" + 
				"		('"+alu.getCurso()+"',"+alu.getAlumno()+")";
		
		Connection cn = null;
		int fila = 0;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			
			Statement st = cn.createStatement();
			fila = st.executeUpdate(consulta);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return fila;
	}
	
	private int Estado(float n1, float n2, float n3, float n4)
	{
		if(n1>6)
		{
			if(n2>6)
			{
				return 1;
			}else
			{
				if(n4>6)
				{
					return 1;
				}else
				{
					return 2;
				}
			}
		}else
		{
			if(n3>6)
			{
				if(n2>6)
				{
					return 1;
				}else
				{
					if(n4>6)
					{
						return 1;
					}else
					{
						return 2;
					}
				}
			}else
			{
				return 2;
			}
		}
	}

	
	public int subirNota(CursoAlu alu)
	{
		System.out.println("adasda");
		System.out.println(alu.getNt1());
		System.out.println(alu.getNt2());
		System.out.println(alu.getNt3());
		System.out.println(alu.getNt4());
		System.out.println(alu.getCurso());
		System.out.println(alu.getAlumno());
		
		int estado = Estado(alu.getNt1(),alu.getNt2(),alu.getNt3(),alu.getNt4()); 
		String consulta = "update cursoalumno set nota1_curAl = "+alu.getNt1()+", nota2_curAl = "+alu.getNt2()+", nota3_curAl = "+alu.getNt3()+", nota4_curAl = "+alu.getNt4()+", estado_curAl = "+estado+"\r\n" + 
				"	where curso_curAl = '"+alu.getCurso()+"' and alumno_curAl = "+alu.getAlumno();
		
		Connection cn = null;
		int fila = 0;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			
			Statement st = cn.createStatement();
			fila = st.executeUpdate(consulta);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return fila;
	}

	public ArrayList<CursoAlu> obtenerCursoAlu(String curso)
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		ArrayList<CursoAlu> lCursoAlu = new ArrayList<CursoAlu>();
		
		String consulta = "select curso_curAl, alumno_curAl, nota1_curAl, nota2_curAl, nota3_curAl, nota4_curAl, estado_curAl from cursoalumno\r\n" + 
				"    inner join alumno\r\n" + 
				"		on alumno_curAl = legajo_alu and estatus_alu = 1 and curso_curAl = '"+curso+"'\r\n" + 
				"	inner join estado\r\n" + 
				"		on estado_curAl = legajo_est";
		
		Connection cn = null;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			while(rs.next())
			{
				CursoAlu c = new CursoAlu();
				c.setCurso(rs.getString(1));
				c.setAlumno(rs.getInt(2));
				System.out.println("legajo alumno "+c.getAlumno());
				c.setNt1(rs.getFloat(3));
				c.setNt2(rs.getFloat(4));
				c.setNt3(rs.getFloat(5));
				c.setNt4(rs.getFloat(6));
				c.setEstado(rs.getInt(7));
				
				lCursoAlu.add(c);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return lCursoAlu;
	}
	
}
