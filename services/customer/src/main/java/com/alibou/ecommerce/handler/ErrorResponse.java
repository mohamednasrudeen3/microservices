package com.alibou.ecommerce.handler;



import java.util.HashMap;
import java.util.Map;

public record ErrorResponse(
        Map<String,String> errors
) {
}
