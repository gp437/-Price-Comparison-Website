package hibernate;


import hibernate.BikeXml;
import hibernate.HibernateXmlExample;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *gabriel documentation
 * @author pisla
 */

public class bikescraping4 {
    

      public String myValue;

      
      HibernateXmlExample databaseInterface;
      
    /** Constructor */
    bikescraping4(){
        databaseInterface = new HibernateXmlExample();
        databaseInterface.init();
        
        try{
            scrapebikes();
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.out.println("No bike found on website 4");
        }
    }
    void scrapebikes() throws Exception{
        //Name of item that we want to scrape
       String itemName = this.myValue;
        //Download HTML document from website
        Document doc = Jsoup.connect("https://www.sigmasports.com/bikes/" + itemName).get();
        
        //Get all of the products on the page
        Elements prods = doc.select(".product");
        
        //Work through the products
        for(int i=0; i<prods.size(); ++i){
            
            //Get the product description
            
            Elements description = prods.get(i).select(".heading");
            
            
            //Geting the product price
            Elements price = prods.get(i).select(".price-holder");
           // Elements finalPrice = price1.select(".price-box");
     
           /*Giving bike values */
           BikeXml bike = new BikeXml();
           bike.setBikeName(myValue);
           bike.setBikeDescription(description.text());
           bike.setPrice(price.text());
           bike.setUrlID(4);
           
           
           //Save bike
           databaseInterface.addBike(bike);
           
           
            
            //Output the data that we have downloaded
            System.out.println("DESCRIPTION: " + description.text()  + "; PRICE: " + price.text());
        
        }
    }
}
