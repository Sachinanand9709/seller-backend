package com.example.test.controller;

import com.example.test.Entity.Seller;
import com.example.test.Respository.sellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sellers")
@CrossOrigin(origins = "http://localhost:5175")
public class sellerController {

    @Autowired
    private sellerRepository sellerRepository;

    @GetMapping
    public List<Seller> getAllSellers(@RequestParam(required = false) String name) {
        if (name != null && !name.isEmpty()) {
            return sellerRepository.findByNameContainingIgnoreCase(name);
        }
        return sellerRepository.findAll();
    }

    // Create a new seller
    @PostMapping
    public ResponseEntity<Seller> createSeller(@RequestBody Seller seller) {
        Seller createdSeller = sellerRepository.save(seller);
        return new ResponseEntity<>(createdSeller, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Long id, @RequestBody Seller sellerDetails) {
        Optional<Seller> optionalSeller = sellerRepository.findById(id);
        if (optionalSeller.isPresent()) {
            Seller sellerToUpdate = optionalSeller.get();
            sellerToUpdate.setName(sellerDetails.getName());
          //  sellerToUpdate.setEmail(sellerDetails.getEmail());
            sellerToUpdate.setRating(sellerDetails.getRating());
            // Add any other fields that need to be updated.

            Seller updatedSeller = sellerRepository.save(sellerToUpdate);
            return new ResponseEntity<>(updatedSeller, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long id) {
        Optional<Seller> optionalSeller = sellerRepository.findById(id);
        if (optionalSeller.isPresent()) {
            sellerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}