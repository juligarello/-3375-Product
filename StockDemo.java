/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;

    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo()
    {
        manager = new StockManager();
        manager.addProduct(new Product(15, "Bread"));
        manager.addProduct(new Product(16, "Cheese"));
        manager.addProduct(new Product(17, "Water"));
        manager.addProduct(new Product(18, "Tea"));
        manager.addProduct(new Product(19, "Oil"));
        manager.addProduct(new Product(20, "Suggar"));
    }
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    public void main()
    {
        // Take delivery of 5 items of one of the products.
        manager.delivery(15, 20);
        manager.delivery(17, 15);
        manager.delivery(18, 30);
        manager.delivery(20, 10);
        manager.printProductDetails();
    }
    
    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void showDetails(int id)
    {
        if (id < 0)
            throw new IllegalArgumentException("Problem searching a non-positive ID");
        Product product = getProduct(id);
        if(product != null) {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id)
    {
        if (id < 0)
            throw new IllegalArgumentException("Problem searching a non-positive ID");
        Product product = getProduct(id);
        int quantity = product.getQuantity();
        if(product != null) {
            product.sellOne();
            showDetails(id);
        }
        assert product.getQuantity() == quantity - 1;
    }
    
    /**
     * Get the product with the given id from the manager.
     * An error message is printed if there is no match.
     * @param id The ID of the product.
     * @return The Product, or null if no matching one is found.
     */
    private Product getProduct(int id)
    {
        if (id < 0)
            throw new IllegalArgumentException("Problem searching a non-positive ID");
        Product product = manager.findProduct(id);
        if(product == null) {
            System.out.println("Product with ID: " + id + " is not recognised.");
        }
        return product;
    }

    /**
     * @return The stock manager.
     */
    public StockManager getManager()
    {
        return manager;
    }
}