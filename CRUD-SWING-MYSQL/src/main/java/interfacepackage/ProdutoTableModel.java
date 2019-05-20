package interfacepackage;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.table.AbstractTableModel;

import produtopackage.ProdutoDAO;
import produtopackage.Produto;

public class ProdutoTableModel extends AbstractTableModel{

	private List<Produto> produtos;
	private List<Produto> selecionados;
	private List<String> colunas= Arrays.asList("Nome","Preço","Categoria","Usado","ID");
	private ProdutoDAO dao;
	
	public ProdutoTableModel(ProdutoDAO dao) {
		this.dao=dao;
		this.produtos=dao.listProduto();
		this.selecionados=produtos;
	}
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.size();
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return selecionados.size();
	}

	public Object getValueAt(int linha, int coluna) {
		Produto p = selecionados.get(linha);
		switch  (coluna) {
		case 0 :
			return p.getNome();
		case 1:
			return p.getPreço();
		case 2:
			return p.getCategoria();
		case 3:
			return p.isUsado();
		case 4:
			return p.getID_Prod();
	
		default:
			throw new IndexOutOfBoundsException ("");			
		}
	}
	public String getColumnName(int i) {
		return colunas.get(i);
	}
	
	public void UpdateTable() {
		this.selecionados=dao.listProduto();
		fireTableDataChanged();
	}
	
	public void Filtro(int ID) {
			selecionados=produtos.stream().filter((prod)->prod.getID_Prod() == ID)
					.collect(Collectors.toList());
			fireTableDataChanged();
	}
}
