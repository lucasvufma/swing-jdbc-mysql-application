package produtopackage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingAPI extends JFrame {
	public SwingAPI() {
		setTitle("Controle de Estoque");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		JButton Consulta = new JButton("Consultar/Remover");
		JButton Inserir = new JButton("Inserir/Atualizar");
		setSize(300,300);
		Consulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new JConsultaRemove();
				dispose();
			}
		});
		
		Inserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new JUpdateInsert();
				dispose();
			}
		});
		
		
		add(Consulta);
		add(Inserir);
		pack();
		
	}

}
