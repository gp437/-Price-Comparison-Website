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

public class bikescraping2 {
    public String myValue;
      HibernateXmlExample databaseInterface;
 bikescraping2(){
             databaseInterface = new HibernateXmlExample();
        databaseInterface.init();
        try{
            scrapebikes();
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Bike given not found on this website");
        }
    }
    
    

    void scrapebikes() throws Exception{
        //Name of item that we want to scrape
        String itemName = this.myValue;
        
        //Download HTML document from website
        Document doc = Jsoup.connect("https://www.cyclesurgery.com/brands/" + itemName + ".html").get();
        
        //Get all of the products on the page
        Elements prods = doc.select(".m-product-tile__container");
        
        //Work through the products
        for(int i=0; i<prods.size(); ++i){
            
            //get brand
           Elements brand = prods.get(i).select(".a-brand-name");
            
            //Get the product description
            Elements description = prods.get(i).select(".a-product-name");
            
            //Get the product price
            Elements price = prods.get(i).select(".a-price--sell");

           /*Giving bike values */
           BikeXml bike = new BikeXml();
           bike.setBikeName(myValue);
           bike.setBikeDescription(description.text());
           bike.setPrice(price.text());
           bike.setUrlID(2);
           
           
           //Save bike
           databaseInterface.addBike(bike);
            
            //Output the data that we have downloaded
            System.out.println("DESCRIPTION: " + description.text() + "Nrand: " + brand.text()  + "; PRICE: " + price.text());
        }
    }
}

