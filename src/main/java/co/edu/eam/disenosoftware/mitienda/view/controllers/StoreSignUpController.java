package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.repositories.StoresRepository;

import javax.swing.*;

public class StoreSignUpController {

  private final StoresRepository storesRepository;

  public StoreSignUpController() {
    storesRepository = new StoresRepository();
  }

  public void createStore(Store store) {
    storesRepository.createStore(store);
    JOptionPane.showMessageDialog(null,"Se ha registrado correctamente");
  }
}