package com.arifsyncjava.cqrsapi;

import org.springframework.http.ResponseEntity;

public interface Query <I,O>{
    ResponseEntity<O>  execute (I input);
}
