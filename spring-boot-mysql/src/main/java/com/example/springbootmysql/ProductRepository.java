/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.springbootmysql;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kalsym
 */
public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}
