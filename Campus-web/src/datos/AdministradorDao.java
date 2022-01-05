package datos;

import java.util.ArrayList;
import entidad.Administrador;

public interface AdministradorDao {
	public ArrayList<Administrador> obtenerAdministradores();
	public Administrador existeAdmin(String usu, String contra);
}
