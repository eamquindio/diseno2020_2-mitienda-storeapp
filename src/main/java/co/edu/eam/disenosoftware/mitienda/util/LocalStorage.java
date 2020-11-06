/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoftware.mitienda.util;

import java.util.HashMap;
import java.util.Map;

/**
 *class to save the state of the application
 * @author caferrerb
 */
public class LocalStorage {

  private static Map<String, Object> map = new HashMap<>();

  /**
   * Method to save data in the app
   * @param key key used to save the data.
   * @param data data to save
   */
  public static void saveData(String key, Object data) {
    map.put(key, data);
  }

  /**
   * Get data saved
   * @param <T>
   * @param key key to retrieve
   * @param typeClass class saved
   * @return object to retrieve
   */
  public static <T> T getData(String key, Class<T> typeClass) {
    return (T) map.get(key);
  }

}
