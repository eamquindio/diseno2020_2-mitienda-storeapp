package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.model.requests.StoreLoginRequest;
import co.edu.eam.disenosoftware.mitienda.repositories.StoresRepository;
import co.edu.eam.disenosoftware.mitienda.util.LocalStorage;

import javax.swing.*;

public class StoreLoginController {

  private final StoresRepository storesRepository;

  public StoreLoginController() {
    storesRepository = new StoresRepository();
  }

  public void loginStore(String email, String password) {
    Store store = storesRepository.storeLogin(new StoreLoginRequest(email, password));
    LocalStorage.saveData("storeId", store.getId());
  }
}