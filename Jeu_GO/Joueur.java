import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.EmptyBorder;


class Joueur {
    // Class Joueur qui change le numero a chaque fois qu'on clique sur le bouton finir, ce qui change le Joueur                                                                                                                 
    public static int numero=1;
    public static int score=0;
    public static int score2=0;
    public static int prison=0;
    public static int prison2=0;
    public static double scorefinal=0;
    public static double scorefinal2=0;
    Joueur(int numero){
        this.numero=numero;
    }
    public int getNumero(){
        return numero;
    }
}
