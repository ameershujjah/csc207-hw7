package com.farevee.groceries;

/**
 * The interface Item.
 * @author Ameer Shujjah
 *
 */
public interface Item
{
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * To get the weight of the object.
   * @return The weight of the object.
   */
  public Weight getWeight();

  /**
   * To extract the price of the object.
   * @return the price as an int.
   */
  public int getPrice();

  /**
   * To convert the object to a string so it can be printed.
   * @return The string representation of the object.
   */
  public String toString();

  /**
   * Gets the name of the item
   * @return a string, the name of the item.
   */
  public String getName();

} // interface Item
