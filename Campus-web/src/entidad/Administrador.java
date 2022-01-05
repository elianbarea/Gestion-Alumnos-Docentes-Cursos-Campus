package entidad;

public class Administrador {

	private String usuario;
	private String pass;
	
	public Administrador()
	{
		
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return "Administrador [usuario=" + usuario + ", pass=" + pass + "]";
	}
	
}
