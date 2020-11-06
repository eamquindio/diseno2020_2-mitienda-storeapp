package co.edu.eam.disenosoftware.mitienda.webservices;

import retrofit2.Call;
import retrofit2.http.PATCH;
import retrofit2.http.Path;



/**
 * Orders api web service client
 */
public interface OrderAPIClient {

  public static final String ORDER_URL = "/api/orders/";

  @PATCH(ORDER_URL + "{id}/end")
  Call<Void> endOrder(@Path("id") Long id);

  @PATCH(ORDER_URL + "{orderId}/delivery")
  Call<Void> deliverOrder(@Path("orderId") Long orderId);

}
