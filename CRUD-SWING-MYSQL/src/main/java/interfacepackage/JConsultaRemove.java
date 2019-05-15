package produtopackage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JConsultaRemove extends JFrame{

	public JConsultaRemove() {
		setSize(400,300);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//// Painel das PK dos produtos !!
		JPanel ID_P= new JPanel();
		JButton back= new JButton("Voltar");
		JButton remove= new JButton("Remover");
		JButton ImprimirLista = new JButton("Imprimir Lista");
		JButton ativar = new JButton("Consultar");
		JLabel Produto = new JLabel("ID Produto");
		final JTextField FieldID = new JTextField(15);
		ID_P.add(new JLabel("ID do Produto: "));
	    final JTextArea area = new JTextArea(10,30);
		add(Produto);
		add(FieldID);
		add(ativar);
		add(remove);
		add(area);
		add(back);
		add(ImprimirLista);
		setVisible(true);
		//Gatilho de consulta não consegui de jeito nenhum por a linha 28 dentro do gatilho do JButton, perguntar depois pra sergio, porque o comp reclama de variavel local e so consigo se for de final!!
		ativar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String gettxt=FieldID.getText();
				area.setText(gettxt);
				ProdutoDAO dao = new ProdutoDAO();
				Produto p = dao.selectProduto(Integer.parseInt(gettxt));
				area.setText("Produto: "+p.getNome()+"\nID: "+p.getID_Prod()+"\nCategoria: "+p.getCategoria()+"\nPreço: "+p.getPreço()+"\nUsado: "+p.isUsado());
		
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				SwingAPI Main = new SwingAPI();
				dispose();
			}
		});
		
		ImprimirLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ProdutoDAO dao = new ProdutoDAO();
				area.setText(dao.listProduto().toString());		
			}
		});
		
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String gettxt=FieldID.getText();
				ProdutoDAO dao = new ProdutoDAO();
				dao.removeProduto(Integer.parseInt(gettxt));
			}
		});
		
		
	}
	
	

}
