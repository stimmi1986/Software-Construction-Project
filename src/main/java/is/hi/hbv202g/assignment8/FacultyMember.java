package is.hi.hbv202g.assignment8;

class FacultyMember extends User {

  private String department;

  public String getDepartment() {
    return this.department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public FacultyMember(String name, String department) {
    super(name);
    this.setDepartment(department);
  }
}
