package hibernate;

/**
 * Simple Hibernate example
 */
public class Main {

    public static void main(String[] args) throws Exception {
        /* 
        This is the scraping part
         */
        String itemSearch = "cannondale";
        /*first bike scrape*/
        
        bikescrape1 scrape1 = new bikescrape1();
        scrape1.myValue = itemSearch;
        scrape1.scrapebikes();

        /*second bike scrape*/
        bikescraping2 scrape2 = new bikescraping2();
        scrape2.myValue = itemSearch;
        scrape2.scrapebikes();

        /*third bike scrape*/
        bikescraping3 scrape3 = new bikescraping3();
        scrape3.myValue = itemSearch;
        scrape3.scrapebikes();

        /*fourth bike scrape*/
        bikescraping4 scrape4 = new bikescraping4();
        scrape4.myValue = itemSearch;
        scrape4.scrapebikes();

        /*fifth bike scrape*/
        bikescraping5 scrape5 = new bikescraping5();
        scrape5.myValue = itemSearch;
        scrape5.scrapebikes();

        HibernateXmlExample hibernateXmlExample = new HibernateXmlExample();

        //Set up the SessionFactory
        hibernateXmlExample.init();
        //Example operations
        // hibernateXmlExample.addBike();//Add data
        // hibernateXmlExample.updateBike();//Updates data
        //hibernateXmlExample.searchBikes();//Search for data
        //hibernateXmlExample.deleteBikeSafe();//Delete data
        /*Shut down Hibernate*/
        hibernateXmlExample.shutDown();
    }

}
