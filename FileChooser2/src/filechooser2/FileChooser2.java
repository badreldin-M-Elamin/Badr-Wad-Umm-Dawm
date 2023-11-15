
package filechooser2;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Badreldin Moh. Elamin Awadalla
 */
public class FileChooser2 extends Application {
      private final Desktop desktop = Desktop.getDesktop();
    
     @Override
    public void start(Stage primaryStage) {
       
//The File chooser class must be inside start method
       
     FileChooser fileChooser = new FileChooser();
                  fileChooser.setTitle("BDR This is the Open File");
//The Root Pane layout        
        GridPane root = new GridPane();
        
        Scene scene = new Scene(root, 230, 70);
//Button File
         Button openFileBtn = new Button();
                openFileBtn.setText("Open File");
                openFileBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                 File file = fileChooser.showOpenDialog(primaryStage);
                 
                 if (file != null){
                     openFile(file);
                 }
             
            }
//openFile() Method repeted in both OnAction Methods
            private void openFile(File file) {
               
                 try {
                     desktop.open(file);
                     } catch (IOException ex) {
                                 java.util.logging.Logger.getLogger(FileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                                              }
                                }

            });
            
//Button multi Files     
                Button openMultipleFilesBtn = new Button("openMultipleFilestn");
                       openMultipleFilesBtn.setOnAction(new EventHandler<ActionEvent>(){
                   @Override
                                 public void handle(ActionEvent event) {
                                        List<File> list = fileChooser.showOpenMultipleDialog(primaryStage);
                                                      if (list != null){
                                                            for (File file : list){
                                                                       openFile(file);
                               }
                      }
            }
//openFile() Method repeted in both OnAction Methods
            private void openFile(File file) {
                 try {
                     desktop.open(file);
                 } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(FileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
    });
                  root.setConstraints(openFileBtn, 0, 0);
                  root.setConstraints(openMultipleFilesBtn, 1, 0);
                  root.setHgap(20);
                  root.setVgap(20);
                  root.setPadding(new Insets(20, 10, 20, 10));    
                  root.getChildren().addAll(openFileBtn, openMultipleFilesBtn); 
        
        primaryStage.setTitle("File Chooser");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
//Main Method  
    public static void main(String[] args) {
        launch(args);
    }
    
}
