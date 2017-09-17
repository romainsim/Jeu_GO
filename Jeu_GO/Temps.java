import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.EmptyBorder;

class Temps implements ActionListener{
    public static int tempsRestant;
    public int temps;
    private JTextField time;
    private JFrame fenetre;
    public static int N;
    public static int periode;
    public static boolean interrupted = false;
   
    public Temps (JTextField time, JFrame fenetre){
	this.fenetre = fenetre;
	this.time = time;
    }

    public void setText(JTextField time) {
	this.time = time;
    }

    public JTextField getText() {
	return time;
    }
    public static void interrupt() {
	interrupted=true;
    }
   
    
    public static void createByoYomi(int periode, int tempsRestant) {
	while(!interrupted) {
	    while (periode > 0) {
		while (tempsRestant > 0) {
		    tempsRestant--;
		    System.out.println("Temps restant : " + tempsRestant);
		    try {
			Thread.sleep(1000);
		    }
		    catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		    }
		}
		
		periode--;
	    }
	}
    }
    
    public static void createHorloge(int tempsRestant) {
	while(tempsRestant > 0) {
	    tempsRestant--;
	    System.out.println("Temps restant : " + tempsRestant);
	    try {
		Thread.sleep(1000);
	    }
	    catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    if (interrupted)
		break;
	}
    }
    
    public void setTempsRestant(int tempsRestant) {
	this.tempsRestant = tempsRestant;
    }
    
    public static int getTempsRestant() {
	return tempsRestant;
    }

    public void setTemps(int temps) {
	this.temps = temps;
    }
    

    public int getTemps() {
	return temps;
    }
    
    public void actionPerformed(ActionEvent event) {
	fenetre.setVisible(true);
    }
    
}