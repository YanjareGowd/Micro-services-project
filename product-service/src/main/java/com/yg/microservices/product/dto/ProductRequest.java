package com.yg.microservices.product.dto;

import java.math.BigDecimal;

public record ProductRequest(String name, String id, String description, BigDecimal price) {
}
