package Vue;
import java.awt.*;
import javax.swing.*;
import Modele.CModele;


/**
* La vue : l'interface avec l'utilisateur.
*
* On définit une classe chapeau [CVue] qui crée la fenêtre principale de
* l'application et contient les deux parties principales de notre vue :
* - Une zone d'affichage où on voit l'ensemble des cellules.
* - Une zone de commande avec un bouton pour passer à la génération suivante.
*/
public class CVue {
/**
* JFrame est une classe fournie pas Swing. Elle représente la fenêtre
* de l'application graphique.
*/
private JFrame frame;
/**
* VueGrille et VueCommandes sont deux classes définies plus loin, pour
* nos deux parties de l'interface graphique.
*/
private VueGrille grille;
private VueCommandes commandes;

/** Construction d'une vue attachée Ã  un modèle. */
public CVue(CModele modele) {
/** Définition de la fenêtre principale. */
frame = new JFrame();
frame.setTitle("L'ILE INTERDITE");
/**
* On précise un mode pour disposer les différents éléments à
* l'intérieur de la fenêtre. Quelques possibilités sont :
* - BorderLayout (défaut pour la classe JFrame) : chaque élément est
* dispose au centre ou le long d'un bord.
* - FlowLayout (defaut pour un JPanel) : les elements sont disposes
* l'un a  la suite de l'autre, dans l'ordre de leur ajout, les lignes
* se formant de gauche a droite et de haut en bas. Un element peut
* passer a la ligne lorsque l'on redimensionne la fenÃªtre.
* - GridLayout : les elements sont disposes l'un a la suite de
* l'autre sur une grille avec un nombre de lignes et un nombre de
* colonnes definis par le programmeur, dont toutes les cases ont la
* meme dimension. Cette dimension est calculee en fonction du
* nombre de cases a placer et de la dimension du contenant.
*/
frame.setLayout(new FlowLayout());

/** Definition des deux vues et ajout a la fenetre. */
grille = new VueGrille(modele);
frame.add(grille);
commandes = new VueCommandes(modele);
frame.add(commandes);
/**
* Remarque : on peut passer a la methode [add] des parametres
* supplementaires indiquant ou placer l'element. Par exemple, si on
* avait conserve la disposition par defaut [BorderLayout], on aurait
* pu ecrire le code suivant pour placer la grille a gauche et les
* commandes a droite.
* frame.add(grille, BorderLayout.WEST);
* frame.add(commandes, BorderLayout.EAST);
*/

/**
* Fin de la plomberie :
* - Ajustement de la taille de la fenetre en fonction du contenu.
* - Indiquer qu'on quitte l'application si la fenetre est fermee.
* - Preciser que la fenetre doit bien apparaitre a l'ecran.
*/
frame.pack();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
}
}

