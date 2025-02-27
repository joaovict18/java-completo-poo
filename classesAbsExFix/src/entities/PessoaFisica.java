package entities;

public class PessoaFisica extends Pessoa {

	private Double gastoComSaude;
	
	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String name, Double rendaAnual, Double gastoComSaude) {
		super(name, rendaAnual);
		this.gastoComSaude = gastoComSaude;
	}

	public Double getGastoComSaude() {
		return gastoComSaude;
	}

	public void setGastoComSaude(Double gastoComSaude) {
		this.gastoComSaude = gastoComSaude;
	}

	// errado abaixo
	@Override
	public double pagaImposto() {
		if (rendaAnual >= 20000) {
			return  (rendaAnual * 0.25) - (gastoComSaude * 0.5);
		}
		else {
			return (rendaAnual * 0.15);
		}
	}

	
}
