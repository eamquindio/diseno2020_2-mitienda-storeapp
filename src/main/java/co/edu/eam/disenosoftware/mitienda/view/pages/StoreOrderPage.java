package co.edu.eam.disenosoftware.mitienda.view.pages;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.util.LocalStorage;
import co.edu.eam.disenosoftware.mitienda.view.controllers.StoreOrderController;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.widgets.StoreOrderDeliveredWidget;
import co.edu.eam.disenosoftware.mitienda.view.widgets.StoreOrderInProgressWidget;
import co.edu.eam.disenosoftware.mitienda.view.widgets.StoreOrderPreparedWidget;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * StoreOrderPage class
 */
public class StoreOrderPage extends Page {

    private List<Order> order;
    private StoreOrderController storeOrderController;

    /**
     * StoreOrderPage constructor
     */
    public StoreOrderPage() {
        storeOrderController = new StoreOrderController();
    }

    /**
     * Store order page init function
     *
     * @throws Exception , exception
     */
    @Override
    public void init() throws Exception {
        storeOrderController = new StoreOrderController();

        Long storeId = (Long) getParam("storeId");
        storeId = LocalStorage.getData("storeId", Long.class);
        this.order = storeOrderController.getOrderByStoreId(storeId);
    }

    /**
     * Store order page build content function
     *
     * @return , return a UI build for body app
     * @throws Exception , exception
     */
    @Override
    public JComponent buildContent() throws Exception {

        JPanel panelContainer = new JPanel();
        JTabbedPane tbdContainer = new JTabbedPane();
        JPanel panebPreparacion = new JPanel();
        JScrollPane jScrollpanelPreparacion = new JScrollPane();
        JPanel panelFlow = new JPanel();
        JPanel panelGrid = new JPanel();
        JPanel panelPreparados = new JPanel();
        JScrollPane jScrollPanelPreparados = new JScrollPane();
        JPanel panelFlowPreparados = new JPanel();
        JPanel panelGridPreparados = new JPanel();
        JPanel panelEntregados = new JPanel();
        JScrollPane jScrollPanelEntregados = new JScrollPane();
        JPanel panelFlowEntregados = new JPanel();
        JPanel panelGridEntregados = new JPanel();


        GroupLayout jPanel1Layout = new GroupLayout(panelContainer);
        panelContainer.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        panelFlow.add(panelGrid);

        jScrollpanelPreparacion.setViewportView(panelFlow);

        GroupLayout panebPreparacionLayout = new GroupLayout(panebPreparacion);
        panebPreparacion.setLayout(panebPreparacionLayout);
        panebPreparacionLayout.setHorizontalGroup(
                panebPreparacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollpanelPreparacion, GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );
        panebPreparacionLayout.setVerticalGroup(
                panebPreparacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollpanelPreparacion, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        tbdContainer.addTab("En preparacion", panebPreparacion);


        panelFlowPreparados.add(panelGridPreparados);

        jScrollPanelPreparados.setViewportView(panelFlowPreparados);

        javax.swing.GroupLayout panelPreparadosLayout = new GroupLayout(panelPreparados);
        panelPreparados.setLayout(panelPreparadosLayout);
        panelPreparadosLayout.setHorizontalGroup(
                panelPreparadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPanelPreparados, GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );
        panelPreparadosLayout.setVerticalGroup(
                panelPreparadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPanelPreparados, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        tbdContainer.addTab("Preparados", panelPreparados);


        panelFlowEntregados.add(panelGridEntregados);

        jScrollPanelEntregados.setViewportView(panelFlowEntregados);

        javax.swing.GroupLayout panelEntregadosLayout = new GroupLayout(panelEntregados);
        panelEntregados.setLayout(panelEntregadosLayout);
        panelEntregadosLayout.setHorizontalGroup(
                panelEntregadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPanelEntregados, GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );
        panelEntregadosLayout.setVerticalGroup(
                panelEntregadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPanelEntregados, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        tbdContainer.addTab("Entregados", panelEntregados);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(tbdContainer)
                        .addComponent(panelContainer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(panelContainer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tbdContainer, GroupLayout.PREFERRED_SIZE, 682, GroupLayout.PREFERRED_SIZE))
        );


        List<Order> orders = order;

        panelGrid.setLayout(new java.awt.GridLayout(orders.size(), 0, 0, 5));
        panelGridPreparados.setLayout(new java.awt.GridLayout(orders.size(), 0, 0, 5));
        panelGridEntregados.setLayout(new java.awt.GridLayout(orders.size(), 0, 0, 5));

        for (int i = 0; i < orders.size(); i++) {

            if (order.get(i).getState().equals("created")) {

                StoreOrderInProgressWidget storeOrderInProgressWidget = new StoreOrderInProgressWidget(order.get(i),this);
                panelGrid.add(storeOrderInProgressWidget);
            }
            if (order.get(i).getState().equals("finished")) {

                StoreOrderPreparedWidget storeOrderInProgressWidget = new StoreOrderPreparedWidget(order.get(i),this);
                panelGridPreparados.add(storeOrderInProgressWidget);

            }
            if (order.get(i).getState().equals("delivered")) {

                StoreOrderDeliveredWidget storeOrderDeliveredWidget = new StoreOrderDeliveredWidget(order.get(i));
                panelGridEntregados.add(storeOrderDeliveredWidget);
            }

        }

        return tbdContainer;
    }

    /**
     * Store order page build header for app
     *
     * @return , return a UI build for header app
     * @throws Exception , exception
     */
    @Override
    public JComponent buildHeader() throws Exception {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0));
        panel.setBackground(Constants.COLOR_GREEN);

        GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        return panel;
    }

    /**
     * Store order page build footer for app
     *
     * @return , return a UI build for footer app
     * @throws Exception
     */
    @Override
    public JComponent buildFooter() throws Exception {
        return null;
    }

    @Override
    public void refresh() throws Exception {
        super.refresh();
    }
}
