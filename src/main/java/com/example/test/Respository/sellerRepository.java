/*package com.example.test.Respository;

import com.example.test.Entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface sellerRepository extends JpaRepository<Seller, Integer> {
    List<Seller> findByNameContainingIgnoreCase(String name);


}*/
package com.example.test.Respository;

import com.example.test.Entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface sellerRepository extends JpaRepository<Seller, Long> {
    List<Seller> findByNameContainingIgnoreCase(String name);

}

