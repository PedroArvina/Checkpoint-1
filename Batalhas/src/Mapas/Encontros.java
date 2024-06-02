package Mapas;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Encontros {

    private static JFrame frame;
    private static JLabel questionLabel;
    private static JButton yesButton, noButton, startButton;
    private static List<Question> questions;
    private static int currentQuestionIndex = 0;
    private static int score = 0;

    public static void encontroComVelho() {
        prepareIntroGUI();
    }

    private static void prepareIntroGUI() {
        frame = new JFrame("Desafio do Mago - Java");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // História e introdução
        JLabel storyLabel = new JLabel("<html><div style='text-align: center;'>Olá! Tudo bem? Meu nome é Joaquim, eu encontro alguem para passar uma grande arma, mas primeiro, ele deve se mostrar digno, voce deseja enfrentar meu teste?</div></html>", JLabel.CENTER);
        frame.add(storyLabel, BorderLayout.CENTER);

        startButton = new JButton("Aceitar Desafio");
        startButton.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeQuestions();
                prepareChallengeGUI();
            }
        });

        JPanel introPanel = new JPanel();
        introPanel.add(startButton);
        frame.add(introPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void prepareChallengeGUI() {
        frame.getContentPane().removeAll();
        frame.setLayout(new BorderLayout());

        questionLabel = new JLabel("", JLabel.CENTER);
        frame.add(questionLabel, BorderLayout.CENTER);

        yesButton = new JButton("Sim");
        noButton = new JButton("Não");

        yesButton.addActionListener(e -> answerAction(true));
        noButton.addActionListener(e -> answerAction(false));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        updateQuestion(currentQuestionIndex);
    }

    private static void updateQuestion(int questionIndex) {
        if (questionIndex < questions.size()) {
            Question currentQuestion = questions.get(questionIndex);
            questionLabel.setText("<html><div style='text-align: center;'>" + currentQuestion.text + "</div></html>");
        } else {
            finishChallenge();
        }
    }

    private static void answerAction(boolean answer) {
        Question currentQuestion = questions.get(currentQuestionIndex);
        if (answer == currentQuestion.answer) {
            score++;
        }

        currentQuestionIndex++;
        updateQuestion(currentQuestionIndex);
    }

    private static void finishChallenge() {
        frame.getContentPane().removeAll();

        String resultMessage = score >= 8 ? "<html><div style='text-align: center;'>Você se motrou hábil, o maior tesouro que posso te dar é este conhecimento, se quiser fazer o teste novamente estarei por aqui :D</div></html>"
                                         : "<html><div style='text-align: center;'>Você se mostou uma vergonha para a sua espécie, pelo seu nível, deveria cursar teatro na estácio, é mais adequado ao seu nível intelectual, você pode tentar novamente se quiser</div></html>";

        JLabel resultLabel = new JLabel(resultMessage, JLabel.CENTER);
        frame.add(resultLabel, BorderLayout.CENTER);

        JButton exitButton = new JButton("Sair");
        exitButton.addActionListener(e -> frame.dispose());
        JPanel exitPanel = new JPanel();
        exitPanel.add(exitButton);
        frame.add(exitPanel, BorderLayout.SOUTH);

        frame.revalidate();
        frame.repaint();
    }

    private static void initializeQuestions() {
        questions = new ArrayList<>();
        questions.add(new Question("Java é uma linguagem de programação baseada em objetos?", true));
        questions.add(new Question("O método finalize() é garantido para ser chamado no Java?", false));
        questions.add(new Question("Java suporta herança múltipla de classes?", false));
        questions.add(new Question("É possível sobrecarregar o operador '+' em Java?", false));
        questions.add(new Question("O garbage collector em Java pode ser forçado a executar?", false));
        questions.add(new Question("O operador 'instanceof' pode ser usado para testar se um objeto é de uma classe específica em tempo de execução?", true));
        questions.add(new Question("A JVM (Java Virtual Machine) executa código-fonte Java diretamente?", false));
        questions.add(new Question("Uma classe em Java pode implementar múltiplas interfaces?", true));
        questions.add(new Question("O Java utiliza exclusivamente passagem de parâmetros por referência?", false));
        questions.add(new Question("A palavra-chave 'synchronized' é usada para prevenir condições de corrida?", true));
    }

    static class Question {
        String text;
        boolean answer;

        Question(String text, boolean answer) {
            this.text = text;
            this.answer = answer;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Encontros::encontroComVelho);
    }







    public static void encontroComAldeoes() {
        System.out.println("Os aldeões estão assustados com uma recente invasão de monstros.");
    }

    public static void encontroComGuardas() {
        System.out.println("O Rei oferece uma recompensa por cada monstro derrotado.");
    }

    public static void encontroComDama() {
        System.out.println("Na taverna, você escuta rumores sobre um dragão nas montanhas.");
    }

    public static void encontroComRei() {
        System.out.println("Um mercador oferece equipamentos raros em troca de gemas mágicas.");
    }

    public static void batalhaContraLadrao() {
        System.out.println("Você é emboscado por um ladrão. Prepare-se para a batalha!");
    }
    
}
