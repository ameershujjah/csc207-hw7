package com.farevee.groceries;

/**
 * The BulkItem class that implement Item.
 * @author Ameer Shujjah
 *
 */
public class BulkItem
    implements Item
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * The BulkFood in the {@link BulkItem}.
   */
  private BulkFood food;

  /**
   * The units of the item.
   */
  private Units unit;

  /**
   * The amount of the item.
   */
  private int amount;

  /**
   * The weight of the item.
   */
  private Weight weight;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Builds a new BulkItem.
   * @param food the type of BulkItem, an object of type {@link BulkFood}.
   * @param unit the units of the BulkItem, an object of type {@link Units}.
   * @param amount the amount of the BulkItem
   */
  public BulkItem(BulkFood food, Units unit, int amount)
  {
    this.food = food;
    this.unit = unit;
    this.amount = amount;
    //Decrement supply
    this.food.decrementSupply(this.amount);
  } // BulkItem(BulkFood, Units, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Returns the weight of the BulkItem.
   * @return Weight the weight of the BulkItem built using the item's unit and amount.
   */
  public Weight getWeight()
  {
    return new Weight(this.unit, this.amount);
  } // getWeight()

  /**
   * Get the Price of the BulkItem
   * @return int, the price.
   */
  public int getPrice()
  {
    return this.amount * this.food.getPricePerUnit();
  } // getPrice()

  /**
   * Convert the BulkItem to a string so it can be printed.
   * @return a String.
   */
  public String toString()
  {
    return this.amount + " " + this.unit + " of " + this.food.getName();
  } // toString()

  /**
   * Checks if the two objects are equal.
   * @param obj the object reference with which to compare.
   * @return a boolean value, if the objects have the same fields true, otherwise false.
   */
  public boolean equals(Object obj)
  {
    if (obj instanceof BulkItem)
      {
        BulkItem that = (BulkItem) obj;
        if ((this.food.equals(that.food)) && (this.unit.equals(that.unit))
            && (this.amount == that.amount)
            && (this.weight.equals(that.weight)))
          {
            return true;
          } // if the two objects have the same fields
      } // if the two objects are the same type
    return false;
  } // equals(Object)

  /**
   * Gets the name of the BulkFood.
   * @return a string, the name of the BulkFood.
   */
  public String getName()
  {
    return this.food.getName();
  } // getName()

  /**
   * Returns the BulkFood in the BulkItem.
   * @return the BulkFood.
   */
  public BulkFood getFood()
  {
    return this.food;
  } // getBulkFood

  /**
   * Returns the Units of the BulkItem.
   * @return the Units.
   */
  public Units getUnits()
  {
    return this.unit;
  } // getUnits()

  /**
   * Get the amount of the BulkItem.
   * @return an int, the amount.
   */
  public int getAmount()
  {
    return this.amount;
  } // getAmount()

} // Class BulkItem
