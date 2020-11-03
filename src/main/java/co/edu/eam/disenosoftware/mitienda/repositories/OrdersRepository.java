package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.OrderAPIClient;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.webservices.StoreAPIClient;

import java.util.List;

/**
 * Repository to access orders data
 */
public class OrdersRepository {
  public List<Order> getOrderByStore(Long storeId) throws IOException {

    StoreAPIClient apiClient =  RetroFitUtils.buildAPIClient(StoreAPIClient.class);

    Call<List<Order>> request = apiClient.getOrderByStore(storeId);
    Response<List<Order>> response = request.execute();

    if (response.isSuccessful()) {
      return response.body();
    } else {
      throw APIErrorHandler.throwApiException(response);
    }
  }

  public void endOrder(Long orderId) throws IOException {

    OrderAPIClient apiClient = RetroFitUtils.buildAPIClient(OrderAPIClient.class);

    //Hacer el Request
    Call<Void> request = apiClient.endOrder(orderId);
    Response<Void> response = request.execute();

    //procesar la respuesta
    if (!response.isSuccessful()) {
      throw APIErrorHandler.throwApiException(response);
    }

  }

}
