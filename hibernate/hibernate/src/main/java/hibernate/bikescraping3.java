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
 * gabriel documentation
 * @author pisla
 */
public class bikescraping3 {
    public String myValue;
     HibernateXmlExample databaseInterface;
 bikescraping3(){
/*     creating new hibernate  and initialise*/
     databaseInterface = new HibernateXmlExample();
        databaseInterface.init();
        try{
            scrapebikes();
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.out.println("given bike not found in website 3");
        }
    }
    
    
    /** Scrapes cornflakes data from the scotbycycles website */
    void scrapebikes() throws Exception{
        //Name of item that we want to scrape
        String itemName = this.myValue;
        
        //Download HTML document from website
        Document doc = Jsoup.connect("https://www.scotbycycles.co.uk/search?type=product%2Carticle%2Cpage&q=" + itemName).get();
        
        //Get all of the products on the page
        Elements prods = doc.select(".o-layout__item");
        
        //Work through the products
        for(int i=0; i<prods.size(); ++i){
            
            //get brand
         //  Elements brand = prods.get(i).select(".");
            
            //Get the product description
            Elements description = prods.get(i).select(".product__details");
            
            //Get the product price
            Elements price = prods.get(i).select(".product__price");
            // "Nrand: " + brand.text()  +
BikeXml bike = new BikeXml();
           bike.setBikeName(myValue);
           bike.setBikeDescription(description.text());
           bike.setPrice(price.text());
           bike.setUrlID(3);
           
           
           //Save bike
           databaseInterface.addBike(bike);
            
            //Output the data that we have downloaded
            System.out.println("DESCRIPTION: " + description.text() +  "; PRICE: " + price.text());
        }
    }
}
