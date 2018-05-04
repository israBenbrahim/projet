package main;
import Modele.CModele;
import Vue.*;

public class Conway {
/**
* L'amorÃ§age est fait en crÃ©ant le modÃ¨le et la vue, par un simple appel
* Ã  chaque constructeur.
* Ici, le modÃ¨le est crÃ©Ã© indÃ©pendamment (il s'agit d'une partie autonome
* de l'application), et la vue prend le modÃ¨le comme paramÃ¨tre (son
* objectif est de faire le lien entre modÃ¨le et utilisateur).
*/
public static void main(String[] args) {
CModele modele = new CModele();
CVue vue = new CVue(modele);
}
}
