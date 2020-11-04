package co.edu.eam.disenosoftware.mitienda.webservices;


import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Path;

import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import retrofit2.http.PUT;


/**
 * OrderProduct api web service client
 */
public interface OrderProductAPIClient {

  public static final String ORDER_PRODUCT_URL = "/api/order-products/";

  @DELETE(ORDER_PRODUCT_URL+"{orderProductId}")
  Call<Void> deleteOrderProductById(@Path("orderProductId") Long orderProductId);

    public static final String ORDERPRODUCT_URL ="/api/order-products";

    @PUT(ORDERPRODUCT_URL + "/{orderProductId}/check-product")
    Call<Void> checkProduct(@Path("orderProductId") Long orderProductId);

}
