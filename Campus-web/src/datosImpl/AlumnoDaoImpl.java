package datosImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import datos.AlumnoDao;
import entidad.Alumno;


public class AlumnoDaoImpl implements AlumnoDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "campusvirtual";
	
	public AlumnoDaoImpl()
	{
		
	}
	
	public int agregarAlumno(Alumno alumno)
	{
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		String consulta = "Insert into alumno (legajo_alu, nombres_alu, apellidos_alu, dni_alu, nacimiento_alu, mail_alu, telefono_alu, provincia_alu, direccion_alu, nacionalidad_alu)\r\n" + 
				"	values\r\n" + 
				"		('"+alumno.getLegajo()+"','"+alumno.getNombre()+"', '"+alumno.getApellido()+"', '"+alumno.getDni()+"', '"+alumno.getNacimiento()+"','"+alumno.getMail()+"','"+alumno.getTelefono()+"', '"+alumno.getProvincia()+"', '"+alumno.getDireccion()+"', '"+alumno.getNacionalidad()+"')";
	
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
	
	public int ocultarAlumno(int legajo)
	{
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		String consulta = "update alumno set estatus_alu = false\r\n" + 
				"	where legajo_alu = "+ legajo;
		
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

 	public int obtenerUltimoLegajoAlu()
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		int id = -1;
		
		Connection cn = null;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			String consulta = "select legajo_alu FROM alumno ORDER BY legajo_alu DESC LIMIT 0, 1";
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
 	//
 	public int editar(Alumno alumno) {
	
		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

		String consulta = "UPDATE  alumno SET nombres_alu='"+alumno.getNombre()+"', apellidos_alu='"+alumno.getApellido()+
				"', nacimiento_alu='"+alumno.getNacimiento()+"', mail_alu='"+alumno.getMail()+"', telefono_alu='"+alumno.getTelefono()+
				"', provincia_alu='"+alumno.getProvincia()+"', direccion_alu='"+alumno.getDireccion()+"', nacionalidad_alu='"+
				alumno.getNacionalidad()+"' WHERE legajo_alu='"+alumno.getLegajo()+"'";
		
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
 	//
 	public Alumno obtenerUno(int legajo) {
 		
 		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 		Alumno d = new Alumno();
		
		String consulta = "select * from alumno\r\n" + 
				"	where legajo_alu = "+legajo;
				
		Connection cn = null;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			rs.next();
			
			d.setLegajo(rs.getInt(1));
			d.setNombre(rs.getString(2));
			d.setApellido(rs.getString(3));
			d.setDni(rs.getString(4));
			d.setNacimiento(rs.getString(5));
			d.setMail(rs.getString(6));
			d.setTelefono(rs.getString(7));
			d.setProvincia(rs.getString(8));
			d.setDireccion(rs.getString(9));
			d.setNacionalidad(rs.getString(10));
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
		return d;
	}
 	//
 	public boolean validarDni(String dni) {
 		
		boolean Estado = false;
		
 		try 
		{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		String consulta = "SELECT * FROM alumno WHERE estatus_alu=1 && dni_alu="+ dni;
				
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
 	//
	public ArrayList<Alumno> obtenerAlumnos()
	{
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		ArrayList<Alumno> lAlumnos = new ArrayList<Alumno>();
		
		String consulta = "select * from alumno where estatus_alu = true";
		Connection cn = null;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			while(rs.next())
			{
				Alumno d = new Alumno();
				d.setLegajo(rs.getInt(1));
				d.setNombre(rs.getString(2));
				d.setApellido(rs.getString(3));
				d.setDni(rs.getString(4));
				d.setNacimiento(rs.getString(5));
				d.setMail(rs.getString(6));
				d.setTelefono(rs.getString(7));
				d.setProvincia(rs.getString(8));
				d.setDireccion(rs.getString(9));
				d.setNacionalidad(rs.getString(10));
				lAlumnos.add(d);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return lAlumnos;
	}
	
}