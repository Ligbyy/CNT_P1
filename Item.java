

public class Item {
    
    private String itemId, description,stockStatus;
    private int quantity, discount;
    private double unitPrice,discountMultiplier;
    
    public Item(String itemId, String description, String stockStatus, int quantity, double unitPrice) {
        this.itemId = itemId;
        this.description = description;
        if (stockStatus.equalsIgnoreCase("true")) {
            this.stockStatus = "1";
        }else{
            this.stockStatus = "0";
        }
        this.quantity = quantity;
        
        if (quantity >=1 && quantity <= 4) {
            this.discountMultiplier = 0.0;
            this.discount = 0;
        }else if (quantity >=5 && quantity <= 9) {
            this.discountMultiplier = 0.10;
            this.discount = 10;
        }else if (quantity >=10 && quantity <= 14) {
            this.discountMultiplier = 0.15;
            this.discount = 15;
        }else if (quantity >= 15) {
            this.discountMultiplier = 0.20;
            this.discount = 20;
        }
        this.unitPrice = unitPrice - (unitPrice * discountMultiplier);
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getDiscountMultiplier() {
        return discountMultiplier;
    }

    public void setDiscountMultiplier(double discountMultiplier) {
        this.discountMultiplier = discountMultiplier;
    }

    @Override
    public String toString() {
        return itemId + " \"" + description + "\"" + " $" + unitPrice + " " + stockStatus + " " + discount + "% $" + unitPrice;
    }

    
    
    
    
}
