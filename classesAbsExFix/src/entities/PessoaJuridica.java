package entities;

public class PessoaJuridica extends Pessoa {
	
	private Integer numeroFuncionario;
	
	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String name, Double rendaAnual, Integer numeroFuncionario) {
		super(name, rendaAnual);
		this.numeroFuncionario = numeroFuncionario;
	}

	@Override
	public double pagaImposto() {
		if (numeroFuncionario > 10) {
			return (rendaAnual * 0.14);
		}
		else {
			return (rendaAnual * 0.16);
		}
	}
}
