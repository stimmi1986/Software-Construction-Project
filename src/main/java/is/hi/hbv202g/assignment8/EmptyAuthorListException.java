package is.hi.hbv202g.assignment8;

public class EmptyAuthorListException extends java.lang.Exception {

  public EmptyAuthorListException(String message) throws java.lang.Exception {
    try {
      throw new java.lang.Exception();
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}
