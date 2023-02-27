package tamagoshi.jeu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import tamagoshi.tamagoshis.Tamagoshi;
import tamagoshi.tamagoshis.GrosJoueur;
import tamagoshi.tamagoshis.GrosMangeur;

public class TamaGame {
    private List<Tamagoshi> tamagoshisDeDepart;
    private List<Tamagoshi> tamagoshisEnCourse;

    private int cycle = 0;

    private Random random = new Random();

    /**
     * Constructeur par défaut de la classe TamaGame
     * Initialise les deux listes de Tamagoshis.
     */
    public TamaGame() {
        this.tamagoshisDeDepart = new ArrayList<>();
        this.tamagoshisEnCourse = new ArrayList<>();
    }

    /**
     * Méthode qui joue un tour de jeu.
     * Pour chaque Tamagoshi en cours de jeu, cette méthode vérifie s'il peut continuer à jouer.
     * Si ce n'est pas le cas, le Tamagoshi est retiré de la liste des Tamagoshis en cours de jeu
     * et un message est affiché pour le signaler.
     */
    public void jouerTour() {
        for (int i = 0; i < tamagoshisEnCourse.size(); i++) {
            Tamagoshi t = tamagoshisEnCourse.get(i);
            if (!t.consommeEnergie() || !t.consommeFun() || !t.vieillit()) {
                tamagoshisEnCourse.remove(i);
                System.out.println(t.getName() + " est KO !");
                i--;
            }
        }
    }

    /**
     * Méthode qui initialise le jeu.
     * Demande le nombre de Tamagoshis à créer, crée des Tamagoshis avec des noms aléatoires
     * et des types (GrosJoueur ou GrosMangeur) aléatoires, et les ajoute à la liste des Tamagoshis de départ
     * et à la liste des Tamagoshis en cours de jeu.
     */
    public void initialisation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Combien de Tamagoshis voulez-vous créer ?");
        int nbTamagoshis = sc.nextInt();
        sc.nextLine(); // pour vider le buffer

        List<String> noms = new ArrayList<>(Arrays.asList(
                "Biscuit","Nemo","Simba","Lola","Caramel","Belle","Felix","Pikachu","Daisy","Rex",
                "Zoe","Chloe","Oscar","Lucky","Rocky","Max","Ruby","Buddy","Pepper","Bailey",
                "Lulu","Sam","Bella","Harley","Charlie","Roxy","Cooper","Sadie","Luna","Toby",
                "Daisy","Nala","Oliver","Riley","Ruby","Zeus","Willow","Koda","Rosie","Loki",
                "Emma","Bailey","Stella","Tucker","Gus","Bear","Charlie","Ivy","Thor","Hazel",
                "Winston","Annie","Dexter","Lilly","Benji","Layla","Jax")
        );

        for (int i = 0; i < nbTamagoshis; i++) {
            int index = random.nextInt(noms.size());
            String nom = noms.remove(index);
            Tamagoshi t;
            if (random.nextDouble() < 0.5) {
                t = new GrosJoueur(nom);
            } else {
                t = new GrosMangeur(nom);
            }
            tamagoshisDeDepart.add(t);
            tamagoshisEnCourse.add(t);
        }
    }

    /**
     * Vérifie si un Tamagoshi est KO (KO signifie que son énergie ou son fun est inférieur ou égal à 0)
     * @param t Tamagoshi à vérifier
     * @return true si le Tamagoshi est KO, false sinon
     */
    private boolean estKO(Tamagoshi t) {
        return (t.getEnergy() <= 0 || t.getFun() <= 0);
    }

    /**
     * Vérifie si le jeu est fini (tous les Tamagoshis en cours de partie sont KO)
     * @return true si tous les Tamagoshis en cours de partie sont KO, false sinon
     */
    private boolean jeuFini() {

        if (!tamagoshisEnCourse.isEmpty()) {
            for (Tamagoshi t : tamagoshisEnCourse) {
                if (!estKO(t)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Affiche l'état de chaque Tamagoshi présent au début du jeu
     */
    public void score() {
        for (Tamagoshi tamagoshi : tamagoshisDeDepart) {
            tamagoshi.etat();
        }
    }

    /**
     * Affiche le score de fun et d'énergie de tous les Tamagoshis présents au début du jeu
     */
    public void resultat() {
        int sommeEnergie = 0;
        int sommeFun = 0;
        int sommeMaxEnergie = 0;
        int sommeMaxFun = 0;
        for (Tamagoshi t : tamagoshisDeDepart) {
            sommeEnergie += t.getEnergy();
            sommeFun += t.getFun();
            sommeMaxFun += t.getmaxFun();
            sommeMaxEnergie += t.getMaxEnergy();

        }
        System.out.println("Votre score de fun est de " + sommeFun + " sur " + sommeMaxFun);
        System.out.println("Votre score d'énergie est de " + sommeEnergie + " sur " + sommeMaxEnergie);
    }

    /**
     * Fonction principale pour jouer au jeu Tamagotchi
     */
    public void play() {
        initialisation();

        Scanner sc = new Scanner(System.in);

        while (!jeuFini()) {
            this.cycle += 1;
            System.out.println("------------Cycle n°" + cycle + "-------------");

            for (Tamagoshi t : tamagoshisEnCourse) {
                System.out.print(t.toString());
                //Pour activer le debug :)
                t.parle();
            }

            System.out.println("Nourrir quel tamagoshi ?");
            int count = 0;
            for (Tamagoshi t : tamagoshisEnCourse) {
                System.out.print("(" + count + ") " + t.getName() + "\t");
                count += 1 ;
            }

            System.out.println("\nEntrez un choix : ");
            int idTamagoshi = sc.nextInt();
            while (idTamagoshi > tamagoshisEnCourse.size() - 1) {
                System.out.print("Vous avez saisi un numéro incorrect, veuillez en resaisir un.");
                System.out.println("\nEntrez un choix : ");
                idTamagoshi = sc.nextInt();
            }

            if(!tamagoshisEnCourse.get(idTamagoshi).mange()){
                System.out.println("Ce tamagotchi n'avait pas faim :(");
            }

            System.out.println("Jouer avec quel tamagoshi ?");
            count = 0;
            for (Tamagoshi t : tamagoshisEnCourse) {
                System.out.print("(" + count + ") " + t.getName() + "\t");
                count += 1 ;
            }

            System.out.println("\nEntrez un choix : ");
            idTamagoshi = sc.nextInt();
            while (idTamagoshi > tamagoshisEnCourse.size() - 1) {
                System.out.print("Vous avez saisi un numéro incorrect, veuillez en resaisir un.");
                System.out.println("\nEntrez un choix : ");
                idTamagoshi = sc.nextInt();
            }

            if (!tamagoshisEnCourse.get(idTamagoshi).joue()){
                System.out.println("Ce tamagotchi n'avait pas envie de jouer :(");
            }

            jouerTour();
        }

        System.out.println("\n--------- fin de partie !! ----------------\n-------------bilan------------");
        score();
        resultat();
    }

    public static void main(String[] args) {
        TamaGame jeu = new TamaGame();
        jeu.play();
    }
}