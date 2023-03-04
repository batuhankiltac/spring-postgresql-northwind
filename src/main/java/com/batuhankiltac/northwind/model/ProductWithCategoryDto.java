package com.batuhankiltac.northwind.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductWithCategoryDto {
    private Integer id;
    private String productName;
    private String categoryName;
}