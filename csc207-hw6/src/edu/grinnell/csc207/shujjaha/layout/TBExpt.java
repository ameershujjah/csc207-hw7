package edu.grinnell.csc207.shujjaha.layout;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.2 of September 2014
 */
public class TBExpt
{
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args)
    throws Exception
  {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);
/*
    // Create a block to use
    TextBlock hello = new BoxedBlock(new TextLine("Hello"));

    TextBlock grid = new BoxedBlock(new Grid(7, 3, '*'));
    // Truncated Block test
    TBUtils.print(pen, hello);
    // Print out the block
    TBUtils.print(pen, grid);
    TextBlock trun =
        new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock trun2 = new TruncatedBlock(trun, 3);
    TBUtils.print(pen, trun);
    TBUtils.print(pen, trun2);
    
    // Centered Block test
    TextBlock block1 =
        new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock block2 = new BoxedBlock(new CenteredBlock(block1, 11));
    TBUtils.print(pen, block2);

    TextBlock top = new CenteredBlock(new TextLine("Hello"), 11);
    TextBlock bottom = new CenteredBlock(new TextLine("Goodbye"), 11);
    TextBlock block = new BoxedBlock(new VComposition(top, bottom));
    TBUtils.print(pen, block);

    // RightJustified Test
    TextBlock blockRJ =
        new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock blockRJ1 = new BoxedBlock(new RightJustified(blockRJ, 11));
    TBUtils.print(pen, blockRJ1);

    TextBlock topRJ = new RightJustified(new TextLine("Hello"), 11);
    TextBlock bottomRJ = new RightJustified(new TextLine("Goodbye"), 11);
    TextBlock blockrj = new BoxedBlock(new VComposition(topRJ, bottomRJ));
    TBUtils.print(pen, blockrj);

    // BlockPair Test

    TextBlock blockBP =
        new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock blockBP1 = new BoxedBlock(new BlockPair(blockBP));
    TBUtils.print(pen, blockBP1);

    TextBlock topBP = new TextLine("Hello");
    TextBlock bottomBP = new TextLine("Goodbye");
    TextBlock blockbp = new BoxedBlock(new BlockPair(topBP));
    TBUtils.print(pen, blockbp);
    TextBlock blockbp2 = new BoxedBlock(new BlockPair(bottomBP));
    TBUtils.print(pen, blockbp2);

   // Mutable Text
    TextLine mutable = new TextLine("hello");
    TBUtils.print(pen, mutable);
    mutable.setContents("Goodbye");
    TBUtils.print(pen, mutable);

    TextLine tb1 = new TextLine("Hello");
    TextLine tb2 = new TextLine("World");
    TextBlock compound = new BoxedBlock(new CenteredBlock(new BoxedBlock(
       new CenteredBlock(new VComposition(tb1, tb2), 7)), 15));
    TextBlock compound2 = new BoxedBlock(new VComposition(tb1, tb2));
    TBUtils.print(pen, compound2);
    pen.println("ORIGINAL");
    TBUtils.print(pen, compound);
    tb2.setContents("Someone");
    pen.println("UPDATED");
    TBUtils.print(pen, compound);
    tb1.setContents("Nice to meet you,");
    TBUtils.print(pen, compound2);
    pen.println("RE-UPDATED");
    TBUtils.print(pen, compound); 
    
    
    */
    
    TextLine tb1 = new TextLine("Hello");
    TextBlock compound = new BoxedBlock(new CenteredBlock(tb1, 7));
    TBUtils.print(pen, compound);
    tb1.setContents("Camila Mateo Volkart");
    TBUtils.print(pen, compound);
    
    pen.close();
    
  } // main(String[])
} // class TBExpt
