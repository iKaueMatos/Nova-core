package com.api.apibackend.Order.Application.repository;

/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.apibackend.Order.Application.DTOs.CreateOrderRequest;
import com.api.apibackend.Order.Application.DTOs.OrderRequest;
import com.api.apibackend.Order.Application.DTOs.OrderUpdateAddressRequest;
import com.api.apibackend.Order.Application.DTOs.ResponseMessageDTO;

public interface IOrderController {
	ResponseEntity<ResponseMessageDTO> listOrders();
	ResponseEntity<String> createOrder(@RequestBody CreateOrderRequest createOrderRequest);
	ResponseEntity<ResponseMessageDTO> updateOrderAddress(@RequestBody OrderUpdateAddressRequest orderRequest);
	ResponseEntity<ResponseMessageDTO> canceladOrder(@RequestBody OrderRequest orderRequest);
}
