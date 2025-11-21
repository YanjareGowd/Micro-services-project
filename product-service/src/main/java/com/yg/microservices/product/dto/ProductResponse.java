package com.yg.microservices.product.dto;

import java.math.BigDecimal;

public record ProductResponse(String name, String id, String description, BigDecimal price) {

}
