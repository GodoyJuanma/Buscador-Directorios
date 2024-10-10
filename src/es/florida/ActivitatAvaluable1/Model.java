package es.florida.ActivitatAvaluable1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * Classe on es treballa amb les dades de la App
 * 
 * @author juvigo
 * @version 1.0
 */
public class Model {

	private File fitxerTreball;
	private String abre = "";
	private String paraulaTrovar;
	private String paraulaReemplas;
	private boolean majusculesMinuscules;
	private boolean acents;

	/**
	 * Mètode constructor buit
	 */
	public Model() {

	}

	/**
	 * Mètode per a agafar el fitxer de treball
	 * 
	 * @return fitxerTreball Torna el fitxer de treball
	 */
	public File getFileTreballar() {
		return fitxerTreball;
	}

	/**
	 * Mètode per a agafar el string abre que mostra la informació de cada proces
	 * 
	 * @return abre Torna el abre d'informació de la App
	 */
	public String getAbre() {
		return abre;
	}

	/**
	 * Mètode que utilitzarem per a reiniciar l'abre en cada llamada
	 * 
	 * @param abre String que conte l'abre de informació del directori principal
	 */
	public void setAbre(String abre) {
		this.abre = abre;
	}

	/**
	 * Mètode per a inicialitzar el fitxer de treball
	 * 
	 * @param fitxerTreball Fitxer amb el que anem a treballar
	 */
	public void setFileTreballar(File fitxerTreball) {
		this.fitxerTreball = fitxerTreball;
	}

	/**
	 * Mètode per a agafar el nom del fitxer
	 * 
	 * @return nom Nom del Fitxer amb el que anem a treballar
	 */
	public String nomFitxer() {
		String nom = fitxerTreball.getName();
		return nom;
	}

	/**
	 * Mètode per a ficar la paraula a trovar en els arxius
	 * 
	 * @param paraulaTrovar Paraula que utilizcem per a trovar coincidencies en els
	 *                      arxius
	 */
	public void setParaulaTrovar(String paraulaTrovar) {
		this.paraulaTrovar = paraulaTrovar;
	}

	/**
	 * Mètode per a ficar la paraula a reemplaçar en els arxius
	 * 
	 * @param paraulaReemplas Paraula que utilizcem per a reemplaçar en els arxius
	 */
	public void setParaulaReemplas(String paraulaReemplas) {
		this.paraulaReemplas = paraulaReemplas;
	}

	/**
	 * Mètode que fica el boolean que indicara si la paraula a ficar respecta o no
	 * les majuscules / minuscules
	 * 
	 * @param majusculesMinuscules Valor boolea que indicara si es respecten les
	 *                             majuscules i minuscules
	 */
	public void setMajusculesMinuscules(boolean majusculesMinuscules) {
		this.majusculesMinuscules = majusculesMinuscules;
	}

	/**
	 * Mètode que fica el boolean que indicara si la paraula a ficar respecta o no
	 * els acents
	 * 
	 * @param acents Valor boolea que indicara si es respecten els acents
	 */
	public void setAcents(boolean acents) {
		this.acents = acents;
	}

