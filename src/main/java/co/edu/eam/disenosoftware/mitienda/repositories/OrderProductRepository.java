package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.exceptions.APIException;
import co.edu.eam.disenosoftware.mitienda.model.responses.ErrorResponse;
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.OrderProductAPIClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

/**
 * Repository to access Order product data
 */
public class OrderProductRepository {

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
}
