package co.edu.eam.disenosoftware.mitienda.model.requests;

/**
 * Body for add product request
 */
public class AddProductRequest {

  /**
   * qty to add
   */
  private Integer quantity;

  /**
   * product to add
   */
  private Long id;

  /**
   * Constructor
   *
   * @param quantity
   * @param id
   */
  public AddProductRequest(Integer quantity, Long id) {
    this.quantity = quantity;
    this.id = id;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long productId) {
    this.id = id;
  }
}
