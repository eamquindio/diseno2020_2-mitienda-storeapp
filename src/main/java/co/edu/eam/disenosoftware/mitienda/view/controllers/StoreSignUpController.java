package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.repositories.StoresRepository;

import java.io.IOException;

public class StoreSignUpController {

  private final StoresRepository storesRepository;

  public StoreSignUpController() {
    storesRepository = new StoresRepository();
  }

  public void createStore(Store store) throws IOException {
    storesRepository.createStore(store);
  }
}
