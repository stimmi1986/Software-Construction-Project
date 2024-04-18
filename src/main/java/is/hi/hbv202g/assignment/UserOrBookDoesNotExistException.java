package is.hi.hbv202g.assignment;

/**
 * Sérsniðin undantekning til að meðhöndla tilvik þar sem notandi eða bók finnst ekki í kerfinu.
 * Þessi undantekning er kölluð þegar tilraun er gerð til að vinna með notanda eða bók sem er ekki til staðar í gagnagrunninum.
 */
public class UserOrBookDoesNotExistException extends Exception {

  /**
   * Smiður sem býr til nýja UserOrBookDoesNotExistException með tilteknu skilaboði.
   *
   * @param message Skilaboð sem lýsa eðli undantekningarinnar.
   */
  public UserOrBookDoesNotExistException(String message) {
    super(message); // Sendir skilaboðin til yfirklasans Exception
  }
}
