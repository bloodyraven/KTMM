package graphique;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelVille extends JPanel {
	
	private String[][] pattern = new String[8][8];

	public PanelVille() {
		intPattern();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		for(int i=0 ; i<8 ; i++) {
			for (int j = 0; j < 8; j++) {
				if (pattern[i][j].equals("0"))
					g2d.drawImage(new ImageIcon("ressources/green.png").getImage(), i*64, j*64, null);
				else if (pattern[i][j].equals("1"))
					g2d.drawImage(new ImageIcon("ressources/stonebrick.png").getImage(), i*64, j*64, null);
				else if (pattern[i][j].equals("2"))
					g2d.drawImage(new ImageIcon("ressources/gravel.png").getImage(), i*64, j*64, null);
			}
		}
	}
	
	private void intPattern() {
		FileReader fr=null;;
		BufferedReader br=null;
		String ligne=null;
		String[] splitted=null;
		int idx = 0;
		String tmp="";
		try {
			fr = new FileReader("bdd/ville.txt");
			br = new BufferedReader(fr) ;
			while((ligne=br.readLine())!=null) {
				splitted=ligne.split(",");
				for (int i = 0; i < splitted.length; i++) {
					pattern[idx][i]=splitted[i];
					tmp+=pattern[idx][i]+" ";
				}
				tmp+="\n";
				idx++;
			}
		}catch(Exception e) {
			
		}
		System.out.println(tmp);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new PanelVille());
		f.setSize(250, 250);
		f.setVisible(true);
	}
}
