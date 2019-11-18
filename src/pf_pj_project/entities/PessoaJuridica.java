package pf_pj_project.entities;

public class PessoaJuridica extends Pessoa {
	
	private Integer numeroFuncionarios;
	
	public PessoaJuridica() {
		super();
	}
	
	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}

	@Override
	public double calculoImposto() {
		if(numeroFuncionarios > 10) 
			return getRendaAnual() * 0.14;
		else 
			return getRendaAnual() * 0.16;
	}

	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}
}