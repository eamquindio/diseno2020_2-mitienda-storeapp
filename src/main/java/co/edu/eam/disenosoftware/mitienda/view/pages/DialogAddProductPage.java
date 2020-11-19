package co.edu.eam.disenosoftware.mitienda.view.pages;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.util.LocalStorage;
import co.edu.eam.disenosoftware.mitienda.view.controllers.AddProductController;
import co.edu.eam.disenosoftware.mitienda.view.controllers.DialogAddProductController;
import co.edu.eam.disenosoftware.mitienda.view.lib.ListView;
import co.edu.eam.disenosoftware.mitienda.view.lib.Navigator;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.widgets.AddProductsDetailWidget;
import co.edu.eam.disenosoftware.mitienda.view.widgets.DialogAddProductWidget;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DialogAddProductPage extends Page {

  private Order order;

  private Product product;

  private int quantity;

  /**
   * page controller
   */
  private DialogAddProductController controller;

  public DialogAddProductPage() {
    controller = new DialogAddProductController();
  }

  @Override
  public void init(){
    controller = new DialogAddProductController();
    product = (Product) getParam("product");
    Long orderId = (Long) getParam("orderId");
    this.order = controller.getOrder(orderId);
    this.quantity = 0;
  }

  @Override
  public JComponent buildContent(){
    JPanel panelM = new JPanel();
    panelM.setLayout(new BoxLayout(panelM, BoxLayout.Y_AXIS));
    List<DialogAddProductWidget> productsWidgets = new ArrayList<>();
    DialogAddProductWidget wdgt = new DialogAddProductWidget(this.product);
    productsWidgets.add(wdgt);
    ListView<JComponent> listView = new ListView(productsWidgets, ListView.ListViewOrientation.VERTICAL);
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
    JButton restar = new JButton("-");
    JLabel labelQuantity = new JLabel(""+quantity);
    JButton sumar = new JButton("+");
    restar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        if(quantity > 0){
          quantity--;
          labelQuantity.setText(""+quantity);
        }
      }
    });
    sumar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        quantity++;
        labelQuantity.setText(""+quantity);
      }
    });
    panel.add(restar);
    panel.add(labelQuantity);
    panel.add(sumar);
    panel.setBorder(new EmptyBorder(30,0,0,0));
    JPanel metodos = new JPanel();
    JButton enviar = new JButton(getString("dialogaddproductpage.send"));
    JButton cancelar = new JButton(getString("dialogaddproductpage.cancel"));
    enviar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        controller.addProductToOrder(order.getId(),product.getId(),quantity);
        Map<String, Object> params = new HashMap<>();
        params.put("orderId", order.getId());
        goToFrame("StoreOrderDetailPage",params);
      }
    });
    cancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        Map<String, Object> params = new HashMap<>();
        params.put("orderId", order.getId());
        goToFrame("StoreOrderDetailPage",params);
      }
    });
    cancelar.setBackground(Constants.COLOR_RED);
    enviar.setBackground(Constants.COLOR_GREEN);
    metodos.add(cancelar);
    metodos.add(enviar);
    metodos.setBorder(new EmptyBorder(30,0,0,0));
    panelM.add(listView);
    panelM.add(panel);
    panelM.add(metodos);
    return panelM;
  }

  @Override
  public void refresh(){
    super.refresh();
  }

  @Override
  public JComponent buildHeader(){
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(1,1));
    panel.setBackground(Color.white);
    JLabel label = new JLabel("Order id: "+order.getId());
    panel.add(label);
    label.setBorder(new EmptyBorder(0,150,0,0));
    panel.setPreferredSize(new Dimension(panel.getPreferredSize().width,100));
    panel.setMaximumSize(new Dimension(1000,50));
    panel.setBackground(Constants.COLOR_GREEN);
    panel.setBorder(new LineBorder(Color.BLACK));
    return panel;
  }

  @Override
  public JComponent buildFooter(){
    return null;
  }
}