	/**
	 * Mètode per a rellenar el string abre depenent de l'accio que se le pasa
	 * 
	 * @param fitxer Fitxer amb el que treballarem en cada llamada del mètode
	 * @param nivell  Int que utilitzarem per a poder coneixer el nivell on es trobe
	 *               el fitxer dins de l'abre del directori
	 * @param accio  String que indicara que mètode se te que realitzar per a
	 *               mostrar la informació del arxius
	 */
	public void infoFitxer(File fitxer, int nivell, String accio) {
		if (fitxer.exists()) {
			for (int i = 1; i < nivell; i++) {
				abre = abre + "|     ";
			}
			if (fitxer.isDirectory()) {
				if (fitxer.canRead()) {
					System.out.println(fitxer);
					File[] llistafitxers = fitxer.listFiles();
					if (llistafitxers != null && llistafitxers.length != 0) {
						if (nivell == 0) {
							abre = abre + fitxer.getName() + "\n";
						} else {
							abre = abre + "|--  \\" + fitxer.getName() + "\n";
						}
						for (File f : llistafitxers) {
							infoFitxer(f, nivell + 1, accio);
						}
					}
				}
			}
			if (fitxer.isFile()) {
				if (fitxer.canRead()) {
					switch (accio) {
					case "informacioGeneral":
						informacioGeneral(fitxer);
						break;
					case "trovarReemplasarString":
						trovarReemplasarString(fitxer, nivell);
						break;
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "<html><h3>El directori o arxiu introduit no existeis</h3></html>",
					"ERROR A L'HORA DE BUSCAR DIRECTORI/ARXIU", JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Mètode per a escriure al abre de fitxers la seua informacio general.
	 * 
	 * @param fitxer Arxiu amb el que treballarem per a sacar les dades
	 */
	public void informacioGeneral(File fitxer) {
		// Grandaria
		long bytesFitxer = fitxer.length();
		double kilobytesFitxer = bytesFitxer / 1024.0;
		String kilobytesString = String.format("%.1f", kilobytesFitxer);

		// Data Modificació
		Date dataUltimaModificacio = new Date(fitxer.lastModified());
		SimpleDateFormat dataTemps = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		String dataTempsString = dataTemps.format(dataUltimaModificacio);

		abre = abre + "|-- " + fitxer.getName() + " (" + kilobytesString + " KB - " + dataTempsString + ") \n";
	}

	/**
	 * Mètode per a trovar les coincidencies de un string als fitxers
	 * 
	 * @param fitxer Arxiu que se li pasara per a comprobar la parula trovada y la remplaçara per altra si se l'indica
	 * @param nivell Int que s'utilitza per a indicar el nivell on se troba l'arxiu
	 *               que es crea al reemplçar
	 */
	public void trovarReemplasarString(File fitxer, int nivell) {
		// Respecta Majuscules i minuscules
		if (majusculesMinuscules == false) {
			paraulaTrovar = paraulaTrovar.toLowerCase();
		}

		// Respecta Acents
		if (acents == false) {
			paraulaTrovar = Normalizer.normalize(paraulaTrovar, Normalizer.Form.NFD);
			paraulaTrovar = paraulaTrovar.replaceAll("[\\p{M}]", "");
		}
		try {
			System.out.println("Paraula a trovar " + paraulaTrovar);
			int index = 0;
			int coincidencies = 0;

			// PDF
			if (fitxer.getName().endsWith(".pdf")) {
				PDDocument arxiu = PDDocument.load(fitxer);
				PDFTextStripper pdfStripper = new PDFTextStripper();
				String text = pdfStripper.getText(arxiu);
				String[] linies = text.split(System.lineSeparator());
				for (String linea : linies) {
					System.out.println(linea);
					index = linea.indexOf(paraulaTrovar);
					while (index != -1) {
						coincidencies = coincidencies + 1;
						index = linea.indexOf(paraulaTrovar, index + 1);
					}
				}
				abre = abre + "|-- " + fitxer.getName() + " (" + coincidencies + " coincidències)\n";
			}

			// ARXIU NORMAL
			else {
				ArrayList<String> lineas = new ArrayList<>();
				FileReader fr = new FileReader(fitxer);
				BufferedReader br = new BufferedReader(fr);
				String linea = br.readLine();
				while (linea != null) {
					System.out.println(linea);
					index = linea.indexOf(paraulaTrovar);
					while (index != -1) {
						coincidencies = coincidencies + 1;
						index = linea.indexOf(paraulaTrovar, index + 1);
					}
					lineas.add(linea);
					linea = br.readLine();
				}

				// REEMPLAÇAR
				if (coincidencies > 0 && paraulaReemplas != null) {
					File fitxerMOD = new File(fitxer.getParentFile().getAbsolutePath(), "/MOD_" + fitxer.getName());
					FileWriter fw = new FileWriter(fitxerMOD);
					BufferedWriter bw = new BufferedWriter(fw);
					for (String lineaArrayList : lineas) {
						String lineaModificada = lineaArrayList.replaceAll(paraulaTrovar, paraulaReemplas);
						bw.write(lineaModificada);
						bw.newLine();
					}
					bw.close();
					fw.close();
					abre = abre + "|-- " + fitxer.getName() + " (" + coincidencies + " reemplaços)\n";
					for (int i = 1; i < nivell; i++) {
						abre = abre + "|     ";
					}
					abre = abre + "|-- " + fitxerMOD.getName() + " (Fitxer Modificat)\n";
				} else {
					abre = abre + "|-- " + fitxer.getName() + " (" + coincidencies + " coincidències)\n";
				}
				br.close();
				fr.close();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "<html><h3>El arxiu no es pot llegir</h3></html>",
					"ERROR A L'HORA DE LLEGIR ARXIU", JOptionPane.WARNING_MESSAGE);
		}

	}
}
