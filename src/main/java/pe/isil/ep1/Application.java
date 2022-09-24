package pe.isil.ep1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);

        //Load driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Create connection
        Connection connexion= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/movies",
                "root",
                "root"
        );
/*
        //Create Statement LISTAR REGISTROS
        Statement st = connexion.createStatement();

        ResultSet listar = st.executeQuery("select * from Movie");

        while (listar.next()){
            System.out.println(listar.getString("title")+"\n"+
                    "Director: "+listar.getString("director")+"\n"+
                    "Protagonistas: "+listar.getString("stars")+"\n"+
                    "Música: "+listar.getString("music")+"\n"+
                    "Duración: "+listar.getString("runTime")+" minutos"+"\n"+
                    "País: "+listar.getString("country")+"\n"+
                    "Género: "+listar.getString("filmGenre")+"\n"+
                    "Sinopsis: "+listar.getString("plot")+"\n");
        }
*/

        //Create Statement INSERTAR REGISTROS

        PreparedStatement preparedStatement = connexion.prepareStatement("insert into Movie values(?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1,12);
        preparedStatement.setString(2,"Licorice Pizza");
        preparedStatement.setString(3,"Paul Thomas Anderson");
        preparedStatement.setString(4,"Alana Haim,Cooper Hoffman");
        preparedStatement.setString(5,"Jonny Greenwood");
        preparedStatement.setInt(6,133);
        preparedStatement.setString(7,"Estados Unidos");
        preparedStatement.setString(8,"Drama histórico, comedia");
        preparedStatement.setString(9,"Alana Kane y Gary Valentine crecen, viven y se enamoran en el Valle de San Fernando, en California, durante la década de 1970.");


        int filasafectadas= preparedStatement.executeUpdate();
        System.out.println("Filas afectadas: "+filasafectadas);

        //Search item






    }

}
