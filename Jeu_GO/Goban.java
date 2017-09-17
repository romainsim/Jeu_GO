import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.EmptyBorder;

class Goban extends JPanel implements MouseListener,ActionListener  {
    JFrame fenetre;
    static int [] plateaux = new int[300]; // Le plateau qui enregiste les coups en x pour les annuler apres
    static int [] plateauy = new int[300]; // meme chose en y
    static int [] plateaux2 = new int[300];// Ne sert a rien
    static int [] plateauy2 = new int[300];// Ne sert a rien
    
    static int [] desannulerx = new int[300]; // Plateau qui enregiste les coups qu'on a annulé si on veut desannuler en x
    static int [] desannulery = new int[300]; // meme chose en 
    int var=0;
    static int varHandicap=0;
    int var2=0;
    int x;
    boolean handi=false;
    int y;
    int numerobouton; // En fonction du bouton, on a un id pour chaque bouton.
    int numero=0; // La variable qui s'increment  chaque coup dans le plateau qui enregistre les coups pour annuler
    int numero2=0;// Ne sert a rien
    int numerodes=0; // La variable qui s'increment  chaque coup dans le tableau desanuller qui enregistre les coups qui ont été annulé
    static int x2;
    static int y2;
    //JTextField taille;
    int test=0;
    static int [][] plateau = new int[9][9]; // Le tableau principale
    static int partieq = 0;
    
    int partiefinie=0;
    Graphics g;
    JPanel panel;
    JTextField tailles;
    JTextField handicap;
    JTextField time;
    int chiffre;
    //int chiffreHandicap;
    //int tailleHandicap = 0;
    int i=1;
    int j=299;

    
    public static int taille=Text.chiffreSize;
    Text text= new Text(tailles,fenetre);
    //Texte texte=new Texte(handicap,fenetre);
    
    Goban(JTextField tailles,JFrame fenetre,int numerobouton,JTextField handicap,JTextField time){
	this.numerobouton=numerobouton;
	this.tailles=tailles;
	this.fenetre=fenetre;
	this.handicap = handicap;
	this.time = time;
    }

    public int getX(int x){
	return x;
    }

