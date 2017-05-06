/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communityinaction_citizen;

import database.DbLinker;
import database.Event;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Xristos Aslamagidis
 */
public class FXMLViewEventsController implements Initializable {

    @FXML
    private Label LabelTitle;

    @FXML
    private Label LabelType;

    @FXML
    private Label LabelLocation;

    @FXML
    private TextArea TextAreaDesctription;

    @FXML
    private Button refreshButton;

    @FXML
    private Button exitButton;

    @FXML
    private ListView ListViewEvent;

    @FXML
    ObservableList<String> items = FXCollections.observableArrayList();

    Event showevent = new Event();
    DbLinker dblinker = new DbLinker();
    private ResultSet result;

    @FXML
    public void ViewEvent(MouseEvent event) {
        TextAreaDesctription.clear();
        
        String currentItem = ListViewEvent.getSelectionModel().getSelectedItem().toString();

        try {
            String query = "select * from events where title like '" + currentItem + "'";
            result = dblinker.getSt().executeQuery(query);

            while (result.next()) {
                TextAreaDesctription.setText(result.getString("description"));
                LabelTitle.setText(result.getString("title"));
                LabelType.setText(result.getString("event_type"));
                LabelLocation.setText(result.getString("location"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

     @FXML
    public void refreshList(ActionEvent event) throws IOException {

        ListViewEvent.getItems().clear();

        try {
            String query = "select * from events";
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
            String query = "select * from events";
            result = dblinker.getSt().executeQuery(query);

            while (result.next()) {
                String description = result.getString("title");
                items.add(description);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        ListViewEvent.setItems(items);
        ListViewEvent.getFocusModel().focus(0);

    }

}
