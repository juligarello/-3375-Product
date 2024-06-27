import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        if (item == null)
            throw new IllegalArgumentException("This item is null");
        for(int i = 0; i < stock.size(); i++)
        {
            if(stock.get(i).getID() == item.getID())
            {
                throw new IllegalArgumentException("invalid ID");
            }    
        }
        for(int j = 0; j < stock.size(); j++)
        {
            if(stock.get(j).getName().equals(item.getName()))
            {
                throw new IllegalArgumentException("invalid Name");
            }    
        }
        stock.add(item);
        assert RepOK();
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        if (id < 0)
            throw new IllegalArgumentException("Problem searching a non-positive ID");
        if (amount < 0)
            throw new IllegalArgumentException("Problem to increase the quantity with a non-positive amount");
        int index = 0;
        boolean found = false;
        while (index < stock.size() || found == false)
        {
            if (stock.get(index).getID() == id)
            {
                stock.get(index).increaseQuantity(amount);
                found = true;
            }
            index++;
        }
        assert RepOK();
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        if (id < 0)
            throw new IllegalArgumentException("Problem searching a non-positive ID");
        int index = 0;
        while (index < stock.size())
        {
            if (stock.get(index).getID() == id)
            {
                return stock.get(index);
            }
            index++;
        }
        assert RepOK();
        return null;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        if (id < 0)
            throw new IllegalArgumentException("Problem searching a non-positive ID");
        int index = 0;
        int inStock = 0;
        boolean found = false;
        while (index < stock.size() || found == false)
        {
            if (stock.get(index).getID() == id)
            {
                found = true;
                inStock = stock.get(index).getQuantity();
            }
            index++;
        }
        assert RepOK();
        return inStock;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for (Product print : stock)
        {
            System.out.println("*************************");
            System.out.println(print.toString());
        }
    }
    
    private boolean RepOK()
    {
        if(stock == null)
            throw new IllegalStateException("The array stock is null");
        return true;
    }
}