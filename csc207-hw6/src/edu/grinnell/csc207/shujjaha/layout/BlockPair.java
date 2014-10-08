package edu.grinnell.csc207.shujjaha.layout;

/**
 * Implements the BlockPair class that creates a copy of the given TextBlock.
 * @author Ameer Shujjah
 *
 */
public class BlockPair
    implements TextBlock
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * The TextBlock that is going to be copied.
   */
  TextBlock contents;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Builds a new BlockPair
   * @param tb is the {@link TextBlock} that is going to be copied.
   */
  public BlockPair(TextBlock tb)
  {
    this.contents = tb;
  } // BlockPair(TextBlock)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Get one row from the block.
   * 
   * @pre 0 <= i < this.height()
   * @exception Exception
   *              if the precondition is not met
   */
  public String row(int i)
    throws Exception
  {
    int tbHeight = this.contents.height();
    if ((i >= 0) && (i <= tbHeight))
      {
        return this.contents.row(i) + this.contents.row(i);
      } // if the row is valid
    else
      {
        throw new Exception("Invalid row " + i);
      }// else throw exception

  } // row(int)

  /**
   * Determine how many rows are in the block.
   * @return an int that is the height of the block.
   */
  public int height()
  {
    // The height is the height of the input TextBlock.
    return this.contents.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   * @return the width of the new TextBlock which is twice the width
   * of the old TextBlock. 
   */
  public int width()
  {
    // The width is twice the width of the input TextBlock.
    return 2 * this.contents.width();
  } // width()

} // Class BlockPair
