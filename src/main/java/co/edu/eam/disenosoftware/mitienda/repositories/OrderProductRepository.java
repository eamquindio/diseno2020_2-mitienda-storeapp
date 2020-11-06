package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.OrderProductAPIClient;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * Repository to access Order product data
 */
public class OrderProductRepository {

  public void deleteOrderProductById(Long orderProductId) throws IOException {
    //crear el cliente del api - crear quien hace el requst
    OrderProductAPIClient apiClient = RetroFitUtils.buildAPIClient(OrderProductAPIClient.class);

    //hacer el request
    Call<Void> request = apiClient.deleteOrderProductById(orderProductId);
    Response<Void> response = request.execute();

    //procesar la respuesta
    if (!(response.isSuccessful())) {
      throw APIErrorHandler.throwApiException(response);
    }
  }

  public void checkProduct(Long orderProductId) throws IOException {
    //crear el cliente del api - crear quien hace el requst
    OrderProductAPIClient apiClient = RetroFitUtils.buildAPIClient(OrderProductAPIClient.class);

    //hacer el request
    Call<Void> request = apiClient.checkProduct(orderProductId);
    Response<Void> response = request.execute();

    //procesar la respuesta
    if (!(response.isSuccessful())) {
      throw APIErrorHandler.throwApiException(response);
    }
  }
}
