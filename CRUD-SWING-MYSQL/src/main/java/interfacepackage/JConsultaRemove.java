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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class JConsultaRemove extends JFrame{

	private JTextField FieldID;
	//private JTextArea AreaList;
	
	public JConsultaRemove() {
		
		setTitle("Consulta/Remover");
		setSize(800,800);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton Bback= new JButton("Voltar");
		JButton Bremove= new JButton("Remover");
		JButton Bimpress = new JButton("Imprimir Todos");
		JButton Bconsult = new JButton("Consultar/Filtrar");
		
		JPanel PanelButtons = new JPanel();
		JPanel PanelFieldLabel = new JPanel();
		JPanel AlmostSuperPanel = new JPanel(new BorderLayout());
		JPanel SuperPanel = new JPanel(new BorderLayout());
		
		ProdutoTableModel model = new ProdutoTableModel(new ProdutoDAO());
		JTable Table = new JTable(new DefaultTableModel());
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(Table);
		

		JLabel LabelID = new JLabel("ID Produto");
		
		this.FieldID = new JTextField(15);
	    //this.AreaList= new JTextArea(10,30);

	    PanelButtons.add(Bback);
	    PanelButtons.add(Bimpress);
	    PanelButtons.add(Bconsult);
	    PanelButtons.add(Bremove);
	    PanelFieldLabel.add(LabelID);
	    PanelFieldLabel.add(FieldID);
	    AlmostSuperPanel.add(PanelFieldLabel,BorderLayout.CENTER);
	    AlmostSuperPanel.add(PanelButtons,BorderLayout.SOUTH);
	    SuperPanel.add(AlmostSuperPanel,BorderLayout.CENTER);
	    //SuperPanel.add(AreaList,BorderLayout.SOUTH);
	    SuperPanel.add(scroll,BorderLayout.SOUTH);
	    
	    
	    add(SuperPanel);
		setVisible(true);
			
		Bconsult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				model.Filtro(Integer.parseInt(FieldID.getText()));
				/* String gettxt=FieldID.getText();
				AreaList.setText(gettxt);
				ProdutoDAO dao = new ProdutoDAO();
				Produto p = dao.selectProduto(Integer.parseInt(gettxt));
				AreaList.setText("Produto: "+p.getNome()+"\nID: "+p.getID_Prod()+"\nCategoria: "+p.getCategoria()+"\nPreço: "+p.getPreço()+"\nUsado: "+p.isUsado());
		*/
			}
		});
		
		Bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new JInitial();
				dispose();
			}
		});
		
		Bimpress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Table.setModel(model);
				model.UpdateTable();
			}
		});
		
		Bremove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String gettxt=FieldID.getText();
				ProdutoDAO dao = new ProdutoDAO();
				dao.removeProduto(Integer.parseInt(gettxt));
			}
		});
		
		
	}
	
	

}
