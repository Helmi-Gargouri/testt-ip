package Controller;

import Entites.Actualite;
import Services.ActualiteService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.List;

public class AfficherActualiteController {
    private final ActualiteService cs = new ActualiteService();
    private final ImageView imageView = new ImageView();

@FXML
private AnchorPane feed;
    @FXML
    private VBox vbox;

    @FXML
    void ondelete() {
        /*
        Actualite selectedActualite = TableView.getSelectionModel().getSelectedItem();
        if (selectedActualite != null) {
            cs.supprimer(selectedActualite);
            TableView.getItems().remove(selectedActualite);
        } else {
            // Handle case where no actualite is selected
            // You might want to show an error message or provide feedback to the user
        }
        */
    }

    private void actualite(Actualite a) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../AfficherCommentaire.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        AfficherCommentaireController pc=loader.getController();
        feed.getScene().setRoot(root);
    }
    @FXML
    void initialize() {
        GridPane gp= new GridPane();
        gp.setPrefWidth(150);
        feed.getChildren().clear();
        int k=0;
        float x=10,y=10;
        List<Actualite> actualite = cs.afficher();
        ObservableList<Actualite> observableList = FXCollections.observableList(actualite);
        System.out.println(actualite);
        System.out.println(observableList);

        for (Actualite listeActualite:actualite) {
            AnchorPane anchorpane=new AnchorPane();
            Border border = new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN));
            anchorpane.setBorder(border);
/*            Image image = new Image("file:src/assets/" +p.getImage(),200,200,false,false);
            ImageView iv= new ImageView(image);*/

            Label textLable = new Label("Tile :");
            Label text = new Label(listeActualite.getText());
            Label dateLable = new Label("Date :");
            Label date = new Label(listeActualite.getDate().toString());
            anchorpane.setLayoutY(y);
            //iv.setLayoutY(y);
            textLable.setLayoutY(y+30);
            textLable.setLayoutX(x+30);
            text.setLayoutY(y+50);
            text.setLayoutX(x+30);
            //v.setLayoutX(x+100);
            //value.setLayoutY(y+240);

            dateLable.setLayoutY(y+70);
            dateLable.setLayoutX(x+30);
            date.setLayoutY(y+90);
            date.setLayoutX(x+30);
/*
            Button btndelete = new Button("delete");
            Button btnupdate = new Button("update");

            btndelete.setOnMouseClicked(MouseEvent->{
                ondeleteclick(p);
            });


            btnupdate.setLayoutY(y+290);
            btndelete.setLayoutY(y+320);*/
            anchorpane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    actualite(listeActualite);
                }
            });
            anchorpane.getChildren().addAll(text,date,textLable,dateLable);
            if (k==3)
                k=0;
            gp.addColumn(k,anchorpane);
            k++;


            x += 30;

        }
            feed.getChildren().addAll(gp);
            y+=50;
        }

    }
