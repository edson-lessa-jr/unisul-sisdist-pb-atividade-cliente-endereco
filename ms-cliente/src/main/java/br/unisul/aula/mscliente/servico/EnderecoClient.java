package br.unisul.aula.mscliente.servico;

import br.unisul.aula.mscliente.dto.EnderecoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/*
 Abstração do Feign, utilizar somente com este método
 Lembrando precisa acrescentar o OpenFein no pow.xml para funcionar
 */

// adicionar o nome da aplicação registrada no eureka que terá comunicação
@FeignClient("endereco")
public interface EnderecoClient {

    // url completa de que será feita a comunicação (endpoint)
    @GetMapping("/end/id/{id}")
    EnderecoDTO buscarPorId(@PathVariable(name = "id")Long id);
    @GetMapping("/end/{cep}")
    EnderecoDTO buscarPorCep(@PathVariable(name = "cep")Integer cep);

    // exemplo de como seria um post (não foi utilizando no ClienteService
    @PostMapping
    void inserirDados(@RequestBody EnderecoDTO enderecoDTO);
}

