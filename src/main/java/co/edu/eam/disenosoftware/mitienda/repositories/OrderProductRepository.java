package co.edu.eam.disenosoftware.mitienda.repositories;

<<<<<<< HEAD
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.OrderProductAPIClient;
import retrofit2.Call;
import retrofit2.Response;
=======

import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;

import co.edu.eam.disenosoftware.mitienda.webservices.OrderProductAPIClient;
import retrofit2.Call;
import retrofit2.Response;

>>>>>>> e040d10 (Arreglando problemas)

import java.io.IOException;

/**
 * Repository to access Order product data
 */
public class OrderProductRepository {

<<<<<<< HEAD
  public void deleteOrderProductById (Long orderProductId) throws  IOException{
    //crear el cliente del api - crear quien hace el requst
    OrderProductAPIClient apiClient = RetroFitUtils.buildAPIClient(OrderProductAPIClient.class);

    //hacer el request
    Call<Void> request = apiClient.deleteOrderProductById(orderProductId);
    Response<Void> response = request.execute();

    //procesar la respuesta
    if (!(response.isSuccessful())){
      throw APIErrorHandler.throwApiException(response);
    }
  }
    public OrderProduct checkProduct(Long id) throws IOException {
=======
    public void checkProduct(Long id) throws IOException {
>>>>>>> e040d10 (Arreglando problemas)
        OrderProductAPIClient orderProductAPIClient = RetroFitUtils.buildAPIClient(OrderProductAPIClient.class);
        Call<Void> request = orderProductAPIClient.checkProduct(id);
        Response<Void> response = request.execute();

        if (!response.isSuccessful()) {
            throw APIErrorHandler.throwApiException(response);
        }
    }
}
