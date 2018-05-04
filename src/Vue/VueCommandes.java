package Vue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Controleur.Controleur;
import Modele.CModele;

/**
* Une classe pour representer la zone contenant le bouton.
*
* Cette zone n'aura pas a etre mise a jour et ne sera donc pas un observateur.
* En revanche, comme la zone precedente, celle-ci est un panneau [JPanel].
*/
public class VueCommandes extends JPanel {
/**
* Pour que le bouton puisse transmettre ses ordres, on garde une
* reference au modele.
*/
private CModele modele;

/** Constructeur. */
public VueCommandes(CModele modele) {
this.modele = modele;
/**
* On cree un nouveau bouton, de classe [JButton], en precisant le
* texte qui doit l'etiqueter.
* Puis on ajoute ce bouton au panneau [this].
*/
JButton boutonAvance = new JButton("Fin de Tour");
this.add(boutonAvance);
JButton boutonHaut = new JButton("HAUT");
this.add(boutonHaut);
JButton boutonBas = new JButton("BAS");
this.add(boutonBas);
JButton boutonGauche = new JButton("GAUCHE");
this.add(boutonGauche);
JButton boutonDroite = new JButton("DROITE");
this.add(boutonDroite);


/**
* Le bouton, lorsqu'il est cliquÃ© par l'utilisateur, produit un
* evenement, de classe [ActionEvent].
*
* On a ici une variante du schema observateur/observe : un objet
* implementant une interface [ActionListener] va s'inscrire pour
* "ecouter" les evenements produits par le bouton, et recevoir
* automatiquements des notifications.
* D'autres variantes d'auditeurs pour des evenements particuliers :
* [MouseListener], [KeyboardListener], [WindowListener].
*
* Cet observateur va enrichir notre schema Modele-Vue d'une couche
* intermediaire Controleur, dont l'objectif est de recuperer les
* evenements produits par la vue et de les traduire en instructions
* pour le modele.
* Cette strate intermediaire est potentiellement riche, et peut
* notamment traduire les memes evenements de differentes facons en
* fonction d'un etat de l'application.
* Ici nous avons un seul bouton realisant une seule action, notre
* controleur sera donc particulierement simple. Cela necessite
* neanmoins la creation d'une classe dediee.
*/
Controleur ctrl = new Controleur(modele);
/** Enregistrement du controleur comme auditeur du bouton. */
boutonAvance.addActionListener(ctrl);
boutonHaut.addActionListener(new ActionListener() {
@Override public void actionPerformed(ActionEvent e) {
ctrl.haut();
}
});

boutonBas.addActionListener(ctrl);
boutonGauche.addActionListener(ctrl);
boutonDroite.addActionListener(ctrl);
/**
* Variante : une lambda-expression qui evite de creer une classe
* specifique pour un controleur simplissime.
*
JButton boutonAvance = new JButton(">");
this.add(boutonAvance);
boutonAvance.addActionListener(e -> { modele.avance(); });
*
*/

}
}
/** Fin de la vue. */

