package is.hi.hbv202g.assignment;

/**
 * Lýsir höfundi innan bókasafnskerfisins.
 * Hver höfundur hefur nafn og getur verið tengdur við eina eða fleiri bækur.
 */
public class Author {

  private String name; // Nafn höfundarins

  /**
   * Smiður fyrir Author.
   * Býr til nýjan höfund með gefnu nafni.
   *
   * @param name Nafn höfundarins.
   */
  public Author(String name) {
    this.name = name;
  }

  /**
   * Nær í nafn höfundarins.
   * @return Nafn höfundarins.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Setur nýtt nafn fyrir höfundinn.
   * @param name Nýtt nafn höfundarins.
   */
  public void setName(String name) {
    this.name = name;
  }
}
