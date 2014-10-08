package edu.grinnell.csc207.shujjaha.layout;

/**
 * Implements the RightJustified class that right justifies a TextBlock.
 * @author Ameer Shujjah
 *
 */
public class RightJustified
    implements TextBlock
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * The TextBlock to be right justified.
   */
  TextBlock contents;

  /**
   * The desired width.
   */
  int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Create a RightJustified {@link TextBlock} with the desired width.
   * @param tb is the TextBlock to be right justified.
   * @param width is the desired width of the new block.
   * @throws Exception
   *    if the width of the TextBlock is less than the desired width.
   */
  public RightJustified(TextBlock tb, int width) throws Exception
  {
    if (width < tb.width())
      {
        throw new Exception("Invalid width");
      } // if the TextBlock's width is less than the input width.
    this.contents = tb;
    this.width = width;
  } // RightJustified(TextBlock, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Get the ith row of the block.
   * @param i is the index of the row
   * @return the string corresponding to the row.
   * @throws Exception 
   *    if the row index is invalid.
   */
  public String row(int i)
    throws Exception
  {
    // Get the width and height of the TextBlock and determine the spacing.
    int tbWidth = this.contents.width();
    int tbHeight = this.contents.height();
    int numSpaces = this.width - tbWidth;
    String pad; 
    
    if (this.width < tbWidth)
      {
        throw new Exception("Invalid width");
      } // If the width of the block exceeds the desired width of the block.
    else if ((i >= 0) && (i <= tbHeight))
      {
        pad = TBUtils.spaces(numSpaces);
        return pad + this.contents.row(i);
      } // if the row is valid
    else
      {
        throw new Exception("Invalid row " + i);
      }// else throw exception

  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height()
  {
    return this.contents.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   * @return a int that is the width of the block.
   */
  public int width()
  {
    return this.width;
  } // width()

} // Class RightJustified
