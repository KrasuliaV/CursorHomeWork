package com.cursor.krasulia.hw15.dao;

import com.cursor.krasulia.hw15.enteties.Plane;
import com.cursor.krasulia.hw15.properties.HikariConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaneDao {
    public List<Plane> getAllPlanesList() {
        List<Plane> planes = new ArrayList<>();
        String sqlQuery = "SELECT * FROM planes ORDER BY seats DESC;";
        try (Connection connection = HikariConnector.HIKARI_CONNECTOR.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    final Plane plane = new Plane();
                    setPlaneVariables(plane, resultSet);
                    planes.add(plane);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planes;
    }

    public Plane getPlaneById(long planeId) {
        String sqlQuery = "SELECT * FROM planes WHERE id = ?;";
        final Plane plane = new Plane();

        try (Connection connection = HikariConnector.HIKARI_CONNECTOR.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setLong(1, planeId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    setPlaneVariables(plane, resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plane;
    }

    public List<Plane> getPlanesForOnePilotByPilotId(long pilotId) {
        String sqlQuery = "SELECT plane_id FROM pilots_professionalism WHERE pilot_id = ?;";
        List<Plane> planes = new ArrayList<>();

        try (Connection connection = HikariConnector.HIKARI_CONNECTOR.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setLong(1, pilotId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    planes.add(getPlaneById(resultSet.getLong("plane_id")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planes;
    }

    private void setPlaneVariables(Plane plane, ResultSet resultSet) throws SQLException {
        plane.setId(resultSet.getLong("id"));
        plane.setModel(resultSet.getString("model"));
        plane.setSerialNumber(resultSet.getString("serial_number"));
        plane.setSeats(resultSet.getInt("seats"));
    }
}
