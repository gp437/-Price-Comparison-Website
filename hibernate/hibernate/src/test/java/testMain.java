
import hibernate.Main;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pisla
 */
public class testMain {
    @Test
public void testMain() throws IOException, Exception {
    System.out.println("main");
    String[] args = null;
    final InputStream original = System.in;
    final FileInputStream fips = new FileInputStream(new File("[path_to_file]"));
    System.setIn(fips);
    Main.main(args);
    System.setIn(original);
}
}
