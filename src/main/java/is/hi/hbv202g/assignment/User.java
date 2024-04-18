package is.hi.hbv202g.assignment;

/**
 * Abstrakt klasi sem lýsir grunneiginleikum notanda innan bókasafnskerfisins.
 * Þessi klasi er grunnurinn fyrir öll notendategundir innan kerfisins.
 */
abstract class User {

  private String name; // Nafn notandans

  /**
   * Smiður fyrir User.
   * Setur upphafsgildi fyrir nafn notandans.
   *
   * @param name Nafn notandans.
   */
  public User(String name) {
    this.name = name;
  }

  /**
   * Nær í nafn notandans.
   * @return Nafn notandans.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Uppfærir nafn notandans.
   * @param name Nýtt nafn notandans.
   */
  public void setName(String name) {
    this.name = name;
  }
}
