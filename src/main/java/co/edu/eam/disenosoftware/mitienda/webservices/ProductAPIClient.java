package co.edu.eam.disenosoftware.mitienda.webservices;

import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

/**
 * Product api web service client
 */
public interface ProductAPIClient {

  String PRODUCT_URL = "/api/products/";

  @GET(PRODUCT_URL + "by-name")
  Call<List<Product>> getProductByName(@Query("name_product") String name);

}
