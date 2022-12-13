package com.nonso.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@Data @NoArgsConstructor @AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Integer id;

  //  @Column(name = "name")
    private String name;

//    private @NotBlank String description;
//
//    private @NotBlank String imageUrl;


//    public Category(@NotBlank String name, @NotBlank String description) {
//        this.name = name;
//        this.description = description;
//    }
//
//    public Category(@NotBlank String name, @NotBlank String description, @NotBlank String imageUrl) {
//        this.name = name;
//        this.description = description;
//        this.imageUrl = imageUrl;
//    }
}
