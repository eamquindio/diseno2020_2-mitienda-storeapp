package co.edu.eam.disenosoftware.mitienda.model.requests;

/**
 * Store's request class
 */
public class StoreLoginRequest {

  /**
   * Email - store's
   */
  private String email;

  /**
   * Password - store's
   */
  private String password;

  /**
   * Constructor
   *
   * @param email    email, Store's email
   * @param password password, Store's password
   */
  public StoreLoginRequest(String email, String password) {
    this.email = email;
    this.password = password;
  }

  /**
   * GetEmail
   *
   * @return Store's email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set Email
   *
   * @param email Store's email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Get password
   *
   * @return Store's password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set password
   *
   * @param password Store's password
   */
  public void setPassword(String password) {
    this.password = password;
  }
}
