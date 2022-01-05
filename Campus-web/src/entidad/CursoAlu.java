package entidad;

public class CursoAlu {

	private String curso;
	private int alumno;
	private float nt1;
	private float nt2;
	private float nt3;
	private float nt4;
	private int estado;
	
	public CursoAlu() {
	
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getAlumno() {
		return alumno;
	}

	public void setAlumno(int alumno) {
		this.alumno = alumno;
	}

	public float getNt1() {
		return nt1;
	}

	public void setNt1(float nt1) {
		this.nt1 = nt1;
	}

	public float getNt2() {
		return nt2;
	}

	public void setNt2(float nt2) {
		this.nt2 = nt2;
	}

	public float getNt3() {
		return nt3;
	}

	public void setNt3(float nt3) {
		this.nt3 = nt3;
	}

	public float getNt4() {
		return nt4;
	}

	public void setNt4(float nt4) {
		this.nt4 = nt4;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "CursoAlu [curso=" + curso + ", alumno=" + alumno + ", nt1=" + nt1 + ", nt2=" + nt2 + ", nt3=" + nt3
				+ ", nt4=" + nt4 + ", estado=" + estado + "]";
	}
	
}
