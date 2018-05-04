package Controleur;
import java.awt.event.*;
import Modele.CModele;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
* Classe pour notre controleur rudimentaire.
*
* Le controleur implemente l'interface [ActionListener] qui demande
* uniquement de fournir une methode [actionPerformed] indiquant la
* reponse du controleur a la reception d'un evenement.
*/
public class Controleur implements ActionListener {
/**
* On garde un pointeur vers le modele, car le controleur doit
* provoquer un appel de methode du modele.
* Remarque : comme cette classe est interne, cette inscription
* explicite du modele est inutile. On pourrait se contenter de
* faire directement reference au modele enregistre pour la classe
* englobante [VueCommandes].
*/
CModele modele;
public Controleur(CModele modele) { this.modele = modele; }
/**
* Action effectuee a reception d'un evenement : appeler la
* methode [avance] du modele.
*/
public void actionPerformed(ActionEvent e)
{
modele.avance();
}
public void haut()
{
modele.Deplacement(0,x,y);
}
}
/** Fin du contrÃ´leur. */