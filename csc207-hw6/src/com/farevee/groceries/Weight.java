package com.farevee.groceries;

/**
 * Implements the Weight class.
 * @author Ameer Shujjah
 *
 */
public class Weight
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * The {@link Units} of the weight.
   */
  private Units unit;
  /**
   * The amount of the weight.
   */
  private int amount;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Builds a new weight.
   * @param unit is the {@link Units} of the weight.
   * @param amount is an int and is the amount of the weight.
   */
  public Weight(Units unit, int amount)
  {
    this.unit = unit;
    this.amount = amount;
  } // Weight(Units,int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Represents pertinent weight information as a string.
   * @return a String with the weight's amount and units.
   */
  public String toString()
  {
    return this.amount + " " + this.unit;
  } // toString()

  /**
   * To check if the two objects are equal.
   * @return true, if the two objects are weights and have the same fields. 
   * Otherwise it return false.
   */
  public boolean equals(Object obj)
  {
    if (obj instanceof Weight)
      {
        Weight that = (Weight) obj;
        if (this.unit.equals(that.unit) && (this.amount == that.amount))
          {
            return true;
          } // if the two weights have the same fields
      } // if the two objects are weights.
    return false;
  } // equals(Object)

  /**
   * Returns the {@link Units} of the weight.
   * @return the Units of the weight.
   */
  public Units getUnits()
  {
    return this.unit;
  } // getUnits()
  
  /**
   * Returns the amount of the weight.
   * @return the amount of the weight.
   */
  public int getAmount()
  {
    return this.amount;
  } // getAmount()
} // Class Weight
