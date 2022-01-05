package negocioImpl;

import java.util.ArrayList;

import datos.AdministradorDao;
import datosImpl.AdministradorDaoImpl;
import entidad.Administrador;
import negocio.AdministradorNeg;

public class AdministradorNegImpl implements AdministradorNeg{

private AdministradorDao adminDao = new AdministradorDaoImpl();
	
	//Se puede recibir por constructor
	public AdministradorNegImpl(AdministradorDao adminDao)
	{
		this.adminDao = adminDao;
	}
	
	public AdministradorNegImpl()
	{
		
	}

	@Override
	public ArrayList<Administrador> obtenerAdministradores() {
		return (ArrayList<Administrador>) adminDao.obtenerAdministradores();
	}

	@Override
	public Administrador existeAdmin(String usu, String contra) {
		
		return adminDao.existeAdmin(usu, contra);
	}
	
}
