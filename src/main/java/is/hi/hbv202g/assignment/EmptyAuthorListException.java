package is.hi.hbv202g.assignment;

/**
 * Sérsniðin undantekning til að meðhöndla tilvik þar sem bók hefur enga höfunda.
 * Þessi undantekning er kölluð þegar tilraun er gerð til að vinna með lista af höfundum sem er tómur.
 */
public class EmptyAuthorListException extends Exception {

  /**
   * Smiður sem býr til nýja EmptyAuthorListException með tilteknu skilaboði.
   *
   * @param message Skilaboð sem lýsa eðli undantekningarinnar.
   */
  public EmptyAuthorListException(String message) {
    super(message); // Sendir skilaboðin til yfirklasans Exception
  }
}
