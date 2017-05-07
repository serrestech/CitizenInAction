/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communityinaction_citizen;

import database.DbLinker;
import database.Problem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Xristos Aslamagidis
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ChoiceBox ChoiceBoxType;

    @FXML
    private TextField TextFieldTitle;

    @FXML
    private TextField TextFieldRoad;

    @FXML
    private TextField TextFieldRoadNumber;

    @FXML
    private TextField TextFieldArea;

    @FXML
    private TextArea TextAreaDescription;

    @FXML
    private Button Submit;

    @FXML
    private Button Clear;

    @FXML
    private Button BackButton;

    Problem problem = new Problem();
    DbLinker dblinker = new DbLinker();

    @FXML
    public void Submit(ActionEvent event) {
        problem.setTitle(TextFieldTitle.getText().trim());
        problem.setRoad(TextFieldRoad.getText().trim());
        problem.setNumberOfRoad(TextFieldRoadNumber.getText().trim());
        problem.setArea(TextFieldArea.getText().trim());
        problem.setDescription(TextAreaDescription.getText().trim());
        problem.setTypeOfProblem(ChoiceBoxType.getSelectionModel().getSelectedItem().toString());

        if (!problem.getTitle().equals("")) {
            try {

                problem.InsertProblem(dblinker);

            } catch (Exception ex) {
                System.out.println(ex);

            }
        } else {
            TextFieldTitle.requestFocus();
        }

    }

    @FXML
    public void Back(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLHomePage.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    public void Clear(ActionEvent event) {
        TextFieldTitle.clear();
        TextFieldRoad.clear();
        TextFieldRoadNumber.clear();
        TextFieldArea.clear();
        TextAreaDescription.clear();

    }

    @FXML
    private void handleButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
               ChoiceBoxType.setItems(FXCollections.observableArrayList("Lighting","Road", "Road signs"));
 
    }

}
