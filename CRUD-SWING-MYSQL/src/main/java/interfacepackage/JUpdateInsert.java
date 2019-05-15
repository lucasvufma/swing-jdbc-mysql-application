package produtopackage;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JUpdateInsert extends JFrame {
	public JUpdateInsert() {
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450,450);
		setTitle("Update e Inserção de Dados");
		JButton Insert = new JButton("Inserir");
		JButton Update = new JButton("Update");
		JButton back = new JButton("Voltar");
		JLabel Nome = new JLabel("Nome do Produto");
		JLabel ID = new JLabel("ID Produto");
		JLabel Categoria = new JLabel("Categoria");
		JLabel Preço = new JLabel("Preço");
		JLabel Usado = new JLabel("Usado");
		final JTextField FieldN = new JTextField(40);
		final JTextField FieldI = new JTextField(40);
		final JTextField FieldC = new JTextField(40);
		final JTextField FieldP = new JTextField(40);
		final JTextField FieldU = new JTextField(40);
		
		add(Nome);add(FieldN);add(ID);add(FieldI);add(Categoria);add(FieldC);add(Preço);add(FieldP);add(Usado);add(FieldU);add(Insert);add(Update);add(back);
		setVisible(true);
		Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String Nome=FieldI.getText();
				ProdutoDAO dao = new ProdutoDAO();
				Produto p = new Produto();
				p.setNome(FieldN.getText());
				p.setCategoria(FieldC.getText());
				p.setPreço(Double.parseDouble(FieldP.getText()));
				p.setUsado(Boolean.parseBoolean(FieldU.getText()));
				dao.insertProduto(p);			  }
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new SwingAPI();
				dispose();
			}
		});
					
		
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String Nome=FieldI.getText();
				ProdutoDAO dao = new ProdutoDAO();
				int z = Integer.parseInt(Nome);
				dao.updateProduto(z, Nome, FieldC.getText(), Double.parseDouble(FieldP.getText()), Boolean.parseBoolean(FieldU.getText()));	
			  }
			});
		    
		
	}

}
