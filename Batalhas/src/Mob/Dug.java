package Mob;

public class Dug extends Monstro {
    public Dug() {
        super("Dug", 60, 12, 1, 1);
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(nome + " usou sua habilidade especial: Golpe Duplo.");
    }
}
