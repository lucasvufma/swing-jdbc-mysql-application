package interfacepackage;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import generictablepackage.GenericTableModel;
import produtopackage.Produto;
import servicespackage.AbstractDAO;
import servicespackage.GenericDAO;

public class GenericView extends JFrame {
	
	public GenericView() {
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,250);
		setTitle("Testando Generic Table Model");
		AbstractDAO dao = new GenericDAO(Produto.class);
		GenericTableModel<Produto> model = new GenericTableModel<Produto>(dao);
		JTable Table = new JTable(model);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(Table);
		add(scroll);
		setVisible(true);
	
		
	}

}
