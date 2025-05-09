package com.alibou.ecommerce.order;

import com.alibou.ecommerce.customer.CustomerClient;
import com.alibou.ecommerce.exception.BussinessException;
import com.alibou.ecommerce.orderline.OrderLineRequest;
import com.alibou.ecommerce.orderline.OrderLineService;
import com.alibou.ecommerce.product.ProductClient;
import com.alibou.ecommerce.product.PurchaseRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;


    public ResponseEntity<Integer> createOrder(@Valid OrderRequest request) {
//        check the Customer --> OpenFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BussinessException("Cannot Create Order:: No Customer Exist with the provide ID"));

//        purchase the Product   --> product microsercvice(Rest Template)
        this.productClient.purchaseProducts(request.products());


//        persist the order
        var order = this.repository.save(mapper.toOrder(request));

//        persist order lines
        for(PurchaseRequest purchaseRequest:request.products()) {
            orderLineService.saveOrderLine(
            new OrderLineRequest(
                    null,
                    order.getId(),
                    purchaseRequest.productId(),
                    purchaseRequest.quantity()
            ));

        }
//        start payment Process
//        send the order confirmation --> notification Microservice(kafka)




    }
}
