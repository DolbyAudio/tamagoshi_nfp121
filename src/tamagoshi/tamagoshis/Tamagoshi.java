package tamagoshi.tamagoshis;
import java.util.Random;



/**
 * La classe Tamagoshi représente un animal virtuel que l'on peut nourrir et divertir.
 *
 * Les Tamagoshis ont un niveau d'énergie et de fun, qui diminuent au fil du temps et
 * augmentent lorsqu'ils mangent ou jouent. S'ils manquent d'énergie ou de fun, ils
 * peuvent mourir. Les Tamagoshis ont également un nom, un âge et une durée de vie maximale.
 */
public class Tamagoshi {

    private int age;
    private int maxEnergy;
    private int energy;
    private int fun;
    private int maxFun;
    private String name;
    private static int lifeTime = 10;
    private Random random = new Random();

    /**
     * Constructeur pour un Tamagoshi.
     *
     * @param name le nom du Tamagoshi.
     */
    public Tamagoshi(String name){
        this.name = name;
        this.age = 0;
        this.random = new Random();
        this.maxEnergy = random.nextInt(5) + 5;
        this.energy = random.nextInt(5) + 3;
        this.maxFun = random.nextInt(5) + 5;
        this.fun = random.nextInt(5) + 3;

        if(this.energy > this.maxEnergy) {
            this.energy = this.maxEnergy;
        }

        if(this.fun > this.maxFun) {
            this.fun = this.maxFun;
        }
    }

    /**
     * Retourne le type de Tamagoshi (ici, "Tamagoshi").
     *
     * @return le type de Tamagoshi.
     */
    public String getType(){
        return "Tamagoshi";
    }

    /**
     * Fait parler le Tamagoshi en fonction de son niveau d'énergie et de fun.
     */
    public void parle() {
        if (this.energy > 4 && this.fun > 4) {
            System.out.println(this.name + " est repu et passe un bon moment.");
        } else
        if (this.energy > 4 && this.fun <= 4) {
            System.out.println(this.name + " est repu et s'ennuie.");
        } else
        if (this.energy <= 4 && this.fun > 4) {
            System.out.println(this.name + " est affamé, mais il passe un bon moment.");
        } else
        {
            System.out.println(this.name + " est affamé et s'ennuie.");
        }
    }

    /**
     * Affiche l'état de santé du Tamagoshi.
     */
    public void etat() {
        if (this.energy <= 0 || this.fun <= 0) {
            System.out.println(this.name + " qui était un " + getType() + " est mort.");
        } else {
            System.out.println(this.name + " qui était un " + getType() + " a survécu au jeu.");
        }
    }

    /**
     * Retourne le niveau d'énergie du Tamagoshi.
     *
     * @return le niveau d'énergie du Tamagoshi.
     */
    public int getEnergy() {
        return this.energy;
    }

    /**
     * Retourne le générateur de nombres aléatoires utilisé par le Tamagoshi.
     *
     * @return le générateur de nombres aléatoires utilisé par le Tamagoshi.
     */
    public Random getRandom(){
        return this.random;
    }

    /**
     * Retourne la durée de vie maximale du Tamagoshi.
     *
     * @return la durée de vie maximale du Tamagoshi.
     */
    public int getLifeTime() {
        return lifeTime;
    }

    /**
     * Retourne l'âge du Tamagoshi.
     *
     * @return l'âge du Tamagoshi.
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Modifie le niveau d'énergie du Tamagoshi.
     *
     * @param energy le nouveau niveau d'énergie du Tamagoshi.
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     * Retourne le niveau de fun du Tamagoshi.
     *
     * @return le niveau de fun du Tamagoshi.
     */
    public int getFun() {
        return this.fun;
    }

    /**
     * Modifie le niveau de fun du Tamagoshi.
     *
     * @param fun le nouveau niveau de fun du Tamagoshi.
     */
    public void setFun(int fun){
        this.fun = fun;
    }

