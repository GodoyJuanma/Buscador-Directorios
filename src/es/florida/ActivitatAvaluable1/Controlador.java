package es.florida.ActivitatAvaluable1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

/**
 * Classe que controla les dades y la interficie gráfica
 * 
 * @author juvigo
 * @version 1.0
 */
public class Controlador {
	private Model model;
	private Vista vista;
	private ActionListener actionDirectoriTreball;
	private ActionListener actionTrovarStringArxiu;
	private ActionListener actionReemplasarStringArxiu;

	/**
	 * Mètode constructor on se instancien el model y la vista
	 * 
	 * @param model Clase objecte Modelo on es troben tots els mètodes y variables
	 *              de dades de la App
	 * @param vista Clase objecte Vista on es troba la interficie de la App
	 */
	public Controlador(Model model, Vista vista) {
		this.model = model;
		this.vista = vista;
		control();
	}

	/**
	 * Mètode que comunica les dades amb la interficie s'inicialitza al constructor
	 */
	public void control() {
		actionDirectoriTreball = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vista.getTextAreaNomDirectori().getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "<html><h3>Valor del directori nul</h3></html>",
							"ERROR VALOR NUL", JOptionPane.WARNING_MESSAGE);
				} else {
					String rutaDirectori = vista.getTextAreaNomDirectori().getText();
					File f = new File(rutaDirectori);
					model.setFileTreballar(f);
					vista.getLblNewLabelNomFitxer().setText(model.getFileTreballar().getName());
					vista.getLblNewLabelNomFitxer().setVisible(true);
					model.setAbre("");
					model.infoFitxer(model.getFileTreballar(), 0, "informacioGeneral");
					vista.getTextAreaInfoOperacions().setText(model.getAbre());
				}
			}
		};
		actionTrovarStringArxiu = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vista.getTextFieldBuscarString().getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "<html><h3>Valor de la paraula a trovar nul</h3></html>",
							"ERROR VALOR NUL", JOptionPane.WARNING_MESSAGE);
				} else {
					model.setAbre("");
					model.setParaulaTrovar(vista.getTextFieldBuscarString().getText());
					model.setAcents(vista.getChckbxNewCheckBoxAccents().isSelected());
					model.setMajusculesMinuscules(vista.getChckbxNewCheckBoxMajusculesMinuscules().isSelected());
					model.infoFitxer(model.getFileTreballar(), 0, "trovarReemplasarString");
					vista.getTextAreaInfoOperacions().setText(model.getAbre());
				}
			}
		};
		actionReemplasarStringArxiu = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vista.getTextFieldBuscarString().getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "<html><h3>Valor de la paraula a trovar nul</h3></html>",
							"ERROR VALOR NUL", JOptionPane.WARNING_MESSAGE);
				} else {
					model.setAbre("");
					model.setParaulaTrovar(vista.getTextFieldBuscarString().getText());
					model.setAcents(vista.getChckbxNewCheckBoxAccents().isSelected());
					model.setMajusculesMinuscules(vista.getChckbxNewCheckBoxMajusculesMinuscules().isSelected());
					if (vista.getTextFieldReemplasar().getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null,
								"<html><h3>Valor de la paraula a reemplaçar nul</h3></html>", "ERROR VALOR NUL",
								JOptionPane.WARNING_MESSAGE);
					} else {
						model.setParaulaReemplas(vista.getTextFieldReemplasar().getText());
						model.infoFitxer(model.getFileTreballar(), 0, "trovarReemplasarString");
						vista.getTextAreaInfoOperacions().setText(model.getAbre());
					}
				}
			}
		};
		vista.getBtnBuscarAbreDirectori().addActionListener(actionDirectoriTreball);
		vista.getBtnNewButtonContar().addActionListener(actionTrovarStringArxiu);
		vista.getBtnNewButtonReemplasar().addActionListener(actionReemplasarStringArxiu);
	}

}
