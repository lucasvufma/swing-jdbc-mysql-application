package interfacepackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JInitial extends JFrame {
	
	ImageIcon ImageInitial;
	ImageIcon ImageBConsultRemove;
	ImageIcon ImageBInsertUpdate;
	
	public JInitial() {
		ImageInitial = new ImageIcon(getClass().getResource("logo.png"));
		ImageBConsultRemove = new ImageIcon(getClass().getResource("consultarremover.png"));
		ImageBInsertUpdate = new ImageIcon(getClass().getResource("createupdate.png"));
		
		setTitle("Controle de Estoque");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(600,600);
		
		JLabel LogoLabel = new JLabel(ImageInitial);
		
		JButton Bconsult = new JButton(ImageBConsultRemove);
		JButton Binsert = new JButton(ImageBInsertUpdate);
		Bconsult.setBackground(Color.white);
	    Bconsult.setFocusPainted(false);
		Binsert.setBackground(Color.white);
		Binsert.setFocusPainted(false);

		JPanel SuperPanel = new JPanel(new BorderLayout());
		JPanel PanelCI= new JPanel();
		JPanel PanelLogo = new JPanel();
		
		this.getContentPane().setBackground(Color.white); // Cor da janela
		PanelCI.add(Bconsult);
		PanelCI.add(Binsert);
		PanelLogo.add(LogoLabel);
		SuperPanel.add(PanelCI,BorderLayout.SOUTH);
		SuperPanel.add(PanelLogo,BorderLayout.CENTER);
		PanelCI.setBackground(Color.white); // Cor do painel dos botoes
		PanelLogo.setBackground(Color.white); //Cor do painel da logo
		
		add(SuperPanel);
		pack();
		setVisible(true);
		
		Bconsult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new JConsultaRemove();
				dispose();
			}
		});
		
		Binsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new JUpdateInsert();
				dispose();
			}
		});
	}

}
