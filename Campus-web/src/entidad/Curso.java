package entidad;

public class Curso {

	private int legajo;
	private Materia materia;
	private String a�o;
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

	public String getA�o() {
		return a�o;
	}
	public void setA�o(String a�o) {
		this.a�o = a�o;
	}

	
	@Override
	public String toString() {
		return "Curso [legajo=" + legajo + ", materia=" + materia + ", a�o=" + a�o + ", Doc="
				+ Doc.getLegajo() + ", Sem=" + Sem.getLegajo() + "]";
	}
	
}
