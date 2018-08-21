/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudencryption;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author koko_
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXButton StartBtn;
    @FXML
    private JFXTextField EmailTxt;
    @FXML
    private Label error;
    @FXML
    private JFXPasswordField PassTxt;
    
    

    private Pattern VALID_EMAIL_PATTERN = null;
    private Pattern VALID_PORT_NUMBER = null;
    private final String Email_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private final String PORT_NUMBER = "^([0-9]{1,4}|[1-5][0-9]{4}|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]|6553[0-5])$";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        VALID_EMAIL_PATTERN = Pattern.compile(Email_PATTERN, Pattern.CASE_INSENSITIVE);
        //VALID_PORT_NUMBER = Pattern.compile(PORT_NUMBER, Pattern.CASE_INSENSITIVE);
//        
//        IPTxt.setText("127.0.0.1");
//        PortTxt.setText("2500");
//        
//        IPTxt.setOnKeyPressed(e->onEnter(e));
//        PortTxt.setOnKeyPressed(e->onEnter(e));
        EmailTxt.setOnKeyPressed(e->onEnter(e));
        PassTxt.setOnKeyPressed(e->onEnter(e));
        
    }
    

    public void GoToHomePage() {

        Parent root;
        try {
            String Email = EmailTxt.getText();
            
            String Pass = PassTxt.getText();
            if(Email.equals("") || Email.replace(" ", "").length()==0 || !VALID_EMAIL_PATTERN.matcher(Email).matches() )
            {
                error.setText("please enter the correct Email Address");
                error.setStyle("-fx-background-color: red;");
            }
            else if(Pass.equals("") || Pass.replace(" ", "").length()==0  )
            {
             
                error.setText("please Don't leave the pass empty");
                error.setStyle("-fx-background-color: red;");
            }
            else if (true)
            { // Authorization here
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("MainWindow.fxml"));



                MainWindowController controller = new MainWindowController();
                controller.setUserName(Email);
                loader.setController(controller);
                root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.getIcons().add(new Image(MainWindowController.class.getResourceAsStream("imgs/icon.png")));
                StartBtn.getScene().getWindow().hide();
                stage.setTitle("Cloud File Encryptor");
                stage.setHeight(440);
                stage.setWidth(770);
                Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2); 
                stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 4);
                stage.setResizable(false);
                stage.setOnCloseRequest(e -> closeWindow());

                stage.show();
            }
            else
            {
                error.setText("incorrect Email or Password ");
                error.setStyle("-fx-background-color: red;");
            }

            

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void closeWindow() {
        System.exit(0);
    }
    
    public void onEnter(KeyEvent event)
    {
        if(event.getCode().equals(KeyCode.ENTER) || event.getCharacter().getBytes()[0] == '\n' || event.getCharacter().getBytes()[0] == '\r') {
        // your action
        GoToHomePage();
    }
    }

}
