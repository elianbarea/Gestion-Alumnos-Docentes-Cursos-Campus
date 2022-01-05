package datosImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import datos.DocenteDao;
import entidad.Docente;

public class DocenteDaoImpl implements DocenteDao{

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "campusvirtual";
	
	public DocenteDaoImpl()
	{
		
	}
	
	public int agregarDocente(Docente docente)
	{
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		String consulta = "insert into docente (nombres_doc, apellidos_doc, dni_doc, nacimiento_doc, mail_doc, telefono_doc, localidad_doc, direccion_doc, nacionalidad_doc, pass_doc)\r\n" + 
				"	values\r\n" + 
				"		('"+docente.getNombre()+"', '"+docente.getApellido()+"', '"+docente.getDni()+"', '"+docente.getNacimiento()+"','"+docente.getMail()+"','"+docente.getTelefono()+"', '"+docente.getLocalidad()+"', '"+docente.getDireccion()+"', '"+docente.getNacionalidad()+"', '"+docente.getPassDoc()+"')";
	
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
	
	public int ocultarDocente(int legajo)
	{
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		String consulta = "update docente set estatus_doc = false\r\n" + 
				"	where legajo_doc = "+ legajo;
		
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
	
	public int obtenerUltimoLegajoDoc()
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		int id=-1;
		Connection cn = null;
		try
		{
			String consulta = "select legajo_doc FROM docente ORDER BY legajo_doc DESC LIMIT 0, 1";
			
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
	
	public int editar(Docente docente) {
		
		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

		String consulta = "UPDATE  docente SET nombres_doc='"+docente.getNombre()+"', apellidos_doc='"+docente.getApellido()+
				"', nacimiento_doc='"+docente.getNacimiento()+"', mail_doc='"+docente.getMail()+"', telefono_doc='"+docente.getTelefono()+
				"', localidad_doc='"+docente.getLocalidad()+"', direccion_doc='"+docente.getDireccion()+"', nacionalidad_doc='"+
				docente.getNacionalidad()+"', pass_doc='"+docente.getPassDoc()+"' WHERE legajo_doc='"+docente.getLegajo()+"'";
		
		Connection cn = null;
		
		int fila = 0;
		try
		 {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			
			Statement st = cn.createStatement();
			fila = st.executeUpdate(consulta);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return fila;
	}
	
public Docente obtenerUno(int legajo) {
 		
 		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

		Docente doc = new Docente();
		
		String consulta = "SELECT * FROM docente WHERE estatus_doc=1 && legajo_doc="+legajo;
				
		Connection cn = null;
		
		try
		 {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			while(rs.next())
			{
				Docente d = new Docente();
				d.setLegajo(rs.getInt(1));
				d.setNombre(rs.getString(2));
				d.setApellido(rs.getString(3));
				d.setDni(rs.getString(4));
				d.setNacimiento(rs.getString(5));
				d.setMail(rs.getString(6));
				d.setTelefono(rs.getString(7));
				d.setLocalidad(rs.getString(8));
				d.setDireccion(rs.getString(9));
				d.setNacionalidad(rs.getString(10));
				d.setPassDoc(rs.getString(11));
			}	 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return doc;
	}

public boolean validarDni(String dni) {
		
	boolean Estado = false;
	
		try 
	{
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
	
	String consulta = "SELECT * FROM docente WHERE estatus_doc=1 && dni_doc="+ dni;
			
	Connection cn = null;
	
	try
	 {
		cn = DriverManager.getConnection(host+dbName, user, pass);
		
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery(consulta);
		
		if (rs.next()) {
			
		Estado = true;
		
		} 	 
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	return Estado;
}

	public Docente existeDocente(String mail, String contra)
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		String consulta = "select legajo_doc, nombres_doc, apellidos_doc, mail_doc, pass_doc from docente\r\n" + 
				"	where estatus_doc = true and mail_doc = '"+mail+"' and pass_doc = '"+contra+"'";
		
		Connection cn = null;
		
		Docente existe = new Docente();
		
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			rs.next();
			existe.setLegajo(rs.getInt(1));
			existe.setNombre(rs.getString(2));
			existe.setApellido(rs.getString(3));
			existe.setMail(rs.getString(4));
			existe.setPassDoc(rs.getString(5));
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return existe;
	}
	
	public ArrayList<Docente> obtenerDocentes()
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		ArrayList<Docente> lDocentes = new ArrayList<Docente>();
		
		String consulta = "select * from docente where estatus_doc = true";
		Connection cn = null;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			while(rs.next())
			{
				Docente d = new Docente();
				d.setLegajo(rs.getInt(1));
				d.setNombre(rs.getString(2));
				d.setApellido(rs.getString(3));
				d.setDni(rs.getString(4));
				d.setNacimiento(rs.getString(5));
				d.setMail(rs.getString(6));
				d.setTelefono(rs.getString(7));
				d.setLocalidad(rs.getString(8));
				d.setDireccion(rs.getString(9));
				d.setNacionalidad(rs.getString(10));
				d.setPassDoc(rs.getString(11));
				lDocentes.add(d);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return lDocentes;
	}
	
}
