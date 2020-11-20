package co.edu.eam.disenosoftware.mitienda.view.widgets;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.lib.Widget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Store order prepared widget
 */
public class StoreOrderInProgressWidget extends Widget<Order> {


    /**
     * Store order prepared widget extends data
     *
     * @param data ,data order
     */
    public StoreOrderInProgressWidget(Order data, Page page) {
        super(data, page);
    }


    /**
     * Store order prepared widget build
     */
    @Override
    public void build() {

        JLabel lblUser = new JLabel();
        JLabel lblCountProduct = new JLabel();
        JLabel lblTelefono = new JLabel();


        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Constants.COLOR_GRAY));
        this.setBackground(Color.white);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Constants.COLOR_GREEN_HOVER);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.white);
            }
        });

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                Map<String, Object> params = new HashMap<>();

                params.put("orderId", data.getId());

                parentPage.goToFrame("StoreOrderDetailPage", params);
            }
        });

        lblUser.setText(data.getUser().getName());

        int count = 0;

        for (OrderProduct orderProduct : data.getProduct()) {
            if (!orderProduct.getState().equals("pending")) {
                count++;
            }
        }
        lblCountProduct.setText(count + " de " + data.getProduct().size());
        lblTelefono.setText(data.getUser().getPhone());


        GroupLayout jPanelLayout = new GroupLayout(this);
        this.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblUser, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                        .addComponent(lblCountProduct, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTelefono, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCountProduct, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 30, Short.MAX_VALUE))
        );

    }
}
