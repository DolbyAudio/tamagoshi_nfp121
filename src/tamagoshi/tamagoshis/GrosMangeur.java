package tamagoshi.tamagoshis;

/**
 * La classe GrosMangeur est une sous-classe de Tamagoshi qui représente un Tamagoshi qui a besoin de manger plus que la normale.
 */
public class GrosMangeur extends Tamagoshi {

    /**
     * Constructeur de la classe GrosMangeur.
     * @param name le nom du Tamagoshi GrosMangeur
     */
    public GrosMangeur(String name) {
        super(name);
    }

    /**
     * Méthode qui permet de faire consommer de l'énergie au Tamagoshi GrosMangeur.
     * Cette méthode est redéfinie pour permettre au Tamagoshi de consommer deux unités d'énergie par tour.
     * @return un booléen qui indique si le Tamagoshi est encore en vie ou non.
     */
    @Override
    public boolean consommeEnergie() {
        this.setEnergy(this.getEnergy()-2);
        if (getEnergy() <= 0) {
            System.out.println(getName() +" est mort de faim.");
            return false;
        }
        else
            return true;
    }

    /**
     * Méthode qui retourne le type du Tamagoshi, qui est "GrosMangeur".
     * @return une chaîne de caractères qui contient le type du Tamagoshi.
     */
    @Override
    public String getType(){
        return "GrosMangeur";
    }
}