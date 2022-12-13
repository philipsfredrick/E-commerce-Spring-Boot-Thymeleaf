package com.nonso.ecommerce.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nonso.ecommerce.model.Category;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Integer id;
    private String name;
    private double price;
    private double weight;
    private String description;
    private String imageName;
    private Integer categoryId;

}
