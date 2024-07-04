package com.arifsyncjava.cqrsapi.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/products")
@RequiredArgsConstructor
public class ProductController {
}
