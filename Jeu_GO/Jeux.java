import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.EmptyBorder;



class Quitter implements ActionListener{
    
    
    public void actionPerformed(ActionEvent event){
	System.exit(0);
    }
}

class Text implements ActionListener {
    private JTextField taille;
    private JFrame fenetre;
    public static int chiffreSize;
   
   
    Text(JTextField taille,JFrame fenetre){
	this.taille=taille;
	this.fenetre=fenetre;
	
    }
    public JTextField getText(){
	return taille;
    }
    
    public void setText(JTextField taille){
	this.taille=taille;
    }
    
    public int getChiffre(){
	return Integer.parseInt(taille.getText()); 
    } 
    public void setChiffre(int chiffreSize){
	this.chiffreSize=chiffreSize;
    }
    public void actionPerformed(ActionEvent event){

	chiffreSize=Integer.parseInt(taille.getText());
	fenetre.setVisible(true);
    }

}

class Texte implements ActionListener {
    private JTextField handicap;
    private JFrame fenetre;
    public static int chiffreHandicap;

    Texte(JTextField handicap, JFrame fenetre){
        this.handicap = handicap;
        this.fenetre = fenetre;
    }

    public JTextField getText() {
        return handicap;
    }

    public void setText(JTextField handicap) {
        this.handicap = handicap;
    }

    public int getHandicap() {
	return Integer.parseInt(handicap.getText());
    }

    public void setHandicap (int chiffreHandicap) {
	this.chiffreHandicap = chiffreHandicap;
    }

    public void actionPerformed (ActionEvent event) {
        chiffreHandicap = Integer.parseInt(handicap.getText());
	fenetre.setVisible(true);
    }
}

public class Jeux extends JFrame {

    private JPanel contentPane;

   
    public static void main(String[] args) {
	Jeux frame = new Jeux();
	frame.setVisible(true);
    }

    
    public Jeux() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(200, 200, 481, 600);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);


	int chiffre=1;
       

	JPanel panel = new JPanel();
	contentPane.add(panel, BorderLayout.CENTER);
	panel.setLayout(null);
	
	Label label = new Label("Time Rule:");
	label.setBounds(10, 25, 62, 22);
	panel.add(label);
	
	
	Label label_1 = new Label("Size:");
	label_1.setBounds(10, 53, 62, 22);
	panel.add(label_1);
	
	
	JTextField taille = new JTextField();
	taille.setBounds(132, 55, 116, 20);
	panel.add(taille);
	JTextField time = new JTextField();
	time.setBounds(132, 27, 116, 20);
	panel.add(time);
	JTextField handicap = new JTextField();
	handicap.setBounds(132,154,116,20);
	panel.add(handicap);
	Label label_2 = new Label("Black Player Name:");
	label_2.setBounds(10, 94, 116, 22);
	panel.add(label_2);
	
	Label label_3 = new Label("White Player Name:");
	label_3.setBounds(10, 122, 116, 22);
	panel.add(label_3);

	Label label_4 = new Label("Handicap");
	label_4.setBounds(10,152,62,22);
	panel.add(label_4);

	JFrame partie = new JFrame();
        partie.setLayout(null);
        partie.setSize(800,800);
       
	Button startButton = new Button("Start");
	startButton.setBounds(178, 176, 70, 22);
	panel.add(startButton);
	startButton.addActionListener(new Text(taille,partie));
	
	
	

	Button quitter = new Button("Quitter");
	quitter.setBounds(178+75, 176, 70, 22);
	panel.add(quitter);
	quitter.addActionListener(new Quitter());

       
	

	Choice choice_1 = new Choice();
	choice_1.setBounds(132, 55, 116, 20);
	panel.add(choice_1);
	
	JTextField textField = new JTextField();
	textField.setBounds(132, 94, 116, 22);
	panel.add(textField);
	
	JTextField textField_1 = new JTextField();
	textField_1.setBounds(132, 122, 116, 22);
	panel.add(textField_1);
	
	

	JPanel partiepanel = new JPanel();

        JPanel boutonpanel = new JPanel();

	Button annuler = new Button("Annuler");
        annuler.setBounds(100, 100, 70, 22);
        boutonpanel.add(annuler);
	annuler.addActionListener(new Goban(textField_1,partie,1,handicap,time));

        Button desannuler = new Button("Desannuler");
        annuler.setBounds(200, 200, 80, 80);
        boutonpanel.add(desannuler);
	desannuler.addActionListener(new Goban(textField_1,partie,2,handicap,time));
	
	Button passer = new Button("Passer");
	passer.setBounds(400,400,80,80);
	boutonpanel.add(passer);
	passer.addActionListener(new Goban(textField_1,partie,4,handicap,time));
	
	Button finir = new Button("Finir");
        finir.setBounds(300, 300, 80, 80);
        boutonpanel.add(finir);
	finir.addActionListener(new Goban(textField_1,partie,3,handicap,time));
        Text text = new Text(taille,partie);
	
        Button abandonner = new Button("Abandonner");
	abandonner.setBounds(300, 350, 80, 80);
        boutonpanel.add(abandonner);
        abandonner.addActionListener(new Goban(textField_1,partie,5,handicap,time));
                                                                                                                                                                        
     
        boutonpanel.setBounds(380,380,400,400);
                                                                                                                                                                               
	
	partie.add(boutonpanel);
	Goban go = new Goban(textField_1,partie,1,handicap,time);
	go.addMouseListener(go);

        go.setBounds(0,0,500,500);                                                                                                                                                                                     
        partie.add(go);
	// Dans la JFrame partie, onr ajoute le panel qui gere les boutons et un objet de type go qui gere le plateau
	       
    }
}
