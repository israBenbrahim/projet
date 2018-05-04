package Vue;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import Modele.CModele;
import Modele.Cellule;

/**
* Une classe pour reprÃ©senter la zone d'affichage des cellules.
*
* JPanel est une classe d'Ã©lÃ©ments graphiques, pouvant comme JFrame contenir
* d'autres Ã©lÃ©ments graphiques.
*
* Cette vue va Ãªtre un observateur du modÃ¨le et sera mise Ã  jour Ã  chaque
* nouvelle gÃ©nÃ©ration des cellules.
*/
public class VueGrille extends JPanel implements Observer {
/** On maintient une reference vers le modele. */
private CModele modele;
/** Definition d'une taille (en pixels) pour l'affichage des cellules. */
private final static int TAILLE = 100;

/** Constructeur. */
public VueGrille(CModele modele) {
this.modele = modele;
/** On enregistre la vue [this] en tant qu'observateur de [modele]. */
modele.addObserver(this);
/**
* DÃ©finition et application d'une taille fixe pour cette zone de
* l'interface, calculÃ©e en fonction du nombre de cellules et de la
* taille d'affichage.
*/
Dimension dim = new Dimension(TAILLE*CModele.LARGEUR,
TAILLE*CModele.HAUTEUR);
this.setPreferredSize(dim);
}

/**
* L'interface [Observer] demande de fournir une methode [update], qui
* sera appele©e lorsque la vue sera notifiÃ©e d'un changement dans le
* modele. Ici on se content de reafficher toute la grille avec la methode
* predefinie [repaint].
*/
public void update(Observable o,Object arg) { repaint(); }

/**
* Les Ã©lÃ©ments graphiques comme [JPanel] possÃ¨dent une mÃ©thode
* [paintComponent] qui dÃ©finit l'action Ã  accomplir pour afficher cet
* Ã©lÃ©ment. On la redÃ©finit ici pour lui confier l'affichage des cellules.
*
* La classe [Graphics] regroupe les Ã©lÃ©ments de style sur le dessin,
* comme la couleur actuelle.
*/
public void paintComponent(Graphics g) {
super.repaint();
/** Pour chaque cellule... */
for(int i=1; i<=CModele.LARGEUR; i++) {
for(int j=1; j<=CModele.HAUTEUR; j++) {
/**
* ... Appeler une fonction d'affichage auxiliaire.
* On lui fournit les informations de dessin [g] et les
* coordonnÃ©es du coin en haut Ã  gauche.
*/
paint(g, modele.getCellule(i, j), (i-1)*TAILLE, (j-1)*TAILLE);
}
}
}
/**
* Fonction auxiliaire de dessin d'une cellule.
* Ici, la classe [Cellule] ne peut Ãªtre dÃ©signÃ©e que par l'intermÃ©diaire
* de la classe [CModele] Ã  laquelle elle est interne, d'oÃ¹ le type
* [CModele.Cellule].
* Ceci serait impossible si [Cellule] Ã©tait dÃ©clarÃ©e privÃ©e dans [CModele].
*/
private void paint(Graphics g, Cellule c, int x, int y) {
/** SÃ©lection d'une couleur. */
if (c.EtatCellule()==0)
{ g.setColor(Color.GREEN);
/** Coloration d'un rectangle. */
g.fillRect(x, y, TAILLE, TAILLE);
}
else if (c.EtatCellule()==1)
g.setColor(Color.CYAN);

else if (c.EtatCellule()>=2)
g.setColor(Color.BLUE);

if (c.heliport==true)
g.setColor(Color.BLACK);

/** Coloration d'un rectangle. */
g.fillRect(x, y, TAILLE, TAILLE);

if(c.occupe >= 1)
{
g.setColor(Color.WHITE);
/** Coloration d'un cercle si y'a un joueur. */
g.fillOval(x+25, y+25, TAILLE/2, TAILLE/2);
}

}
}

