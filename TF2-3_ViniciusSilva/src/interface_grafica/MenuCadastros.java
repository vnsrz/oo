package interface_grafica;
	
import javax.swing.*;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dados.CadastroPessoas;
import saida.Visao;


@SuppressWarnings("serial")
public class MenuCadastros extends JFrame{
	public MenuCadastros(CadastroPessoas cadastroPessoas ) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuCadastros.class.getResource("/icones/icons8_hospital_32px_1.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Cadastro");
		setBounds(1000, 0, 377, 497);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		getContentPane().add(new PainelPrincipal(this, cadastroPessoas));
	}
	
}

@SuppressWarnings("serial")	
class PainelPrincipal extends JPanel{
	private JLabel lbNome;
	private JTextField textNome;
	
	private JLabel lbNumID;
	private JTextField textId;
	
	private JLabel lbSituacaoSaude;
	private JComboBox<String> estadoSaude;
	
	private JLabel lbIdade;
	private JTextField textIdade;
	
	private JLabel lbGravidez;
	private JComboBox<String> estadoGravidez;
	
	private JLabel lbSexo;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	
	private JButton btnCancelar;
	private JButton btnCadastrar;
	
	private final ButtonGroup grupoSexo = new ButtonGroup();
	
	public PainelPrincipal(JFrame frame, CadastroPessoas cadastroPessoas ) {
		setBounds(0, 0, 820, 497);
		setLayout(null);
		
		//nome
		lbNome = new JLabel("Nome:");
		lbNome.setBounds(23, 37, 46, 14);
		add(lbNome);
		
		textNome = new JTextField();
		textNome.setBounds(79, 30, 262, 26);
		textNome.setColumns(10);
		add(textNome);
		
		
		//identificacao
		lbNumID = new JLabel("ID:");
		lbNumID.setBounds(23, 80, 46, 14);
		add(lbNumID);
		
		textId = new JTextField();
		textId.setBounds(79, 73, 262, 26);
		textId.setColumns(10);
		add(textId);
		
		
		//situacao de saude
		lbSituacaoSaude = new JLabel("Situacao de Saude:");
		lbSituacaoSaude.setBounds(23, 123, 103, 14);
		add(lbSituacaoSaude);
		
		JComboBox<String> estadoSaude = new JComboBox<String>();
		estadoSaude.setModel(new DefaultComboBoxModel<String>(new String[] {"Em tratamento", "Falecida", "Curada", "Sem Contaminacao" }));
		estadoSaude.setSelectedIndex(-1);
		estadoSaude.setBounds(136, 120, 205, 22);
		add(estadoSaude);
		
		
		//idade
		lbIdade = new JLabel("Idade:");
		lbIdade.setBounds(23, 229, 46, 14);
		add(lbIdade);
		
		textIdade = new JTextField();
		textIdade.setBounds(79, 226, 262, 20);
		textIdade.setColumns(10);
		textIdade.setEnabled(false);
		add(textIdade);
		
		
		//gravidez
		lbGravidez = new JLabel("Gravidez:");
		lbGravidez.setBounds(23, 282, 116, 23);
		add(lbGravidez);
				
		JComboBox<String> estadoGravidez = new JComboBox<String>();
		estadoGravidez.setModel(new DefaultComboBoxModel<String>(new String[] {"Ja esteve gravida", "Nunca esteve gravida", "Nao tem certeza"}));
		estadoGravidez.setBounds(136, 282, 205, 24);
		estadoGravidez.setEnabled(false);
		estadoGravidez.setSelectedIndex(-1);
		add(estadoGravidez);
		
		
		//sexo
		lbSexo = new JLabel("Sexo:");
		lbSexo.setBounds(23, 176, 46, 14);
		add(lbSexo);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(133, 172, 103, 23);
		rdbtnMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estadoGravidez.setEnabled(false);
				textIdade.setEnabled(true);
			}
		});
		add(rdbtnMasculino);
		grupoSexo.add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(238, 172, 103, 23);
		rdbtnFeminino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estadoGravidez.setEnabled(true);
				textIdade.setEnabled(false);
			}
		});
		add(rdbtnFeminino);
		grupoSexo.add(rdbtnFeminino);
		
		
		//botoes cadastra/cancela
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(105, 407, 113, 38);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Visao.mostraConfirmacao("Deseja cancelar?") == 0) 
	            	frame.dispose(); 
			}
		});
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(228, 407, 113, 38);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMasculino.isSelected()) {
					if(cadastroPessoas.cadastraHomem(textNome.getText(), textId.getText().trim(), 
							getEstadoSaude(estadoSaude.getSelectedIndex()), textIdade.getText(), cadastroPessoas) == 1) {
						
						Visao.mostraMensagem("Cadastro realizado com sucesso.");
						frame.dispose();
					
					}
				}else if(rdbtnFeminino.isSelected()) {
					if(cadastroPessoas.cadastraMulher(textNome.getText(), textId.getText().trim(), 
							getEstadoSaude(estadoSaude.getSelectedIndex()), getGravidez(estadoGravidez.getSelectedIndex()), cadastroPessoas) == 1) {
						
						Visao.mostraMensagem("Cadastro realizado com sucesso.");
						frame.dispose();
					
					}
				}else
					Visao.mostraErro("Selecione um sexo.");
			}
		});
		
		add(btnCadastrar);
		add(btnCancelar);
		

	}
	
	public char getEstadoSaude(int i) {
		switch(i) {
		case 0:
			return 'T';
		case 1:
			return 'F';
		case 2:
			return 'C';
		case 3:
			return 'S';
		default:
			return 'N';	
		}
	}
		
	public char getGravidez(int i) {
		switch(i) {
		case 0:
			return 'S';
		case 1:
			return 'N';
		case 2:
			return 'T';
		default:
			return ' ';	
		}
	}
	
}