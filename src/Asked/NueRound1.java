package Asked;

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



