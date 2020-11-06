package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.requests.AddProductRequest;
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.OrderAPIClient;
import co.edu.eam.disenosoftware.mitienda.webservices.StoreAPIClient;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Repository to access orders data
 */
public class OrdersRepository {

  public List<Order> getOrderByStore(Long storeId) throws IOException {
    StoreAPIClient apiClient = RetroFitUtils.buildAPIClient(StoreAPIClient.class);

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

  /**
   * Function to use the deliverOrder controller
   *
   * @param id , id
   * @throws IOException , throws exception if response is not successful
   */
  public void deliverOrder(Long id) throws IOException {
    OrderAPIClient orderApiClient = RetroFitUtils.buildAPIClient(OrderAPIClient.class);
    Call<Void> request = orderApiClient.deliverOrder(id);
    Response<Void> response = request.execute();

    if (!response.isSuccessful()) {
      throw APIErrorHandler.throwApiException(response);
    }
  }

  /**
   * Function to get order by id
   *
   * @param id , id
   * @return , the response body
   * @throws IOException , if response fails throws the exception
   */
  public Order getOrderById(long id) throws IOException {
    OrderAPIClient orderAPIClient = RetroFitUtils.buildAPIClient(OrderAPIClient.class);
    Call<Order> request = orderAPIClient.getOrderById(id);
    Response<Order> response = request.execute();

    if (response.isSuccessful()) {
      return response.body();
    }
    throw APIErrorHandler.throwApiException(response);
  }

  /**
   * Add product
   *
   * @param orderId
   * @param body
   * @return the order after
   * @throws IOException
   */
  public Order addProduct(Long orderId, AddProductRequest body) throws IOException {
    OrderAPIClient orderAPIClient = RetroFitUtils.buildAPIClient(OrderAPIClient.class);

    Call<Order> request = orderAPIClient.addProduct(orderId, body);
    Response<Order> response = request.execute();

    if (response.isSuccessful()) {
      return response.body();
    }
    throw APIErrorHandler.throwApiException(response);
  }
}
