package com.farevee.groceries;

/**
 * The NonFood Class
 * @author Ameer Shujjah
 *
 */
public class NonFood
    implements Item
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * The name of the NonFood item.
   */
  private String name;
  /**
   * The weight of the item.
   */
  private Weight weight;
  /**
   * The price of the item.
   */
  private int price;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Builds a new NonFood object.
   * @param name is the name of the NonFood object.
   * @param weight is the {@link Weight} of the object.
   * @param price is the price of the object.
   */
  public NonFood(String name, Weight weight, int price)
  {
    this.name = name;
    this.weight = weight;
    this.price = price;
  } // NonFood(String,Weight,int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Returns the weight of the object.
   * @return the {@link Weight}.
   */
  public Weight getWeight()
  {

    return this.weight;
  } // getWeight()

  /**
   * Returns the price of the object.
   * @return the price.
   */
  public int getPrice()
  {

    return this.price;
  } // getPrice()

  /**
   * Outputs the name of the objects so it can be printed.
   * @return the name of the NonFood object.
   */
  public String toString()
  {
    return this.name;
  } // toString()

  /**
   * Checks if the two objects are equal.
   * @param obj an object to compare with.
   * @return true, if the two objects have the same field. Otherwise it 
   * returns false.
   */
  public boolean equals(Object obj)
  {
    if (obj instanceof NonFood)
      {
        NonFood that = (NonFood) obj;
        if ((this.name.equals(that.name)) && (this.weight.equals(that.weight))
            && (this.price == that.price))
          {
            return true;
          } // if the fields of the two objects are the same
      } // if the two objects are the same type
    return false;
  } // equals(Object)
  
  
  /**
   * Gets the name of the NonFood.
   * @return a string, the name of the NonFood.
   */
  public String getName()
  {
    return this.name;
  } // getName()
} // Class NonFood