    public void paint (Graphics g,int chiffre){
	for (int i=0;i<=(chiffre-1)*20;i+=20){
            g.drawLine(0,i,(chiffre-1)*20,i);
            g.drawLine (i,0,i,(chiffre-1)*20);
            g.setColor(Color.black);
            if (chiffre == 9 ){
		g.drawOval (chiffre*20/2-15,chiffre*20/2-15,10,10);
                g.drawOval (chiffre*20/4-10,chiffre*20/4-10,10,10);
		g.drawOval (chiffre*20/4-10,chiffre*20/4+70,10,10);
		g.drawOval (chiffre*20/4+70,chiffre*20/4-10,10,10);
                g.drawOval (chiffre*20/4+70,chiffre*20/4+70,10,10);

		
	    }
	    else if (chiffre == 13){
                g.drawOval (chiffre*20/2-15,chiffre*20/2-15,10,10);
                g.drawOval (chiffre*20/4-10,chiffre*20/4-10,10,10);
                g.drawOval (chiffre*20/4-10,chiffre*20/4+110,10,10);
                g.drawOval (chiffre*20/4+110,chiffre*20/4-10,10,10);
                g.drawOval (chiffre*20/4+110,chiffre*20/4+110,10,10);
	    }
	    else if (chiffre == 19){
                g.drawOval (chiffre*20/2-15,chiffre*20/2-15,10,10);
                g.drawOval (chiffre*20/2-15,chiffre*20/2-135,10,10);
                g.drawOval (chiffre*20/2-15,chiffre*20/2+125,10,10);
                g.drawOval (chiffre*20/2-135,chiffre*20/2-15,10,10);
                g.drawOval (chiffre*20/2-135,chiffre*20/2-135,10,10);
                g.drawOval (chiffre*20/2-135,chiffre*20/2+125,10,10);
                g.drawOval (chiffre*20/2+105,chiffre*20/2-15,10,10);
                g.drawOval (chiffre*20/2+105,chiffre*20/2-135,10,10);
                g.drawOval (chiffre*20/2+105,chiffre*20/2+125,10,10);
	    }
	}
    }
    public void supprimer(int x2,int y2,int[][] plateau,int taille){
    
      
       
	if (isDead(x2, y2, plateau, new boolean[taille][taille], plateau[x2][y2], taille)) {
	    JOptionPane.showMessageDialog(this, "Stop !!!");
	        
	    plateau[x2][y2] = 0;
	}
	
	
    }
    public void paint2(Graphics g,int chiffre, int chiffreHandicap){
	//Dessine le plateau et les hoshi
	for (int i=0;i<=(chiffre-1)*20;i+=20){
	        
            g.setColor(Color.black);
	    if (chiffre == 9 ){
		
                if (chiffreHandicap == 1) {
		    plateau[2][2] = 1;
                } 
                else if (chiffreHandicap == 2) {
                    plateau[6][6] = 1;
                    plateau[2][2] = 1;
                }
		else if (chiffreHandicap == 3) {
                    plateau[4][4] = 1;
                    plateau[2][2] = 1;
                    plateau[6][6] = 1;
                }
                else if (chiffreHandicap == 4) {
                    plateau[2][6] = 1;
                    plateau[2][2] = 1;
                    plateau[6][6] = 1;
                    plateau[6][2] = 1;
                }
		else if (chiffreHandicap == 5) {
                    plateau[4][4] = 1;
                    plateau[2][2] = 1;
                    plateau[6][6] = 1;
                    plateau[6][2] = 1;
                    plateau[2][6] = 1;
                }
		
            }                                                                                                                                                      
	        
	        
            else if (chiffre == 13){
		
                if (chiffreHandicap == 1) {
		    plateau[3][3] = 1;
                }
		else if (chiffreHandicap == 2) {
                    plateau[3][3] = 1;
                    plateau[9][9] = 1;
                }
                else if (chiffreHandicap == 3) {
                    plateau[6][6] = 1;
                    plateau[3][3] = 1;
                    plateau[9][9] = 1;
                }
                else if (chiffreHandicap == 4) {
                    plateau[3][9] = 1;
                    plateau[3][3] = 1;
                    plateau[9][9] = 1;
                    plateau[9][3] = 1;
                }
		else if (chiffreHandicap == 5) {
                    plateau[6][6] = 1;
                    plateau[3][3] = 1;
                    plateau[9][9] = 1;
                    plateau[9][3] = 1;
                    plateau[3][9] = 1;
                }

            }
	    else if (chiffre == 19){
		
                if (chiffreHandicap == 1) {
		    plateau[15][3] = 1;
                }
                else if (chiffreHandicap == 2){
                    plateau[15][3] = 1;
                    plateau[3][16] = 1;
                }
                else if (chiffreHandicap == 3) {
                    plateau[15][3] = 1;
                    plateau[3][16] = 1;
                    plateau[3][3] = 1;
                }
		else if (chiffreHandicap == 4) {
                    plateau[15][3] = 1;
                    plateau[3][16] = 1;
                    plateau[3][3] = 1;
                    plateau[15][16] = 1;
                }
		else if (chiffreHandicap == 5) {
                    plateau[15][3] = 1;
                    plateau[3][16] = 1;
                    plateau[3][3] = 1;
                    plateau[15][16] = 1;
                    plateau[9][9] = 1;
                }
                else if (chiffreHandicap == 6) {
                    plateau[15][3] = 1;
                    plateau[3][16] = 1;
                    plateau[3][3] = 1;
                    plateau[15][16] = 1;
                    plateau[15][9] = 1;
                    plateau[3][9] = 1;
                }
		else if (chiffreHandicap == 7) {
                    plateau[15][3] = 1;
                    plateau[3][16] = 1;
                    plateau[3][3] = 1;
                    plateau[15][16] = 1;
                    plateau[9][9] = 1;
                    plateau[3][9] = 1;
                    plateau[15][9] = 1;
                }
		else if (chiffreHandicap == 8) {
                    plateau[15][3] = 1;
                    plateau[3][16] = 1;
                    plateau[3][3] = 1;
                    plateau[15][16] = 1;
                    plateau[9][16] = 1;
                    plateau[3][9] = 1;
                    plateau[15][9] = 1;
                    plateau[9][3] = 1;
                }
		else if (chiffreHandicap == 9) {
                    plateau[15][3] = 1;
                    plateau[3][16] = 1;
                    plateau[3][3] = 1;
                    plateau[15][16] = 1;
                    plateau[9][9] = 1;
                    plateau[3][9] = 1;
                    plateau[15][9] = 1;
                    plateau[9][3] = 1;
                    plateau[9][16] = 1;
                }
            }
	        
	        
	}
    }
    

                                                                                                                                            
    public void score(int score,int score2,int[][] plateau){
	for (int j=0;j<taille;j++){
            for (int i=0;i<taille;i++){
                if (plateau[i][j]==1){
                    var++;
                    
		        
                }
                else if (plateau[i][j]==2){
		        
                    var2++;
		}
		
		
	    }
	        
	        
	}
        score=var;
        score2=var2;
        var=0;
	var2=0;
    }
    
