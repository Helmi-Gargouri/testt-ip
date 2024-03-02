/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*

package Controller;

import Entites.Actualite;
import Services.ActualiteService;
import edu.dottn.entities.Category;
import edu.dottn.entities.Product;
import edu.dottn.entities.SubCategory;
import edu.dottn.entities.User;
import edu.dottn.services.CategoryServices;
import edu.dottn.services.ProductServices;
import edu.dottn.services.SubCategoryServices;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ModifierActualite implements Initializable {

    @FXML
    private TextArea ActualiteTA;

    @FXML
    private TextField TitreTF;

    @FXML
    private Button BtnAfficher;

    @FXML
    private Button BtnAjouter;

    @FXML
    private Label inputcontrol;

    @FXML
    private DatePicker DateDP;
    @FXML
    private String imagePath;

    @FXML
    private Button btnUpload;
    ActualiteService as = new ActualiteService();
    Product p=new Product();
    String imagename;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         List<Actualite> l = as.afficher();
        List<String> l1 = new ArrayList<>();

        for (int i = 0; i < l.size(); i++) {

            l1.add(l.get(i).getName());

        }

        category.setItems(FXCollections.observableArrayList(l1));


    }
public void setInformation(User u) {
         user = u;
    }
    public void setproduct(Product product){
          p=new Product(product.getId(),product.getName(),product.getDescription(),product.getImage(),product.getPrice(),product.getSubCategory().getId(),user.getIdUser());
          System.out.println(p);
          inputcontrol.setText("");
        System.out.println(p);
        tfName.setText(p.getName());
        tfDescription.setText(p.getDescription());
        tfValue.setText(String.valueOf(p.getPrice()));
        Category c =cs.getById(p.getSubCategory().getCategory().getId());
        category.setValue(c.getName());
        subcategory.setValue(p.getSubCategory().getName());
        Image image1 = new Image("file:src/assets/" + p.getImage());
            image.setImage(image1);
            imagename=p.getImage();

    }

    @FXML
    private void updateproduct(ActionEvent event) {

             if ((tfName.getText() == null || tfName.getText().isEmpty())) {
          inputcontrol.setText("You didn't enter a title!");
        }
             else if ((tfDescription.getText() == null || tfDescription.getText().isEmpty())) {
          inputcontrol.setText("You didn't enter a description!");
        } else
        if ((tfValue.getText() == null || tfValue.getText().isEmpty())) {
          inputcontrol.setText("You didn't enter a value!");
        }
         else
        if (imagename == null ) {
          inputcontrol.setText("You didn't enter an image!");
        }
         else
        if ((category.getValue() == null || category.getValue().isEmpty())) {
          inputcontrol.setText("You didn't choose a category!");
        }
         else
        if ((subcategory.getValue() == null || subcategory.getValue().isEmpty())) {
          inputcontrol.setText("You didn't choose a subcategory!");
        }else


        {
        List<SubCategory> l = (List<SubCategory>) scs.getByName(subcategory.getValue());
        float value=Float.parseFloat(tfValue.getText());
        p.setName(tfName.getText());
        p.setDescription(tfDescription.getText());
        p.setPrice(value);
        p.setImage(imagename);
        p.setSubcategory(l.get(0));
        System.out.println(p);
         Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to update this product", ButtonType.YES,ButtonType.NO);
        a.showAndWait().ifPresent(type -> {
        if (type == ButtonType.YES) {
            ps.modifyProduct(p);

        Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Product modified !", ButtonType.FINISH);
        a1.showAndWait();
       gotolistproduct(event);
        }
        else if (type == ButtonType.NO) {
            a.close();
        } ;

        });}

    }
    @FXML
    void choisirImage(ActionEvent event) {
        try {
            // Créer un FileChooser
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", ".png", ".jpg", "*.jpeg"));

            // Ouvrir le FileChooser
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                // Obtenir le chemin de l'image
                imagePath = file.getPath().replace("\\", "/");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void cancel(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/feedproductFXML.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        btnncancel.getScene().setRoot(root);
    }


}
*/
