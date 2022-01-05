package datosImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import datos.CursoDao;
import entidad.Curso;
import entidad.Materia;
import entidad.Semestre;

public class CursoDaoImpl implements CursoDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "campusvirtual";
	
	public CursoDaoImpl()
	{
		
	}
	
	public int agregarCurso(Curso curso)
	{
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		
		
        String consulta = "call PA_Cargar_Curso ('"+curso.getDoc().getLegajo()+"', '"+curso.getMateria().getLegajo()+"', '"+curso.getSem().getLegajo()+"', '"+curso.getAño()+"')";
	
        
		
        
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

	public int obtenerUltimoLegajoCur()
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		int id=-1;
		
		try
		{
			String consulta = "select legajo_cur FROM curso ORDER BY legajo_cur DESC LIMIT 0, 1";
			Connection cn = null;
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next())
			{
				id = rs.getInt(1)+1;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}
	
	public ArrayList<Curso> obtenerCursos(int docente)
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		ArrayList<Curso> lCursos = new ArrayList<Curso>();
		
		String consulta = "select legajo_cur, materia_cur ,nombre_mat, nombre_sem, año_cur from curso\r\n" + 
				"    inner join docente\r\n" + 
				"        on legajo_doc = docente_cur and docente_cur =" +docente + 
				"    inner join materia\r\n" + 
				"        on legajo_mat = materia_cur\r\n" + 
				"    inner join semestre\r\n" + 
				"        on legajo_sem = semestre_cur;";
		Connection cn = null;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			while(rs.next())
			{
				Curso c = new Curso();
                c.setLegajo(rs.getInt(1));   
                
                
                Materia m = new Materia();
                m.setLegajo(rs.getInt(2));
                m.setNombre(rs.getString(3));
                c.setMateria(m)  ;

                System.out.println(c.getMateria().getLegajo());
                
                c.setAño( rs.getString(5));
            
                Semestre s = new Semestre();
                s.setNombre(rs.getString(4));
                c.setSem(s)  ;
                
                System.out.println(c.getSem().getLegajo());
                
                
                lCursos.add(c);
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lCursos;
	}

	public Materia obtenerMat(String curso)
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		Materia m = new Materia();
		
		String consulta = "select nombre_mat from materia\r\n" + 
				"	inner join curso\r\n" + 
				"		on legajo_mat = materia_cur and legajo_cur = '1112021'";
		
		Connection cn = null;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			rs.next();
			
			m.setNombre(rs.getString(1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return m;
	}
}
