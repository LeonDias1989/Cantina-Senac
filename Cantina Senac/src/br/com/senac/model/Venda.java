package br.com.senac.model;

import java.util.Date;

public class Venda {

	private int codigoVenda;
	private String matriculaClienteFK;
	private String codigoFuncionarioFK;
	private Date dataVenda;

	public Venda(String matriculaClienteFK, String codigoFuncionarioFK,
			Date dataVenda) {
		super();
		this.matriculaClienteFK = matriculaClienteFK;
		this.codigoFuncionarioFK = codigoFuncionarioFK;
		this.dataVenda = dataVenda;
	}

	public Venda(int codigoVenda, String matriculaClienteFK,
			String codigoFuncionarioFK, Date dataVenda) {
		super();
		this.codigoVenda = codigoVenda;
		this.matriculaClienteFK = matriculaClienteFK;
		this.codigoFuncionarioFK = codigoFuncionarioFK;
		this.dataVenda = dataVenda;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public int getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(int codigoVenda) {
		this.codigoVenda = codigoVenda;
	}

	public String getMatriculaClienteFK() {
		return matriculaClienteFK;
	}

	public void setMatriculaClienteFK(String matriculaClienteFK) {
		this.matriculaClienteFK = matriculaClienteFK;
	}

	public String getCodigoFuncionarioFK() {
		return codigoFuncionarioFK;
	}

	public void setCodigoFuncionarioFK(String codigoFuncionarioFK) {
		this.codigoFuncionarioFK = codigoFuncionarioFK;
	}

	@Override
	public String toString() {
		return "Venda [codigoVenda=" + codigoVenda + ", matriculaClienteFK="
				+ matriculaClienteFK + ", codigoFuncionarioFK="
				+ codigoFuncionarioFK + ", dataVenda=" + dataVenda + "]";
	}
	
	

}