    public void paintComponent(Graphics g){
	
	int tailleHandicap = Integer.parseInt(handicap.getText());
	
	
	paint(g,taille);
	
	
	if (varHandicap==3){
	    paint2(g, taille, tailleHandicap);
	}
	varHandicap++;
	
	
	
	
	
	g.drawString("Score Noir : " + Joueur.score,100,400);
	g.drawString("Score Blanc : " + Joueur.score2,100,500);
	g.drawString("Priso Noir : " + Joueur.prison,200,400);
        g.drawString("Priso Blanc : " + Joueur.prison2,200,500);
	g.drawString("Temps : " + Temps.tempsRestant,300,400);
	
	
	
        for (int j=0;j<taille;j++){
            for (int i=0;i<taille;i++){
                if (plateau[i][j]==1){
		    var++;   
		    g.setColor(Color.black);
                    g.fillOval(i*20-5,j*20-5,10,10);
		        
                }
                else if (plateau[i][j]==2){
		    g.setColor(Color.white);
                    g.fillOval(i*20-5,j*20-5,10,10);
		    var2++;
		}
		
		
	    }
	            
	            
	}
	
	Joueur.score=var;
	Joueur.score2=var2;
        var=0;
        var2=0;

	
	
    }
    
    
    public void actionPerformed(ActionEvent e){
	if (numerobouton==1){
	    // Le bouton qui annule un coup
	    j=299;
	            

    
	    for (;j>=0;j--){
		if (plateaux[j]!=0){ // Si le plateau des coups annulé a un truc a l'interieur different de 0 ( SI on a joué un coup donc)
		    //System.out.println("Le joueur 1 a annulé coup en case :" + plateaux[j] + plateauy[j]);     
		    plateau[plateaux[j]][plateauy[j]]=0; // On remet la case du plateau principâl a 0 car on a annulé
		    desannulerx[numerodes]=plateaux[j]; // on met le ocup annuler dans le tableau desannuler si on veut desanuller le coup
		    desannulery[numerodes]=plateauy[j];
		    numerodes++; // On incremente la valeur pour passer a la cas esuivante
		            
		    plateaux[j]=0; // Vu qu'on a annulé, on peut retirer le coup dans le plateau qui annule donc pour ne pas toujours re annuler le meme coup
		    plateauy[j]=0;
		    fenetre.repaint();
		    j=0;
		    if (Joueur.numero==1)
			Joueur.numero=2;
		    else if (Joueur.numero==2)
			Joueur.numero=1;
		            
		}
		
		
		
	    }
	        
	            
	        
	}
	else if (numerobouton==2){
	        
	    j=299;
	    for (;j>=0;j--){
		if (desannulerx[j]!=0){
		    if (Joueur.numero==1){
			plateau[desannulerx[j]][desannulery[j]]=1;
                        Joueur.numero=2;
                    }
                    else if (Joueur.numero==2){
                        plateau[desannulerx[j]][desannulery[j]]=2;
                        Joueur.numero=1;
                    }
		        
		    // Le reste fonctionne comme pour le tableau qui annule un coup
		    //    plateau[desannulerx[j]][desannulery[j]]=Joueur.numero;
		        
		        
		    desannulerx[j]=0;
		    desannulery[j]=0;
		        
		    fenetre.repaint();
		    j=0;
		        
		}
	    }
	}
	else if (numerobouton==3){
	    Joueur.scorefinal=Joueur.score+Joueur.prison;
	    Joueur.scorefinal2=Joueur.score2+Joueur.prison2+7.5;
	    if(Joueur.scorefinal>Joueur.scorefinal2){
		JOptionPane.showMessageDialog(this,"Le gagnant est le Joueur Noir avec un score de : "+ Joueur.scorefinal);
	    }
	    else if (Joueur.scorefinal2>Joueur.scorefinal){
                JOptionPane.showMessageDialog(this,"Le gagnant est le Joueur Blanc avec un score de : "+ Joueur.scorefinal2);
            }
	    else if(Joueur.scorefinal2==Joueur.scorefinal){
                JOptionPane.showMessageDialog(this,"Egalité");
            }

	    System.exit(0);    
	}    
	// Bouton finir. Si on clique dessus le Joueur change
	else if (numerobouton==4) {
	    partieq++;
	    if (partieq==2){
		Joueur.scorefinal=Joueur.score+Joueur.prison;
		Joueur.scorefinal2=Joueur.score2+Joueur.prison2+7.5;
		if(Joueur.scorefinal>Joueur.scorefinal2){
		    JOptionPane.showMessageDialog(this,"Le gagnant est le Joueur Noir avec un score de : "+ Joueur.scorefinal);
		}
		else if (Joueur.scorefinal2>Joueur.scorefinal){
		    JOptionPane.showMessageDialog(this,"Le gagnant est le Joueur Blanc avec un score de : "+ Joueur.scorefinal2);
		}
		else if(Joueur.scorefinal2==Joueur.scorefinal){
		    JOptionPane.showMessageDialog(this,"Egalité");
		}

		System.exit(0);
		

	    }
	    if (Joueur.numero==1){
		Joueur.numero=2;
		
            }
            else if (Joueur.numero==2){
                Joueur.numero=1;
		
            }
	        
	        
	        
	}
	else if (numerobouton==5){
	    if (Joueur.numero==1){
		JOptionPane.showMessageDialog(this,"Le gagnant est le Joueur Blanc.");
	    }
	    else if (Joueur.numero==2){
		
		JOptionPane.showMessageDialog(this,"Le gagnant est le Joueur Noir.");
	    }
	    System.exit(0);
	        
	        
	}
	
	
    }
    public void mouseClicked(MouseEvent e){
	partieq=0;
	taille=Text.chiffreSize;

	if (plateau.length!=taille){
	    plateau= new int[taille][taille];
	}
	//Temps.interrupt();
	
	
	x= e.getX();
	y= e.getY();
	// x2 et y2 sont les cases du tableau a l'endroit ou on clique. Si on clique sur la derniere case, x2 = 18 et y2 =18 par exemple
	x2=(int)x/20;
	y2=(int)y/20;
	int x3=x%20;
	int y3=y%20;
	if (x3>=10)
	    x2++;
	if (y3>=10)
	    y2++;
	
	
	
	
	
	
	if (x2<=taille && y2<=taille){ 
	    if (plateau[x2][y2] != 0) {
		JOptionPane.showMessageDialog(this, "Stop !!!");
		return;
	    }
	    // SI l'endroit ou on clique est dans le plateau
	    if (plateau[x2][y2]==0 && x<(taille)*20 && y<(taille)*20){
		
		for (int j=0;j<300;j++){
		        
		    desannulerx[j]=0;
		        
		        
		}
		// A chaque clique, en fonction du nemero du Joueur, on remplit la case du tableau plateau du numero du Joueur qui clique. On fait enssuite la fonciton supprimer qui evite le suicide, et on rajoute le coupx dans plateaux et plateauy qui sont les coup qu'on sauvegarde pour les annuler apres.
		if (Joueur.numero==1){
		        
		    //System.out.println("Le joueur 1 a joué un coup en case : " +x2 +y2); 
		        
		    plateau[x2][y2]=1; // On met la case a l'endroit ou on clique a 1 poru dire que y'a une pierre dessus
		    supprimer(x2,y2,plateau,taille); // On verifie le suicide
		    plateaux[numero]=x2; // On rajoute le coup dans le plateua qui annule
		    plateauy[numero]=y2; // Meme chose
		    numero++; // On increment la valeur du plateau qui annule pour passer a la case suivante
		        
		}
		
		else if (Joueur.numero==2){
		        
		        
		        
		        
		    plateau[x2][y2]=2;
		    supprimer(x2,y2,plateau,taille);
		        
		    plateaux[numero]=x2;
		    plateauy[numero]=y2;
		    numero++;
		        
		        
		}
		// score(Joueur.score,Joueur.score2,plateau);
		
		if (plateau[x2][y2] != 0 && Joueur.numero == 1) {
		    verifyAdversarialStates(taille, 2);
		        
		    Joueur.numero = 2;
		} else if (plateau[x2][y2] != 0 && Joueur.numero == 2) {
		    verifyAdversarialStates(taille, 1);                                                                                                                                                      
		    Joueur.numero = 1;
		}
		
		
	    }
	        
	}
	
	String test = time.getText();
        
	
        if (test.equals("horloge absolue") || test.equals("Horloge absolue")){
            Temps.createHorloge(10);
	}
        else if (test.equals("Byo-Yomi") || test.equals("Byo-yomi") || test.equals("byo-yomi")) {
            Temps.createByoYomi(5,30);
	}
	Temps.interrupt();
	
	fenetre.repaint();
	
        
    }
    
    
  

 
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}



    public boolean isDead(int x, int y, int goban[][], boolean visited[][], int playerColor, int size) {

	visited[x][y] = true;
	if (x > 0 && !visited[x - 1][y]) {
	    if (goban[x - 1][y] == 0)
		return false;
	    if (goban[x - 1][y] == playerColor) {
		boolean dead = isDead(x - 1, y, goban, visited, playerColor, size);
		
		if (!dead)
		    return false;
	    }
	        
	}
	if (x < (size - 1) && !visited[x + 1][y]) {
	    if (goban[x + 1][y] == 0)
		return false;
	    if (goban[x + 1][y] == playerColor) {
		boolean dead = isDead(x + 1, y, goban, visited, playerColor, size);
		if (!dead)
		    return false;
	    }
	        

	}
	if (y > 0 && !visited[x][y - 1]) {
	    if (goban[x][y - 1] == 0)
		return false;
	    if (goban[x][y - 1] == playerColor) {
		boolean dead = isDead(x, y - 1, goban, visited, playerColor, size);
		if (!dead)
		    return false;
	    }
	            

	}
	if (y < (size - 1) && !visited[x][y + 1]) {
	    if (goban[x][y + 1] == 0)
		return false;
	    if (goban[x][y + 1] == playerColor) {
		boolean dead = isDead(x, y + 1, goban, visited, playerColor, size);
		if (!dead)
		    return false;
	    }
	            

	}
       
	return true;
	
    }

    public void verifyAdversarialStates(int size, int adversarialPlayer) {
	int plateau[][] = new int[size][size];
	for (int i = 0; i < size; i++)
	    for (int j = 0; j < size; j++)
		plateau[i][j] = this.plateau[i][j];
	
	for (int i = 0; i < size; i++) {
	    for (int j = 0; j < size; j++) {
		if (this.plateau[i][j] == adversarialPlayer
		    && isDead(i, j, this.plateau, new boolean[size][size], adversarialPlayer, size)) {
		    if (Joueur.numero==1)
			Joueur.prison++;
		    else if (Joueur.numero==2)
			Joueur.prison2++;
		        
		    System.out.println("Pierre mort  " + adversarialPlayer + " en " + i + "." + j);
		    plateau[i][j] = 0;
		}
	    }
	}
	this.plateau = plateau;
    }
    
    
}

