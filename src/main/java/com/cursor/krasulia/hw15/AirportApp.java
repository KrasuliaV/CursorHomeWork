package com.cursor.krasulia.hw15;

import com.cursor.krasulia.hw15.enteties.Pilot;
import com.cursor.krasulia.hw15.enteties.Plane;
import com.cursor.krasulia.hw15.properties.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportApp {

    public static List<Plane> getPlanesList() {
        List<Plane> planes = new ArrayList<>();
        String sqlQuery = "SELECT * FROM planes;";
        try (Connection connection = Connector.getConnection();
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

    public static List<Pilot> getPilotsList() {
        List<Pilot> pilots = new ArrayList<>();
        String sqlQuery = "SELECT * FROM pilots;";

        try (Connection connection = Connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    final Pilot pilot = new Pilot();
                    long id = resultSet.getLong("id");
                    pilot.setId(id);
                    pilot.setName(resultSet.getString("name"));
                    pilot.setAge(resultSet.getInt("age"));
                    pilot.setPlaneList(getPlanesForOnePilot(id));
                    pilots.add(pilot);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pilots;
    }

    private static List<Plane> getPlanesForOnePilot(long id) {
        String sqlQuery = "SELECT plane_id FROM pilots_professionalism WHERE pilot_id = ?;";
        List<Plane> planes = new ArrayList<>();

        try (Connection connection = Connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setLong(1, id);

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

    private static Plane getPlaneById(long id) {
        String sqlQuery = "SELECT * FROM planes WHERE id = ?;";
        final Plane plane = new Plane();

        try (Connection connection = Connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setLong(1, id);

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

    private static void setPlaneVariables(Plane plane, ResultSet resultSet) throws SQLException {
        plane.setId(resultSet.getLong("id"));
        plane.setModel(resultSet.getString("model"));
        plane.setSerialNumber(resultSet.getString("serial_number"));
        plane.setSets(resultSet.getInt("seats"));
    }
}
