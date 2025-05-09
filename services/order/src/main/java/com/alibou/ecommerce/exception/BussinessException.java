package com.alibou.ecommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
public class BussinessException extends RuntimeException {
    private final String msg;
}
