package datosImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import datos.EstadoDao;
import entidad.Estado;

public class EstadoDaoImpl implements EstadoDao{

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "campusvirtual";
	
	public EstadoDaoImpl()
	{
		
	}
	
	public Estado obtenerUno(int legajo)
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        }
		catch (ClassNotFoundException e) 
		{
            e.printStackTrace();
        }
		
		Estado est = new Estado();
		
		String consulta = "select * from estado\r\n" + 
				"	where legajo_est = "+legajo;
		Connection cn = null;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			rs.next();
			est.setLegajo(rs.getInt(1));
			est.setNombre(rs.getString(2));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return est;
	}
	
	public ArrayList<Estado> obtenerEstados()
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        }
		catch (ClassNotFoundException e) 
		{
            e.printStackTrace();
        }
		
		ArrayList<Estado> lEstados = new ArrayList<Estado>();
		
		String consulta = "select * from estado";
		Connection cn = null;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			while(rs.next())
			{
				Estado e  = new Estado();
				e.setLegajo(rs.getInt(1));
				e.setNombre(rs.getString(2));
				lEstados.add(e);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return lEstados;
	}
	
}
