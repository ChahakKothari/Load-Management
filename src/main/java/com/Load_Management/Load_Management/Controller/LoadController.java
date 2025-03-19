package com.Load_Management.Load_Management.Controller;


import com.Load_Management.Load_Management.Model.Load;
import com.Load_Management.Load_Management.service.LoadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadService loadService;

    // POST /load - Create a new load
    @PostMapping
    public ResponseEntity<Load> createLoad(@Valid @RequestBody Load load) {
        Load savedLoad = loadService.createLoad(load);
        return new ResponseEntity<>(savedLoad, HttpStatus.CREATED);
    }

    // GET /load - Get loads by filters
    @GetMapping
    public ResponseEntity<List<Load>> getLoadsByFilters(
            @RequestParam(required = false) String shipperId,
            @RequestParam(required = false) String truckType,
            @RequestParam(required = false) String productType,
            @RequestParam(required = false) String loadingPoint,
            @RequestParam(required = false) String unloadingPoint) {

        List<Load> loads = loadService.getLoadsByFilters(
                shipperId, truckType, productType, loadingPoint, unloadingPoint);
        return new ResponseEntity<>(loads, HttpStatus.OK);
    }

    // GET /load/{loadId} - Get load by ID
    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable String loadId) {
        Load load = loadService.getLoadById(loadId);
        return new ResponseEntity<>(load, HttpStatus.OK);
    }

    // PUT /load/{loadId} - Update load
    @PutMapping("/{loadId}")
    public ResponseEntity<Load> updateLoad(
            @PathVariable String loadId,
            @Valid @RequestBody Load loadDetails) {

        Load updatedLoad = loadService.updateLoad(loadId, loadDetails);
        return new ResponseEntity<>(updatedLoad, HttpStatus.OK);
    }

    // DELETE /load/{loadId} - Delete load
    @DeleteMapping("/{loadId}")
    public ResponseEntity<Void> deleteLoad(@PathVariable String loadId) {
        loadService.deleteLoad(loadId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
