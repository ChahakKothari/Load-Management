package com.Load_Management.Load_Management.service;


import com.Load_Management.Load_Management.Model.Load;
import com.Load_Management.Load_Management.Repository.LoadRepository;
import com.Load_Management.Load_Management.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadServiceImpl implements LoadService {

    @Autowired
    private LoadRepository loadRepository;

    @Override
    public Load createLoad(Load load) {
        return loadRepository.save(load);
    }

    @Override
    public List<Load> getAllLoads() {
        return loadRepository.findAll();
    }

    @Override
    public Load getLoadById(String loadId) {
        return loadRepository.findById(loadId)
                .orElseThrow(() -> new ResourceNotFoundException("Load not found with id: " + loadId));
    }

    @Override
    public Load updateLoad(String loadId, Load loadDetails) {
        Load load = getLoadById(loadId);

        load.setFacility(loadDetails.getFacility());
        load.setProductType(loadDetails.getProductType());
        load.setTruckType(loadDetails.getTruckType());
        load.setNoOfTrucks(loadDetails.getNoOfTrucks());
        load.setWeight(loadDetails.getWeight());
        load.setComment(loadDetails.getComment());
        load.setShipperId(loadDetails.getShipperId());
        load.setDate(loadDetails.getDate());

        return loadRepository.save(load);
    }

    @Override
    public void deleteLoad(String loadId) {
        Load load = getLoadById(loadId);
        loadRepository.delete(load);
    }

    @Override
    public List<Load> getLoadsByFilters(String shipperId, String truckType, String productType,
                                        String loadingPoint, String unloadingPoint) {
        return loadRepository.findByFilters(shipperId, truckType, productType, loadingPoint, unloadingPoint);
    }
}

