package quizApplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];

    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    Quiz(String name) {
        this.name = name;

        setBounds(100, 20, 1200, 700);
        getContentPane().setBackground(new Color(240, 245, 255));
        setLayout(null);

        // HEADER
        JLabel title = new JLabel("Techno Quiz");
        title.setBounds(50, 20, 300, 40);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(30, 144, 255));
        add(title);

        // QUESTION NUMBER
        qno = new JLabel();
        qno.setBounds(100, 100, 50, 30);
        qno.setFont(new Font("Segoe UI", Font.BOLD, 20));
        add(qno);

        // QUESTION BOX
        question = new JLabel();
        question.setBounds(150, 100, 900, 60);
        question.setFont(new Font("Segoe UI", Font.BOLD, 20));
        question.setOpaque(true);
        question.setBackground(Color.WHITE);
        question.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(question);

        // OPTIONS
        opt1 = createOption(150, 200);
        opt2 = createOption(150, 250);
        opt3 = createOption(150, 300);
        opt4 = createOption(150, 350);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        // BUTTONS
        next = createButton("Next", 850, 500, new Color(173, 216, 255));   // light blue
        lifeline = createButton("50-50 Lifeline", 650, 500, new Color(255, 182, 193)); // light pink
        submit = createButton("Submit", 1050, 500, new Color(255, 255, 153)); // light yellow
        submit.setEnabled(false);

        add(next);
        add(lifeline);
        add(submit);

        // QUESTIONS
        questions[0][0] = "Which is used to find and fix bugs in the Java programs?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of hashCode() method?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "Interface with no methods is called?";
        questions[3][1] = "Runnable";
        questions[3][2] = "Abstract";
        questions[3][3] = "Marker";
        questions[3][4] = "CharSequence";

        questions[4][0] = "Where is String stored?";
        questions[4][1] = "Stack";
        questions[4][2] = "Heap";
        questions[4][3] = "Pool";
        questions[4][4] = "ROM";

        questions[5][0] = "Which is marker interface?";
        questions[5][1] = "Runnable";
        questions[5][2] = "Remote";
        questions[5][3] = "Readable";
        questions[5][4] = "Result";

        questions[6][0] = "Keyword to access package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "JAR stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Resource";
        questions[7][4] = "Java Runner";

        questions[8][0] = "Mutable class?";
        questions[8][1] = "StringBuilder";
        questions[8][2] = "String";
        questions[8][3] = "Byte";
        questions[8][4] = "Short";

        questions[9][0] = "Java portability reason?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "Applet";
        questions[9][3] = "Exception";
        questions[9][4] = "Binding";

        // ANSWERS
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker";
        answers[4][1] = "Heap";
        answers[5][1] = "Remote";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        start(count);
        setVisible(true);
    }

    private JRadioButton createOption(int x, int y) {
        JRadioButton opt = new JRadioButton();
        opt.setBounds(x, y, 800, 40);
        opt.setBackground(Color.WHITE);
        opt.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        opt.setFocusPainted(false);
        add(opt);
        return opt;
    }

    private JButton createButton(String text, int x, int y, Color color) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 180, 40);
        btn.setBackground(color);
        btn.setForeground(Color.BLACK); // important
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(new Color(200,200,200)));
        btn.addActionListener(this);
        return btn;
    
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;

            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        }

        else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        }

        else if (ae.getSource() == submit) {
            ans_given = 1;

            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                }
            }

            setVisible(false);              // hide quiz screen
            new Score(name, score);         // open score screen
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setFont(new Font("Segoe UI", Font.BOLD, 20));

        if (timer <= 5) {
            g.setColor(Color.RED);
        } else {
            g.setColor(new Color(30,144,255));
        }

        g.drawString("⏰ " + timer + "s", 950, 100);

        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {}

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            if (count == 9) {
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    }
                }

                JOptionPane.showMessageDialog(this, name + ", your score is " + score);
                System.exit(0);
            } else {
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                count++;
                start(count);
            }
        }
    }

    public void start(int count) {
        qno.setText((count + 1) + ". ");
        question.setText(questions[count][0]);

        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}