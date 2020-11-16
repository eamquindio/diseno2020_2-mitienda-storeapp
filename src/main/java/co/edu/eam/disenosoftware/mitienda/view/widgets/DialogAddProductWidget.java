package co.edu.eam.disenosoftware.mitienda.view.widgets;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import co.edu.eam.disenosoftware.mitienda.util.ImageUtil;
import co.edu.eam.disenosoftware.mitienda.view.lib.Navigator;
import co.edu.eam.disenosoftware.mitienda.view.lib.Widget;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DialogAddProductWidget extends Widget<Product> {

  public DialogAddProductWidget(Product data) {
    super(data);
  }

  @Override
  public void build() {
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    String name = data.getName();
    name = name.length() >= 18 ? name.substring(0,15) + "..." : name;
    ImageIcon image = ImageUtil.loadFromURL(Constants.PRODUCT_IMAGE_URL +
                    data.getId() + "_small.jpg",
            100, 80);
    JLabel lblImage = new JLabel(image);
    this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    this.setPreferredSize(new Dimension(getPreferredSize().width, 150));
    JPanel panelInfo = new JPanel();
    JLabel lblName = new JLabel(name);
    lblName.setBorder(new EmptyBorder(130,0,0,10));
    panelInfo.setBackground(Color.white);
    this.setBackground(Color.white);
    panelInfo.add(lblName);
    this.add(lblImage);
    this.add(panelInfo);
    this.setBorder(new LineBorder(Color.black));
  }
}
