package co.edu.eam.disenosoftware.mitienda.webservices;

import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.model.requests.StoreLoginRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Store api client
 */
public interface StoreAPIClient {

  public static final String STORES_URL = "/api/stores/";

  @POST(STORES_URL + "login")
  Call<Store> storeLogin(@Body StoreLoginRequest storeLoginRequest);

}
