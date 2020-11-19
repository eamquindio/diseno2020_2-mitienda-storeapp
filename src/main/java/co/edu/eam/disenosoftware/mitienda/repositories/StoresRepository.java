package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.exceptions.TecnicalException;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.model.requests.StoreLoginRequest;
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.StoreAPIClient;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * Repository to access stores data
 */
public class StoresRepository {

  /**
   * Store Login Repository
   *
   * @param body email and password
   * @return Logged store
   * @ IOException
   */
  public Store storeLogin(StoreLoginRequest body) {
    StoreAPIClient storeAPIClient = RetroFitUtils.buildAPIClient(StoreAPIClient.class);
    try {
      Call<Store> storeRequest = storeAPIClient.storeLogin(body);
      Response<Store> storeResponse = storeRequest.execute();

      if (storeResponse.isSuccessful()) {
        return storeResponse.body();
      } else {
        throw APIErrorHandler.throwApiException(storeResponse);
      }
    } catch (IOException exc) {
      throw new TecnicalException(exc);
    }
  }

  public void createStore(Store store) {
    StoreAPIClient storeAPIClient = RetroFitUtils.buildAPIClient(StoreAPIClient.class);
    try {
      Call<Void> storeRequest = storeAPIClient.registerStore(store);
      Response<Void> storeResponse = storeRequest.execute();

      if (!storeResponse.isSuccessful()) {
        throw APIErrorHandler.throwApiException(storeResponse);
      }
    } catch (IOException exc) {
      throw new TecnicalException(exc);
    }

  }
}