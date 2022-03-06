package rs.ac.uns.ftn.svtvezbe03.primer04;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Thread2 extends Thread {

    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void run() {

        Statement statement = null;
        ResultSet resultSet = null;
        System.out.println("THREAD 2 - Start");

        try {

            System.out.println("THREAD 2 - SLEEP FOR FIRST TIME");
            Thread2.sleep(1000);
            System.out.println("THREAD 2 - WAKE UP FOR FIRST TIME");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try{

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM nastavnici");

            while(resultSet.next()){
                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
            }


        }catch(SQLException sqlex){
            sqlex.printStackTrace();
        }

        try {
            System.out.println("THREAD 2 - SLEEP FOR SECOND TIME");
            Thread2.sleep(1000);
            System.out.println("THREAD 2 - WAKE UP FOR SECOND TIME");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try{

            resultSet = statement.executeQuery("SELECT * FROM nastavnici");

            while(resultSet.next()){
                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
            }

            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("THREAD 2 - Stop");

        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}

