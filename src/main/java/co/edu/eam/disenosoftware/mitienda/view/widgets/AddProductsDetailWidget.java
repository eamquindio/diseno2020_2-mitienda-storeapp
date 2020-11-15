package co.edu.eam.disenosoftware.mitienda.view.widgets;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import co.edu.eam.disenosoftware.mitienda.util.ImageUtil;
import co.edu.eam.disenosoftware.mitienda.view.lib.Widget;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class AddProductsDetailWidget extends Widget<Product> {

  public AddProductsDetailWidget(Product data) {
    super(data);
  }

  @Override
  public void build() {
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    System.out.println(data.getId());
    ImageIcon image = ImageUtil.loadFromURL(Constants.PRODUCT_IMAGE_URL +
                    data.getId() + "_small.jpg",
            100, 80);
    JLabel lblImage = new JLabel(image);
    this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

    this.setPreferredSize(new Dimension(getPreferredSize().width, 150));
    JPanel panelInfo = new JPanel();
    panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));

    JLabel lblName = new JLabel(data.getName());
    panelInfo.add(lblName);

    this.add(lblImage);
    this.add(panelInfo);
  }
}
