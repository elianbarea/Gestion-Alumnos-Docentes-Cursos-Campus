package entidad;

public class Curso {

	private int legajo;
	private Materia materia;
	private String año;
	private Docente Doc;
	private Semestre Sem;
	
	
		public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia Materia) {
		materia = Materia;
	}
	
	public Docente getDoc() {
		return Doc;
	}

	public void setDoc(Docente doc) {
		Doc = doc;
	}

	public Semestre getSem() {
		return Sem;
	}

	public void setSem(Semestre sem) {
		
		Sem = sem;
		
	}


	
	public Curso()
	{
		
	}
	
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getAño() {
		return año;
	}
	public void setAño(String año) {
		this.año = año;
	}

	
	@Override
	public String toString() {
		return "Curso [legajo=" + legajo + ", materia=" + materia + ", año=" + año + ", Doc="
				+ Doc.getLegajo() + ", Sem=" + Sem.getLegajo() + "]";
	}
	
}
