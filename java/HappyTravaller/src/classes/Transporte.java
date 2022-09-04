package classes;

public class Transporte {
	private Integer id, numEmb;
	private String nomeComp;
	private String aerRod;
	private Double valor;

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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
