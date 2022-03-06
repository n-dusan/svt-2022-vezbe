package rs.ac.uns.ftn.svtvezbe03.primer04;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

@SpringBootApplication
public class Primer04 implements CommandLineRunner {

    private static String driver;
    private static String connectionUrl;
    private static String username;
    private static String password;

    public static void main(String[] args) {
        SpringApplication.run(Primer04.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {

            // Inializacija parametara za konektovanje ka bazi
            initializeDatabaseProperties();

            // Ucitavanje H2 drajvera
            Class.forName(driver);

            // Povezivanje na bazu podataka
            Connection connection1 = DriverManager.getConnection(connectionUrl, username, password);
            Connection connection2 = DriverManager.getConnection(connectionUrl, username, password);
            connection1.setAutoCommit(false);

            // Testiranje threadova
            System.out.println("TEST - START");

            Thread1 thread1 = new Thread1();
            Thread2 thread2 = new Thread2();

            thread1.setConnection(connection1);
            thread2.setConnection(connection2);

            thread1.start();
            thread2.start();

            System.out.println("TEST - END");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeDatabaseProperties() throws IOException {
        Properties databaseProperties = loadDatabasePropertiesFromFile();

        driver = databaseProperties.getProperty("db.driver");
        connectionUrl = databaseProperties.getProperty("db.connectionUrl");
        username = databaseProperties.getProperty("db.username");
        password = databaseProperties.getProperty("db.password");
    }

    private Properties loadDatabasePropertiesFromFile() throws IOException {
        ClassLoader classLoader = Primer04.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("application.properties");

        Properties properties = new Properties();
        properties.load(inputStream);

        return properties;
    }
}
