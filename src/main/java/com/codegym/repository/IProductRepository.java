package com.codegym.repository;


import com.codegym.model.Category;
import com.codegym.model.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
    //Show category
    List<Product> findAllByCategory(Category category);

    
    //Tìm kiếm sản phẩm theo tên
    @Query(value = "select  * from product where product.name like ?", nativeQuery = true)
    Page<Product> findProductName(String name , Pageable pageable);

    @Query(value = "select * from product where product.category_id = ?", nativeQuery = true)
    Page<Product> findProductByCategoryName(Long id, Pageable pageable);

    @Query(value = "select * from product order by price desc limit ?" , nativeQuery = true)
    List<Product> findByTopPrice (int limit);

    @Query(value = "select * from product order by dateOfManufacture desc limit ?" , nativeQuery = true)
    List<Product> findByTopNewProduct (int limit);

    @Query(value = "select sum(price*quantity) from Product " , nativeQuery = true)
    long totalPrice();



}
