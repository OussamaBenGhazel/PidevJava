package tn.esprit.pigui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import tn.esprit.pigui.models.Client;
import tn.esprit.pigui.services.ClientService;
import tn.esprit.pigui.test.HelloApplication;

import java.io.IOException;
import java.sql.SQLException;

public class AddClient {
    @FXML
    private TextField adresseTF;

    @FXML
    private TextField emailTF;

    @FXML
    private TextField nomTF;

    @FXML
    private TextField phoneTF;

    @FXML
    void AjouterClient(ActionEvent event) {
        ClientService clientService = new ClientService();
        Client client = new Client();
        client.setNom(nomTF.getText());
        client.setPhone(Integer.parseInt(phoneTF.getText()));
        client.setAdresse(adresseTF.getText());
        client.setEmail(emailTF.getText());

        try {
            clientService.ajouter(client);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setContentText("Client est ajouté");
            alert.showAndWait();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }

    @FXML
    void afficherClients(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/tn/esprit/pigui/AfficherClient.fxml"));
        try {
            phoneTF.getScene().setRoot(fxmlLoader.load());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
