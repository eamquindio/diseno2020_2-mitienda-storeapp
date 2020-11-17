package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.model.requests.StoreLoginRequest;
import co.edu.eam.disenosoftware.mitienda.repositories.StoresRepository;
import co.edu.eam.disenosoftware.mitienda.util.LocalStorage;

import java.io.IOException;

public class StoreLoginController {

  private final StoresRepository storesRepository;

  public StoreLoginController() {
    storesRepository = new StoresRepository();
  }

  public Long loginStore(String email, String password) throws IOException {
    Store store = storesRepository.storeLogin(new StoreLoginRequest(email, password));
    LocalStorage.saveData("storeId", store.getId());
    return store.getId();
  }
}