    /**
     * Retourne la valeur maximale du niveau de fun du Tamagoshi.
     *
     * @return la valeur maximale du niveau de fun du Tamagoshi.
     */
    public int getmaxFun() {
        return this.maxFun;
    }

    /**
     * Retourne la valeur maximale du niveau d'énergie du Tamagoshi.
     *
     * @return la valeur maximale du niveau d'énergie du Tamagoshi.
     */
    public int getMaxEnergy() {
        return this.maxEnergy;
    }

    /**
     * Retourne le nom du Tamagoshi.
     *
     * @return le nom du Tamagoshi.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Fait manger le Tamagoshi si il a faim.
     *
     * @return true si le Tamagoshi mange, false sinon.
     */
    public boolean mange() {
        if (this.energy < this.maxEnergy) {
            this.energy += this.random.nextInt(3) + 1;
            if (this.energy > this.maxEnergy) {
                this.energy = this.maxEnergy;
            }
            System.out.println(this.name + " mange.");
            return true;
        } else {
            System.out.println(this.name + " n'a pas faim !");
            return false;
        }
    }

    /**
     * Fait jouer le Tamagoshi si il ne s'ennuie pas.
     *
     * @return true si le Tamagoshi joue, false sinon.
     */
    public boolean joue() {
        if (this.fun < this.maxFun) {
            this.fun += this.random.nextInt(3) + 1;
            if (this.fun > this.maxFun) {
                this.fun = this.maxFun;
            }
            System.out.println(this.name + " joue.");
            return true;
        } else {
            System.out.println(this.name + " n'a pas envie de jouer !");
            return false;
        }
    }

    /**
     * Cette fonction réduit l'énergie du Tamagoshi courant de 1. Si l'énergie de l'objet devient inférieure
     * ou égale à 0, un message de mort est affiché et la fonction retourne faux. Sinon, elle retourne vrai.
     *
     * @return true si le Tamagoshi a encore de l'énergie, false sinon.
     */
    public boolean consommeEnergie() {
        this.energy -= 1;
        if (getEnergy() <= 0) {
            System.out.println(getName() +" est mort de faim.");
            return false;
        }
        else
            return true;
    }

    /**
     * Cette fonction augmente l'âge du Tamagoshi courant de 1. Si l'âge de l'objet devient supérieur ou égal
     * à son espérance de vie, un message de mort est affiché et la fonction retourne faux. Sinon, elle retourne
     * vrai.
     *
     * @return true si le Tamagoshi est toujours vivant, false sinon.
     */
    public boolean vieillit(){
        this.age += 1;
        if (getAge() >= getLifeTime()) {
            System.out.println(getName() +" est mort de vieillesse.");
            return false;
        }
        else
            return true;
    }

    /**
     * Cette fonction réduit le niveau de fun du Tamagoshi courant de 1. Si le niveau de fun du Tamagoshi devient
     * inférieur ou égal à 0, un message de mort est affiché et la fonction retourne faux. Sinon, elle retourne
     * vrai.
     *
     * @return true si le Tamagoshi a encore du fun, false sinon.
     */
    public boolean consommeFun() {
        this.fun -= 1;
        if (getFun() <= 0) {
            System.out.println(getName() + " est mort de dépression.");
            return false;
        } else
            return true;
    }

    public String toString() {
        return "Tamagoshi [age=" + age + ", maxEnergy=" + maxEnergy + ", energy=" + energy + ", name=" + name + ", fun=" + fun + ", maxFun=" + maxFun + "]";
    }

    public static void main(String[] args) {
        Tamagoshi tamagoshi = new Tamagoshi("Tama");
        System.out.println(tamagoshi);
        tamagoshi.parle();
        System.out.print(tamagoshi.toString());
        tamagoshi.mange();
        System.out.print(tamagoshi.toString());
        tamagoshi.mange();
        System.out.print(tamagoshi.toString());
        tamagoshi.consommeEnergie();
        System.out.print(tamagoshi.toString());
        tamagoshi.mange();
        System.out.print(tamagoshi.toString());
        tamagoshi.consommeEnergie();
        System.out.print(tamagoshi.toString());
    }
}