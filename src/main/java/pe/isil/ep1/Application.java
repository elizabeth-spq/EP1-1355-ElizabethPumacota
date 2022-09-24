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


        // INSERTAR REGISTROS

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
        Statement st2= connexion.createStatement();
        ResultSet newInsert = st2.executeQuery("select * from movie where id='13'");

        while (newInsert.next()){

            System.out.println("REGISTRO INSERTADO"+"\n"+newInsert.getString("title")+"\n"+
                    "Director: "+newInsert.getString("director")+"\n"+
                    "Protagonistas: "+newInsert.getString("stars")+"\n"+
                    "Música: "+newInsert.getString("music")+"\n"+
                    "Duración: "+newInsert.getString("runTime")+" minutos"+"\n"+
                    "País: "+newInsert.getString("country")+"\n"+
                    "Género: "+newInsert.getString("filmGenre")+"\n"+
                    "Sinopsis: "+newInsert.getString("plot")+"\n");
        }


        // LISTAR REGISTROS
        Statement st = connexion.createStatement();

        ResultSet listar = st.executeQuery("select * from Movie");

        while (listar.next()){
            System.out.println("LISTA DE PELICULAS"+"\n"+listar.getString("title")+"\n"+
                    "Director: "+listar.getString("director")+"\n"+
                    "Protagonistas: "+listar.getString("stars")+"\n"+
                    "Música: "+listar.getString("music")+"\n"+
                    "Duración: "+listar.getString("runTime")+" minutos"+"\n"+
                    "País: "+listar.getString("country")+"\n"+
                    "Género: "+listar.getString("filmGenre")+"\n"+
                    "Sinopsis: "+listar.getString("plot")+"\n");
        }




        //ACTUALIZAR REGISTROS
        CallableStatement callActualizar = connexion.prepareCall("{call actualizar(?,?)}");
        callActualizar.setInt(1,1);
        callActualizar.setString(2,"Drama Historico,Romance");

        ResultSet resultSetSP1 = callActualizar.executeQuery();

        int filasafectadas2= callActualizar.executeUpdate();
        System.out.println("Filas afectadas: "+filasafectadas2);

        //Search item
        PreparedStatement updateitem =
                connexion.prepareStatement("select * from movie where id=?");

        updateitem.setInt(1,1);

        ResultSet newIntem2 = updateitem.executeQuery();

        while (newIntem2.next()){
            System.out.println("REGISTRO ACTUALIZADO"+"\n"+newIntem2.getString("title")+"\n"+
                    "Género: "+newIntem2.getString("filmGenre")+"\n");
        }


        //ELIMINAR REGISTRO

        CallableStatement callEliminar = connexion.prepareCall("{call eliminar(?)}");
        callEliminar.setInt(1,13);

        ResultSet resultSetSP2 = callEliminar.executeQuery();

        System.out.println("REGISTRO ELIMINADO");

//CERRAR

        connexion.close();

    }

}
