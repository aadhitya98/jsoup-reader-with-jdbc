import com.mongodb.*;
import com.sun.xml.internal.ws.developer.MemberSubmissionEndpointReference;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import javax.swing.text.Document;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;

import java.io.InputStream;

public class springstruts {

    public static void main(String args[]) throws Exception, IOException, SQLException, ClassNotFoundException {


        //MongoClient mongo = new MongoClient( "localhost" , 27017 );
        //MongoCredential credential;
        // credential = MongoCredential.createCredential("username", "mydatabase",
        //        "password".toCharArray());
        //DB db = mongo.getDB("mydatabase");
        //DBCollection table = db.getCollection("user");
        //System.out.println("Connected to the database successfully");
        //int choice;

        //System.out.println("Enter 1 for Spring");
        //System.out.println("Enter 2 for Struts");
        //Scanner sc=new Scanner(System.in);
        //System.out.println("Enter the choice");
        //choice=sc.nextInt();
        //switch(choice)
        //{
        // case 1:
        //{
        try {
            final String springcount;
            final String strutscount;
            final org.jsoup.nodes.Document document = (org.jsoup.nodes.Document) Jsoup.connect("https://stackoverflow.com/questions/tagged/spring").get();
            //Elements
            springcount = document.select("div.summarycount").text();
            System.out.println("The total Spring tags are" + springcount);

            //Element spring= document.getElementById("summarycount");
            //}
            //case 2:
            //{
            final org.jsoup.nodes.Document document1 = (org.jsoup.nodes.Document) Jsoup.connect("https://stackoverflow.com/questions/tagged/struts").get();
            strutscount = document1.select("div.summarycount").text();
            System.out.println("The total Struts tags are" + strutscount);


        //break;

        // }


        //}
        //BasicDBObject doc = new BasicDBObject();
        //doc.put("Spring", springcount);
        //doc.put("Struts", strutscount);

            String url = "jdbc:mysql://127.0.0.1:3306/stackoverflow";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
           // Class.forName("java.sql.Driver");

            Connection conn = DriverManager.getConnection(url, user,pass);
            String sql = "INSERT INTO count1 (spring, struts) VALUES(?, ?)";
           /* Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO count " + "VALUES ('Spring', '133,832')");
            statement.executeUpdate("INSERT INTO count " +
                    "VALUES ('Struts', '3,459')");*/
           // String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, springcount);
            statement.setString(2, strutscount);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("JDBC is Established!!!!!!!!!!!!!!!!!!!!!");
            }

            // PreparedStatement statement = conn.prepareStatement(sql);
            //statement.setString(1, springcount);
            //statement.setString(2, strutscount);
            conn.close();

        } catch (Exception e) {
            System.out.println("this "+e);
        }
    }
}
