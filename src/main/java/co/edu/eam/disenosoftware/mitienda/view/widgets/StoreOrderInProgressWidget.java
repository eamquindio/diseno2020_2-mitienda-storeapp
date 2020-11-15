package co.edu.eam.disenosoftware.mitienda.view.widgets;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.util.LocalStorage;
import co.edu.eam.disenosoftware.mitienda.view.lib.Navigator;
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

    private final Page page;

    /**
     * Store order prepared widget extends data
     *
     * @param data ,data order
     */
    public StoreOrderInProgressWidget(Order data, Page page) {
        super(data);
        this.page = page;
    }


    /**
     * Store order prepared widget build
     */
    @Override
    public void build() {

        JLabel lblUser = new JLabel();
        JLabel lblCountProduct = new JLabel();


        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        this.setBackground(Color.white);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(103, 159, 152));
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

                LocalStorage.saveData("orderId", data.getId());

                Navigator.goToFrame("StoreOrderDetailPage", params);

                try {

                    page.refresh();

                } catch (Exception exc) {
                    exc.getStackTrace();
                }


            }
        });

        lblUser.setText(data.getUser().getName());

        int count = 0;

        for (OrderProduct orderProduct : data.getProduct()) {
            if (orderProduct.getState().equals("checked")) {
                count++;
            }
        }
        lblCountProduct.setText(count + " de " + data.getProduct().size());


        GroupLayout jPanelLayout = new GroupLayout(this);
        this.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblUser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addComponent(lblCountProduct, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                                .addContainerGap())))
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(lblCountProduct, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 20, Short.MAX_VALUE))
        );

    }
}
