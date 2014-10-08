package com.farevee.groceries;

/**
 * Units of measurement.  The primary units available at 
 * Units.GRAM, Units.KILOGRAM, Units.OUNCE, and Units.POUND.
 */
public class Units
{
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The name of the unit.
   */
  String name;

  /**
   * The abbreviation of the unit.
   */
  String abbrev;

  /**
   * The plural name of the unit.
   */
  String plural;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new unit with a given name.
   */
  private Units(String name, String abbrev, String plural)
  {
    this.name = name;
    this.abbrev = abbrev;
    this.plural = plural;
  } // Units(String, String, String)

  // +-----------+---------------------------------------------------
  // | Accessors |
  // +-----------+

  /**
   * Get the unit name.
   */
  public String toString()
  {
    return this.name;
  } // toString()

  /**
   * Get the abbreviation of the unit name.
   */
  public String abbrev()
  {
    return this.abbrev;
  } // abbrev()

  /**
   * Get the plural of the unit name.  (One does not always form a plural
   * by just adding "s", so we provide this additional method.)
   */
  public String plural()
  {
    return this.plural;
  } // plural

  // Citation : When discussing part D with Albert, he came up
  // with the idea of adding a equals method in the Units class which
  // I have also implemented to make the getWeight() method in Cart class
  // easier.

  /**
   * Checks whether the two objects are equal.
   * @param obj the object reference with which to compare.
   * @return true if the two objects have the same fields, otherwise
   * it returns false.
   */
  public boolean equals(Object obj)
  {
    if (obj instanceof Units)
      {
        Units that = (Units) obj;
        if ((this.name.equals(that.name) && (this.abbrev.equals(that.abbrev)) 
            && (this.plural.equals(that.plural))))
          {
            return true;
          } // If all the fields are the same.
      } // If obj is a Units object
    return false;
  } // equals(Object)

  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * Standard unit: Pounds
   */
  public static final Units POUND = new Units("pound", "lb.", "pounds");

  /** 
   * Standard unit: Ounces
   */
  public static final Units OUNCE = new Units("ounce", "oz.", "ounces");

  /**
   * Standard unit: Kilograms
   */
  public static final Units KILOGRAM =
      new Units("kilogram", "kg.", "kilograms");

  /**
   * Standard unit: Grams
   */
  public static final Units GRAM = new Units("gram", "gm.", "grams");

} // class Units