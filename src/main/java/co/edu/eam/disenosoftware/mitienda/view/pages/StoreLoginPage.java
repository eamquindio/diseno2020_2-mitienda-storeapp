package co.edu.eam.disenosoftware.mitienda.view.pages;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.util.LocalStorage;
import co.edu.eam.disenosoftware.mitienda.view.controllers.StoreLoginController;
import co.edu.eam.disenosoftware.mitienda.view.lib.Navigator;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class StoreLoginPage extends Page {

  private StoreLoginController storeLoginController;

  public StoreLoginPage() {
    storeLoginController = new StoreLoginController();
  }

  @Override
  public void init() throws Exception {
    storeLoginController = new StoreLoginController();
  }

  @Override
  public JComponent buildContent() throws Exception {

    JPanel pBody = new JPanel();
    pBody.setBackground(Color.white);

    JLabel lblEmail = new JLabel("Email:");
    lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15)); // NOI18N
    lblEmail.setText("Email:");

    JTextField txtEmail = new JTextField();
    txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
    txtEmail.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204)));

    JLabel lblPassword = new JLabel();
    lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15)); // NOI18N
    lblPassword.setText("Password:");

    JPasswordField txtPassword = new JPasswordField();
    txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
    txtPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204)));

    JLabel lblMessage = new JLabel();
    lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
    lblMessage.setText("No tienes una cuenta?");

    JLabel lblSignUp = new JLabel("Registrarse");
    lblSignUp.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
    lblSignUp.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        lblSignUp.setText("<html><u>Registrarse</u></html>");
      }

      @Override
      public void mouseExited(MouseEvent e) {
        lblSignUp.setText("Registrarse");
      }

      @Override
      public void mouseClicked(MouseEvent e) {
        Navigator.goToFrame("StoreSignUpPage");
      }
    });

    JButton btnLogin = new JButton();
    btnLogin.setBackground(Constants.COLOR_GREEN);
    btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15)); // NOI18N
    btnLogin.setForeground(new Color(255, 255, 255));
    btnLogin.setText("Iniciar sesion");
    btnLogin.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          Store store = storeLoginController.loginStore(txtEmail.getText(), txtPassword.getText());

          Map<String, Object> params = new HashMap<>();
          params.put("storeId", store.getId());

          LocalStorage.saveData("storeId", store.getId());
          Navigator.goToFrame("Home", params);
        } catch (Exception ex) {
          ex.printStackTrace();
        }

      }
    });

    GroupLayout pBodyLayout = new GroupLayout(pBody);
    pBody.setLayout(pBodyLayout);
    pBodyLayout.setHorizontalGroup(
            pBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, pBodyLayout.createSequentialGroup()
                            .addGap(0, 53, Short.MAX_VALUE)
                            .addGroup(pBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmail)
                                    .addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pBodyLayout.createSequentialGroup()
                                            .addComponent(lblMessage, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblSignUp, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                                    .addComponent(txtPassword))
                            .addGap(0, 58, Short.MAX_VALUE))
    );
    pBodyLayout.setVerticalGroup(
            pBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pBodyLayout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addGap(72, 72, 72)
                            .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addGroup(pBodyLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMessage)
                                    .addComponent(lblSignUp))
                            .addContainerGap(148, Short.MAX_VALUE))
    );
    return pBody;
  }

  @Override
  public JComponent buildHeader() throws Exception {
    JPanel pHeader = new JPanel();
    JPanel pBodyHeader = new JPanel();
    JLabel lblTitleHeader = new JLabel();

    pHeader.setBackground(Constants.COLOR_GREEN);
    pHeader.setPreferredSize(new Dimension(pHeader.getPreferredSize().width, 50));
    pHeader.setMaximumSize(new Dimension(468, 50));

    pBodyHeader.setForeground(Color.white);
    pBodyHeader.setOpaque(false);
    pBodyHeader.setLayout(new BorderLayout(50, 10));

    lblTitleHeader.setFont(new Font("Tahoma", Font.BOLD, 15)); // NOI18N
    lblTitleHeader.setForeground(Color.white);
    lblTitleHeader.setText("Inicio de sesion");
    pBodyHeader.add(lblTitleHeader, BorderLayout.LINE_START);

    GroupLayout pHeaderLayout = new GroupLayout(pHeader);
    pHeader.setLayout(pHeaderLayout);
    pHeaderLayout.setHorizontalGroup(
            pHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, pHeaderLayout.createSequentialGroup()
                            .addContainerGap(28, Short.MAX_VALUE)
                            .addComponent(pBodyHeader, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
    );
    pHeaderLayout.setVerticalGroup(
            pHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pHeaderLayout.createSequentialGroup()
                            .addGap(0, 0, 0)
                            .addComponent(pBodyHeader, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
    );

    return pHeader;
  }

  @Override
  public JComponent buildFooter() throws Exception {
    return null;
  }

  @Override
  public void refresh() throws Exception {
    super.refresh();
  }
}
