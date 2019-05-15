package interfacepackage;

import produtopackage.ProdutoDAO;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class JImpressTable extends JFrame { 
	public JImpressTable() {
		super("Impressão Tabela de Produtos");
		setSize(500,600);
		setLayout(new FlowLayout());
		
		ProdutoTableModel model = new ProdutoTableModel(new ProdutoDAO());
		JTable Table = new JTable(model);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(Table);
		
		add(scroll);
		setVisible(true);
		
	}
}
