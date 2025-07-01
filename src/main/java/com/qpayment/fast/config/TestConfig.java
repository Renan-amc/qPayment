package com.qpayment.fast.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.qpayment.fast.entities.Charge;
import com.qpayment.fast.entities.Client;
import com.qpayment.fast.entities.Host;
import com.qpayment.fast.entities.enums.ChargeStatus;
import com.qpayment.fast.repositories.ChargeRepository;
import com.qpayment.fast.repositories.ClientRepository;
import com.qpayment.fast.repositories.HostRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ChargeRepository chargeRepository;
	
	@Autowired
	private HostRepository hostRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Client c1 = new Client(null, "Renan", "renanmv10@hotmail.com", "renan123");
		Client c2 = new Client(null, "Joana", "joana1@gmail.com", "joana123");
		
		Host h1 = new Host(null, "Claudio", "claudio@gmail.com", "claudio123");
		
		Charge ch1 = new Charge(null, "Pagamento Renan", 120.0, Instant.now(), "localhost:8080/link1", ChargeStatus.PAID, c2, h1);
		Charge ch2 = new Charge(null, "Pagamento Joana", 150.0, Instant.now(), "localhost:8080/link2", ChargeStatus.WAITING_PAYMENT , c1, h1);
		
		clientRepository.saveAll(Arrays.asList(c1, c2));
		hostRepository.saveAll(Arrays.asList(h1));
		chargeRepository.saveAll(Arrays.asList(ch1, ch2));
	}
}
