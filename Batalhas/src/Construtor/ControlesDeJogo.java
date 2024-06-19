package Construtor;

import javax.swing.*;
import Mob.Monstro;
import Mob.Personagem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import Construtor.Inventario;

public class ControlesDeJogo extends JPanel {

    private static final int LARGURA = 10;
    private static final int ALTURA = 5;
    private static final Color HIGHLIGHT_COLOR = Color.YELLOW;
    private static final Color ATTACK_COLOR = Color.RED;

    private Acessório acessorio;
    private Turno turno;
    private IA ia;
    private Personagem mago;
    private Personagem guerreiro;
    private Personagem anao;
    private Monstro pug;
    private Monstro lug;
    private Monstro dug;
    private Personagem personagemSelecionado;
    private Map<String, JButton> quadrados;
    private Poderes poderes; 
    private Inventario inventario;

    public ControlesDeJogo(Personagem personagemSelecionado, Acessório acessorio) {
        this.acessorio = acessorio;
        this.poderes = new Poderes();
        this.inventario = new Inventario();
        this.personagemSelecionado = personagemSelecionado;
        setLayout(new BorderLayout());
        quadrados = new HashMap<>();

        JLabel titulo = new JLabel("Painel de Controle", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(titulo, BorderLayout.NORTH);

        JPanel controlePanel = new JPanel(new GridLayout(3, 1));
        controlePanel.add(criarPainelHeroi("Mago", "Fotos/P1", "quadradoMago"));
        controlePanel.add(criarPainelHeroi("Guerreiro", "Fotos/Guerreiro.png", "quadradoGuerreiro"));
        controlePanel.add(criarPainelHeroi("Anão", "Fotos/Anao.png", "quadradoAnao"));
        add(controlePanel, BorderLayout.CENTER);

        JButton botaoInventario = new JButton("Abrir Inventário");
        botaoInventario.addActionListener(e -> inventario.abrirInventario(this.personagemSelecionado));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(botaoInventario);
        add(buttonPanel, BorderLayout.SOUTH);

        inicializarAcoesETextos();
    }

    private JPanel criarPainelHeroi(String nomeHeroi, String linkImagem, String prefixoQuadrados) {
        JPanel painelHeroi = new JPanel(new BorderLayout());
        JLabel imagemHeroi = new JLabel(new ImageIcon(new ImageIcon(linkImagem).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        JLabel nomeHeroiLabel = new JLabel(nomeHeroi, SwingConstants.LEFT);
        nomeHeroiLabel.setFont(new Font("Arial", Font.BOLD, 12));

        JPanel painelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelSuperior.add(imagemHeroi);
        painelSuperior.add(nomeHeroiLabel);
        painelHeroi.add(painelSuperior, BorderLayout.NORTH);

        JPanel painelInferior = new JPanel(new GridLayout(1, 1));
        JButton botaoAcao = new JButton("Usar Poder");
        botaoAcao.setActionCommand(prefixoQuadrados + "1");
        botaoAcao.addActionListener(new QuadradoActionListener());
        quadrados.put(prefixoQuadrados + "1", botaoAcao);
        painelInferior.add(botaoAcao);
        painelHeroi.add(painelInferior, BorderLayout.CENTER);

        return painelHeroi;
    }

    private class QuadradoActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nomeQuadrado = e.getActionCommand();
            acionarPoder(nomeQuadrado);
        }
    }

    private void acionarPoder(String nomeQuadrado) {
        poderes.acionar(nomeQuadrado, personagemSelecionado);
        atualizarPainelAcessorio();
    }

    private void atualizarPainelAcessorio() {
        if (personagemSelecionado != null) {
            acessorio.atualizarStatusAnao(personagemSelecionado.getHp());
        }
    }

    private void inicializarAcoesETextos() {
        setTextoQuadrado("quadradoMago1", "Porção de cura");
        setTextoQuadrado("quadradoGuerreiro1", "Poção de cura");
        setTextoQuadrado("quadradoAnao1", "Porção de cura");
    }

    private void setTextoQuadrado(String nomeQuadrado, String texto) {
        JButton quadrado = quadrados.get(nomeQuadrado);
        if (quadrado != null) {
            quadrado.setText(texto);
        }
    }
}
