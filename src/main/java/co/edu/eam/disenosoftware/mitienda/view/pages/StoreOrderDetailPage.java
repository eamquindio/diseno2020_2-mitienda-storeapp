package co.edu.eam.disenosoftware.mitienda.view.pages;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.view.controllers.StoreOrderDetailController;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.widgets.StoreOrderDetailWidget;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreOrderDetailPage extends Page {

  private StoreOrderDetailController storeOrderDetailController;

  private Order order;

  private Map<String, Object> params;

  private int productsToChoose;

  public StoreOrderDetailPage() {
    params = new HashMap<>();
    storeOrderDetailController = new StoreOrderDetailController();
  }

  @Override
  public void init()  {
    storeOrderDetailController = new StoreOrderDetailController();

    Long orderId = (Long) getParam("orderId");

    this.order = storeOrderDetailController.getOrder(orderId);
  }

  @Override
  public JComponent buildContent()  {
    this.productsToChoose = 0;

    List<OrderProduct> orderProducts = order.getProduct();

    JPanel panelProducts = new JPanel();

    int rows = this.productsToChoose == orderProducts.size() ? 1 : orderProducts.size();

    panelProducts.setLayout(new GridLayout(rows, 0, 0, 10));
    panelProducts.setBackground(Color.white);

    for (OrderProduct orderProduct : orderProducts) {
      if (!orderProduct.getState().equals("pending")) {
        this.productsToChoose++;
        rows--;
      } else {
        StoreOrderDetailWidget wdgt = new StoreOrderDetailWidget(orderProduct, this);
        panelProducts.add(wdgt);
      }
    }

    if (rows > 4) {

      panelProducts.setLayout(new GridLayout(rows, 0));

    } else if (rows == 0) {

      JPanel panelFinishedOrder = new JPanel();
      panelFinishedOrder.setLayout(new BorderLayout());
      panelFinishedOrder.setBackground(Color.white);

      JLabel lblFinishOrder = new JLabel(getString("storeorderdetailpage.finish_order_title"));
      lblFinishOrder.setFont(new Font("Arial", Font.BOLD, 13));
      lblFinishOrder.setHorizontalAlignment(SwingConstants.CENTER);
      lblFinishOrder.setOpaque(true);

      if (order.getState().equals("finished")) {
        lblFinishOrder.setText(getString("storeorderdetailpage.order_completed_title"));
      }

      JButton btnFinishOrder = new JButton(getString("storeorderdetailpage.btn_finish"));
      btnFinishOrder.setPreferredSize(new Dimension(btnFinishOrder.getPreferredSize().width, 50));
      btnFinishOrder.setMaximumSize(new Dimension(336, 50));
      btnFinishOrder.setForeground(Color.white);

      btnFinishOrder.setBackground(Constants.COLOR_GREEN);
      btnFinishOrder.setUI(new BasicButtonUI() {
        @Override
        public void paint(Graphics grphcs, JComponent jc) {
          Graphics2D grphcs2D = (Graphics2D) grphcs.create();
          grphcs2D.setColor(Constants.COLOR_GREEN);
          grphcs2D.dispose();
          super.paint(grphcs, jc);
        }
      });

      btnFinishOrder.setBorderPainted(false);
      btnFinishOrder.setCursor(new Cursor(Cursor.HAND_CURSOR));
      btnFinishOrder.setFocusPainted(false);

      if (!order.getState().equals("finished")) {
        btnFinishOrder.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
            btnFinishOrder.setBackground(Constants.COLOR_GREEN_HOVER);
          }

          @Override
          public void mouseExited(MouseEvent e) {
            btnFinishOrder.setBackground(Constants.COLOR_GREEN);
          }
        });
      }

      btnFinishOrder.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          storeOrderDetailController.endOrder(order.getId());
          goBack();
        }
      });

      if (order.getState().equals("finished")) {
        btnFinishOrder.setEnabled(false);
      }

      panelFinishedOrder.add(lblFinishOrder, BorderLayout.CENTER);
      panelFinishedOrder.add(btnFinishOrder, BorderLayout.PAGE_END);

      panelProducts.add(panelFinishedOrder);
      panelProducts.setLayout(new GridLayout(1, 0));
    }

    JScrollPane scrollPane = new JScrollPane(panelProducts);
    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setBackground(Color.white);
    scrollPane.getViewport().setOpaque(false);

    return scrollPane;
  }

  @Override
  public JComponent buildHeader()  {

    NumberFormat formatter = NumberFormat. getCurrencyInstance();

    JPanel panel = new JPanel();
    panel.setPreferredSize(new Dimension(panel.getPreferredSize().width, 50));
    panel.setMaximumSize(new Dimension(468, 50));
    panel.setBackground(Constants.COLOR_GREEN);
    panel.setLayout(new BorderLayout());

    JPanel panelOrderDetails = new JPanel();
    panelOrderDetails.setBackground(Constants.COLOR_GREEN);

    String clientName = order.getUser().getName();
    clientName = clientName.length() >= 37 ? clientName.substring(0, 37) + "..." : clientName;

    JLabel lblOrderClient = new JLabel(getString("storeorderdetailpage.order_client") + clientName);
    lblOrderClient.setFont(new Font("", Font.BOLD, 12));
    lblOrderClient.setForeground(Color.white);
    lblOrderClient.setHorizontalAlignment(SwingConstants.LEFT);

    String totalValue =formatter. format(order.getTotalValue());

    JLabel lblTotalOrder = new JLabel("<html><b>" + getString("storeorderdetailpage.total_order") + "</b> " + totalValue + "</html>");
    lblTotalOrder.setFont(new Font("", Font.PLAIN, 12));
    lblTotalOrder.setForeground(Color.white);
    lblTotalOrder.setHorizontalAlignment(SwingConstants.LEFT);

    JLabel lblQuantityProducts = new JLabel("<html><b>" + getString("storeorderdetailpage.products") + "</b> " + this.productsToChoose + "/" + order.getProduct().size() + "</html>");
    lblQuantityProducts.setFont(new Font("", Font.PLAIN, 12));
    lblQuantityProducts.setForeground(Color.white);
    lblQuantityProducts.setHorizontalAlignment(SwingConstants.RIGHT);

    GroupLayout panelOrderDetailsLayout = new GroupLayout(panelOrderDetails);
    panelOrderDetails.setLayout(panelOrderDetailsLayout);
    panelOrderDetailsLayout.setHorizontalGroup(
            panelOrderDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelOrderDetailsLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panelOrderDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOrderClient, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelOrderDetailsLayout.createSequentialGroup()
                                            .addComponent(lblTotalOrder, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                            .addComponent(lblQuantityProducts, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
    );
    panelOrderDetailsLayout.setVerticalGroup(
            panelOrderDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelOrderDetailsLayout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(lblOrderClient)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelOrderDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTotalOrder)
                                    .addComponent(lblQuantityProducts))
                            .addGap(0, 13, Short.MAX_VALUE))
    );

    panel.add(panelOrderDetails, BorderLayout.CENTER);

    return panel;
  }

  @Override
  public JComponent buildFooter() {

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(1, 0));
    panel.setBackground(Color.white);

    JButton btnAdd = new JButton(getString("storeorderdetailpage.btn_add"));
    btnAdd.setBackground(Constants.COLOR_BLUE);
    btnAdd.setForeground(Color.white);

    btnAdd.setBorderPainted(false);
    btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnAdd.setFocusPainted(false);

    if (!order.getState().equals("finished")) {
      btnAdd.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
          btnAdd.setBackground(Constants.COLOR_BLUE_HOVER);
        }

        @Override
        public void mouseExited(MouseEvent e) {
          btnAdd.setBackground(Constants.COLOR_BLUE);
        }
      });
    }

    btnAdd.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        params.put("orderId",(Long) getParam("orderId"));
        goToFrame("AddProductPage", params);
      }
    });

    if (order.getState().equals("finished")) {
      btnAdd.setEnabled(false);
    }

    btnAdd.setUI(new BasicButtonUI() {
      @Override
      public void paint(Graphics grphcs, JComponent jc) {
        Graphics2D grphcs2D = (Graphics2D) grphcs.create();
        grphcs2D.setColor(Constants.COLOR_BLUE);
        grphcs2D.setBackground(Constants.COLOR_BLUE);
        grphcs2D.dispose();
        super.paint(grphcs, jc);
      }
    });

    panel.add(btnAdd);
    panel.setPreferredSize(new Dimension(panel.getPreferredSize().width, 50));
    panel.setMaximumSize(new Dimension(336, 50));

    return panel;
  }

  @Override
  public void refresh()  {
    super.refresh();
  }
}
