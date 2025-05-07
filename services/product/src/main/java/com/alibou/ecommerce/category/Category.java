package com.alibou.ecommerce.category;

import jakarta.persistence.*;
import lombok.*;
import com.alibou.ecommerce.product.Product;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
public class Category {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category",cascade= CascadeType.REMOVE)
    private List<Product> products;

}

