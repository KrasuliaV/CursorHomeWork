package com.cursor.krasulia.hw15.dao;

import com.cursor.krasulia.hw15.enteties.Pilot;
import com.cursor.krasulia.hw15.properties.HikariConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PilotDao {

    PlaneDao planeDao;

    public PilotDao() {
        this.planeDao = new PlaneDao();
    }

    public List<Pilot> getAllPilotsList() {
        List<Pilot> pilots = new ArrayList<>();
        String sqlQuery = "SELECT * FROM pilots;";

        try (Connection connection = HikariConnector.HIKARI_CONNECTOR.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    final Pilot pilot = new Pilot();
                    long id = resultSet.getLong("id");
                    pilot.setId(id);
                    pilot.setName(resultSet.getString("name"));
                    pilot.setAge(resultSet.getInt("age"));
                    pilot.setPlaneList(planeDao.getPlanesForOnePilotByPilotId(id));
                    pilots.add(pilot);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pilots;
    }
}
