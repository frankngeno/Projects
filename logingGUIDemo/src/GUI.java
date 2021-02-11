import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//https://beginnersbook.com/2015/07/java-swing-tutorial/

public class GUI  implements ActionListener {
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton userButton;
    private static JLabel success;

    public static void main(String[] args){

        JPanel userPanel = new JPanel();
        JFrame userFrame = new JFrame();
        userFrame.setSize(350, 200);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setVisible(true);
        userFrame.add(userPanel);

        userPanel.setLayout(null);

        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        userPanel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        userPanel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        userPanel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        userPanel.add(passwordText);

        userButton = new JButton("Login");
        userButton.setBounds(10,80, 80,25);
        userButton.addActionListener(new GUI());
        userPanel.add(userButton);


        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        userPanel.add(success);


        userFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) { //to implement action listener code.
     //System.out.println("Button clicked");
        String user = userText.getText();
        String password = passwordText.getText();// lined through means its not supported.
        //System.out.println(user + ", " +  password);
        if (user.equals("fngeno") && password.equals("Greenbay123")){
            success.setText("Login Successful!");
        }

    }
}
