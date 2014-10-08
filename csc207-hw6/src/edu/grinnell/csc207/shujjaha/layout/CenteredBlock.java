package edu.grinnell.csc207.shujjaha.layout;

/**
 * Implements the CenteredBlock class that centers a Textblock with the given width.
 * @author Ameer Shujjah
 * @author Camila Mateo Volkart
 *
 */
public class CenteredBlock
    implements TextBlock
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * The TextBlock that is going to be centered.
   */
  TextBlock contents;
  /**
   * The width that is going to define the spacing.
   */
  int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Create a new Centered block of the specified width.
   * @param tb is the {@link TextBlock} that is going to be centered.
   * @param width is the width of the new desired centered block.
   * @throws Exception
   *    if the width of block is bigger than the input spacing width.
   */
  public CenteredBlock(TextBlock tb, int width) throws Exception
  {
    if (width < tb.width())
      {
        throw new Exception("Invalid width");
      } // if the width of the TextBlock is bigger than the desired input spacing
    this.contents = tb;
    this.width = width;
  } // CenteredBlock(TextBlock, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Get the ith row of the block.
   * @param i is the index of the row.
   * @throws Exception 
   * @return a string at the ith row.
   */
  public String row(int i)
    throws Exception
  {
    // Determine the width and height of the TextBlock to determine 
    // the spacing required.
    int tbWidth = this.contents.width();
    int tbHeight = this.contents.height();
    int numSpaces = this.width - tbWidth;
    System.out.println("tbWidth = " + tbWidth + "this.width = " + this.width);
    // Pad is the spacing / 2 for either side of the TextBlock.
    String pad;

    if (this.width < tbWidth)
      {
        //System.out.println("bad");
        throw new Exception("Invalid width");
      } // If the width of the block exceeds the desired width of the block.
    else if ((i >= 0) && (i <= tbHeight))
      {
        pad = TBUtils.spaces(numSpaces / 2);
        System.out.println("works, good");
        return pad + this.contents.row(i) + pad;
      } // if the row is valid
    else
      {
        System.out.println("else if");
        throw new Exception("Invalid row " + i);
      }// else throw exception
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
   * Determine how many columns are in the block
   * @return an int that is the width of the block.
   */
  public int width()
  {
    return this.width;
  } // width()
} // Class CenteredBlock
