package co.edu.eam.disenosoftware.mitienda.model.requests;

/**
 * Store's request class
 */
public class StoreLoginRequest {

  /**
   * email - store's
   */
  private String email;

  /**
   * password - store's
   */
  private String password;

  /**
   * Constructor
   * @param email email, Store's email
   * @param password password, Store's password
   */
  public StoreLoginRequest(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
