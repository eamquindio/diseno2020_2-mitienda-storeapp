package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.repositories.OrdersRepository;

import java.util.List;

/**
 * Store order controller class
 */
public class StoreOrderController {


  private final OrdersRepository ordersRepository;

  /**
   * Store order controller constructor
   */
  public StoreOrderController() {
    ordersRepository = new OrdersRepository();
  }

  /**
   * Store order get order by id function
   *
   * @param id , store id
   * @return , list of orders
   * @ , exception
   */
  public List<Order> getOrderByStoreId(Long id) {
    return ordersRepository.getOrderByStore(id);
  }
}
