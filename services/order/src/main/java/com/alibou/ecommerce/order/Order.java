package com.alibou.ecommerce.order;

import com.alibou.ecommerce.orderline.OrderLine;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EntityListeners(AuditingEntityListener.class)

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String reference;

    private BigDecimal totalAmount;

    @Enumerated(STRING)
    private PaymentMethod paymentmethod;

    private String customerId;

    private List<OrderLine> orderLines;

    private LocalDateTime createdAt;

    private LocalDateTime lastModifiedDate;






}
