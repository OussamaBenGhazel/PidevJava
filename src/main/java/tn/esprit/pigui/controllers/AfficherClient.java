package tn.esprit.pigui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.pigui.models.Client;
import tn.esprit.pigui.services.ClientService;

import java.sql.SQLException;
import java.util.List;

public class AfficherClient {

    @FXML
    private TableColumn<Client, String> adressecol;

    @FXML
    private TableColumn<Client, String> emailcol;

    @FXML
    private TableColumn<Client, String> nomcol;

    @FXML
    private TableColumn<Client, Integer> phonecol;

    @FXML
    private TableView<Client> tableView;

    @FXML
    void initialize() {
        ClientService clientService = new ClientService();

        try {
            List<Client> clients = clientService.afficher();
            ObservableList<Client> observableList = FXCollections.observableList(clients);
            tableView.setItems(observableList);

            nomcol.setCellValueFactory(new PropertyValueFactory<>("nom"));
            phonecol.setCellValueFactory(new PropertyValueFactory<>("phone"));
            adressecol.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            emailcol.setCellValueFactory(new PropertyValueFactory<>("email"));

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
