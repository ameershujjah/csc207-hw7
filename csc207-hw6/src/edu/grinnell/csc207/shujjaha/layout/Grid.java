package edu.grinnell.csc207.shujjaha.layout;

/**
 * Implement the Grid class.
 * @author Ameer Shujjah
 *
 */
public class Grid
    implements TextBlock
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * The string that would represent each line in the block.
   */
  String contents;
  /**
   * The height of the block.
   */
  int height;
  /**
   * The width of the block.
   */
  int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Build a new Grid.
   * @param width is the desired width of the grid.
   * @param height is the desired height of the grid.
   * @param ch is the character the grid is going to be made of.
   * @throws Exception
   *    if the width and height are not reasonable values.
   */
  public Grid(int width, int height, char ch) throws Exception
  {
    if ((height <= 0) || (width <= 0))
      {
        throw new Exception(
                            "Please choose appropriate values of width and height");
      }
    this.width = width;
    this.height = height;
    // The first character.
    this.contents = String.valueOf(ch);
    for (int j = 1; j < this.width; j++)
      {
        this.contents += ch;
      } // for loop, that loops over the width of the grid starting at index 1
    // adding the characters to the string.
  } // Grid(int,int,char)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Get one row from the block.
   * @param i is the index of the row
   * @pre
   *   0 <= i < this.height()
   * @exception Exception
   *   if the precondition is not met
   * @return a string corresponding to the input row.
   */
  public String row(int i)
    throws Exception
  {
    if ((i >= 0) && (i <= this.height))
      {
        return this.contents;
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

    return this.height;
  } // height()

  /**
   * Determine how many columns are in the block.
   * @return the width of the new TextBlock which is twice the width
   * of the old TextBlock.
   */
  public int width()
  {
    return this.width;
  } // width()

} // Class Grid
