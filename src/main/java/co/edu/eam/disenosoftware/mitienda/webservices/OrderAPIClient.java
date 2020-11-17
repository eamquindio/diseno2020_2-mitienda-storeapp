package co.edu.eam.disenosoftware.mitienda.webservices;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.requests.AddProductRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.Path;


/**
 * Orders api web service client
 */
public interface OrderAPIClient {

  String ORDER_URL = "/api/orders/";

  @PATCH(ORDER_URL + "{id}/end")
  Call<Void> endOrder(@Path("id") Long id);

  @PATCH(ORDER_URL + "{orderId}/delivery")
  Call<Void> deliverOrder(@Path("orderId") Long orderId);

  /**
   * get order by id
   *
   * @param id
   * @return order
   */
  @GET(ORDER_URL + "{id}")
  Call<Order> getOrderById(@Path("id") long id);


  @PUT(ORDER_URL + "{id}/add-product")
  Call<Order> addProduct(@Path("id") Long id, @Body AddProductRequest body);

}
