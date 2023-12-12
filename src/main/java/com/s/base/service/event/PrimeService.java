package com.s.base.service.event;

import com.s.base.repository.PrimeRepository;
import com.s.base.repository.model.Prime;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PrimeService {
  private PrimeRepository primeRepository;

  public static BigInteger makePrime() {
    final int BIT_LENGTH = 100;
    return BigInteger.probablePrime(BIT_LENGTH, new Random());
  }

  public String createPrime() {
    final Prime prime= new Prime();
    final String value = makePrime().toString();
    prime.setValue(value);
    prime.setCreationDatetime(LocalDateTime.now());
    primeRepository.save(prime);
    return value;
  }

  public List<String> getCurrentPrime() {
    return primeRepository.findFirst10ByOrderByCreationDatetimeDesc().stream()
        .map(Prime::getValue)
        .toList();
  }
}
