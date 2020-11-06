package co.edu.eam.disenosoftware.mitienda.webservices;


import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * OrderProduct api web service client
 */
public interface OrderProductAPIClient {

  String ORDER_PRODUCT_URL = "/api/order-products/";

  @DELETE(ORDER_PRODUCT_URL + "{orderProductId}")
  Call<Void> deleteOrderProductById(@Path("orderProductId") Long orderProductId);

  @PUT(ORDER_PRODUCT_URL + "{orderProductId}/check-product")
  Call<Void> checkProduct(@Path("orderProductId") Long orderProductId);
}
