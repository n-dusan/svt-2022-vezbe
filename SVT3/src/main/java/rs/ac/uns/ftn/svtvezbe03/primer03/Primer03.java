package rs.ac.uns.ftn.svtvezbe03.primer03;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

@SpringBootApplication
public class Primer03 implements CommandLineRunner {

    private static String driver;
    private static String connectionUrl;
    private static String username;
    private static String password;

    public static void main(String[] args) {
        SpringApplication.run(Primer03.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Inializacija parametara za konektovanje ka bazi
        initializeDatabaseProperties();

        // Ucitavanje H2 drajvera
        Class.forName(driver);

        // Povezivanje na bazu podataka
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        // Dodavanje novih nastavnika
        CallableStatement callableStatement = connection.prepareCall("{ CALL helloWorld (?, ?)}");

        callableStatement.setString(1, "Pera");
        callableStatement.setString(2, "Peric");

        // Izvrsavanje funkcije
        callableStatement.executeUpdate();

        // Zatvaranje veze
        callableStatement.close();
        connection.close();
    }

    private void initializeDatabaseProperties() throws IOException {
        Properties databaseProperties = loadDatabasePropertiesFromFile();

        driver = databaseProperties.getProperty("db.driver");
        connectionUrl = databaseProperties.getProperty("db.connectionUrl");
        username = databaseProperties.getProperty("db.username");
        password = databaseProperties.getProperty("db.password");
    }

    private Properties loadDatabasePropertiesFromFile() throws IOException {
        ClassLoader classLoader = Primer03.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("application.properties");

        Properties properties = new Properties();
        properties.load(inputStream);

        return properties;
    }
}
