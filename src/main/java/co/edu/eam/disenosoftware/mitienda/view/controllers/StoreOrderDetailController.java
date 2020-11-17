package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderProductRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.OrdersRepository;

public class StoreOrderDetailController {

  private final OrdersRepository ordersRepository;
  private final OrderProductRepository orderProductRepository;

  public StoreOrderDetailController() {
    ordersRepository = new OrdersRepository();
    orderProductRepository = new OrderProductRepository();
  }

  public Order getOrder(Long id) {
    return ordersRepository.getOrderById(id);
  }

  public void checkProduct(Long orderProductId) {
    orderProductRepository.checkProduct(orderProductId);
  }

  public void deleteOrderProductById(Long orderProductId) {
    orderProductRepository.deleteOrderProductById(orderProductId);
  }

  public void endOrder(Long orderId) {
    ordersRepository.endOrder(orderId);
  }

}
