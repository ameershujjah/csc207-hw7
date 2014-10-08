package com.farevee.groceries;

/**
 * Implement the Package Class.
 * @author Ameer Shujjah
 *
 */
public class Package
    implements Item
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * The name of the package.
   */
  private String name;
  /**
   * The weight of the package.
   */
  private Weight weight;
  /**
   * The price of the package.
   */
  private int price;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Builds a Package Object.
   * @param name is the name of the package.
   * @param weight is the {@link Weight} of the object.
   * @param price is an int and is the price of the object.
   */
  public Package(String name, Weight weight, int price)
  {
    this.name = name;
    this.weight = weight;
    this.price = price;
  } // Package(String,Weight,int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * The functions gets the weight of the object.
   * @return the {@link Weight}.
   */
  public Weight getWeight()
  {
    return this.weight;
  } // getWeight()

  /**
   * To get the price of the object.
   * @return the price.
   */
  public int getPrice()
  {
    return this.price;
  } // getPrice()

  /** 
   * Returns a string containing information about the object.
   * @return a String with the Package's name and {@link Weight}.
   */
  public String toString()
  {
    return this.getWeight() + " package " + this.getName();
  } // toString()

  /**
   * Checks if the two objects are equal.
   * @param obj an Object to compare with.
   * @return true, if the two objects have the same fields. Otherwise it 
   * is false.
   */
  public boolean equals(Object obj)
  {
    if (obj instanceof Package)
      {
        Package that = (Package) obj;
        if ((this.name.equals(that.name)) && (this.weight.equals(that.weight))
            && (this.price == that.price))
          {
            return true;
          } // if the two objects have the same fields
      } // if the two objects have the same type
    return false;
  } // equals(Object)

  /**
   * Gets the name of the Package.
   * @return a string, the name of the Package.
   */
  public String getName()
  {
    return this.name;
  } // getName()

} // Class Package
