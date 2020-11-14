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
import java.io.IOException;

public class StoreOrderDetailWidget extends Widget<OrderProduct> {

  private StoreOrderDetailController storeOrderDetailController;
  private Page storeOrderDetailPage;

  public StoreOrderDetailWidget(OrderProduct data, Page page) {
    super(data);
    this.storeOrderDetailPage = page;
  }

  @Override
  public void build() {

    this.setBackground(new Color(255, 255, 255));
    this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204)));

    ImageIcon image = ImageUtil.loadFromURL(Constants.PRODUCT_IMAGE_URL +
                    data.getProductStore().getProduct().getId() + "_small.jpg",
            70, 80);

    JLabel lblImage = new JLabel(image);

    String productName = data.getProductStore().getProduct().getName();
    productName = productName.length() >= 18 ? productName.substring(0, 15) + "..." : productName;

    JLabel lblQuantityNameProduct = new JLabel(data.getQuantity() + " x " + productName);
    lblQuantityNameProduct.setFont(new Font("", Font.PLAIN, 12));

    JLabel lblProductPrice = new JLabel("$" + data.getProductStore().getPrice() + " - 1 unidad");

    JButton btnCheck = new JButton("Encontrar");
    btnCheck.setFont(new Font("", Font.BOLD, 12));
    btnCheck.setForeground(new Color(255, 255, 255));

    btnCheck.setBackground(new Color(122, 191, 181));

    btnCheck.setUI(new BasicButtonUI() {
      @Override
      public void paint(Graphics grphcs, JComponent jc) {
        Graphics2D grphcs2D = (Graphics2D) grphcs.create();
        grphcs2D.setColor(new Color(122, 191, 181));
        grphcs2D.dispose();
        super.paint(grphcs, jc);
      }
    });

    btnCheck.setBorderPainted(false);
    btnCheck.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnCheck.setFocusPainted(false);
    btnCheck.addMouseListener(new MouseAdapter() {
      public void mouseEntered(MouseEvent evt) {
        btnCheck.setBackground(new Color(103, 159, 152));
      }

      public void mouseExited(MouseEvent evt) {
        btnCheck.setBackground(new Color(122, 191, 181));
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
    btnDelete.setForeground(new Color(255, 255, 255));
    btnDelete.setBackground(new Color(220, 53, 69));

    btnDelete.setUI(new BasicButtonUI() {
      @Override
      public void paint(Graphics grphcs, JComponent jc) {
        Graphics2D grphcs2D = (Graphics2D) grphcs.create();
        grphcs2D.setColor(new Color(220, 53, 69));
        grphcs2D.dispose();
        super.paint(grphcs, jc);
      }
    });

    btnDelete.setBorderPainted(false);
    btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnDelete.setFocusPainted(false);

    btnDelete.addMouseListener(new MouseAdapter() {
      public void mouseEntered(MouseEvent evt) {
        btnDelete.setBackground(new java.awt.Color(185, 47, 61));
      }

      public void mouseExited(MouseEvent evt) {
        btnDelete.setBackground(new Color(220, 53, 69));
      }
    });

    btnDelete.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        btnDeleteActionPerformed(e, data.getId());
      }
    });

    javax.swing.GroupLayout orderDetailWidgetLayout = new GroupLayout(this);
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
    try {
      storeOrderDetailController.checkProduct(id);
      storeOrderDetailPage.refresh();
    } catch (IOException io) {
      io.printStackTrace();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private void btnDeleteActionPerformed(ActionEvent evt, Long id) {
    storeOrderDetailController = new StoreOrderDetailController();
    try {
      storeOrderDetailController.deleteOrderProductById(id);
      storeOrderDetailPage.refresh();
    } catch (IOException io) {
      io.printStackTrace();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}