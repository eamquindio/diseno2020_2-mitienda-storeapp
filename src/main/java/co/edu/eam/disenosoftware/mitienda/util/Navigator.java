/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoftware.mitienda.util;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Navigator utilt
 *
 * @author caferrerb
 */
public class Navigator {

  /**
   * current frame
   */
  private static String currentFrame;

  /**
   * current params
   */
  private static Map<String, Object> currentParams;

  /**
   * previous visited frame
   */
  private static final Stack<String> previousFrames = new Stack<>();

  /**
   * params current frame
   */
  private static final Stack<Map<String, Object>> previousParams = new Stack<>();

  /**
   * base pacakage of the frames
   */
  public static String GUI_PACKAGE = "co.edu.eam.disenosoftware.mitienda.userapp.gui";


  /**
   * go to a frame
   *
   * @param frame  frame name
   * @param params params to send
   * @return frame
   */
  public static GroceryFrame goToFrame(String frame, Map<String, Object> params, boolean fromBack) {

    try {
      Constructor ctor = Class.forName(GUI_PACKAGE + "." + frame).getDeclaredConstructor();
      ctor.setAccessible(true);

      GroceryFrame gFrame = (GroceryFrame) ctor.newInstance();
      gFrame.setVisible(true);
      gFrame.setTitle(frame);
      gFrame.setParams(params);

      if (currentFrame != null && !fromBack) {
        previousFrames.push(currentFrame);
        previousParams.push(new HashMap<>(currentParams));
      }

      currentFrame = frame;
      currentParams = params;

      return gFrame;
    } catch (Exception ex) {
      Logger.getLogger(Navigator.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  /**
   * go to a frame without params
   *
   * @param frame frame name
   * @return frame
   */
  public static GroceryFrame goToFrame(String frame) {

    try {
      return goToFrame(frame, new HashMap<>(), false);
    } catch (Exception ex) {
      Logger.getLogger(Navigator.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  /**
   * go to a frame iwth params
   *
   * @param frame frame name
   * @return frame
   */
  public static GroceryFrame goToFrame(String frame, Map<String, Object> params) {

    try {
      return goToFrame(frame, new HashMap<>(), false);
    } catch (Exception ex) {
      Logger.getLogger(Navigator.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }


  /**
   * Go Back
   *
   * @return frame
   */
  public static GroceryFrame goBack() {
    try {
      String frame = previousFrames.pop();

      Map<String, Object> params = previousParams.pop();

      if (frame != null) {
        return goToFrame(frame, params, true);
      }
    } catch (java.util.EmptyStackException exc) {
      return null;
    }
    return null;
  }
}
