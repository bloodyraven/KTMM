package bdd;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;


public class BDD {

	public static String[][] getTable(String fichier) {
		FileReader fr=null;;
		BufferedReader br=null;
		String ligne=null;
		String[] splitted=null;
		String[][] toReturn=null;
		int nbRow=0;
		int cpt=0;
		try {
			fr = new FileReader(fichier);
			br = new BufferedReader(fr) ;
			while((ligne=br.readLine())!=null) {
				nbRow++;
				if(nbRow==1) {
					splitted=ligne.split(",");
				}
			}
			br.close();
			fr.close();
			fr=new FileReader(fichier);
			br=new BufferedReader(fr);
			toReturn=new String[nbRow][splitted.length];
			while((ligne=br.readLine())!=null) {
				splitted=ligne.split(",");
				for(int i=0 ; i<splitted.length ; i++) {
					toReturn[cpt][i]=splitted[i];
				}
				cpt++;
			}
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erreur", "Erreur", JOptionPane.WARNING_MESSAGE);
		}
		
		return toReturn;
	}
	
	/**
	 * 
	 * @param table tableau dans lequel on rechercher
	 * @param wanted String recherchée dans la colonne nbCol
	 * @param nbCol numero de colonne (commence a 0)
	 * @return la ligne, null sinon
	 */
	public static String[] contient(String[][] table, String wanted, int nbCol) {
		String[] toReturn=null;;
		for (int i = 0; i < table.length; i++) {
			if(table[i][nbCol].equals(wanted)) {
				toReturn=new String[table[1].length];
				for (int j = 0; j < toReturn.length; j++) {
					toReturn[j]=table[i][j];
				}
				return toReturn;
			}
		}
		return toReturn;
	}
	
	/**
	 * insert à la dernière ligne les String de ligne séparées par des virgules
	 * @param fichier
	 * @param ligne
	 */
	public static void insert(String fichier, String[] ligne) {
		try {
			FileWriter fw = new FileWriter(fichier, true);
			BufferedWriter output = new BufferedWriter(fw);
			String s="\n";
			for (int i = 0; i < ligne.length-1; i++) {
				s+=ligne[i]+",";
			}
			s+=ligne[ligne.length-1];
			output.write(s);
			output.flush();
			output.close();
		}
		catch(IOException ioe){
			System.out.print("Erreur : ");
			ioe.printStackTrace();
		}
		
	}
}
