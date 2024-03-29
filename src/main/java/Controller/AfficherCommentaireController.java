package Controller;

import Entites.Commentaire;
import Services.CommentaireService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class AfficherCommentaireController {
    private final CommentaireService cs = new CommentaireService();

    @FXML
    private TableColumn<Commentaire, Integer> id_userCol ;

    @FXML
    private TableColumn<Commentaire, String> id_actCol ;
    @FXML
    private TableColumn<Commentaire, String> contenuCol;

    @FXML
    private TableView<Commentaire> TableView;

    @FXML
    private TableColumn<Commentaire, Date> dateCol;
    @FXML
    void ondelete() throws SQLException {
        Commentaire selectedActualite = TableView.getSelectionModel().getSelectedItem();
        if (selectedActualite != null) {
            cs.supprimer(selectedActualite);
            TableView.getItems().remove(selectedActualite);
        } else {
            // Handle case where no actualite is selected
            // You might want to show an error message or provide feedback to the user
        }
    }

    @FXML
    void initialize() throws SQLException {

        List<Commentaire> commentaire = cs.afficher();
        ObservableList<Commentaire> observableList = FXCollections.observableList(commentaire);
        TableView.setItems(observableList);
        id_userCol.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        id_actCol.setCellValueFactory(new PropertyValueFactory<>("id_act"));
        contenuCol.setCellValueFactory(new PropertyValueFactory<>("contenuC"));
        //dateCol.setCellValueFactory(new PropertyValueFactory<>("dateC"));

    }
}
