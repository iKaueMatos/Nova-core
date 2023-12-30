package com.api.apibackend.Product.Application.useCase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apibackend.Product.Domain.model.Product;
import com.api.apibackend.Product.Domain.service.GetFirstProductService;

@Service
public class GetFirstProductUseCase {
    private GetFirstProductService getFirstProductService;

    @Autowired
    public GetFirstProductUseCase(GetFirstProductService getFirstProductService) {
        this.getFirstProductService = getFirstProductService;
    }

    public List<Product> execute() {
        return getFirstProductService.listProducts();
    }
}