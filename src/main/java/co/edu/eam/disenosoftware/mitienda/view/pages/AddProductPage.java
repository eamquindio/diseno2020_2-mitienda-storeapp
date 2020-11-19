package co.edu.eam.disenosoftware.mitienda.view.pages;

import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import co.edu.eam.disenosoftware.mitienda.util.LocalStorage;
import co.edu.eam.disenosoftware.mitienda.view.controllers.AddProductController;
import co.edu.eam.disenosoftware.mitienda.view.lib.ListView;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.widgets.AddProductsDetailWidget;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddProductPage extends Page {

  private String name = null;

  private Long orderId;

  /**
   * page controller
   */
  private AddProductController controller;

  public AddProductPage() {
    controller = new AddProductController();
  }

  @Override
  public void init(){
    orderId = (Long)getParam("orderId");
  }

  @Override
  public JComponent buildContent(){
    if (this.name==null) {
      JLabel label = new JLabel(getString("addproductpage.notsearchs"));
      label.setBorder(new EmptyBorder(40,50,0,0));
      return label;
    } else {
      List<Product> productList = controller.listAllProductByName(name);
      List<AddProductsDetailWidget> productsWidgets = new ArrayList<>();
      for (Product product : productList) {
        AddProductsDetailWidget wdgt = new AddProductsDetailWidget(product, this);
        productsWidgets.add(wdgt);
      }
        ListView<JComponent> listView = new ListView(productsWidgets, ListView.ListViewOrientation.VERTICAL);
        return listView;
    }

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
    JTextField txt = new JTextField();
    name = LocalStorage.getData("searchProductName", String.class);
    if(name == null){
      name = "";
    }else{
      txt.setText(name);
    }
    panel.add(txt);
    txt.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        name = txt.getText();
        LocalStorage.saveData("searchProductName", name);
        AddProductPage.super.refresh();
      }
    });
    panel.setPreferredSize(new Dimension(panel.getPreferredSize().width,100));
    panel.setMaximumSize(new Dimension(1000,50));
    return panel;
  }

  @Override
  public JComponent buildFooter(){
    return null;
  }
}
