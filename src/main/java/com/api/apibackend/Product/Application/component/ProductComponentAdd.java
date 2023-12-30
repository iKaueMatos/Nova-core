package com.api.apibackend.Product.Application.component;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.apibackend.Price.infra.entity.PriceEntity;
import com.api.apibackend.Price.infra.repository.PriceRepository;
import com.api.apibackend.Product.Application.DTOs.ProductDTO;
import com.api.apibackend.Product.Infra.entity.ProductEntity;
import com.api.apibackend.Supplier.Infra.entity.SupplierEntity;
import com.api.apibackend.Supplier.Infra.repository.SupplierRepository;
import com.api.apibackend.SupplierAddress.infra.persistence.entity.SupplierAddressEntity;
import com.api.apibackend.SupplierAddress.infra.repository.SupplierAddressRepository;

@Component
public class ProductComponentAdd {
    private PriceRepository priceRepository;
    private SupplierAddressRepository supplierAddressRepository;
    private SupplierRepository supplierRepository;

    @Autowired
    public ProductComponentAdd(PriceRepository priceRepository, SupplierAddressRepository supplierAddressRepository, SupplierRepository supplierRepository) {
        this.priceRepository = priceRepository;
        this.supplierAddressRepository = supplierAddressRepository;
        this.supplierRepository = supplierRepository;
    }

    public void priceSaveProduct(ProductDTO productDTO, ProductEntity newProduct) {
        PriceEntity price = new PriceEntity();
        price.setPrice(productDTO.getPriceEntity().getPrice());
        price.setDiscountPrice(productDTO.getPriceEntity().getDiscountPrice());
        price.setStartDate(productDTO.getPriceEntity().getStartDate());
        price.setEndDate(productDTO.getPriceEntity().getEndDate());
        price.setCurrency(productDTO.getPriceEntity().getCurrency());
        price.setUnitOfMeasure(productDTO.getPriceEntity().getUnitOfMeasure());
        price.setStatus(productDTO.getPriceEntity().getStatus());
        price.setDiscountType(productDTO.getPriceEntity().getDiscountType());
        price.setPriceOrigin(productDTO.getPriceEntity().getPriceOrigin());
        price.setNotes(productDTO.getPriceEntity().getNotes());
        price.setUpdatedBy(productDTO.getPriceEntity().getUpdatedBy());
        price.setProductEntity(newProduct);
        priceRepository.save(price);
    }

    public SupplierEntity supplierSave(ProductDTO productDTO) {
        SupplierAddressEntity supplierAddress = new SupplierAddressEntity();
        supplierAddress.setCep(productDTO.getSupplierEntity().getSupplierAddress().getCep());
        supplierAddress.setRoad(productDTO.getSupplierEntity().getSupplierAddress().getRoad());
        supplierAddress.setNeighborhood(productDTO.getSupplierEntity().getSupplierAddress().getNeighborhood());
        supplierAddress.setNumberHouseOrCompany(productDTO.getSupplierEntity().getSupplierAddress().getNumberHouseOrCompany());
        supplierAddressRepository.save(supplierAddress);

        SupplierEntity supplier = new SupplierEntity();
        supplier.setNameCompany(productDTO.getSupplierEntity().getNameCompany());
        supplier.setCnpj(productDTO.getSupplierEntity().getCnpj());
        supplier.setRegion(productDTO.getSupplierEntity().getRegion());
        supplier.setOfficeSupplier(productDTO.getSupplierEntity().getOfficeSupplier());
        supplier.setDateCreated(new Date());
        supplier.setContact(productDTO.getSupplierEntity().getContact());
        supplier.setSupplierAddressEntity(supplierAddress);
        supplier = supplierRepository.save(supplier);

        return supplier;
    }
}