/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communityinaction_citizen;

import database.Announcements;
import database.DbLinker;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Xristos Aslamagidis
 */
public class FXMLViewAnnouncementsController implements Initializable {

    @FXML
    private Label LabelTitle;

    @FXML
    private Label LabelRealiability;

    @FXML
    private Label LabelType;

    @FXML
    private Label LabelRoad;

    @FXML
    private Label LabelPostcode;

    @FXML
    private TextArea TextAreaDesctription;

    @FXML
    private Button refreshButton;

    @FXML
    private Button exitButton;

    @FXML
    private ListView ListViewAnnouncement;

    @FXML
    ObservableList<String> items = FXCollections.observableArrayList();

    @FXML
    Label selectLabel;

    @FXML
    Button backButton;

    Announcements shownnouncement = new Announcements();
    DbLinker dblinker = new DbLinker();
    private ResultSet result;

    @FXML
    public void ViewAnnouncement(MouseEvent event) {
        if (!LabelTitle.isVisible()) {
            LabelTitle.setVisible(true);
            LabelRealiability.setVisible(true);
            LabelType.setVisible(true);
            TextAreaDesctription.setVisible(true);
            LabelRoad.setVisible(true);
            LabelPostcode.setVisible(true);
            selectLabel.setVisible(false);
        }
        TextAreaDesctription.clear();
        String currentItem = ListViewAnnouncement.getSelectionModel().getSelectedItem().toString();

        try {
            String query = "select * from announcements where title like '" + currentItem + "'";
            result = dblinker.getSt().executeQuery(query);

            while (result.next()) {
                LabelTitle.setText(result.getString("title"));
                LabelRealiability.setText(result.getString("reliability"));
                LabelType.setText(result.getString("an_type"));
                TextAreaDesctription.setText(result.getString("description"));
                LabelRoad.setText(result.getString("road"));
                LabelPostcode.setText(result.getString("postcode"));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLHomePage.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    @FXML 
    public void exitApplication(ActionEvent event){
        System.exit(0);
    }

    @FXML
    public void refreshList(ActionEvent event) throws IOException {
        if (LabelTitle.isVisible()) {
            LabelTitle.setVisible(false);
            LabelRealiability.setVisible(false);
            LabelType.setVisible(false);
            TextAreaDesctription.setVisible(false);
            LabelRoad.setVisible(false);
            LabelPostcode.setVisible(false);
            selectLabel.setVisible(true);
        }
        ListViewAnnouncement.getItems().clear();

        try {
            String query = "select * from announcements";
            result = dblinker.getSt().executeQuery(query);

            while (result.next()) {
                String description = result.getString("title");
                items.add(description);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        try {
            String query = "select * from announcements";
            result = dblinker.getSt().executeQuery(query);

            while (result.next()) {
                String description = result.getString("title");
                items.add(description);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        ListViewAnnouncement.setItems(items);
        ListViewAnnouncement.getFocusModel().focus(0);
    }

}
