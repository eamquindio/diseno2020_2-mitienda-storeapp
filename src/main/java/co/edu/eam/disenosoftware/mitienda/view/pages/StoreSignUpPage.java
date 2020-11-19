package co.edu.eam.disenosoftware.mitienda.view.pages;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.view.controllers.StoreSignUpController;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreSignUpPage extends Page {

  private StoreSignUpController storeSignUpController;

  public StoreSignUpPage() {
    storeSignUpController = new StoreSignUpController();
  }

  @Override
  public void init() {
    storeSignUpController = new StoreSignUpController();
  }

  @Override
  public JComponent buildContent() {

    JPanel pBody = new JPanel();
    pBody.setBackground(Color.white);

    JLabel lblNameStore = new JLabel(getString("storesignuppage.name_title"));
    lblNameStore.setFont(new Font("Tahoma", Font.BOLD, 15));

    JTextField txtNameStore = new JTextField();
    txtNameStore.setFont(new Font("Tahoma", Font.PLAIN, 14));
    txtNameStore.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204)));

    JLabel lblOwner = new JLabel(getString("storesignuppage.owner_title"));
    lblOwner.setFont(new Font("Tahoma", Font.BOLD, 15));

    JTextField txtOwner = new JTextField();
    txtOwner.setFont(new Font("Tahoma", Font.PLAIN, 14));
    txtOwner.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204)));

    JLabel lblPhone = new JLabel(getString("storesignuppage.phone_title"));
    lblPhone.setFont(new Font("Tahoma", Font.BOLD, 15));

    JTextField txtPhone = new JTextField();
    txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
    txtPhone.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204)));

    JLabel lblPassword = new JLabel(getString("storesignuppage.password_title"));
    lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));

    JTextField txtPassword = new JPasswordField();
    txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
    txtPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204)));

    JLabel lblEmail = new JLabel(getString("storesignuppage.email_title"));
    lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));

    JTextField txtEmail = new JTextField();
    txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
    txtEmail.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204)));

    JLabel lblAddress = new JLabel(getString("storesignuppage.address_title"));
    lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));

    JTextField txtAddress = new JTextField();
    txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
    txtAddress.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204)));

    JButton btnCancel = new JButton("Cancelar");
    btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));

    btnCancel.setForeground(Color.white);
    btnCancel.setBackground(new Color(220, 53, 69));

    btnCancel.setBorderPainted(false);
    btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnCancel.setFocusPainted(false);

    btnCancel.setUI(new BasicButtonUI() {
      @Override
      public void paint(Graphics grphcs, JComponent jc) {
        Graphics2D grphcs2D = (Graphics2D) grphcs.create();
        grphcs2D.setBackground(new Color(220, 53, 69));
        grphcs2D.setColor(new Color(220, 53, 69));
        grphcs2D.dispose();
        super.paint(grphcs, jc);
      }
    });

    btnCancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        goBack();
      }
    });

    JButton btnSignUp = new JButton("Registrar");
    btnSignUp.setBackground(Constants.COLOR_GREEN);
    btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnSignUp.setForeground(Color.white);

    btnSignUp.setBorderPainted(false);
    btnSignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnSignUp.setFocusPainted(false);

    btnSignUp.setUI(new BasicButtonUI() {
      @Override
      public void paint(Graphics grphcs, JComponent jc) {
        Graphics2D grphcs2D = (Graphics2D) grphcs.create();
        grphcs2D.setBackground(Constants.COLOR_GREEN);
        grphcs2D.setColor(Constants.COLOR_GREEN);
        grphcs2D.dispose();
        super.paint(grphcs, jc);
      }
    });

    btnSignUp.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        storeSignUpController.createStore(new Store(txtNameStore.getText(), txtOwner.getText(), txtAddress.getText(), txtPhone.getText(), txtEmail.getText(), txtPassword.getText()));
        goBack();
      }
    });

    GroupLayout pBodyLayout = new GroupLayout(pBody);
    pBody.setLayout(pBodyLayout);
    pBodyLayout.setHorizontalGroup(
            pBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pBodyLayout.createSequentialGroup()
                            .addGroup(pBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(pBodyLayout.createSequentialGroup()
                                            .addGap(23, 23, 23)
                                            .addGroup(pBodyLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txtAddress, GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblAddress, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                                    .addComponent(txtEmail, GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblEmail, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                                    .addComponent(lblPhone, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                                    .addComponent(txtNameStore, GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblNameStore, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                                    .addComponent(txtPassword, GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblPassword, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblOwner, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                                    .addComponent(txtOwner, GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtPhone, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pBodyLayout.createSequentialGroup()
                                            .addGap(0, 22, 22)
                                            .addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 18, 18)
                                            .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(28, Short.MAX_VALUE))
    );
    pBodyLayout.setVerticalGroup(
            pBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pBodyLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblNameStore, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 18)
                            .addComponent(txtNameStore, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 18)
                            .addComponent(lblOwner, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 18)
                            .addComponent(txtOwner, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 18)
                            .addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 18)
                            .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 18)
                            .addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 18)
                            .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 18)
                            .addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 18)
                            .addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 18)
                            .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 18)
                            .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                            .addGroup(pBodyLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 37, 37))
    );
    return pBody;
  }

  @Override
  public JComponent buildHeader() {
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
    lblTitleHeader.setText("Registro de tienda");
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
  public JComponent buildFooter() {
    return null;
  }

  @Override
  public void refresh() {
    super.refresh();
  }
}