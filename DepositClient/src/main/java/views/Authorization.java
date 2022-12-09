package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

import depositclient.model.SocketStream;

public class Authorization extends JFrame {

    public Authorization() {
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new ImagePanel();
        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jPanel2 = new JPanel();
        loginField = new JTextField();
        jPanel3 = new JPanel();
        jPasswordField = new JPasswordField();
        authorizationButton = new JButton();
        isEmployee = new JCheckBox();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Raleway", Font.BOLD, 24));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("ВХОД");

        loginField.setFont(new Font("Raleway", Font.PLAIN, 18));
        loginField.setPreferredSize(new Dimension(450, 35));

        JLabel title1 = new JLabel("Логин:");
        title1.setFont(new Font("Raleway", Font.PLAIN, 18));
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(title1)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(30, 30)
                                .addComponent(loginField)
                        )
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(title1)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(30, 30)
                                .addComponent(loginField)
                        )
        );

        jPasswordField.setPreferredSize(new Dimension(450, 35));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        JLabel title2 = new JLabel("Пароль: ");
        title2.setFont(new Font("Raleway", Font.PLAIN, 18));
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(title2)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(30, 30)
                                .addComponent(jPasswordField)
                        )
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(title2)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(30, 30)
                                .addComponent(jPasswordField)
                        )
        );

        authorizationButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        authorizationButton.setText("Войти");
        authorizationButton.setBackground(new Color(240, 248, 255));
        authorizationButton.setPreferredSize(new Dimension(50, 50));
        authorizationButton.setBorderPainted(false);
        authorizationButton.addActionListener(this::authorizationButtonActionPerformed);

        isEmployee.setFont(new Font("Raleway", Font.PLAIN, 18));
        isEmployee.setText("Сотрудник банка");


        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(authorizationButton, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
                                .addGap(129, 129, 129))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(isEmployee)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(isEmployee)
                                .addGap(18, 18, 18)
                                .addComponent(authorizationButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void authorizationButtonActionPerformed(ActionEvent evt) {
            String selection = "no";
            if (isEmployee.isSelected()) {
                selection = "yes";
            }
            SocketStream server = new SocketStream();
            server.sendInt(1);
            server.sendString(selection);
            server.sendString(loginField.getText());
            server.sendString(String.valueOf(jPasswordField.getPassword()));
        try {
            String a = server.getString();
            if(a.equals("Admin")){
                this.setVisible(false);
                MainAdminFrame admin = new MainAdminFrame(loginField.getText());
                admin.setVisible(true);
                admin.setLocationRelativeTo(null);
            }
            if(a.equals("Client")){
                this.setVisible(false);
                MainUserFrame userFrame = new MainUserFrame(loginField.getText());
                userFrame.setVisible(true);
                userFrame.setLocationRelativeTo(null);
            }
            if(a.equals("Employee")){
                this.setVisible(false);
                MainEmployeeFrame employeeFrame = new MainEmployeeFrame(loginField.getText());
                employeeFrame.setVisible(true);
                employeeFrame.setLocationRelativeTo(null);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new Authorization().setVisible(true));
    }

    private JButton authorizationButton;
    private JCheckBox isEmployee;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPasswordField jPasswordField;
    private JSeparator jSeparator1;
    private JTextField loginField;

    public class ImagePanel extends JPanel {

        private BufferedImage image;

        public ImagePanel() {
            try {
                image = ImageIO.read(new File("src/main/resources/1613673876_31-p-fon-dlya-prezentatsii-bank-33.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image,  0, 0, 700, 600, null);
        }

    }
}
