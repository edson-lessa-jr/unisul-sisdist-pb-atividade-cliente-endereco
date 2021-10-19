package br.unisul.aula.mscliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// Habilitar o Feign na classe principal
@SpringBootApplication
@EnableFeignClients
public class MsClienteApplication {


// Parte do Rainbow não utilizada quando existe o Feign, poderia ser apagada
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MsClienteApplication.class, args);
    }

}
