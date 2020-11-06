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
  private Long productId;

  /**
   * Constructor
   *
   * @param quantity
   * @param productId
   */
  public AddProductRequest(Integer quantity, Long productId) {
    this.quantity = quantity;
    this.productId = productId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }
}
