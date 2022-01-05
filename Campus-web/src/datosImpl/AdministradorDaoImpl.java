package datosImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import datos.AdministradorDao;
import entidad.Administrador;


public class AdministradorDaoImpl implements AdministradorDao{

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "campusvirtual";
	
	public AdministradorDaoImpl()
	{
		
	}
	
	public ArrayList<Administrador> obtenerAdministradores()
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		ArrayList<Administrador> lAdministradores = new ArrayList<Administrador>();
		
		String consulta = "select * from admin";
		Connection cn = null;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			while(rs.next())
			{
				Administrador a  = new Administrador();
				a.setUsuario(rs.getString(1));
				a.setPass(rs.getString(2));
				lAdministradores.add(a);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return lAdministradores;
	}
	
	public Administrador existeAdmin(String usu, String contra)
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		String consulta = "select * from admin\r\n" + 
				"	where usuario = '"+usu+"' and pass = '"+contra+"'";
		
		Connection cn = null;
		
		Administrador existe = new Administrador();
		
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			rs.next();
			existe.setUsuario(rs.getString(1));
			existe.setPass(rs.getString(2));
			
			System.out.println(existe.getUsuario());
			System.out.println(existe.getPass());
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return existe;
	}
	
}
