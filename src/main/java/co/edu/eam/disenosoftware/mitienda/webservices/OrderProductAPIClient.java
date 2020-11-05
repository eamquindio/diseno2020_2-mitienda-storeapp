package co.edu.eam.disenosoftware.mitienda.webservices;


import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Path;

/**
 * OrderProduct api web service client
 */
public interface OrderProductAPIClient {

  public static final String ORDER_PRODUCT_URL = "/api/order-products/";

  @DELETE(ORDER_PRODUCT_URL+"{orderProductId}")
  Call<Void> deleteOrderProductById(@Path("orderProductId") Long orderProductId);

}
