package Mob;

public class Anão extends Personagem {
    public Anão() {
        super("Anão", 60, 12, 1, 1);
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(nome + " usou sua habilidade especial: Fúria Anã.");
    }
}
