package com.Load_Management.Load_Management.service;


import com.Load_Management.Load_Management.Model.Load;

import java.util.List;

public interface LoadService {
    Load createLoad(Load load);

    List<Load> getAllLoads();

    Load getLoadById(String loadId);

    Load updateLoad(String loadId, Load loadDetails);

    void deleteLoad(String loadId);

    List<Load> getLoadsByFilters(String shipperId, String truckType, String productType,
                                 String loadingPoint, String unloadingPoint);
}
