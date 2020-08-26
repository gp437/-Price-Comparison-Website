package hibernate;


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
public class bikescrape1 {
      public String myValue;

      
      HibernateXmlExample databaseInterface;
      
    /** Constructor */
    bikescrape1(){
        databaseInterface = new HibernateXmlExample();
        databaseInterface.init();
        
        try{
            scrapebikes();
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.out.println("No bike found on website 1");
        }
    }
    void scrapebikes() throws Exception{
        //Name of item that we want to scrape
        
        
       String itemName = this.myValue;
       
        
        //Download HTML document from website
        Document doc = Jsoup.connect("https://www.ribblecycles.co.uk/catalogsearch/result/?q=" + itemName).get();
        
        //Get all of the products on the page
        Elements prods = doc.select(".inner");
        
        //Work through the products
        for(int i=0; i<prods.size(); ++i){
            
            //Get the product description
            
            Elements description = prods.get(i).select(".name");
            
            
            //Geting the product price
            Elements price = prods.get(i).select(".price-box");
           // Elements finalPrice = price1.select(".price-box");
     
           /*Giving bike values */
           BikeXml bike = new BikeXml();
           bike.setBikeName(myValue);
           bike.setBikeDescription(description.text());
           bike.setPrice(price.text());
           bike.setUrlID(1);
           
           
           //Save bike
           databaseInterface.addBike(bike);
           
           
            
            //Output the data that we have downloaded
            System.out.println("DESCRIPTION: " + description.text()  + "; PRICE: " + price.text());
        
        }
    }
}
