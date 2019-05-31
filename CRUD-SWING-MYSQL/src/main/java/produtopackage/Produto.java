package produtopackage;

import annotationpackages.Coluna;

public class Produto {
	@Coluna(nome="Nome", pos = 0)
	private String Nome;
	@Coluna(nome="Categoria", pos = 1)
	private String Categoria;
	@Coluna(nome="Preço", pos = 2)
	private double Preço;
	@Coluna(nome="Usado", pos = 3)
	private boolean Usado;
	@Coluna(nome="ID", pos = 4)
	private int Id_prod;
	
	public Produto(String Nome,String Categoria,double Preço, boolean Usado) {
		this.Nome=Nome;
		this.Categoria=Categoria;
		this.Preço=Preço;
		this.Usado=Usado;
	}
	public String toString() {
		return "Nome produto: "+this.Nome+" \nPK: "+this.Id_prod;
	}

	public Produto() {
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public double getPreço() {
		return Preço;
	}

	public void setPreço(double preço) {
		Preço = preço;
	}

	public boolean getUsado() {
		return Usado;
	}

	public void setUsado(boolean usado) {
		Usado = usado;
	}
	public int getId_prod() {
		return Id_prod;
	}
	public void setId_prod(int iD_Prod) {
		Id_prod = iD_Prod;
	}
	
	
	

}
