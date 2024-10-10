package es.florida.ActivitatAvaluable1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Color;

/**
 * Classe on es construeix la interficie gráfica de la App
 * 
 * @author juvigo
 * @version 1.0
 */
public class Vista extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panellPrincipal;
	private JTextField textAreaNomDirectori;
	private JTextField textFieldBuscarString;
	private JTextField textFieldReemplasar;
	private JButton btnBuscarAbreDirectori;
	private JButton btnNewButtonContar;
	private JButton btnNewButtonReemplasar;
	private JLabel lblNewLabelNomFitxer;
	private JLabel imatgeLabel;
	private JTextArea textAreaInfoOperacions;
	private JCheckBox chckbxNewCheckBoxMajusculesMinuscules;
	private JCheckBox chckbxNewCheckBoxAccents;

	/**
	 * Mètode constructor on es fa la Vista
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 437);
		panellPrincipal = new JPanel();
		panellPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panellPrincipal);
		panellPrincipal.setLayout(null);

		JScrollPane scrollPaneAreaNomDirectori = new JScrollPane();
		scrollPaneAreaNomDirectori.setBounds(21, 21, 281, 34);
		panellPrincipal.add(scrollPaneAreaNomDirectori);

		textAreaNomDirectori = new JTextField();
		textAreaNomDirectori.setToolTipText("");
		scrollPaneAreaNomDirectori.setViewportView(textAreaNomDirectori);
		textAreaNomDirectori.setColumns(10);

		btnBuscarAbreDirectori = new JButton("MOSTRAR ABRE");
		btnBuscarAbreDirectori.setForeground(new Color(255, 250, 240));
		btnBuscarAbreDirectori.setBackground(new Color(128, 0, 0));
		btnBuscarAbreDirectori.setBounds(75, 66, 166, 34);
		panellPrincipal.add(btnBuscarAbreDirectori);

		lblNewLabelNomFitxer = new JLabel("NOM DIRECTORI");
		lblNewLabelNomFitxer.setForeground(new Color(128, 0, 0));
		lblNewLabelNomFitxer.setVisible(false);
		lblNewLabelNomFitxer.setFont(new Font("Castellar", Font.BOLD, 15));
		lblNewLabelNomFitxer.setBounds(21, 122, 362, 25);
		panellPrincipal.add(lblNewLabelNomFitxer);

		JScrollPane scrollPaneBuscarString = new JScrollPane();
		scrollPaneBuscarString.setBounds(401, 21, 166, 34);
		panellPrincipal.add(scrollPaneBuscarString);

		textFieldBuscarString = new JTextField();
		scrollPaneBuscarString.setViewportView(textFieldBuscarString);
		textFieldBuscarString.setColumns(10);

		btnNewButtonContar = new JButton("CONTAR");
		btnNewButtonContar.setForeground(new Color(255, 250, 240));
		btnNewButtonContar.setBackground(new Color(128, 0, 0));
		btnNewButtonContar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButtonContar.setBounds(577, 21, 115, 34);
		panellPrincipal.add(btnNewButtonContar);

		JScrollPane scrollPaneInfoOperacions = new JScrollPane();
		scrollPaneInfoOperacions.setBounds(21, 147, 362, 240);
		panellPrincipal.add(scrollPaneInfoOperacions);

		textAreaInfoOperacions = new JTextArea();
		scrollPaneInfoOperacions.setViewportView(textAreaInfoOperacions);

		JScrollPane scrollPaneReemplasar = new JScrollPane();
		scrollPaneReemplasar.setBounds(401, 147, 164, 32);
		panellPrincipal.add(scrollPaneReemplasar);

		textFieldReemplasar = new JTextField();
		scrollPaneReemplasar.setViewportView(textFieldReemplasar);
		textFieldReemplasar.setColumns(10);

		btnNewButtonReemplasar = new JButton("REEMPLAÇAR");
		btnNewButtonReemplasar.setForeground(new Color(255, 250, 240));
		btnNewButtonReemplasar.setBackground(new Color(128, 0, 0));
		btnNewButtonReemplasar.setBounds(577, 145, 115, 34);
		panellPrincipal.add(btnNewButtonReemplasar);

		chckbxNewCheckBoxMajusculesMinuscules = new JCheckBox("Majúscules / Minúscules");
		chckbxNewCheckBoxMajusculesMinuscules.setSelected(true);
		chckbxNewCheckBoxMajusculesMinuscules.setBounds(401, 66, 166, 23);
		panellPrincipal.add(chckbxNewCheckBoxMajusculesMinuscules);

		chckbxNewCheckBoxAccents = new JCheckBox("Accents");
		chckbxNewCheckBoxAccents.setSelected(true);
		chckbxNewCheckBoxAccents.setBounds(401, 92, 97, 23);
		panellPrincipal.add(chckbxNewCheckBoxAccents);

		imatgeLabel = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon("img\\FloridaUniLogo.png").getImage().getScaledInstance(250, 80, Image.SCALE_DEFAULT));
		imatgeLabel.setIcon(imageIcon);
		imatgeLabel.setBounds(425, 302, 254, 85);
		panellPrincipal.add(imatgeLabel);
		this.setVisible(true);
	}

	/**
	 * Mètode per agafar el text area on es ficará la ruta del directori principal
	 * 
	 * @return textAreaNomDirectori Torna el nom del directori
	 */
	public JTextField getTextAreaNomDirectori() {
		return textAreaNomDirectori;
	}

	/**
	 * Mètode per agafar el text field on se escribirà el string a busca
	 * 
	 * @return textFieldBuscarString Torna el camp de text on s'ecribira el string a
	 *         buscar
	 */
	public JTextField getTextFieldBuscarString() {
		return textFieldBuscarString;
	}

	/**
	 * Mètode per agafar el text field on se escribirà el string a reemplaçar
	 * 
	 * @return textFieldReemplaçar Torna el camp de text on s'ecribira el string a
	 *         reemplçar
	 */
	public JTextField getTextFieldReemplasar() {
		return textFieldReemplasar;
	}

	/**
	 * Mètode per agafar el boto que realitzara la funció de obrir el directori
	 * principal
	 * 
	 * @return btnBuscarAbreDirectori Torna el boto que mostrara la informacio
	 *         general
	 */
	public JButton getBtnBuscarAbreDirectori() {
		return btnBuscarAbreDirectori;
	}

	/**
	 * Mètode per agafar el boto que realitzara la funció de contar el string en els
	 * fitxers
	 * 
	 * @return btnNewButtonContar Torna el boto que contara les coincidencies
	 */
	public JButton getBtnNewButtonContar() {
		return btnNewButtonContar;
	}

	/**
	 * Mètode per agafar el boto que realitzara la funció de reemplçar la paraula en
	 * el fitxers
	 * 
	 * @return btnNewButtonReemplaçar Torna el boto que contara els reemplaços
	 */
	public JButton getBtnNewButtonReemplasar() {
		return btnNewButtonReemplasar;
	}

	/**
	 * Mètode per agafar el label que tendrá el nom del directori principal
	 * 
	 * @return lblNewLabelNomFitxer Torna el label on es ficara el nom del directori
	 *         amb el que estem treballant
	 */
	public JLabel getLblNewLabelNomFitxer() {
		return lblNewLabelNomFitxer;
	}

	/**
	 * Mètode per agafar el text area on es ficará l'informació de les operacions de
	 * la app
	 * 
	 * @return lblNewLabelNomFitxer Torna l'area de text on es ficara l'informacio
	 *         de les distintes accions de la App
	 */
	public JTextArea getTextAreaInfoOperacions() {
		return textAreaInfoOperacions;
	}

	/**
	 * Mètode per agafar el checkbox que indicará que es respeten les majúscules y
	 * minúscules
	 * 
	 * @return chckbxNewCheckBoxMajusculesMinuscules Torna el checkbox que indicara
	 *         si es respeten o no les majuscules/minuscules
	 */
	public JCheckBox getChckbxNewCheckBoxMajusculesMinuscules() {
		return chckbxNewCheckBoxMajusculesMinuscules;
	}

	/**
	 * Mètode per agafar el checkbox que indicará que es respeten els acents
	 * 
	 * @return chckbxNewCheckBoxAccents Torna el checkbox que indicara si es
	 *         respeten o no els acents
	 */
	public JCheckBox getChckbxNewCheckBoxAccents() {
		return chckbxNewCheckBoxAccents;
	}
}
