package datosImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import datos.SemestreDao;
import entidad.Semestre;

public class SemestreDaoImpl implements SemestreDao{

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "campusvirtual";
	
	public SemestreDaoImpl()
	{
		
	}
	
	public Semestre obtenerUno(int legajo)
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		Semestre s = new Semestre();
		
		System.out.println(legajo);
		
		String consulta = "select * from semestre\r\n" + 
				"	where legajo_sem = "+legajo;
				
		Connection cn = null;
		
		try
		 {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			rs.next();

			s.setLegajo(rs.getInt(1));
			s.setNombre(rs.getString(2));
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		System.out.println(s);
		return s;
	}
	
	public ArrayList<Semestre> obtenerSemestres()
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		ArrayList<Semestre> lSemestres = new ArrayList<Semestre>();
		
		String consulta = "select * from semestre";
		Connection cn = null;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			while(rs.next())
			{
				Semestre s  = new Semestre();
				s.setLegajo(rs.getInt(1));
				s.setNombre(rs.getString(2));
				lSemestres.add(s);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return lSemestres;
	}
	
}
