package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.ProductAPIClient;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Repository to access products data
 */
public class ProductsRepository {

  /**
   * Get products by name
   *
   * @param name
   * @return ist of products
   * @throws IOException
   */
  public List<Product> getProductsByName(String name) throws IOException {
    ProductAPIClient apiClient = RetroFitUtils.buildAPIClient(ProductAPIClient.class);

    Call<List<Product>> request = apiClient.getProductByName(name);
    Response<List<Product>> response = request.execute();

    if (response.isSuccessful()) {
      return response.body();
    } else {
      throw APIErrorHandler.throwApiException(response);
    }
  }
}
