package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.OrderAPIClient;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * Repository to access orders data
 */
public class OrdersRepository {

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

  public void deliverOrder(Long id) throws IOException {
    OrderAPIClient orderApiClient = RetroFitUtils.buildAPIClient(OrderAPIClient.class);
    Call<Void> request = orderApiClient.deliverOrder(id);
    Response<Void> response = request.execute();

    if (!response.isSuccessful()) {
      throw APIErrorHandler.throwApiException(response);
    }
  }
}
