package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderProductRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.OrdersRepository;

import java.io.IOException;

public class StoreOrderDetailController {

  private OrdersRepository ordersRepository;
  private OrderProductRepository orderProductRepository;

  public StoreOrderDetailController() {
    ordersRepository = new OrdersRepository();
    orderProductRepository = new OrderProductRepository();
  }

  public Order getOrder(Long id) throws IOException {
    return ordersRepository.getOrderById(id);
  }

  public void checkProduct(Long orderProductId) throws IOException {
    orderProductRepository.checkProduct(orderProductId);
  }

  public void deleteOrderProductById(Long orderProductId) throws IOException {
    orderProductRepository.deleteOrderProductById(orderProductId);
  }

  public void endOrder(Long orderId) throws IOException {
    ordersRepository.endOrder(orderId);
  }

}
