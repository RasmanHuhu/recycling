package dao;

import model.Driver;
import model.WasteTruck;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class WasteTruckDAOImpl implements IWasteTruckDAO {


    private static EntityManagerFactory emf;

    private static WasteTruckDAOImpl instance;

    public static WasteTruckDAOImpl getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new WasteTruckDAOImpl();
        }
        return instance;
    }

    @Override
    public int saveWasteTruck(String brand, String registrationNumber, int capacity) {
        return 0;
    }

    @Override
    public WasteTruck getWasteTruckById(int id) {
        return null;
    }

    @Override
    public void setWasteTruckAvailable(WasteTruck wasteTruck, boolean available) {

    }

    @Override
    public void deleteWasteTruck(int id) {

    }

    @Override
    public void addDriverToWasteTruck(WasteTruck wasteTruck, Driver driver) {

    }

    @Override
    public void removeDriverFromWasteTruck(WasteTruck wasteTruck, String id) {

    }

    @Override
    public List<WasteTruck> getAllAvailableTrucks() {
        return null;
    }
}
