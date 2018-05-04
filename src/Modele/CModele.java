package Modele;
import java.util.*;

/**
* Le modèle : le coeur de l'application.
*
* Le modèle étend la classe [Observable] : il va posséder un certain nombre
* d'observateurs (ici, un : la partie de la vue responsable de l'affichage)
* et devra les prévenir avec [notifyObservers] lors des modifications.
* Voir la méthode [avance()] pour cela.
*/
public class CModele extends Observable {
/** On fixe la taille de la grille. */
public static final int HAUTEUR=6, LARGEUR=6;
/** On stocke un tableau de cellules. */
private Cellule[][] cellules;

/** Construction : on initialise un tableau de cellules. */
public CModele() {
/**
* Pour éviter les problèmes aux bords, on ajoute une ligne et une
* colonne de chaque côté, dont les cellules n'évolueront pas.
*/
cellules = new Cellule[LARGEUR+2][HAUTEUR+2];
for(int i=0; i<LARGEUR+2; i++) {
for(int j=0; j<HAUTEUR+2; j++) {
cellules[i][j] = new Cellule(this,i, j);
}
}
init();
}

/**
* Initialisation aléatoire des cellules, exceptées celles des bords qui
* ont été ajoutées.
*/
public void init()
{
int cle1 = 0;
int cle2 = 0;
int cle3 = 0;
int cle4 = 0;
int artefact1 = 0;
int artefact2 = 0;
int artefact3 = 0;
int artefact4 = 0;
boolean heliport = false;
while(cle1 == 0 && cle2 == 0 && cle3 == 0 && cle4 == 0 && artefact1 == 0 &&artefact2 == 0 && artefact3 == 0
&& artefact4 == 0 && heliport == false)
{
int x = (int)(Math.random() * 6);
int y = (int)(Math.random() * 6);
if(heliport == false){
cellules[x][y].heliport = true;
heliport = true;
}
else if(cellules[x][y].cle == 0 && cle1 == 0)
{
cellules[x][y].cle = 1;
cle1 = 1;
}
else if(cellules[x][y].cle == 0 && cle2 == 0)
{
cellules[x][y].cle = 2;
cle2 = 1;
}
else if(cellules[x][y].cle == 0 && cle3 == 0)
{
cellules[x][y].cle = 3;
cle3 = 1;
}
else if(cellules[x][y].cle == 0 && cle4 == 0)
{
cellules[x][y].cle = 4;
cle4 = 1;
}
else if(cellules[x][y].artefact == 0 && cellules[x][y].cle == 0 && artefact1 == 0)
{
cellules[x][y].artefact = 1;
artefact1 = 1;
}
else if(cellules[x][y].artefact == 0 && cellules[x][y].cle == 0 && artefact2 == 0)
{
cellules[x][y].artefact = 2;
artefact2 = 1;
}
else if(cellules[x][y].artefact == 0 && cellules[x][y].cle == 0 && artefact3 == 0)
{
cellules[x][y].artefact = 3;
artefact3 = 1;
}
else if(cellules[x][y].artefact == 0 && cellules[x][y].cle == 0 && artefact4 == 0)
{
cellules[x][y].artefact = 4;
artefact4 = 1;
}
}
}

/**
* Calcul de la génération suivante.
*/
public void avance() {
/**
* On tire au sort 3 cases et on y incrémente la valeur de etat
*/
// Modification de votre sensei : au lieu d'utiliser Math.random()
// (qui renvoie des floats et c'est chiant),
// On va plutôt utiliser Random.
Random rangen = new Random();

// Remplacez les expressions dans nextInt() par :
// this.getWidth() pour x
// this.getHiehgt() pour y
// getWidth() et getHeight() n'existent pas encore.
// Mais vous allez les créer bien entendu :3
// (pareil pour les affectations dans la boucle)
Point p = new Point(0,0);
p.x = rangen.nextInt(cellules.length - 2) + 1;
p.y = rangen.nextInt(cellules[0].length - 2) + 1;
ArrayList<Point> picked = new ArrayList<Point>();
System.out.println("\n");

// Là j'ai fait en mode bourrin. Attenton aux boucles infinies !
// Quand il ne restera plus de zones submergées ça bouclera à l'infini.
// A vous de corriger (ou sinon vous me payez <3)
for (int i = 0; i < 3; i++) {
// On choisit un cellule pas déjà choisie
// Bonus : on ne prend pas non plus les zones déjà submergées
while (picked.contains(p) || cellules[p.x][p.y].etat >= 2) {
p = new Point(0,0);
p.x = rangen.nextInt(cellules.length - 2) + 1;
p.y = rangen.nextInt(cellules[0].length - 2) + 1;
}

System.out.println(p);
System.out.println(picked);
picked.add(p);
cellules[p.x][p.y].etat++;
}

/*int x1 = (int)(Math.random() * 7);
int y1 = (int)(Math.random() * 7);
int x2 = (int)(Math.random() * 7);
int y2 = (int)(Math.random() * 7);
int x3 = (int)(Math.random() * 7);
int y3 = (int)(Math.random() * 7);
while (x1 == x2 && y1 == y2){
x2 = (int)(Math.random() * 7);
y2 = (int)(Math.random() * 7);}
while ((x1 == x3 && y1 == y3) || (x2 == x3 && y2 == y3)){
x3 = (int)(Math.random() * 7);
y3 = (int)(Math.random() * 7);}

cellules[x1][y1].etat++;
System.out.print(cellules[x1][y1].etat+"\n");
cellules[x2][y2].etat++;
System.out.print(cellules[x2][y2].etat+"\n");
cellules[x3][y3].etat++;
System.out.print(cellules[x3][y3].etat+"\n*\n");*/
/**
* Pour finir, le modèle ayant changé, on signale aux observateurs
* qu'ils doivent se mettre à jour.
*/
notifyObservers();
}

/**
* Méthode auxiliaire : compte le nombre de voisines vivantes d'une
* cellule désignée par ses coordonnées.
*/
protected int verifVoisinesSub(int x, int y) {
int res=0;
/**
* On compte les cellules non submergées dans les
* zones adjacentes autour des coordonnées (x, y)
*/
if(cellules[x+1][y].etat < 2) res++;
if(cellules[x-1][y].etat < 2) res++;
if(cellules[x][y+1].etat < 2) res++;
if(cellules[x][y-1].etat < 2) res++;
return (res);
}

/**
* Une méthode pour renvoyer la cellule aux coordonnées choisies (sera
* utilisée par la vue).
*/
public Cellule getCellule(int x, int y) {
return cellules[x][y];
}
/**
* Notez qu'à  l'intérieur de la classe [CModele], la classe interne est
* connue sous le nom abrégé [Cellule].
* Son nom complet est [CModele.Cellule], et cette version complète est
* la seule à  pouvoir être utilisée depuis l'extèrieur de [CModele].
* Dans [CModele], les deux fonctionnent.
*/

@Override
public String toString() {
String result = "";
for(int x=0; x<LARGEUR+2; x++) {
for(int y=0; y<HAUTEUR+2; y++) {
result += getCellule(x, y).EtatCellule();
}
result += "\n";
}

return result;
}
}

/** Fin de la classe CModele. */

// Classe à déplacer là où vous voulez (mais autre part quand même)
class Point {
public int x;
public int y;

public Point(int x, int y) {
this.x = x;
this.y = y;
}

@Override
public boolean equals(Object o) {
if (!(o instanceof Point))
return false;

Point p = (Point) o;
return (p.x == x) && (p.y == y);
}

@Override
public String toString() {
return "(" + x + ", " + y + ")";
}
}

