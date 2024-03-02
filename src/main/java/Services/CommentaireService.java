package Services;

import Entites.Actualite;
import Entites.Commentaire;
import Utils.ConnexionDB;

import java.sql.*;
import java.util.*;
import java.sql.Date;
public class CommentaireService implements IService<Commentaire>{
    private Connection con= ConnexionDB.getInstance().getCon();

    private Statement ste;

    public CommentaireService()
    {
        try {
            ste= con.createStatement();
        }catch (SQLException e)
        {
            System.out.println(e);
        }


    }
    public void ajouter(Commentaire commentaire) {
        System.out.println(commentaire);

        String req = "INSERT INTO `commentaire`( `id_user`, `id_act`, `contenuC`) "
                +"values ( '" + null +"', '"+commentaire.getId_act()+"','"+commentaire.getContenuC()+"')";
        try {
            Statement st = con.createStatement();
            st.executeUpdate(req);
            System.out.println("Commentaire ajoutée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
/*    @Override
    public void ajouter(Commentaire commentaire) {

        String req = "INSERT INTO commentaire ( contenuC) VALUES ( ?) " ;
             try (PreparedStatement statement = con.prepareStatement(req)) {
                 //statement.setInt(1,commentaire.getId_user());
                 //statement.setInt(2,commentaire.getId_act());
                 statement.setString(1,commentaire.getContenuC());
                // Exécuter la requête d'insertion
                statement.executeUpdate();
                System.out.println("Nouvel commentaire inséré avec succès.");
            }
            catch (SQLException e) {
                 System.out.println("tneknaa") ;
                e.printStackTrace();
            }
    }*/

    @Override
    public void modifier(Commentaire commentaire) throws SQLException {

    }


    @Override
    //done
    public void supprimer(Commentaire commentaire) {
        String req = "DELETE from commentaire where id_c = " + commentaire.getId_c() + ";";
        try {
            Statement st = con.createStatement();
            st.executeUpdate(req);
            System.out.println("supprimée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Commentaire findById(int id) throws SQLException {
        String req = "SELECT * FROM commentaire WHERE id_c = " + id + ";";
        ResultSet res = ste.executeQuery(req);
        if (res.next()) {
            int id_c = res.getInt(1);
            int id_act = res.getInt(2);
            int id_user = res.getInt(3);
            String contenuC = res.getString(4);
            Date dateC = res.getDate(5);

/*            ActualiteService actualiteService = new ActualiteService();
            Actualite actualite = actualiteService.findById(id_act);*/

            return new Commentaire(id_c, id_act, id_user, contenuC);
        }
        return null;
    }

    @Override
    //done
    public List<Commentaire> afficher() throws SQLException {

        List<Commentaire> list=new ArrayList<>();
        ResultSet res=ste.executeQuery("select * from commentaire");
        while (res.next()) {

            int id_c = res.getInt(1);
            int id_act = res.getInt(2);
            int id_user = res.getInt(3);
            String contenuC = res.getString("contenuC");
/*
            ActualiteService actualiteService = new ActualiteService();
            Actualite actualite = actualiteService.findById(id_act);*/

            Commentaire c1 =new Commentaire (id_c,id_act,id_user,contenuC);
            list.add(c1);
        }

        return list;
    }
 /*   public List<Commentaire> readCommentairesForSelectedActualite(Actualite selectedActualite) throws SQLException {
        List<Commentaire> commentairesList = new ArrayList<>();

        // Assuming you have a database connection (conn) and a Statement (ste) in your ServiceForum class
        String query = "SELECT * FROM commentaire WHERE id_act = " + selectedActualite.getId();
        ResultSet resultSet = ste.executeQuery(query);

        while (resultSet.next()) {
            int id_c = resultSet.getInt("id_com");
            int id_act = resultSet.getInt("id_actualite");
            int id_user = resultSet.getInt("id_user");
            String contenuC = resultSet.getString("contenuC");
            Date dateC = resultSet.getDate("dateC");
*//*            ActualiteService actualiteService = new ActualiteService();
            Actualite actualite = actualiteService.findById(id_act);*//*

            Commentaire response =new Commentaire (id_c,id_act,id_user,contenuC);
            commentairesList.add(response);
        }

        return commentairesList;
    }*/

}