package Services;
import Entites.Commentaire;
import Utils.ConnexionDB;
import Entites.Actualite;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class ActualiteService implements IService<Actualite> {

    private Connection connection;
    private Statement ste;


    public ActualiteService() {
        connection = ConnexionDB.getInstance().getCon();
    }
    @Override
    public void ajouter(Actualite actualite) {
        String req = "INSERT into actualite(text,date) values ('" + actualite.getText() + "', '" + actualite.getDate() + "');";
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(req);
            System.out.println("Actualite ajoutée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void modifier(Actualite actualite) {
        String req = "UPDATE actualite set text = '" + actualite.getText()+ "', date = '" + actualite.getDate() + "' where id = " + actualite.getId()+ ";";
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(req);
            System.out.println("Actualite modifiée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void supprimer(Actualite actualite) {
        String req = "DELETE from Actualite where id = " + actualite.getId() + ";";
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(req);
            System.out.println("Actualite supprmiée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Actualite> afficher() {
        List<Actualite> Actualite = new ArrayList<>();

        String req = "SELECT * from actualite";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Actualite.add(new Actualite(rs.getInt("id"), rs.getString("text"), rs.getString("date")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return Actualite;
    }

    @Override
    public Actualite findById(int idd) throws SQLException {
        String req = "SELECT * FROM actualite WHERE id_com = " + idd + ";";
        ResultSet res = ste.executeQuery(req);
        if (res.next()) {
            int id = res.getInt(1);
            String text = res.getString(2);
            String date = res.getString(3);
            return new Actualite (id, text, date);
        }
        return null;
    }
}
