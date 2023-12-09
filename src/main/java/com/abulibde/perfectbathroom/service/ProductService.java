package com.abulibde.perfectbathroom.service;

import com.abulibde.perfectbathroom.model.dto.productDTO.CreateProductDTO;
import com.abulibde.perfectbathroom.model.dto.productDTO.ProductSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProductService {
    Page<ProductSummaryDTO> getAllProducts(Pageable pageable);

    long createProduct(CreateProductDTO createProductDTO);
}
