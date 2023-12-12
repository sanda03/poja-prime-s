package com.s.base.endpoint.rest.controller;

import com.s.base.service.event.PrimeService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class PrimeController {
  private final PrimeService primeService;

  @GetMapping("/new-prime")
  public String getPrime() {
    return primeService.createPrime();
  }

  @GetMapping("/generated-primes")
  public List<String> getGenerated() {
    return primeService.getCurrentPrime();
  }
}
