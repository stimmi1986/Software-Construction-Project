package is.hi.hbv202g.assignment;

/**
 * Lýsir kennara við háskóla eða menntastofnun.
 * Inniheldur upplýsingar um deild sem kennari tilheyrir.
 * Erfir frá User klössunum sem lýsir almennum eiginleikum notenda.
 *
 * @author Nafn höfundar
 * @version 1.0
 */
class FacultyMember extends User {

  private String department; // Deild sem kennari tilheyrir

  /**
   * Smiður fyrir FacultyMember.
   * @param name Nafn kennarans.
   * @param department Deild sem kennari tilheyrir.
   */
  public FacultyMember(String name, String department) {
    super(name); // Kalla á smið í yfirklasa User
    this.setDepartment(department); // Stillir deild kennarans
  }

  /**
   * Nær í deild kennarans.
   * @return Nafn deildarinnar sem kennarinn tilheyrir.
   */
  public String getDepartment() {
    return this.department;
  }

  /**
   * Uppfærir deild kennarans.
   * @param department Nýtt deildarheiti.
   */
  public void setDepartment(String department) {
    this.department = department;
  }
}
