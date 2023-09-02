/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package newtablecode;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

/**
 *
 * @author Badreldin Elamin
 * @baderelameen@gmail.com
 */
public class NewTableCode extends Application {
    
    private final TableView table3= new TableView();
   
// Observable list
  ObservableList<Table3Data> data3 = FXCollections.observableArrayList
            (new Table3Data(1, "Welcome to Table3", "Meter", 
                1.2, 5.0),
            (new Table3Data(2, "This Table don't save any changes"  , "m2", 15.98, .36))       

    );
    @Override
    public void start(Stage primaryStage) {
//Header Label   
        Label label = new Label("Table 3");
        label.setText("Table 3");
        label.setTextFill(Color.web("#d30a90"));
        label.setFont(new Font("Algerian", 33));
       
//Table Columns

        TableColumn noCol = new TableColumn("NO");
                    noCol.setCellValueFactory(new PropertyValueFactory<Table3Data, Integer>("No"));
                    noCol.setCellFactory(TextFieldTableCell.forTableColumn());
                    noCol.setOnEditCommit(
                        new EventHandler<CellEditEvent<Table3Data, Integer>>() {
            @Override
            public void handle(CellEditEvent<Table3Data, Integer> t) {
                ((Table3Data) t.getTableView().getItems().get(
                     t.getTablePosition().getRow())
                ).setNO(t.getNewValue());
            }
                        }
                          );
                  
        TableColumn discrCol = new TableColumn("Discreption");
                    discrCol.setCellValueFactory(new PropertyValueFactory<Table3Data, String>("Decription"));
                    discrCol.setCellFactory(TextFieldTableCell.forTableColumn());
                    discrCol.setOnEditCommit(
                        new EventHandler<CellEditEvent<Table3Data, String>>() {
            @Override
            public void handle(CellEditEvent<Table3Data, String> t) {
                ((Table3Data) t.getTableView().getItems().get(
                     t.getTablePosition().getRow())
                ).setDecription(t.getNewValue());
            }
                        }
                          );
                    
        TableColumn untCol = new TableColumn("Unit");
                    untCol.setCellValueFactory(new PropertyValueFactory<Table3Data, String>("Unit"));
                    untCol.setCellFactory(TextFieldTableCell.forTableColumn());
                    untCol.setOnEditCommit(new EventHandler<CellEditEvent<Table3Data, String>>() {
            @Override
            public void handle(CellEditEvent<Table3Data, String> t) {
                        ((Table3Data) t.getTableView().getItems().get(
                                 t.getTablePosition().getRow())
                        ).setUnit(t.getNewValue());
            }
        });
       
        TableColumn quanCol = new TableColumn("Quantity");
                    quanCol.setCellValueFactory(new PropertyValueFactory<Table3Data, Double>("Quantity"));
            
                    quanCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
                    quanCol.setOnEditCommit(
                        new EventHandler<CellEditEvent<Table3Data, Double>>() {
            @Override
            public void handle(CellEditEvent<Table3Data, Double> t) {
                ((Table3Data) t.getTableView().getItems().get(
                     t.getTablePosition().getRow())
                ).setQuantity(t.getNewValue());
            }
                        }
                          );
                    
    
              
        TableColumn untPriceCol = new TableColumn("Unit Price");
                    untPriceCol.setCellValueFactory(new PropertyValueFactory<Table3Data, Double>("UnitPrice"));
                  untPriceCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
                    untPriceCol.setOnEditCommit(
                        new EventHandler<CellEditEvent<Table3Data, Double>>() {
            @Override
            public void handle(CellEditEvent<Table3Data, Double> t) {
                ((Table3Data) t.getTableView().getItems().get(
                     t.getTablePosition().getRow())
                ).setUnitPrice(t.getNewValue());
            }
                        }
                          );
              //    data3.setItems(t);
        TableColumn amountCol = new TableColumn("Amount");
                    amountCol.setCellValueFactory(new PropertyValueFactory<Table3Data, Double>("Amount"));

           
//Table 
       table3.setItems(data3);
       
       table3.getColumns().addAll(noCol, discrCol,untCol, quanCol,untPriceCol,amountCol  );

       table3.setEditable(true);
    
//Data Entary Labels
        Label noLbl = new Label("No");
              noLbl.prefWidth( 30);
              noLbl.setTextFill(Color.web("#d30a90"));
              noLbl.setFont(new Font("Cambria", 18));
              
        Label discrLbl = new Label("Discreption");
              discrLbl.prefWidth( 30);
              discrLbl.setTextFill(Color.web("#d30a90"));
              discrLbl.setFont(new Font("Cambria", 18));
                    
        Label untLbl = new Label("Unit");
              untLbl.prefWidth( 30);
              untLbl.setTextFill(Color.web("#d30a90"));
              untLbl.setFont(new Font("Cambria", 18));
              //untLbl.setTooltip("Enter new Unit");
              
        Label quanLbl = new Label("Quantity");
              quanLbl.prefWidth(30);
              quanLbl.setTextFill(Color.web("#d30a90"));
              quanLbl.setFont(new Font("Cambria", 18));
                    
        Label untPriceLbl = new Label("Unit Price");
              untPriceLbl. prefWidth( 30);
              untPriceLbl.setTextFill(Color.web("#d30a90"));
              untPriceLbl.setFont(new Font("Cambria", 18));
                    
// Label HBox
    HBox lblHBox = new HBox();
         lblHBox.setSpacing(150);
         lblHBox.setPadding(new Insets(10, 30 ,3 ,30));
         lblHBox.setAlignment(Pos.BOTTOM_CENTER);
         lblHBox.getChildren().addAll(noLbl,discrLbl,untLbl,quanLbl,
                 untPriceLbl );
//Data Entary Text Field       

        TextField noTxtFld = new TextField("");
                  noTxtFld.setPromptText("Enter new No");
                  
        TextField discrTxtFld = new TextField("");
                  discrTxtFld.setPromptText("Enter new Discription");
                  
        TextField untTxtFld = new TextField("");
                  untTxtFld.setPromptText("Enter new Unit");

        TextField quanTxtFld = new TextField("");
                  quanTxtFld.setPromptText("Enter new Quantity");
                  
        TextField untPriceTxtFld = new TextField("");
                  untPriceTxtFld.setPromptText("Enter new Unt Price");       
                  
// Label HBox
    HBox txtFldHBox = new HBox();
         txtFldHBox.setSpacing(50);
         txtFldHBox.setPadding(new Insets(5, 10 ,10 ,10));
         txtFldHBox.setAlignment(Pos.CENTER);
         txtFldHBox.getChildren().addAll(noTxtFld,discrTxtFld,untTxtFld,quanTxtFld,
                 untPriceTxtFld);
         
//Data Entary Buttons  
      //addNewRawBtn
       
        Button  addNewRawBtn = new Button("Add New Data");
                addNewRawBtn.setTextFill(Color.web("#d30a90"));
                addNewRawBtn.setFont(new Font("Cambria", 18));
               
 //New Data Method 
      //Enevnt Handler
                addNewRawBtn.setOnAction((new EventHandler<ActionEvent>(){
                    
      //Event Action
            @Override
        public void handle(ActionEvent e) {
            
            //Parse String to Integer and Double
                String noTxt1 = noTxtFld.getText();
                int noTxt = Integer.parseInt(noTxt1);
                
                String quanTxt1 = quanTxtFld.getText();
                double quanTxt = Double.parseDouble(quanTxt1);
                
                String untPrice1 = untPriceTxtFld.getText();
                double untPriceTxt = Double.parseDouble(untPrice1);
                 
               
                data3.add(new Table3Data(
                   
                   noTxt,
                   discrTxtFld.getText(),
                   untTxtFld.getText(),
                   quanTxt,
                   untPriceTxt 
                                         )
                       );
                  table3.setItems(data3);
//Clear Entery Text Fields
              
                      noTxtFld.clear();
                      discrTxtFld.clear();
                      untTxtFld.clear();
                      quanTxtFld.clear();
                      untPriceTxtFld.clear();         
            }
                    
                    
                }));
                
                
/*EditDataBtn                
                
    *    Button  editDataBtn = new Button("Edit Data");
    *           editDataBtn.setTextFill(Color.web("#d30a90"));
    *           editDataBtn.setFont(new Font("Cambria", 18));
    *          
    * //EditDataBtn  Envent Handler Method         
    *            editDataBtn.setOnAction((new EventHandler  <ActionEvent>()  {
           
    *     @Override
    *       public void handle(ActionEvent event) {
               
    *        }
    *            }));  
*/          
// DeleteRawBtn    
                Button  deleteRawBtn = new Button("Delete Raw");
                deleteRawBtn.setTextFill(Color.web("#d30a90"));
                deleteRawBtn.setFont(new Font("Cambria", 18));
              
    //EditDataBtn  Envent Handler Method         
                deleteRawBtn.setOnAction((new EventHandler  <ActionEvent>()  {
           
         @Override
            public void handle(ActionEvent event) {
// Select Row
          Table3Data selectedRow = (Table3Data) table3.getSelectionModel().getSelectedItem();
             if (selectedRow != null) {
                //remove the selected row from the list
                data3.remove(selectedRow);
             }
                
                
            }
                }));  
                    
//RefreshBtn                         
        Button  refreshBtn = new Button("Refresh");
                refreshBtn.setTextFill(Color.web("#d30a90"));
                refreshBtn.setFont(new Font("Cambria", 18));
    //refreshBtn  Envent Handler Method         
                refreshBtn.setOnAction((new EventHandler  <ActionEvent>()  {
           
         @Override
            public void handle(ActionEvent event) {
                table3.refresh();
                
                
            }
                }));  
// Buttons HBox
    HBox btnHBox = new HBox();
         btnHBox.setSpacing(90);
         btnHBox.setPadding(new Insets(10, 10 ,10 ,10));
         btnHBox.setAlignment(Pos.CENTER);
         btnHBox.getChildren().addAll(addNewRawBtn,
                 deleteRawBtn, refreshBtn );
//Data Entary Buttons     
//add verticl box to arrange label and table 

    VBox vBox = new VBox();
         vBox.setSpacing(10);
         vBox.setPadding(new Insets(10, 10 ,10 ,10));
         vBox.setAlignment(Pos.CENTER);
         vBox.getChildren().addAll(label, table3, lblHBox, txtFldHBox, btnHBox);

         
        StackPane root = new StackPane();
        root.getChildren().add(vBox );
        
        
        Scene scene = new Scene(root);
        primaryStage.setTitle("Table 3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
