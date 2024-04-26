package tn.esprit.pigui.services;

import tn.esprit.pigui.models.Client;
import tn.esprit.pigui.utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService implements IService<Client>{

    private Connection connection ;

    public ClientService(){
        connection = MyDatabase.getInstance().getConnection();
    }
    @Override
    public void ajouter(Client client) throws SQLException {
        String req = "INSERT INTO client (nom,phone,adresse,email) VALUES('"+client.getNom()+"',"+client.getPhone()+",'"+client.getAdresse()+"','"+client.getEmail()+"') ";
        Statement st = connection.createStatement();
        st.executeUpdate(req);

    }

    @Override
    public void modifier(Client client) throws SQLException {
        String req = "UPDATE client SET nom = ?, phone = ?, adresse = ?, email = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setString(1, client.getNom());
        ps.setInt(2, client.getPhone());
        ps.setString(3, client.getAdresse());
        ps.setString(4, client.getEmail());
        ps.setInt(5, client.getId());
        ps.executeUpdate();

    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM client WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setInt(1,id);
        ps.executeUpdate();
    }

    @Override
    public List<Client> afficher() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String req = "SELECT * FROM client";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(req);

        while (rs.next()){
            Client client = new Client();
            client.setId(rs.getInt("id"));
            client.setNom(rs.getString("nom"));
            client.setPhone(rs.getInt("phone"));
            client.setAdresse(rs.getString("adresse"));
            client.setEmail(rs.getString("email"));

            clients.add(client);

        }
        return clients ;
    }
}
