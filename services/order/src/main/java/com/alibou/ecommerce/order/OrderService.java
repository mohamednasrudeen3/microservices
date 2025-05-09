package com.alibou.ecommerce.order;

import com.alibou.ecommerce.customer.CustomerClient;
import com.alibou.ecommerce.exception.BussinessException;
import com.alibou.ecommerce.product.ProductClient;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final CustomerClient customerClient;
    private final ProductClient productClient;


    public ResponseEntity<Integer> createOrder(@Valid OrderRequest request) {
//        check the Customer --> OpenFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BussinessException("Cannot Create Order:: No Customer Exist with the provide ID"));

//        purchase the Product   --> product microsercvice(Rest Template)
        this.productClient.purchaseProducts(request.products());


//        persist the order
//        persist order lines
//        start payment Process
//        send the order confirmation --> notification Microservice(kafka)




    }
}
