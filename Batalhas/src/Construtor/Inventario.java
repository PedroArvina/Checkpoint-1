package Construtor;

import javax.swing.*;
import java.awt.*;

public class Inventario extends JPanel {
    private JLabel inventarioGeral;
    private JPanel painelHerois;
    private JLabel armaduraMago;
    private JLabel armaduraGuerreiro;
    private JLabel armaduraAnao;
    private JPanel bustoMago, bustoGuerreiro, bustoAnao;
    private JDialog dialog;

    // Construtor que aceita um Frame como argumento
    public Inventario(Frame owner) {
        dialog = new JDialog(owner, "Inventário", false);
        dialog.setContentPane(this);
        dialog.setSize(400, 300); // Defina o tamanho conforme necessário
        dialog.setLocationRelativeTo(owner);
    }

    // Construtor padrão sem argumentos
    public Inventario() {
        dialog = new JDialog();
        dialog.setContentPane(this);
        dialog.setSize(400, 300); // Defina o tamanho conforme necessário
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Garante que a janela pode ser fechada
        dialog.setLocationRelativeTo(null);
    }

    public void abrirInventario() {
        // Define o layout principal do painel do inventário
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder("Inventário"));

        // Cria e configura o inventário geral no topo
        inventarioGeral = new JLabel("Itens Gerais: 0");
        JPanel painelInventarioGeral = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelInventarioGeral.add(inventarioGeral);
        this.add(painelInventarioGeral, BorderLayout.NORTH);

        // Cria o painel para os bustos dos heróis com armas e armaduras
        painelHerois = new JPanel(new GridLayout(1, 3));
        bustoMago = new JPanel(new BorderLayout());
        bustoGuerreiro = new JPanel(new BorderLayout());
        bustoAnao = new JPanel(new BorderLayout());

        // Substitua "path/to/mago_busto.png" pelo caminho correto das imagens
        armaduraMago = new JLabel(new ImageIcon("path/to/mago_busto.png"));
        armaduraGuerreiro = new JLabel(new ImageIcon("path/to/guerreiro_busto.png"));
        armaduraAnao = new JLabel(new ImageIcon("path/to/anao_busto.png"));

        bustoMago.add(armaduraMago, BorderLayout.CENTER);
        bustoGuerreiro.add(armaduraGuerreiro, BorderLayout.CENTER);
        bustoAnao.add(armaduraAnao, BorderLayout.CENTER);

        painelHerois.add(bustoMago);
        painelHerois.add(bustoGuerreiro);
        painelHerois.add(bustoAnao);

        // Adiciona o painel dos heróis na parte inferior
        this.add(painelHerois, BorderLayout.SOUTH);

        // Exibe o JDialog
        dialog.setVisible(true);
    }

    public void atualizarInventarioGeral(int novosItens) {
        inventarioGeral.setText("Itens Gerais: " + novosItens);
    }

    public void atualizarArmaduraMago(int novaArmadura) {
        // Atualiza a descrição ou imagem da armadura do Mago
    }

    public void atualizarArmaduraGuerreiro(int novaArmadura) {
        // Atualiza a descrição ou imagem da armadura do Guerreiro
    }

    public void atualizarArmaduraAnao(int novaArmadura) {
        // Atualiza a descrição ou imagem da armadura do Anão
    }
}
