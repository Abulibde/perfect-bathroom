package com.abulibde.perfectbathroom.service.impl;

import com.abulibde.perfectbathroom.model.dto.productDTO.CreateProductDTO;
import com.abulibde.perfectbathroom.model.dto.productDTO.ProductSummaryDTO;
import com.abulibde.perfectbathroom.model.entity.ProductEntity;
import com.abulibde.perfectbathroom.repository.ProductRepository;
import com.abulibde.perfectbathroom.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

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

    @Override
    public long createProduct(CreateProductDTO createProductDTO) {
        ProductEntity newProduct = map(createProductDTO);

        newProduct = productRepository.save(newProduct);

        return newProduct.getId();
    }

    private ProductEntity map(CreateProductDTO createProductDTO){

        ProductEntity newProduct = new ProductEntity();

        newProduct.setCategory(createProductDTO.getCategory());
        newProduct.setBrand(createProductDTO.getBrand());
        newProduct.setModel(createProductDTO.getModel());
        newProduct.setName(createProductDTO.getName());
        newProduct.setAddedDate(LocalDateTime.now());
        newProduct.setPrice(createProductDTO.getPrice());
        newProduct.setDiscount(createProductDTO.getDiscount());
        newProduct.setDescription(createProductDTO.getDescription());

        return newProduct;

    }

    private static ProductSummaryDTO mapAsSummary(ProductEntity productEntity) {

        return new ProductSummaryDTO(
                productEntity.getCategory().name(),
                productEntity.getBrand(),
                productEntity.getModel(),
                productEntity.getPrice());
    }
}
