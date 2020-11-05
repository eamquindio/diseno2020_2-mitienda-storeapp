package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.StoreAPIClient;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Repository to access Category data
 */
public class CategoryRepository {

  public List<Category> getCategoriesByStoreId(Long storeId) throws IOException {
    StoreAPIClient apiClient = RetroFitUtils.buildAPIClient(StoreAPIClient.class);

    Call<List<Category>> categoriesRequest = apiClient.getCategoriesByStoreId(storeId);
    Response<List<Category>> response = categoriesRequest.execute();

    if (response.isSuccessful()){
      return response.body();
    }else{
      throw APIErrorHandler.throwApiException(response);
    }
  }

}
