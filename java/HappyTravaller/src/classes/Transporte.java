package classes;

public class Transporte {
	private Integer id, numEmb;
	private String nomeComp;
	private String aerRod;
	private Float valor;

	public Transporte() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumEmb() {
		return numEmb;
	}

	public void setNumEmb(Integer numEmb) {
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

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
	
}
