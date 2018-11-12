package sample;

import Alerts.SendAlert;
import DAO.DAOFactory;
import Entities.TclientsEntity;
import Entities.TsellEntity;
import Entities.TzakupkaEntity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Controller {

    @FXML
    private TableView<TzakupkaEntity> tbvw1;

    @FXML
    private Button addbtn1;

    @FXML
    private TableView<TclientsEntity> tbvw2;

    @FXML
    private TableView<TsellEntity> tbvw3;

    @FXML
    private TextField nametxtf;

    @FXML
    private TextField pricetxtf;

    @FXML
    private TextField edtxtf;

    @FXML
    private Button delbtn1;

    @FXML
    private Button delbtn3;

    @FXML
    private Button delbtn2;

    @FXML
    private Button addbtn11;

    @FXML
    private Button addbtn12;

    @FXML
    private TextField firmtxtf;

    @FXML
    private TextField coutrytxtf;

    @FXML
    private TextField adresstxtf;

    @FXML
    private TextField telephonetxtf;

    @FXML
    private TextField datetxtf;

    @FXML
    private TextField counttxtf;

    @FXML
    private TextField clientidtxtf;

    @FXML
    private TextField zakupkaidtxtf;

    private void setTbvw1(){
        javafx.scene.control.TableColumn<TzakupkaEntity, Integer> idColumn = new TableColumn<>("ID");
       // idColumn.setMinWidth(50);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        javafx.scene.control.TableColumn<TzakupkaEntity, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("namee"));

        javafx.scene.control.TableColumn<TzakupkaEntity, Double> priceColumn = new TableColumn<>("Price");
       // priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        javafx.scene.control.TableColumn<TzakupkaEntity, String> edColumn = new TableColumn<>("Ed");
        //edColumn.setMinWidth(150);
        edColumn.setCellValueFactory(new PropertyValueFactory<>("ed"));

        tbvw1.setItems((ObservableList<TzakupkaEntity>) DAOFactory.getInstance().getZakupkaDAO().getAllZakupki());
        tbvw1.getColumns().addAll(idColumn, nameColumn, priceColumn, edColumn);
    }

    private void setTbvw2(){
        javafx.scene.control.TableColumn<TclientsEntity, Integer> idColumn = new TableColumn<>("ID");
        //idColumn.setMinWidth(50);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        javafx.scene.control.TableColumn<TclientsEntity, String> firmColumn = new TableColumn<>("Firm");
       // firmColumn.setMinWidth(150);
        firmColumn.setCellValueFactory(new PropertyValueFactory<>("firm"));

        javafx.scene.control.TableColumn<TclientsEntity, Double> countryColumn = new TableColumn<>("Country");
       // countryColumn.setMinWidth(100);
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));

        javafx.scene.control.TableColumn<TclientsEntity, String> adressColumn = new TableColumn<>("Adress");
       // adressColumn.setMinWidth(150);
        adressColumn.setCellValueFactory(new PropertyValueFactory<>("adress"));

        javafx.scene.control.TableColumn<TclientsEntity, Integer> telephoneColumn = new TableColumn<>("Telephone");
        //telephoneColumn.setMinWidth(150);
        telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telephone"));

        tbvw2.setItems((ObservableList<TclientsEntity>) DAOFactory.getInstance().getClientDAO().getAllClients());
        tbvw2.getColumns().addAll(idColumn, firmColumn, countryColumn, adressColumn, telephoneColumn);
    }

    private void setTbvw3(){
        javafx.scene.control.TableColumn<TsellEntity, Integer> idColumn = new TableColumn<>("ID");
        //idColumn.setMinWidth(50);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        javafx.scene.control.TableColumn<TsellEntity, Timestamp> dateColumn = new TableColumn<>("Date");
        // dateColumn.setMinWidth(150);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("datee"));

        javafx.scene.control.TableColumn<TsellEntity, Integer> countColumn = new TableColumn<>("Count");
        // countColumn.setMinWidth(100);
        countColumn.setCellValueFactory(new PropertyValueFactory<>("counting"));

        tbvw3.setItems((ObservableList<TsellEntity>) DAOFactory.getInstance().getSellDAO().getAllSell());
        tbvw3.getColumns().addAll(idColumn, dateColumn, countColumn);
    }

    @FXML
    private void initialize() {
        setTbvw1();
        setTbvw2();
        setTbvw3();

        addbtn1.setOnAction(actionEvent -> {
            if(!nametxtf.getText().equals("") || !pricetxtf.equals("") || !edtxtf.equals("")) {
                TzakupkaEntity tzakupkaEntity = new TzakupkaEntity();
                tzakupkaEntity.setNamee(nametxtf.getCharacters().toString());
                tzakupkaEntity.setPrice(Double.parseDouble(pricetxtf.getCharacters().toString()));
                tzakupkaEntity.setEd(edtxtf.getCharacters().toString());

                DAOFactory.getInstance().getZakupkaDAO().addZakupka(tzakupkaEntity);

                tbvw1.getItems().clear();
                tbvw1.setItems((ObservableList<TzakupkaEntity>) DAOFactory.getInstance().getZakupkaDAO().getAllZakupki());
            }
            else{
                SendAlert.showAlert("Warning Dialog", "Wrong data","Fill all cells" );

            }
        });

        addbtn11.setOnAction(actionEvent -> {
            if(!firmtxtf.getText().equals("") || !coutrytxtf.equals("") || !adresstxtf.equals("") || !telephonetxtf.equals("")) {

                TclientsEntity tclientsEntity = new TclientsEntity();
                tclientsEntity.setFirm(firmtxtf.getCharacters().toString());
                tclientsEntity.setCountry(coutrytxtf.getCharacters().toString());
                tclientsEntity.setAdress(adresstxtf.getCharacters().toString());
                tclientsEntity.setTelephone(Integer.parseInt(telephonetxtf.getCharacters().toString()));

                DAOFactory.getInstance().getClientDAO().addClient(tclientsEntity);

                tbvw2.getItems().clear();
                tbvw2.setItems((ObservableList<TclientsEntity>) DAOFactory.getInstance().getClientDAO().getAllClients());
            }
            else{
                SendAlert.showAlert("Warning Dialog", "Wrong data","Fill all cells" );
            }
        });

        addbtn12.setOnAction(actionEvent -> {
            if(!datetxtf.getText().equals("") || !counttxtf.equals("") || !clientidtxtf.equals("") || !zakupkaidtxtf.equals("")) {
                TsellEntity tsellEntity = new TsellEntity();
                tsellEntity.setDatee(Timestamp.valueOf(datetxtf.getCharacters().toString()));
                tsellEntity.setCounting(Integer.parseInt(counttxtf.getCharacters().toString()));
                tsellEntity.setTclientsByIdKlienta( DAOFactory.getInstance().getClientDAO().getClientEntity(Integer.parseInt(clientidtxtf.getCharacters().toString())));
                tsellEntity.setTzakupkaByIdTovara( DAOFactory.getInstance().getZakupkaDAO().getZakupkaEntity(Integer.parseInt(zakupkaidtxtf.getCharacters().toString())));

                DAOFactory.getInstance().getSellDAO().addSell(tsellEntity);

                tbvw3.getItems().clear();
                tbvw3.setItems((ObservableList<TsellEntity>) DAOFactory.getInstance().getSellDAO().getAllSell());
            }
            else{
                SendAlert.showAlert("Warning Dialog", "Wrong data","Fill all cells" );
            }
        });

        delbtn1.setOnAction(actionEvent -> {
            TzakupkaEntity zakupka = tbvw1.getSelectionModel().getSelectedItem();
            DAOFactory.getInstance().getZakupkaDAO().deleteZakupka(zakupka);
            tbvw1.getItems().clear();
            tbvw1.setItems((ObservableList<TzakupkaEntity>) DAOFactory.getInstance().getZakupkaDAO().getAllZakupki());

        });

        delbtn2.setOnAction(actionEvent -> {
            TclientsEntity clients = tbvw2.getSelectionModel().getSelectedItem();
            DAOFactory.getInstance().getClientDAO().deleteClient(clients);
            tbvw2.getItems().clear();
            tbvw2.setItems((ObservableList<TclientsEntity>) DAOFactory.getInstance().getClientDAO().getAllClients());
        });

        delbtn3.setOnAction(actionEvent -> {
            TsellEntity sell = tbvw3.getSelectionModel().getSelectedItem();
            DAOFactory.getInstance().getSellDAO().deleteSell(sell);
            tbvw3.getItems().clear();
            tbvw3.setItems((ObservableList<TsellEntity>) DAOFactory.getInstance().getSellDAO().getAllSell());
        });
    }
}
