package negocio;

import java.util.ArrayList;

import entidad.Administrador;

public interface AdministradorNeg {

	public ArrayList<Administrador> obtenerAdministradores();
	public Administrador existeAdmin(String usu, String contra);
	
}
