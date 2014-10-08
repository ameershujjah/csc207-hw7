package com.farevee.groceries;

/**
 * Creates a new class BulkFood for our grocery modeling.
 * @author Ameer Shujjah
 *
 */
public class BulkFood
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The name of BulkFood
   */
  private String name;

  /**
   * The units of BulkFood
   */
  private Units unit;

  /**
   * The price per unit of the BulkFood
   */
  private int pricePerUnit;

  /**
   * The supply of the BulkFood
   */
  private int supply;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Builds a new BulkFood object.
   * @param name the name of the BulkFood.
   * @param unit the {@link Units} of the BulkFood.
   * @param pricePerUnit the price per unit of the BulkFood.
   * @param supply the supply of the BulkFood.
   */
  public BulkFood(String name, Units unit, int pricePerUnit, int supply)
  {
    this.name = name;
    this.unit = unit;
    this.pricePerUnit = pricePerUnit;
    this.supply = supply;
  } // BulkFood(String,Units,int,int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Checks if the two objects are equal.
   * @param obj the object reference with which to compare.
   * @return a boolean value, if the objects are equal it returns true, otherwise false.
   */
  public boolean equals(Object obj)
  {
    if (obj instanceof BulkFood)
      {
        BulkFood that = (BulkFood) obj;
        if ((this.name.equals(that.name)) && (this.unit.equals(that.unit))
            && (this.pricePerUnit == that.pricePerUnit)
            && (this.supply == that.supply))
          {
            return true;
          } // if the fields of the objects are the same
      } // if the two objects are the same type
    return false;
  } // equals(Object)

  /**
   * Decrement the supply of the BulkFood when the corresponding BulkItem is added. 
   */
  public void decrementSupply(int num)
  {
    this.supply -= num;
  } // decrementSupply(int)
  
  
  /**
   * Gets the name of the BulkFood.
   * @return a string, the name of the BulkFood.
   */
  public String getName()
  {
    return this.name;
  } // getName()
  
  /**
   * Get the Units of the BulkFood
   * @return the units.
   */
  public Units getUnits()
  {
    return this.unit;
  } // getUnits
  
  /**
   * Get the price per unit of the BulkFood.
   * @return an int, the price per unit.
   */
  public int getPricePerUnit()
  {
    return this.pricePerUnit;
  } // getPricePerUnit();
  
  /**
   * Get the supply of the BulkFood
   * @return an int, the supply.
   */
  public int getSupply()
  {
    return this.supply;
  } // getSupply()
} // Class BulkFood
