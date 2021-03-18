package com.codegym.service.product;

import com.codegym.model.Product;
import com.codegym.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends IService<Product> {
    Page<Product> findByCategoryName(Long id, Pageable pageable);

    Page<Product> findByProductName(String name, Pageable pageable);

    List<Product> top5Price();

    List<Product> top5ProductNew();

    Long totalPrice();
}
