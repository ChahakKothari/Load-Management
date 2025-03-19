package com.Load_Management.Load_Management.Repository;


import com.Load_Management.Load_Management.Model.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoadRepository extends JpaRepository<Load, String> {
    List<Load> findByShipperId(String shipperId);

    List<Load> findByTruckType(String truckType);

    List<Load> findByProductType(String productType);

    @Query("SELECT l FROM Load l WHERE l.facility.loadingPoint = :loadingPoint")
    List<Load> findByLoadingPoint(@Param("loadingPoint") String loadingPoint);

    @Query("SELECT l FROM Load l WHERE l.facility.unloadingPoint = :unloadingPoint")
    List<Load> findByUnloadingPoint(@Param("unloadingPoint") String unloadingPoint);

    @Query("SELECT l FROM Load l WHERE " +
            "(:shipperId IS NULL OR l.shipperId = :shipperId) AND " +
            "(:truckType IS NULL OR l.truckType = :truckType) AND " +
            "(:productType IS NULL OR l.productType = :productType) AND " +
            "(:loadingPoint IS NULL OR l.facility.loadingPoint = :loadingPoint) AND " +
            "(:unloadingPoint IS NULL OR l.facility.unloadingPoint = :unloadingPoint)")
    List<Load> findByFilters(@Param("shipperId") String shipperId,
                             @Param("truckType") String truckType,
                             @Param("productType") String productType,
                             @Param("loadingPoint") String loadingPoint,
                             @Param("unloadingPoint") String unloadingPoint);
}

