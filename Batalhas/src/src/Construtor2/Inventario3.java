package Construtor2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import Mob.Personagem;

public class Inventario3 extends JPanel {
    private JDialog dialog;
    private JPanel painelItens;
    private Map<String, Runnable> itemActions;
    private int itensEquipados;

    public Inventario3() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Inventário"));

        painelItens = new JPanel();
        painelItens.setLayout(new BoxLayout(painelItens, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(painelItens);
        add(scrollPane, BorderLayout.CENTER);

        JLabel inventario3Geral = new JLabel("Escolha somente 2 por partida");
        JPanel painelInventarioGeral3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelInventarioGeral3.add(inventario3Geral);
        add(painelInventarioGeral3, BorderLayout.NORTH);

        // Adiciona itens ao inventário
        String[] itens = {
            "Cajado de Madeira: Concede a maga +3 de ataque",
            "Escudo de Aegis: +20 de vida para a maga",
            "Cajado de Aço: Concede a maga +5 de ataque",
           
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
        itemActions.put("Cajado de Madeira", () -> personagem.setAtaque(personagem.getAtaque() + 3));
        itemActions.put("Escudo de Aegis", () -> personagem.setHp(personagem.getHp() + 20));
        itemActions.put("Cajado de Aço", () -> personagem.setAtaque(personagem.getAtaque() + 5));
        
    }

    private class EquipButtonListener implements ActionListener {
        private String itemName;

        public EquipButtonListener(String itemName) {
            this.itemName = itemName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (itensEquipados < 2) {
                if (itemActions.containsKey(itemName)) {
                    itemActions.get(itemName).run();
                    itensEquipados++;
                    ((JButton) e.getSource()).setEnabled(false); // Desativa o botão após equipar
                }
            } else {
                JOptionPane.showMessageDialog(null, "Você já equipou o máximo de 2 itens.");
            }
        }
    }

    public void abrirInventario3(Personagem personagem) {
        initializeItemActions(personagem);

        dialog = new JDialog();
        dialog.setTitle("Inventário");
        dialog.setSize(900, 600);
        dialog.setLocationRelativeTo(null);
        dialog.add(this);
        dialog.setVisible(true);
    }
}
