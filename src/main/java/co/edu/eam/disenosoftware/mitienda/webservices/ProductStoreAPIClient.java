package co.edu.eam.disenosoftware.mitienda.webservices;

import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * ProductStore api web service client
 */
public interface ProductStoreAPIClient {

  @GET("/api/products-store/stores/{storeId}/products")
  Call<List<ProductStore>> getProductsByStoreId(@Path("storeId") Long storeId);

}
