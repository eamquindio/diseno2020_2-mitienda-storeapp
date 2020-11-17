package co.edu.eam.disenosoftware.mitienda.view.widgets;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.repositories.OrdersRepository;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.lib.Widget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Store order in progress widget
 */
public class StoreOrderPreparedWidget extends Widget<Order> {

    private final Page page;
    OrdersRepository order = new OrdersRepository();

    /**
     * Store order in progress widget extends data
     * @param data , data order
     */
    public StoreOrderPreparedWidget(Order data, Page page) {
        super(data);
        this.page=page;
    }

    /**
     * Store order in progress widget build
     */
    @Override
    public void build() {
        JButton btnEntregar = new JButton();
        JLabel lblNameUser = new JLabel();
        JLabel lblIdUser = new JLabel();

        btnEntregar.setBackground(Constants.COLOR_GREEN);
        btnEntregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEntregar.setBorderPainted(false);
        btnEntregar.setFocusPainted(false);
        btnEntregar.setForeground(Color.white);

        btnEntregar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnEntregar.setBackground(new Color(103,159,152));
            }

            @Override
            public void mouseExited(MouseEvent e) {

                btnEntregar.setBackground(Constants.COLOR_GREEN);
            }
        });

        btnEntregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    order.deliverOrder(data.getId());
                    page.refresh();

                } catch (Exception exc) {
                    exc.getStackTrace();
                }

            }
        });
        ActionListener actionListener;

        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        this.setBackground(Color.white);

        btnEntregar.setText("Entregar");
        lblNameUser.setText(data.getUser().getName());
        lblIdUser.setText(data.getUser().getId().toString());
        lblNameUser.setFont(new Font("", 0, 10));
        GroupLayout jPanelLayout = new GroupLayout(this);
        this.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNameUser, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblIdUser, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addComponent(btnEntregar, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(0, 20, Short.MAX_VALUE)
                                                .addComponent(btnEntregar, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24))
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addComponent(lblNameUser, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblIdUser, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );

    }
}