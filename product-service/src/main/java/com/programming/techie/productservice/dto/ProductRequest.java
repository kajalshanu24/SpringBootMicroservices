package com.programming.techie.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private String name;
    private String description;
    private BigDecimal price;
}
//Good practice to separate model and DTO's.
//Reason why DTO is required even when Model is created is, DTO's are exposed to UI, and we don't want our DB models
// to be exposed to UI.
//In future if there are few more fields required in Model and we don't want to expose those fields to UI or are not needed
// in UI side then separating them is again helpful.
