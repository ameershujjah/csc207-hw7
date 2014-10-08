package com.farevee.groceries;

/**
 * A class for the BulkContainer that extends BulkItem.
 * @author Ameer Shujjah
 */
public class BulkContainer
    extends BulkItem
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The name of the container
   */
  private String container;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Builds a new BulkContainer.
   * @param name The name of the container.
   * @param food an object of type {@link BulkFood} for the inherited class.
   * @param unit an Object of type {@link Units}.
   * @param amount an int defining the amount of the {@link BulkItem}. 
   */
  public BulkContainer(String name, BulkFood food, Units unit, int amount)
  {
    super(food, unit, amount);
    this.container = name;
  }// BulkContainer(String, BulkFood, Units, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Represents the object in string form so that it can be printed.
   * @return A string with the container name and the corresponding BulkItem fields.
   */
  @Override
  public String toString()
  {
    return this.getName()+ " " + super.toString();
  } // toString()

  /**
   * Checks if the two objects are equal.
   * @param obj the object reference with which to compare.
   * @return a boolean value, if the objects are equal it returns true, otherwise false.
   */
  public boolean equals(Object obj)
  {
    if (obj instanceof BulkContainer)
      {
        BulkContainer that = (BulkContainer) obj;
        if ((this.container.equals(that.container)) && super.equals(that))
          {
            return true;
          } // if the two objects have the same fields
      } // if the two objects are of the same type
    return false;
  } // equals (Object)
  
  /**
   * Gets the name of the container.
   * @return a string, the name of the container.
   */
  public String getName()
  {
    return this.container;
  } // getName()
} // Class BulkContainer
