package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.model.requests.AddProductRequest;
import co.edu.eam.disenosoftware.mitienda.repositories.OrdersRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ProductStoresRepository;

import java.io.IOException;

public class DialogAddProductController {

  private OrdersRepository ordersRepository;

  public DialogAddProductController() {
    ordersRepository = new OrdersRepository();
  }

  /**
   * get the order
   * @param id order id to get
   * @return order
   */
  public Order getOrder(Long id) throws IOException {
    ordersRepository = new OrdersRepository();
    return ordersRepository.getOrderById(id);
  }

  public Order addProductToOrder(Long orderId, Long productId, int quantity) throws IOException {
    ordersRepository = new OrdersRepository();
    AddProductRequest body = new AddProductRequest(quantity, productId);
    return ordersRepository.addProduct(orderId, body);
  }


}
