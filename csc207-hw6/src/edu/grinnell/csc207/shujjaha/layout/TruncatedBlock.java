package edu.grinnell.csc207.shujjaha.layout;

/**
 * Implements the TruncatedBlock class
 * @author Ameer Shujjah
 *
 */
public class TruncatedBlock
    implements TextBlock
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * The TextBlock that is going to be truncated.
   */
  TextBlock contents;
  /**
   * The new width of the truncated block.
   */
  int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Create a new truncated block of the specified width.
   * @param tb the TextBlock that is going to truncated.
   * @param width the new width of the truncated block.
   * @throws Exception 
   *    if the width is not reasonable.
   */
  public TruncatedBlock(TextBlock tb, int width) throws Exception
  {
    if (width < 0)
      {
        throw new Exception("Invalid width");
      } // if the width is negative
    this.contents = tb;
    this.width = width;
  } // TruncatedBlock(TextBlock, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Get the ith row of the block.
   * @param i is the input row index
   * @throws Exception 
   * @return a string at the ith row.
   */
  public String row(int i)
    throws Exception
  {
    int h = this.contents.height();
    if ((i >= 0) && (i <= h))
      {
        return this.contents.row(i).substring(0, this.width);
      } // if the row is valid
    else
      {
        throw new Exception("Invalid row " + i);
      } // else throw exception
  } // row(int)

  /**
   * Determine how many rows are in the block.
   * @return an int that is the height of the block.
   */
  public int height()
  {
    return this.contents.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   * @return an int that is the width of the block.
   */
  public int width()
  {
    return this.width;
  } // width()
} // class TruncatedBlock