/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *gabriel documentation
 * @author pisla
 */
public class bikescraping5 {
      public String myValue;
      HibernateXmlExample databaseInterface;
    /** this is a Constructor */
    bikescraping5(){
        databaseInterface = new HibernateXmlExample();
        databaseInterface.init();
        
        try{
            scrapebikes();
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.out.println("No bike found on website 5");
        }
    }
    void scrapebikes() throws Exception{
        //Name of item that we want to scrape
       String itemName = this.myValue;
        //Download HTML document from website
        Document doc = Jsoup.connect("https://www.evanscycles.com/" + itemName + "_b").get();
        
        //Get all of the products on the page
        Elements prods = doc.select(".product");
        
        //Work through the products
        for(int i=0; i<prods.size(); ++i){
            
            //Get the product description
            
            Elements description = prods.get(i).select(".title");
          
            //Geting the product price
            Elements price = prods.get(i).select(".price");
           // Elements finalPrice = price1.select(".price-box");
  
           /*Giving bike values */
           BikeXml bike = new BikeXml();
           bike.setBikeName(myValue);
           bike.setBikeDescription(description.text());
           bike.setPrice(price.text());
           bike.setUrlID(5);
           //Save bike
           databaseInterface.addBike(bike);
   
            //Output the data that we have downloaded
            System.out.println("DESCRIPTION: " + description.text()  + "; PRICE: " + price.text());
        
        }
    }
}
