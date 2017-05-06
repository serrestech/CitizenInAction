/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communityinaction_citizen;

import database.DbLinker;
import database.Event;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    Event showevent = new Event();
    DbLinker dblinker = new DbLinker();
    private ResultSet result;
    
    @FXML
    public void ViewEvent(MouseEvent event){
        TextAreaDesctription.clear();
        try {
          
          showevent.View(dblinker);
            

        } catch (Exception ex) {
            System.out.println(ex);

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
