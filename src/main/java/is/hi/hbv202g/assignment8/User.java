package is.hi.hbv202g.assignment8;

abstract class User {

  private String name;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User(String name) {
    this.name = name;
  }
}
