package com.abulibde.perfectbathroom.service.impl;

import com.abulibde.perfectbathroom.model.dto.productDTO.ProductSummaryDTO;
import com.abulibde.perfectbathroom.model.entity.ProductEntity;
import com.abulibde.perfectbathroom.repository.ProductRepository;
import com.abulibde.perfectbathroom.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Page<ProductSummaryDTO> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(ProductServiceImpl::mapAsSummary);
    }

    private static ProductSummaryDTO mapAsSummary(ProductEntity productEntity) {

        return new ProductSummaryDTO(
                productEntity.getCategory().name(),
                productEntity.getBrand(),
                productEntity.getModel(),
                productEntity.getPrice());
    }
}
