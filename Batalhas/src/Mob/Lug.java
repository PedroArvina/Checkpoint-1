package Mob;

public class Lug extends Monstro {
    public Lug() {
        super("Lug", 70, 15, 1, 2);
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(nome + " usou sua habilidade especial: Investida Brutal.");
    }
}
