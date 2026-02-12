package Asked;

/*
Problem: Quote Line Item Price Rollup Calculator

Context: In a CPQ/RevOps system, you need to calculate aggregated pricing for quote line items that may have complex hierarchies (bundles with options) and various discount types.

Requirements:
Given a list of quote line items with parent-child relationships (bundle structure)
Each line has: listPrice, quantity, discount%, discountAmount, optional parentId
Calculate the final totalPrice for each line, bundle, and the overall quote total
Handle both percentage and flat discounts (only one applies per line)
Parent bundle prices should include all child option prices
Return the hierarchy with calculated totals

Input Quote Example:
[
  { "id": "1", "name": "Software Bundle", "listPrice": 1000, "quantity": 1, "discountPercentage": 10, "parentId": null }, // 900 + 450 + 510 + 750
  { "id": "2", "name": "Premium Support", "listPrice": 500, "quantity": 1, "discountAmount": 50, "parentId": "1" }, // 450
  { "id": "3", "name": "Training", "listPrice": 300, "quantity": 2, "discountPercentage": 15, "parentId": "1" } // 510 + 750
  { "id": "4", "name": "More Training", "listPrice": 150, "quantity": 5, "discountPercentage": 0, "parentId": "3" } // 750
]


Expected Output: Calculated totals with proper hierarchy aggregation
*/
import java.util.*;
import java.math.*;

enum DiscountType {
    PERCENTAGE,
    AMOUNT
};

interface Item {
    public String getName();
    public BigDecimal getPrice();
    public DiscountType getDiscountType();
    public int getQuantity();
    public double getDiscountValue();
    public BigDecimal getDiscountedLinePrice();
    public Item getParent();
    public BigDecimal getLinePrice();
}

class Product implements Item {
    private int id;
    private String name;
    private DiscountType type;
    private double discountValue;
    private BigDecimal price;
    private int quantity;
         
    public Product(int id, String name, DiscountType type, double discountValue, BigDecimal price, int quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.discountValue = discountValue;
        this.price = price;
        this.quantity = quantity;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public DiscountType getDiscountType() {
        return type;
    }
    
    @Override
    public BigDecimal getPrice() {
        return price;
    }
    
    @Override
    public BigDecimal getLinePrice() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public double getDiscountValue() {
        return discountValue;
    }
    
    @Override
    public BigDecimal getDiscountedLinePrice() {
         BigDecimal disc = BigDecimal.ZERO;
        if(type == DiscountType.PERCENTAGE) {
             disc = price.multiply(BigDecimal.valueOf(discountValue));
        }
        if(type == DiscountType.AMOUNT) {
             disc = BigDecimal.valueOf(discountValue);
        }   
        return getLinePrice().subtract(disc);
    }

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Item getParent() {
		// TODO Auto-generated method stub
		return null;
	}
   
}



