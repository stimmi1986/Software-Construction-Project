package is.hi.hbv202g.assignment;

/**
 * Lýsir nemandanum innan bókasafnskerfisins.
 * Þessi klasi erfir frá User og bætir við breytu til að fylgjast með hvort skráningargjald hafi verið greitt.
 */
class Student extends User {

  private boolean feePaid; // Greiðslustöðu fyrir skráningargjald

  /**
   * Smiður fyrir Student.
   * Býr til nýjan nemanda með gefnu nafni og greiðslustöðu.
   *
   * @param name Nafn nemandans.
   * @param feePaid Boolean gildi sem sýnir hvort skráningargjaldið hafi verið greitt.
   */
  public Student(String name, boolean feePaid) {
    super(name); // Kalla á smið í yfirklasa User
    this.feePaid = feePaid;
  }

  /**
   * Skilar greiðslustöðu fyrir skráningargjald nemandans.
   * @return true ef gjaldið hefur verið greitt, annars false.
   */
  public boolean isFeePaid() {
    return this.feePaid;
  }

  /**
   * Uppfærir greiðslustöðu fyrir skráningargjald nemandans.
   * @param feePaid Nýtt gildi fyrir greiðslustöðu.
   */
  public void setFeePaid(boolean feePaid) {
    this.feePaid = feePaid;
  }
}
