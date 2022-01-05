package datosImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import datos.MateriaDao;
import entidad.Materia;

public class MateriaDaoImpl implements MateriaDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "campusvirtual";
	
	public MateriaDaoImpl()
	{
		
	}
	
	public Materia obtenerUno(int legajo)
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

		Materia m = new Materia();
		
		String consulta = "select * from materia\r\n" + 
				"	where legajo_mat = "+legajo;
				
		Connection cn = null;
		
		try
		 {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			rs.next();

			m.setLegajo(rs.getInt(1));
			m.setNombre(rs.getString(2));
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return m;
	}
	
	public ArrayList<Materia> obtenerMaterias()
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		ArrayList<Materia> lMaterias = new ArrayList<Materia>();
		
		String consulta = "select * from materia";
		Connection cn = null;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			while(rs.next())
			{
				Materia m  = new Materia();
				m.setLegajo(rs.getInt(1));
				m.setNombre(rs.getString(2));
				lMaterias.add(m);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return lMaterias;
	}
	
}
