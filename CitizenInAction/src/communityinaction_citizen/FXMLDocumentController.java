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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    
    //@FXML
   // private Button ReportButton; afairesh meta

   
    
    

    Problem problem = new Problem();
    DbLinker dblinker = new DbLinker();
   

    @FXML
    public void Submit(ActionEvent event) {
        problem.setTitle(TextFieldTitle.getText().trim());
        problem.setRoad(TextFieldRoad.getText().trim());
        problem.setNumberOfRoad(TextFieldRoadNumber.getText().trim());
        problem.setArea(TextFieldArea.getText().trim());
        problem.setDescription(TextAreaDescription.getText().trim());

        try {

            problem.InsertProblem(dblinker);

        } catch (Exception ex) {
            System.out.println(ex);

        }

    }
    
  
    @FXML
    private void handleButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
