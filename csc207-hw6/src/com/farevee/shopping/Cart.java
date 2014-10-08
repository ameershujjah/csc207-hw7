package com.farevee.shopping;

import java.io.PrintWriter;
import java.util.ArrayList;

import com.farevee.groceries.*;
import com.farevee.groceries.Package;

/**
 * Implements a shopping cart building on the groceries model.
 * @author Ameer Shujjah
 * @author Camila Mateo
 * @version 1.1 of October 2014
 */
public class Cart
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * The total items in the array
   */
  public int totalThings;
  /**
   * Total entries in the array
   */
  public int totalEntries;
  /**
   * Total price of all the items
   */
  public int totalPrice;
  /**
   * An array with the total Weight of all the items.
   */
  public Weight[] totalWeight;
  /**
   * An ArrayList of {@link Item} with all the items in the cart.
   */
  public ArrayList<Item> cart;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Builds a new cart.
   */
  public Cart()
  {
    this.totalThings = 0;
    this.totalEntries = 0;
    this.totalPrice = 0;
    this.cart = new ArrayList<Item>();
  } // Cart()

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Adds an item to the cart and updates totalThings, totalEntries
   * and totalPrice.
   * @param thing is an object of type {@link Item}
   */
  public void addItem(Item thing)
  {
    if (thing instanceof ManyPackages)
      {
        this.totalThings += ((ManyPackages) thing).getCount();
        this.totalEntries++;
        this.totalPrice += thing.getPrice();
        cart.add(thing);
      } // if thing is a ManyPackages object
    else
      {
        this.totalThings++;
        this.totalEntries++;
        this.totalPrice += thing.getPrice();
        cart.add(thing);
      } // else
  } // addItem

  /**
   * Returns the totalThings in the cart
   * @return an int, the totalThings.
   */
  public int numThings()
  {
    return this.totalThings;
  } // numThings()

  /**
   * Return the totalEntries in the cart
   * @return an int, the totalEntries.
   */
  public int numEntries()
  {
    return this.totalEntries;
  } // numEntries()

  /**
   * Prints all the items in the cart
   * @param pen is of type PrintWriter which is used to print the items.
   */
  public void printContents(PrintWriter pen)
  {
    for (Item item : cart)
      {
        pen.println(item);
      } // for, iterate over each element in the ArrayList cart
  } // printContents(PrintWriter)

  /**
   * Returns the total price of all the items in the cart.
   * @return an int, the totalPrice.
   */
  public int getPrice()
  {
    return this.totalPrice;
  } // getPrice()

  // Citation : When discussing this part with Albert, he came up
  // with the idea of adding an equals method in the Units class which
  // I have also implemented. 

  /**
   * Gets the weights of all the items in the cart.
   * @return an array of {@link Weight}s, with weights having 
   * similar units grouped together.
   */
  public Weight[] getWeight()
  {
    // Initialize the total unit amounts
    int totalPound = 0;
    int totalOunce = 0;
    int totalKilogram = 0;
    int totalGram = 0;

    for (Item item : cart)
      {
        // Get the Units and amount of each weight
        Units unit = item.getWeight().getUnits();
        int amount = item.getWeight().getAmount();

        if (unit.equals(Units.POUND))
          {
            totalPound += amount;
          } // if the item has units POUND
        else if (unit.equals(Units.OUNCE))
          {
            totalOunce += amount;
          } // else if the item has units OUNCE
        else if (unit.equals(Units.KILOGRAM))
          {
            totalKilogram += amount;
          } // else if the item has units KILOGRAM
        else if (unit.equals(Units.GRAM))
          {
            totalGram += amount;
          } // else if the item has units GRAM
      } // for, iterate over all the items in the cart

    // Create new pounds corresponding to the total amounts and Units
    Weight Pounds = new Weight(Units.POUND, totalPound);
    Weight Ounces = new Weight(Units.OUNCE, totalOunce);
    Weight Kilograms = new Weight(Units.KILOGRAM, totalKilogram);
    Weight Gram = new Weight(Units.GRAM, totalGram);

    // Update totalWeight with the new Weights
    this.totalWeight = new Weight[] { Pounds, Ounces, Kilograms, Gram };
    return totalWeight;
  } // getWeight()

  /**
   * Removes the items in the cart with names matching the input name.
   * @param name, a String
   */
  public void remove(String name)
  {
    Item thing;
    for (int i = 0; i < cart.size(); i++)
      {
        thing = cart.get(i);
        if (thing.getName().equals(name))
          {
            if (thing instanceof ManyPackages)
              {
                // Decrement the fields of the Cart accordingly
                this.totalThings -= ((ManyPackages) thing).getCount();
                this.totalEntries--;
                this.totalPrice -= thing.getPrice();
                cart.remove(thing);
              } // if the name matches an entry in the cart of type ManyPacakges
            else
              {
                // Decrement the fields of the Cart accordingly
                this.totalThings--;
                this.totalEntries--;
                this.totalPrice -= thing.getPrice();
                cart.remove(thing);
              } // else
            i--; // decrement i after removing an element
          } // if, an element in the cart matches the input name
      } // for, iterate over all the elements in the ArrayList
  } // remove(String)

  // Copied from EBoard - Samuel Rebelsky's code
  /**
   * Remove the jth item in the cart, putting the last value in 
   * position j.  Return the new length.
   */
  int replace(int j)
  {
    int last = this.cart.size() - 1;
    this.cart.set(j, this.cart.get(last));
    this.cart.remove(last);
    return last;
  } // replace(int)

  /**
   * Finds and merges identical items in the cart.
   */
  // Citation, based off the code written by Zoe Walter and Samuel Rebelsky
  public void merge()
  {
    // Initialize item1 and item2 which are going to be used in the 
    // iterations.
    Item item1;
    Item item2;
    // Get the length of the cart for each iteration as its length changes when we
    // delete items
    for (int i = 0; i < cart.size(); i++)
      {
        item1 = cart.get(i);
        for (int j = i + 1; j < cart.size(); j++)
          {
            item2 = cart.get(j);
            if (item1 instanceof Package)
              {
                if ((item2 instanceof Package) && item1.equals(item2))
                  {
                    ManyPackages temp = new ManyPackages((Package) item1, 2);
                    // Remove the jth element, update the ith element
                    // with the new object and don't let j increment
                    replace(j);
                    j--;
                    this.cart.set(i, temp);
                  } // if, item2 is a Package and equal to item2
              } // if, item1 is a Package

            else if (item1 instanceof ManyPackages)
              {
                if ((item2 instanceof Package)
                    && (((ManyPackages) item1).getPackage().equals(item2)))
                  {
                    ManyPackages temp =
                        new ManyPackages((Package) item2,
                                         ((ManyPackages) item1).getCount() + 1);
                    // Remove the jth element, update the ith element
                    // with the new object and don't let j increment
                    replace(j);
                    j--;
                    this.cart.set(i, temp);
                  } // if, item2 is a package and equal to the package in item1 

                else if ((item2 instanceof ManyPackages)
                         && (((ManyPackages) item1).getPackage().equals(((ManyPackages) item2).getPackage())))
                  {
                    ManyPackages temp =
                        new ManyPackages(
                                         ((ManyPackages) item2).getPackage(),
                                         ((ManyPackages) item1).getCount()
                                             + ((ManyPackages) item2).getCount());
                    // Remove the jth element, update the ith element
                    // with the new object and don't let j increment
                    replace(j);
                    j--;
                    this.cart.set(i, temp);
                  } // else if, item2 is a ManyPackages object with the same Package as item1
              } // if, item1 is a ManyPackages object

            else if (item1 instanceof BulkItem)
              {
                if ((item2 instanceof BulkItem)
                    && (((BulkItem) item2).getFood().equals(((BulkItem) item1).getFood()))
                    && (((BulkItem) item2).getUnits().equals(((BulkItem) item1).getUnits())))
                  {
                    BulkItem temp =
                        new BulkItem(((BulkItem) item1).getFood(),
                                     ((BulkItem) item1).getUnits(),
                                     ((BulkItem) item1).getAmount()
                                         + ((BulkItem) item2).getAmount());
                    // Remove the jth element, update the ith element
                    // with the new object and don't let j increment
                    replace(j);
                    j--;
                    this.cart.set(i, temp);
                  } // if, item2 is also a BulkItem and with the same BulkFood and Units
              } // if, item1 is a BulkItem
          } // for, check with every other item in the cart
      } // for, each item in the cart
  } // merge()

} // Class Cart

