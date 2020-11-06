package co.edu.eam.disenosoftware.mitienda.webservices;

import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.model.requests.StoreLoginRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
import retrofit2.http.GET;
import retrofit2.http.Path;
import java.util.List;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;

/**
 * Store api client
 */
public interface StoreAPIClient {

  /**
   * Stores API URL
   */
  public static final String STORES_URL = "/api/stores/";

  /**
   * Store Login - Web Services
   * @param storeLoginRequest Store email and password
   * @return Logged store
   */
  @POST(STORES_URL + "login")
  Call<Store> storeLogin(@Body StoreLoginRequest storeLoginRequest);

  /**
   * Store Categories - Web Services
   * @param storeId of a store
   * @return List of categories
   */

  @GET(STORES_URL+ "{storeId}/categories")
  Call<List<Category>> getCategoriesByStoreId(@Path("storeId") Long storeId);
  public static final String ORDERS_URL = "/api/stores/";

  @GET(ORDERS_URL +"{store_id}/orders")
  Call<List<Order>> getOrderByStore(@Path("store_id") Long storeId);
}
