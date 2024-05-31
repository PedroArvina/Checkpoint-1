package Construtor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ControlesDeJogo extends JPanel {

    private Map<String, JButton> quadrados;

    public ControlesDeJogo() {
        setLayout(new BorderLayout());
        quadrados = new HashMap<>();

        JLabel titulo = new JLabel("Painel de Controle", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(titulo, BorderLayout.NORTH);

        // Painel para elementos de controle com imagens dos heróis
        JPanel controlePanel = new JPanel(new GridLayout(3, 1)); // Grid de 3 linhas, 1 coluna

        // Adiciona painéis para cada herói com cinco quadrados personalizados abaixo de cada um
        controlePanel.add(criarPainelHeroi("Mago", "link_para_imagem_mago.png", "quadradoMago"));
        controlePanel.add(criarPainelHeroi("Guerreiro", "link_para_imagem_guerreiro.png", "quadradoGuerreiro"));
        controlePanel.add(criarPainelHeroi("Anão", "link_para_imagem_anao.png", "quadradoAnao"));

        add(controlePanel, BorderLayout.CENTER);

        // Podemos adicionar mais botões ou elementos interativos aqui conforme necessário
        JButton botaoExemplo = new JButton("Ação Exemplo");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(botaoExemplo);
        add(buttonPanel, BorderLayout.SOUTH);

        setPreferredSize(new Dimension(200, 0)); // Define a largura preferida para o painel

        // Definindo ações e textos iniciais para cada quadrado
        inicializarAcoesETextos();
    }

    private JPanel criarPainelHeroi(String nomeHeroi, String linkImagem, String prefixoQuadrados) {
        JPanel painelHeroi = new JPanel();
        painelHeroi.setLayout(new BorderLayout());

        // Painel para imagem e nome do herói lado a lado
        JPanel painelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel imagemHeroi = new JLabel(new ImageIcon(new ImageIcon(linkImagem).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)), SwingConstants.CENTER);
        painelSuperior.add(imagemHeroi);
        JLabel nomeHeroiLabel = new JLabel(nomeHeroi, SwingConstants.LEFT);
        nomeHeroiLabel.setFont(new Font("Arial", Font.BOLD, 12));
        painelSuperior.add(nomeHeroiLabel);

        painelHeroi.add(painelSuperior, BorderLayout.NORTH);

        // Painel para os quadrados personalizados
        JPanel painelInferior = new JPanel(new GridLayout(2, 5)); // 2 linhas, 5 colunas
        for (int i = 1; i <= 5; i++) {
            String nomeQuadrado = prefixoQuadrados + i;
            JPanel painelQuadrado = new JPanel(new BorderLayout());
            JButton quadrado = new JButton();
            quadrado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            quadrado.setPreferredSize(new Dimension(30, 30)); // Definindo o tamanho quadrado
            quadrado.setActionCommand(nomeQuadrado); // Define o nome do comando de ação
            quadrado.addActionListener(new QuadradoActionListener());
            quadrados.put(nomeQuadrado, quadrado); // Armazena o botão no mapa para acesso posterior
            JLabel textoQuadrado = new JLabel(nomeQuadrado, SwingConstants.CENTER);
            textoQuadrado.setFont(new Font("Arial", Font.PLAIN, 10));
            painelQuadrado.add(quadrado, BorderLayout.CENTER);
            painelQuadrado.add(textoQuadrado, BorderLayout.SOUTH);
            painelInferior.add(painelQuadrado);
        }

        painelHeroi.add(painelInferior, BorderLayout.CENTER);

        return painelHeroi;
    }

    private class QuadradoActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nomeQuadrado = e.getActionCommand();
            // Aqui você pode definir a ação que deseja executar quando o quadrado for clicado
            System.out.println("Ação: " + nomeQuadrado);
        }
    }

    public void setAcaoQuadrado(String nomeQuadrado, ActionListener acao) {
        JButton quadrado = quadrados.get(nomeQuadrado);
        if (quadrado != null) {
            for (ActionListener al : quadrado.getActionListeners()) {
                quadrado.removeActionListener(al);
            }
            quadrado.addActionListener(acao);
        } else {
            System.out.println("Quadrado " + nomeQuadrado + " não encontrado.");
        }
    }

    public void setImagemQuadrado(String nomeQuadrado, String linkImagem) {
        JButton quadrado = quadrados.get(nomeQuadrado);
        if (quadrado != null) {
            quadrado.setIcon(new ImageIcon(new ImageIcon(linkImagem).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        } else {
            System.out.println("Quadrado " + nomeQuadrado + " não encontrado.");
        }
    }

    public void setTextoQuadrado(String nomeQuadrado, String texto) {
        JButton quadrado = quadrados.get(nomeQuadrado);
        if (quadrado != null) {
            quadrado.setText(texto);
        } else {
            System.out.println("Quadrado " + nomeQuadrado + " não encontrado.");
        }
    }

    private void inicializarAcoesETextos() {
        setTextoQuadrado("quadradoMago1", "Feitiço");
        setTextoQuadrado("quadradoMago2", "Cura");
        setTextoQuadrado("quadradoMago3", "Escudo");
        setTextoQuadrado("quadradoMago4", "Fogo");
        setTextoQuadrado("quadradoMago5", "Gelo");

        setTextoQuadrado("quadradoGuerreiro1", "Ataque 1");
        setTextoQuadrado("quadradoGuerreiro2", "Ataque 2");
        setTextoQuadrado("quadradoGuerreiro3", "Defesa");
        setTextoQuadrado("quadradoGuerreiro4", "Especial 1");
        setTextoQuadrado("quadradoGuerreiro5", "Especial 2");

        setTextoQuadrado("quadradoAnao1", "Martelo");
        setTextoQuadrado("quadradoAnao2", "Escavação");
        setTextoQuadrado("quadradoAnao3", "Construir");
        setTextoQuadrado("quadradoAnao4", "Explodir");
        setTextoQuadrado("quadradoAnao5", "Defender");
    }
}
