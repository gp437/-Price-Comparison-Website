package hibernate;

/** Represents a Bike */
public class BikeXml {
    private int id;
    private String bikeName;
    private String bikeDescription;
    private int weight;
    private int urlID;
    private String price;
    
    
    /** Empty constructor */
    public BikeXml(){
    }

    
    //Getters and setters
    public int getId() {
        return id;
    }
    public String getBikeName() {
        return bikeName;
    }
    public String getBikeDescription() {
        return bikeDescription;
    }
    public int getWeight() {
        return weight;
    }
    public int getUrlID() {
        return urlID;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }
    public void setBikeDescription(String bikeDescription) {
        this.bikeDescription = bikeDescription;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setUrlID(int urlID) {
        this.urlID = urlID;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    
    /** Returns a String description of the class */
    public String toString(){
        String str = "Bike. id: " + id + "; productTypeId: " + bikeName + "; brandId: " +
                 bikeDescription + "; url: " + urlID + "; price: " + price + "; weight: " + weight;
        return str;
    } 
}
