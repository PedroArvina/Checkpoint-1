package Construtor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import Mob.Personagem;

public class Inventario extends JPanel {
    private JDialog dialog;
    private JPanel painelItens;
    private Map<String, Runnable> itemActions;
    private int itensEquipados;

    public Inventario() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Inventário"));

        painelItens = new JPanel();
        painelItens.setLayout(new BoxLayout(painelItens, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(painelItens);
        add(scrollPane, BorderLayout.CENTER);

        JLabel inventarioGeral = new JLabel("Itens Gerais: 0");
        JPanel painelInventarioGeral = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelInventarioGeral.add(inventarioGeral);
        add(painelInventarioGeral, BorderLayout.NORTH);

        // Adiciona itens ao inventário
        String[] itens = {
            "Espada Longa do Destino: Uma espada forjada nas chamas de um dragão adormecido.",
            "Escudo de Aegis: Escudo lendário que pode absorver qualquer ataque, aumentando a defesa do usuário.",
            "Capa das Sombras: Uma capa que confere invisibilidade temporária quando usada.",
            "Botas de Velocidade: Calçados mágicos que dobram a velocidade de movimento do usuário.",
            "Anel dos Cinco Magos: Um anel que aumenta significativamente o poder mágico.",
            "Armadura de Mithril: Leve e resistente, ideal para proteção sem sacrificar a agilidade.",
            "Poção de Cura: Recupera completamente a saúde do usuário quando consumida.",
            "Báculo Ancião: Báculo encantado que aumenta o alcance e o impacto de feitiços.",
            "Capacete do Vidente: Permite que o usuário veja brevemente o futuro, antecipando movimentos inimigos.",
            "Cinto do Gigante: Concede ao usuário força sobre-humana por curtos períodos.",
            "Luvas do Ladrão: Melhora a destreza e habilidades de furto.",
            "Amuleto da Vida: Previna a morte por uma vez, ressuscitando o usuário imediatamente.",
            "Manto da Noite Eterna: Um manto que oculta o usuário nas sombras.",
            "Lâmina Fantasma: Uma espada etérea que atravessa armaduras.",
            "Olho de Horus: Um amuleto que revela armadilhas ocultas."
        };

        for (String item : itens) {
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel itemLabel = new JLabel(item);
            JButton equipButton = new JButton("Equipar");
            equipButton.addActionListener(new EquipButtonListener(item.split(":")[0]));

            itemPanel.add(itemLabel);
            itemPanel.add(equipButton);
            painelItens.add(itemPanel);
        }
    }

    private void initializeItemActions(Personagem personagem) {
        itemActions = new HashMap<>();
        // Define as ações para cada item aqui
        itemActions.put("Espada Longa do Destino", () -> {
            personagem.setAtaque(personagem.getAtaque() + 8);
            System.out.println("Espada equipada, ataque aumentado. Novo ataque: " + personagem.getAtaque());
        });
        itemActions.put("Escudo de Aegis", () -> {
            personagem.setHp(personagem.getHp() + 20);
            System.out.println("Escudo equipado, HP aumentado. Novo HP: " + personagem.getHp());
        });
        itemActions.put("Capa das Sombras", () -> {
            // Lógica para capa das sombras
            System.out.println("Capa equipada, invisibilidade concedida.");
        });
        itemActions.put("Botas de Velocidade", () -> {
            personagem.setAlcanceMovimento(personagem.getAlcanceMovimento() + 20);
            System.out.println("Botas equipadas, alcance de movimento aumentado. Novo alcance: " + personagem.getAlcanceMovimento());
        });
        itemActions.put("Anel dos Cinco Magos", () -> {
            personagem.setRange(personagem.getRange() + 20);
            System.out.println("Anel equipado, alcance aumentado. Novo alcance: " + personagem.getRange());
        });
        itemActions.put("Armadura de Mithril", () -> {
            personagem.setHp(personagem.getHp() + 15);
            System.out.println("Armadura equipada, HP aumentado. Novo HP: " + personagem.getHp());
        });
        itemActions.put("Poção de Cura", () -> {
            personagem.setHp(personagem.getHp() + 30);
            personagem.setRange(personagem.getRange() + 20);
            System.out.println("Poção usada, HP restaurado. Novo HP: " + personagem.getHp());
        });
        itemActions.put("Báculo Ancião", () -> {
            personagem.setRange(personagem.getRange() + 8);
            System.out.println("Báculo equipado, alcance aumentado. Novo alcance: " + personagem.getRange());
        });
        itemActions.put("Capacete do Vidente", () -> {
            // Lógica para capacete do vidente
            System.out.println("Capacete equipado, futuro vislumbrado.");
        });
        itemActions.put("Cinto do Gigante", () -> {
            personagem.setAtaque(personagem.getAtaque() + 5);
            System.out.println("Cinto equipado, ataque aumentado. Novo ataque: " + personagem.getAtaque());
        });
        itemActions.put("Luvas do Ladrão", () -> {
            // Lógica para luvas do ladrão
            System.out.println("Luvas equipadas, habilidades de furto melhoradas.");
        });
        itemActions.put("Amuleto da Vida", () -> {
            personagem.setHp(personagem.getHp() + 50);
            System.out.println("Amuleto usado, HP aumentado. Novo HP: " + personagem.getHp());
        });
        itemActions.put("Manto da Noite Eterna", () -> {
            // Lógica para manto da noite eterna
            System.out.println("Manto equipado, ocultação concedida.");
        });
        itemActions.put("Lâmina Fantasma", () -> {
            personagem.setAtaque(personagem.getAtaque() + 10);
            System.out.println("Lâmina equipada, ataque aumentado. Novo ataque: " + personagem.getAtaque());
        });
        itemActions.put("Olho de Horus", () -> {
            // Lógica para olho de Horus
            System.out.println("Olho equipado, armadilhas reveladas.");
        });
    }

    private class EquipButtonListener implements ActionListener {
        private String itemName;

        public EquipButtonListener(String itemName) {
            this.itemName = itemName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (itensEquipados < 5) {
                if (itemActions.containsKey(itemName)) {
                    itemActions.get(itemName).run();
                    itensEquipados++;
                    ((JButton) e.getSource()).setEnabled(false); // Desativa o botão após equipar
                }
            } else {
                JOptionPane.showMessageDialog(null, "Você já equipou o máximo de 5 itens.");
            }
        }
    }

    public void abrirInventario(Personagem personagem) {
        initializeItemActions(personagem);

        dialog = new JDialog();
        dialog.setTitle("Inventário");
        dialog.setSize(400, 600);
        dialog.setLocationRelativeTo(null);
        dialog.add(this);
        dialog.setVisible(true);
    }
}
