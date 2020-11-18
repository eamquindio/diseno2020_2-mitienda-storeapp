package co.edu.eam.disenosoftware.mitienda.view.widgets;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.util.ImageUtil;
import co.edu.eam.disenosoftware.mitienda.view.controllers.StoreOrderDetailController;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.lib.Widget;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;

public class StoreOrderDetailWidget extends Widget<OrderProduct> {

  private StoreOrderDetailController storeOrderDetailController;

  public StoreOrderDetailWidget(OrderProduct data, Page page) {
    super(data, page);
  }

  @Override
  public void build() {

    NumberFormat formatter = NumberFormat. getCurrencyInstance();

    this.setBackground(Color.white);
    this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204)));

    ImageIcon image = new ImageIcon();

    try {
      image = ImageUtil.loadFromURL(Constants.PRODUCT_IMAGE_URL +
                      data.getProductStore().getProduct().getId() + "_small.jpg",
              70, 80);
    } catch (Exception ex) {
      image = ImageUtil.loadFromURL(Constants.PRODUCT_IMAGE_NOT_FOUNDED_URL, 70, 80);
    }

    JLabel lblImage = new JLabel(image);

    String productName = data.getProductStore().getProduct().getName();

    productName = productName.length() >= 18 ?
            productName.substring(0, 1).toUpperCase() + productName.substring(1, 13).toLowerCase() + "..."
            : productName.substring(0, 1).toUpperCase() + productName.substring(1).toLowerCase();

    JLabel lblQuantityNameProduct = new JLabel(data.getQuantity() + " x " + productName);
    lblQuantityNameProduct.setFont(new Font("", Font.PLAIN, 12));

    String productPrice =formatter. format(data.getProductStore().getPrice());

    JLabel lblProductPrice = new JLabel(productPrice + " - 1 "
            + parentPage.getString("storeorderdetailwidget.unit_price"));

    JButton btnCheck = new JButton(parentPage.getString("storeorderdetailwidget.btn_check"));
    btnCheck.setFont(new Font("", Font.BOLD, 12));
    btnCheck.setForeground(Color.white);

    btnCheck.setBackground(Constants.COLOR_GREEN);

    btnCheck.setUI(new BasicButtonUI() {
      @Override
      public void paint(Graphics grphcs, JComponent jc) {
        Graphics2D grphcs2D = (Graphics2D) grphcs.create();
        grphcs2D.setColor(Constants.COLOR_GREEN);
        grphcs2D.setBackground(Constants.COLOR_GREEN);
        grphcs2D.dispose();
        super.paint(grphcs, jc);
      }
    });

    btnCheck.setBorderPainted(false);
    btnCheck.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnCheck.setFocusPainted(false);
    btnCheck.addMouseListener(new MouseAdapter() {
      public void mouseEntered(MouseEvent evt) {
        btnCheck.setBackground(Constants.COLOR_GREEN_HOVER);
      }

      public void mouseExited(MouseEvent evt) {
        btnCheck.setBackground(Constants.COLOR_GREEN);
      }
    });

    btnCheck.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        btnCheckActionPerformed(e, data.getId());
      }
    });

    JButton btnDelete = new JButton("Eliminar");
    btnDelete.setFont(new Font("", Font.BOLD, 12));
    btnDelete.setForeground(Color.white);
    btnDelete.setBackground(Constants.COLOR_RED);

    btnDelete.setUI(new BasicButtonUI() {
      @Override
      public void paint(Graphics grphcs, JComponent jc) {
        Graphics2D grphcs2D = (Graphics2D) grphcs.create();
        grphcs2D.setColor(Constants.COLOR_RED);
        grphcs2D.setBackground(Constants.COLOR_RED);
        grphcs2D.dispose();
        super.paint(grphcs, jc);
      }
    });

    btnDelete.setBorderPainted(false);
    btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnDelete.setFocusPainted(false);

    btnDelete.addMouseListener(new MouseAdapter() {
      public void mouseEntered(MouseEvent evt) {
        btnDelete.setBackground(Constants.COLOR_RED_HOVER);
      }

      public void mouseExited(MouseEvent evt) {
        btnDelete.setBackground(Constants.COLOR_RED);
      }
    });

    btnDelete.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        btnDeleteActionPerformed(e, data.getId());
      }
    });

    GroupLayout orderDetailWidgetLayout = new GroupLayout(this);
    this.setLayout(orderDetailWidgetLayout);
    orderDetailWidgetLayout.setHorizontalGroup(
            orderDetailWidgetLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(orderDetailWidgetLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(orderDetailWidgetLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(lblProductPrice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblQuantityNameProduct, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(orderDetailWidgetLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                    .addComponent(btnCheck, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                            .addContainerGap())
    );
    orderDetailWidgetLayout.setVerticalGroup(
            orderDetailWidgetLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(orderDetailWidgetLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(orderDetailWidgetLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(orderDetailWidgetLayout.createSequentialGroup()
                                            .addGap(5, 5, 5)
                                            .addGroup(orderDetailWidgetLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(lblQuantityNameProduct)
                                                    .addComponent(btnCheck))
                                            .addGap(16, 16, 16)
                                            .addGroup(orderDetailWidgetLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(lblProductPrice)
                                                    .addComponent(btnDelete))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(lblImage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
    );
  }

  private void btnCheckActionPerformed(ActionEvent evt, Long id) {
    storeOrderDetailController = new StoreOrderDetailController();
    storeOrderDetailController.checkProduct(id);
    parentPage.refresh();
  }

  private void btnDeleteActionPerformed(ActionEvent evt, Long id) {
    storeOrderDetailController = new StoreOrderDetailController();
    storeOrderDetailController.deleteOrderProductById(id);
    parentPage.refresh();
  }
}
