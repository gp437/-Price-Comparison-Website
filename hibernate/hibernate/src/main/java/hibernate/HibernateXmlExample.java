package hibernate;

//Hibernate imports
import java.util.List;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;


/** Simple Hibernate example that uses XML files to specify the mapping between 
 *  a Bike object and the Bikes table in the price_comparison database. */
public class HibernateXmlExample {
    //Use this class to create new Sessions to interact with the database 
    private SessionFactory sessionFactory;
    
    
    /** Empty constructor */
    HibernateXmlExample() {
    }

    
    /** Sets up the session factory.
     *  Call this method first.
     */
    public void init(){
        try {
            //Create a builder for the standard service registry
            StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();

            //Load configuration from hibernate configuration file
            standardServiceRegistryBuilder.configure("hibernate.cfg.xml"); 

            //Create the registry that will be used to build the session factory
            StandardServiceRegistry registry = standardServiceRegistryBuilder.build();
            
            try {
                //Create the session factory - this is the goal of the init method.
                sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            }
            catch (Exception e) {
                    /* The registry would be destroyed by the SessionFactory, 
                        but we had trouble building the SessionFactory, so destroy it manually */
                    System.err.println("Session Factory build failed.");
                    e.printStackTrace();
                    StandardServiceRegistryBuilder.destroy( registry );
            }

            //Ouput result
            System.out.println("Session factory built.");

        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("SessionFactory creation failed." + ex);
        }
    }
    
    
    /** Closes Hibernate down and stops its threads from running*/
    public void shutDown(){
        sessionFactory.close();
    }

    
    /** Adds a new bike to the database */
    public void addBike(BikeXml bike){
        //Get a new Session instance from the SessionFactory
        Session session = sessionFactory.getCurrentSession();
//
//        //Create an instance of a Cereal class 
//        BikeXml bike = new BikeXml();
//
//        //Set values of bike class that we want to add
//        bike.setBikeDescription(bikescrape1.description.text());
//        bike.setBikeName("Carera");
//        bike.setUrl("halfords");
//        bike.setWeight(5000);
//        bike.setPrice(10.5f);

        //Start transaction
        session.beginTransaction();

        //Add bike to database - will not be stored until we commit the transaction
        session.save(bike);

        //Commit transaction to save it to database
        session.getTransaction().commit();
        
        //Close the session and release database connection
        session.close();
        System.out.println("Bike added to database with ID: " + bike.getId());
    }
    
    
    /** Updates the values of an existing bike in the database */
    public void updateBike(){
        //Get a new Session instance from the session factory
        Session session = sessionFactory.getCurrentSession();

        //Create an instance of a Cereal class 
        BikeXml bike = new BikeXml();
        
        //Set ID of bike class - this controls the row in the table that we want to update
        bike.setId(16);

        //Set new values of Bike class that we want to add
        bike.setBikeDescription("sport 2019");
        bike.setBikeName("Carera");
        bike.setUrlID(1);
        bike.setWeight(900);
        bike.setPrice("229");

        //Start transaction
        session.beginTransaction();

        //Update database to match class 
        session.update(bike);
        session.getTransaction().commit();
        
        //Close the session and release database connection
        session.close();
        System.out.println("Bike updated in database. ID: " + bike.getId());
    }
    
    
    /** Searches for Bikes whose price is 5.5 */
//    public void searchBikes(){
//        //Get a new Session instance from the session factory
//        Session session = sessionFactory.getCurrentSession();
//
//        //Start transaction
//        session.beginTransaction();
//
//        List<BikeXml> bikeList = session.createQuery("from BikeXml where price=d5.5").getResultList();
//        for(BikeXml bike : bikeList){
//            System.out.println(bike.toString());
//        }
//        
//        //Close the session and release database connection
//        session.close();
//    }

    
    /** Deletes an object without a foreign key from the database 
        This will generate an error if there is a foreign key. */
    public void deleteBikeSimple(){
        //Create Bike class with the ID that we want to delete
        BikeXml bike = new BikeXml();
        bike.setId(5);
        
        //Get a new Session instance from the session factory
        Session session = sessionFactory.getCurrentSession();
        
        //Start transaction
        session.beginTransaction();

        //Update database to match class 
        session.delete(bike);
        session.getTransaction().commit();
        
        //Close the session and release database connection
        session.close();
        System.out.println("Bike updated in database. ID: " + bike.getId());
    }
    
    
    /** Deletes a bike in a way that will work with tables with foreign keys */
    public void deleteBikeSafe(){
        //Get a new Session instance from the session factory
        Session session = sessionFactory.getCurrentSession();
        
        //Start transaction
        session.beginTransaction();
        
        //Search for bike in database that has ID of 6
        Object persistentInstance = session.load(BikeXml.class, 16);
        
        //Delete object (and corresponding data) if we have found a match.
        if (persistentInstance != null) 
            session.delete(persistentInstance);

        //Update database
        session.getTransaction().commit();
        
        //Close the session and release database connection
        session.close();
        System.out.println("Bike updated in database. ID: 6");
    }

}