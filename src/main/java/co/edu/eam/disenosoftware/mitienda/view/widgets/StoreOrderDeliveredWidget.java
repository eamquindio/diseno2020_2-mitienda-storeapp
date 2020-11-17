package co.edu.eam.disenosoftware.mitienda.view.widgets;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.view.lib.Widget;

import javax.swing.*;
import java.awt.*;

/**
 * Store order delivered widget
 */
public class StoreOrderDeliveredWidget extends Widget<Order> {

  /**
   * Store order delivered widget extends data
   *
   * @param data , data order
   */
  public StoreOrderDeliveredWidget(Order data) {
    super(data);
  }

  /**
   * Store order delivered widget build
   */
  @Override
  public void build() {
    JLabel lblState = new JLabel();
    JLabel lblUser = new JLabel();
    JLabel lblOrderId = new JLabel();


    this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
    this.setBackground(Color.white);


    lblState.setText(data.getState());

    lblUser.setText(data.getUser().getName());

    lblOrderId.setText(data.getId().toString());

    GroupLayout jPanelLayout = new GroupLayout(this);
    this.setLayout(jPanelLayout);
    jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(lblState, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                    .addComponent(lblUser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblOrderId, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
    );
    jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblState, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblOrderId, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 30, Short.MAX_VALUE))
    );

  }
}
