package com.abulibde.perfectbathroom.service;

import com.abulibde.perfectbathroom.model.dto.productDTO.ProductSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<ProductSummaryDTO> getAllProducts(Pageable pageable);
}
