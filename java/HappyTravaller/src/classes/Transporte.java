package classes;

public class Transporte {
	private int id;
	private String nomeComp;
	private String aerRod;
	private String numEmb;
	private double valor;

	public Transporte() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumEmb() {
		return numEmb;
	}

	public void setNumEmb(String numEmb) {
		this.numEmb = numEmb;
	}

	public String getNomeComp() {
		return nomeComp;
	}

	public void setNomeComp(String nomeComp) {
		this.nomeComp = nomeComp;
	}

	public String getAerRod() {
		return aerRod;
	}

	public void setAerRod(String aerRod) {
		this.aerRod = aerRod;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
