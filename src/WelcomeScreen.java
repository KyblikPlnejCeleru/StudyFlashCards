import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WelcomeScreen {

    private JFrame frame;
    private DefaultListModel model;
    private JList<String> list;
    private JTextField input;


    public WelcomeScreen(){
        this.frame = new JFrame("FlashCards romek sro");
        this.model = new DefaultListModel<>();
        this.list = new JList<>(model);
        this.input = new JTextField();
    }

    public void showApp(){
        this.frame.setSize(500,500);
        this.frame.setLayout(new BorderLayout());
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.frame.add(new JScrollPane(list), BorderLayout.CENTER);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(input, BorderLayout.CENTER);

        JButton button = new JButton("Pridat");
        panel.add(button, BorderLayout.EAST);

        this.frame.add(panel, BorderLayout.SOUTH);

        button.addActionListener(e -> {
            String text = input.getText();

            if(!text.isEmpty()){
                model.addElement(text);
                input.setText("");
            }

        });

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2){
                    int index = list.locationToIndex(e.getPoint());
                    if(index != -1){
                        model.remove(index);
                    }
                }
            }
        });

        input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    String text = input.getText();

                    if(!text.isEmpty()){
                        model.addElement(text);
                        input.setText("");
                    }
                }
            }
        });



        this.frame.setVisible(true);
    }

}




