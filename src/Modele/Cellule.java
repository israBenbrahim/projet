package Modele;

/**
* Définition d'une classe pour les cellules.
* Cette classe fait encore partie du modèle.
*/
public class Cellule {
/** On conserve un pointeur vers la classe principale du modèle. */
protected CModele modele;

/** L'état d'une cellule est donné par un entier : 0 = normale 1 = innondée 2 ou + = submergée. */
protected int etat;
/**
* On stocke les coordonnées pour pouvoir les passer au modèle lors
* de l'appel à  [compteVoisines].//Au cas où on pourra s'en servir pour savoir si un joueur peut être sauvé !
*/
protected final int x, y;
public int occupe;
protected int cle;
protected int artefact;
public boolean heliport;

public Cellule(CModele modele, int x, int y) {
this.modele = modele;
this.etat = 0;
this.x = x; this.y = y;
this.occupe = 0;
this.cle = 0;
this.artefact = 0;
this.heliport = false;
}

/** Un test à  l'usage des autres classes (sera utilisé par la vue). */
public int EtatCellule() {
return etat;
}
}
/** Fin de la classe Cellule, et du modÃ¨le en gÃ©nÃ©ral. */