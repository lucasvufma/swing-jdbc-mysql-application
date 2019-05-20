package interfacepackage;

import produtopackage.ProdutoDAO;
import produtopackage.Produto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JUpdateInsert extends JFrame {
	
	private JTextField FieldN; 
	private JTextField FieldI;
	private JTextField FieldC;
	private JTextField FieldP;
	private JTextField FieldU;
	
	public JUpdateInsert() {
		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,250);
		setTitle("Update e Inserção de Dados");
		
		
		JButton Insert = new JButton("Inserir");
		JButton Update = new JButton("Update");
		JButton back = new JButton("Voltar");
		
		
		JLabel Nome = new JLabel("Nome do Produto");
		JLabel ID = new JLabel("ID Produto");
		JLabel Categoria = new JLabel("Categoria");
		JLabel Preço = new JLabel("Preço");
		JLabel Usado = new JLabel("Usado");
		
		this.FieldN = new JTextField(30);
		this.FieldI = new JTextField(30);
		this.FieldC = new JTextField(30);
		this.FieldP = new JTextField(30);
		this.FieldU = new JTextField(30);
		
		JPanel PanelN = new JPanel();
		JPanel PanelI = new JPanel();
		JPanel PanelC = new JPanel();
		JPanel PanelP = new JPanel();
		JPanel PanelU = new JPanel();
		JPanel PanelButtons = new JPanel();
		JPanel AlmostSuperPanel1 = new JPanel(new BorderLayout());
		JPanel AlmostSuperPanel2 = new JPanel(new BorderLayout());
		JPanel AlmostSuperPanel3 = new JPanel(new BorderLayout());
		JPanel SuperPanel = new JPanel(new BorderLayout());
			
		PanelN.add(Nome);PanelN.add(FieldN);
		PanelI.add(ID);PanelI.add(FieldI);
		PanelC.add(Categoria);PanelC.add(FieldC);
		PanelP.add(Preço);PanelP.add(FieldP);
		PanelU.add(Usado);PanelU.add(FieldU);
		
		
		PanelButtons.add(back);PanelButtons.add(Update);PanelButtons.add(Insert);
		AlmostSuperPanel1.add(PanelN,BorderLayout.NORTH);AlmostSuperPanel1.add(PanelI,BorderLayout.SOUTH);
		AlmostSuperPanel2.add(PanelC,BorderLayout.NORTH);AlmostSuperPanel2.add(PanelP,BorderLayout.SOUTH);
		AlmostSuperPanel3.add(AlmostSuperPanel1,BorderLayout.NORTH);
		AlmostSuperPanel3.add(AlmostSuperPanel2,BorderLayout.SOUTH);
		SuperPanel.add(AlmostSuperPanel3,BorderLayout.NORTH);
		SuperPanel.add(PanelButtons,BorderLayout.SOUTH);
		
		
		add(SuperPanel);
		setVisible(true);
		
		Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
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
				new JInitial();
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
