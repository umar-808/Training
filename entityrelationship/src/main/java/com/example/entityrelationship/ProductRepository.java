/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.entityrelationship;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kalsym
 */
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
