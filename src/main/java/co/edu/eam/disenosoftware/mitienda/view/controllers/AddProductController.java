package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import co.edu.eam.disenosoftware.mitienda.repositories.OrdersRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ProductsRepository;

import java.io.IOException;
import java.util.List;

/**
 * Controller page of add a product
 */
public class AddProductController {

  /**
   * order repository
   */
  private OrdersRepository ordersRepository;

  private ProductsRepository productsRepository;

  public AddProductController() {
    ordersRepository = new OrdersRepository();
    productsRepository = new ProductsRepository();
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

  public List<Product> listAllProductByName(String name) throws IOException {
    productsRepository = new ProductsRepository();
    return productsRepository.getProductsByName(name);
  }
}
