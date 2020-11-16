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

  private ProductsRepository productsRepository;

  public AddProductController() {
    productsRepository = new ProductsRepository();
  }

  public List<Product> listAllProductByName(String name){
    productsRepository = new ProductsRepository();
    return productsRepository.getProductsByName(name);
  }
}
