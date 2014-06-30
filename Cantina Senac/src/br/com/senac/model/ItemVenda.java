package br.com.senac.model;

public class ItemVenda {

	private int idVendaFK;
	private int idprodutoFK;

	public ItemVenda(int idVendaFK, int idprodutoFK) {
		super();
		this.idVendaFK = idVendaFK;
		this.idprodutoFK = idprodutoFK;
	}

	public int getIdVendaFK() {
		return idVendaFK;
	}

	public void setIdVendaFK(int idVendaFK) {
		this.idVendaFK = idVendaFK;
	}

	public int getIdprodutoFK() {
		return idprodutoFK;
	}

	public void setIdprodutoFK(int idprodutoFK) {
		this.idprodutoFK = idprodutoFK;
	}

	@Override
	public String toString() {
		return "ItemVenda [idVendaFK=" + idVendaFK + ", idprodutoFK="
				+ idprodutoFK + "]";
	}

}
