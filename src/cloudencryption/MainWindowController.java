/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudencryption;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author KyrillosNagyWadieYas
 */
public class MainWindowController implements Initializable {

    
    @FXML
    private Label IDTxt;
    @FXML
    private Label EmailTxt;
    @FXML
    private JFXTextField ChoosedFile;
    @FXML
    private JFXListView ListFiles;
    @FXML
    private JFXButton ChooseBtn;
    @FXML
    private JFXButton ListFilesBtn;
    @FXML
    private JFXButton UploadBtn;
    
    private String Email;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.EmailTxt.setText(Email);
    }    
    
    

    void setUserName(String Email) {
        this.Email= Email;
    }
    
    public void ChooseFile()
    {
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(null);
        if(file != null)
        {
            ChoosedFile.setText(file.getAbsolutePath());
        }
    }
    
    public void ChooseDirectory()
    {
        DirectoryChooser dc = new DirectoryChooser();
        File file = dc.showDialog(null);
        if(file!=null)
        {
            ListFiles.getItems().clear();
            File[] fList = file.listFiles();

            for (File f : fList)
            {
                if (f.isFile()){
                    
                    ListFiles.getItems().add(f.getAbsolutePath());
                }
            }
        }
    }
    
    public void ClearList()
    {
        ListFiles.getItems().clear();
    }
    public void UploadFile()
    {
        //TO DO upload file from this function
    }
}
    

