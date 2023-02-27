package tamagoshi.tamagoshis;

/**
 * La classe GrosJoueur représente un Tamagoshi de type "Gros Joueur".
 * Elle hérite de la classe Tamagoshi et redéfinit la méthode consommeFun() et getType().
 */
public class GrosJoueur extends Tamagoshi {

    /**
     * Constructeur de la classe GrosJoueur.
     * @param name Le nom du Tamagoshi.
     */
    public GrosJoueur(String name) {
        super(name);
    }

    /**
     * Redéfinition de la méthode consommeFun() de la classe Tamagoshi.
     * Diminue de 2 l'attribut fun du Tamagoshi et vérifie s'il est mort de dépression.
     * @return true si le Tamagoshi est toujours en vie, false s'il est mort.
     */
    @Override
    public boolean consommeFun() {
        this.setFun(this.getFun()-2);
        if (getFun() <= 0) {
            System.out.println(getName() + " est mort de dépression.");
            return false;
        } else
            return true;
    }

    /**
     * Redéfinition de la méthode getType() de la classe Tamagoshi.
     * @return Le type du Tamagoshi (ici, "GrosJoueur").
     */
    @Override
    public String getType(){
        return "GrosJoueur";
    }
}