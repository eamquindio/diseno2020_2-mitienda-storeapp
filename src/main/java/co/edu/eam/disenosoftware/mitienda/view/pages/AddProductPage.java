package co.edu.eam.disenosoftware.mitienda.view.pages;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import co.edu.eam.disenosoftware.mitienda.view.controllers.AddProductController;
import co.edu.eam.disenosoftware.mitienda.view.lib.ListView;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.widgets.AddProductsDetailWidget;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddProductPage extends Page {

  private String name = null;

  private Order order;
  /**
   * page controller
   */
  private AddProductController controller;

  public AddProductPage() {
    controller = new AddProductController();
  }

  @Override
  public void init() throws Exception {
    controller = new AddProductController();
    Long orderId = (Long) getParam("orderId");
    orderId = 13l;
    this.order = controller.getOrder(orderId);
    System.out.println(order.getId());
  }

  @Override
  public JComponent buildContent() throws Exception {
    if (this.name==null) {
      JLabel label = new JLabel("Aun no se ha realizado ninguna busqueda");
      return label;
    } else {
      List<Product> productList = controller.listAllProductByName(name);
      List<AddProductsDetailWidget> productsWidgets = new ArrayList<>();
      for (Product product : productList) {
        AddProductsDetailWidget wdgt = new AddProductsDetailWidget(product);
        productsWidgets.add(wdgt);
      }
        ListView<JComponent> listView = new ListView(productsWidgets, ListView.ListViewOrientation.VERTICAL);
        return listView;
    }

  }

  @Override
  public void refresh() throws Exception {
    super.refresh();
  }

  @Override
  public JComponent buildHeader() throws Exception {
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(1,1));
    panel.setBackground(Color.white);
    JTextField txt = new JTextField();
    panel.add(txt);
    txt.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        try{
          name = txt.getText();
          AddProductPage.super.refresh();
        }catch (IOException io){
          io.printStackTrace();
        }catch (Exception ex){
          ex.printStackTrace();
        }
        System.out.println("header" + name);
      }
    });

    return panel;
  }

  @Override
  public JComponent buildFooter() throws Exception {
    return null;
  }
}
