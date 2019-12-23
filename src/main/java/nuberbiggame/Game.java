package nuberbiggame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Game extends JudgeNumber {

    private static Game instance = null;
    private JLabel statusLabel;

    private Game() {

    }

    static Game getInstance() {
        if (instance == null) {
            synchronized (Game.class) {
                if (instance == null) {
                    instance = new Game();
                }
            }
        }
        return instance;
    }

    void prepareGUI() {

        if (instance == null) {
            return;
        }

        JFrame mainFrame = new JFrame();
        mainFrame.setSize(400, 200);
        //設定JFrame Title
        mainFrame.setTitle("Simple Judge Number Game");
        //顯示JFrame螢幕中間
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setUndecorated(false);

        JPanel backGroundPanel = new JPanel();
        backGroundPanel.setOpaque(true);
        backGroundPanel.setBackground(Color.PINK);
        backGroundPanel.setLayout(null);
        mainFrame.add(backGroundPanel);

        JLabel jLabel = new JLabel();
        jLabel.setText("Please Enter One Number");
        jLabel.setBounds(10, 5, 300, 60);
        jLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
        backGroundPanel.add(jLabel);

        final JTextField jTextField = new JTextField(1);
        jTextField.setBounds(310, 20, 30, 30);
        jTextField.setFont(new Font("Monospaced", Font.PLAIN, 20));
        jTextField.setDocument(new TextDocument(1));
        jTextField.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                return false;
            }
        });

        JButton jButton = new JButton();
        jButton.setText("Start");
        jButton.setBounds(10, 50, 380, 50);
        jButton.setFont(new Font("Monospaced", Font.PLAIN, 20));
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jTextField.getText().trim().equals(""))
                    start(Integer.valueOf(jTextField.getText()));
            }
        });

        statusLabel = new JLabel();
        statusLabel.setText("");
        statusLabel.setBounds(10, 100, 390, 50);
        statusLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));

        backGroundPanel.add(jTextField);
        backGroundPanel.add(jButton);
        backGroundPanel.add(statusLabel);

        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        mainFrame.setVisible(true);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public void start(int entryNumber) {

        if (instance == null) {
            System.out.println("No Game Class");
        } else {
            judgeNumber(entryNumber);
        }
    }

    @Override
    public void biggerNumber() {
        statusLabel.setText("You number is bigger than me.");
    }

    @Override
    public void smallerNumber() {
        statusLabel.setText("You number is smaller than me.");
    }

    @Override
    public void equalsNumber() {
        statusLabel.setText("You number is equal than me.");
    }
}
