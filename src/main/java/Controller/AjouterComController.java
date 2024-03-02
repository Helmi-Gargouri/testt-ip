package Controller;

import Entites.Commentaire;
import Services.CommentaireService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AjouterComController {
    @FXML
    private TextArea ContenuTA;

    @FXML
    private DatePicker DateDP;
    private final CommentaireService ser = new CommentaireService();
    private int idAct;
    @FXML
    void AjouterCom(ActionEvent event) {
        try {
            String contenuC = ContenuTA.getText();
            Commentaire c = new Commentaire(contenuC);
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Confirmation");
            alert1.setContentText("Commentaire ajouté avec succès");
            alert1.showAndWait();
            ser.ajouter(c);

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }


    public void setActualite(int idAct) {
        this.idAct = idAct;
    }

}
