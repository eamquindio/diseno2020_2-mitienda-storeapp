package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.model.requests.StoreLoginRequest;
import co.edu.eam.disenosoftware.mitienda.repositories.StoresRepository;

import java.io.IOException;

public class StoreLoginController {

  private final StoresRepository storesRepository;

  public StoreLoginController() {
    storesRepository = new StoresRepository();
  }

  public Store loginStore(String email, String password) throws IOException {
    return storesRepository.storeLogin(new StoreLoginRequest(email, password));
  }
}
