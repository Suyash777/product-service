package com.prod.services;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prod.dto.ProductDto;
import com.prod.entities.Product;
import com.prod.entities.ProductType;
import com.prod.repositories.ProductRepository;
import com.prod.repositories.ProductTypeRepository;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;
	@Autowired 
	ProductTypeRepository productTypeRepo;
	@Autowired
	private ModelMapper modelMapper;
	

	public ProductServiceImpl(ProductRepository productRepo, ProductTypeRepository productTypeRepo,
			 ModelMapper modelMapper) {
		super();
		this.productRepo = productRepo;
		this.productTypeRepo = productTypeRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public ProductDto saveProduct(ProductDto productDto) {
		ProductType productType = productTypeRepo.findByProductTypeKey(productDto.getProductTypeKey());
		
		Product product = modelMapper.map(productDto, Product.class);
		
		product.setProductType(productType);
		Product savedProduct = productRepo.save(product);
		return modelMapper.map(savedProduct, ProductDto.class);
	}

	@Override
	public ProductDto getProductByKey(String productKey) {
		Product product = productRepo.findByProductKey(productKey);

		return modelMapper.map(product, ProductDto.class);
	}

}