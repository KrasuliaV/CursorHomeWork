package com.cursor.krasulia.hw15;

import com.cursor.krasulia.hw15.dao.PilotDao;
import com.cursor.krasulia.hw15.dao.PlaneDao;
import com.cursor.krasulia.hw15.enteties.Pilot;
import com.cursor.krasulia.hw15.enteties.Plane;

import java.util.List;
import java.util.stream.Collectors;

public class AirportApp {

    private final PilotDao pilotDao;
    private final PlaneDao planeDao;

    public AirportApp() {
        this.pilotDao = new PilotDao();
        this.planeDao = new PlaneDao();
    }

    public int countSeats() {
        return getListWithAvailablePlanes().stream()
                .map(Plane::getSeats)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public List<Plane> getAllPlanes() {
        return planeDao.getAllPlanesList();
    }

    public List<Pilot> getAllPilots() {
        return pilotDao.getAllPilotsList();
    }

    private List<Plane> getListWithAvailablePlanes() {
        final List<Pilot> allPilotsList = pilotDao.getAllPilotsList();
        return planeDao.getAllPlanesList()
                .stream()
                .filter(plane -> isThereAvailablePilotsForPlane(plane, allPilotsList))
                .collect(Collectors.toList());
    }

    private boolean isThereAvailablePilotsForPlane(Plane plane, List<Pilot> pilots) {
        final List<Pilot> pilotList = pilots.stream()
                .filter(pilot -> pilot.getPlaneList().contains(plane))
                .limit(2)
                .collect(Collectors.toList());
        if (pilotList.size() != 2) {
            return false;
        }
        pilots.removeAll(pilotList);
        return true;
    }
}
