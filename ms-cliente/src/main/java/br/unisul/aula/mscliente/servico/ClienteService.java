package br.unisul.aula.mscliente.servico;

import br.unisul.aula.mscliente.dto.ClienteDTO;
import br.unisul.aula.mscliente.dto.EnderecoDTO;
import br.unisul.aula.mscliente.modelo.Cliente;
import br.unisul.aula.mscliente.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoClient enderecoClient;

    // Quando utilizado o Feign, não é necessário permanecer
    @Autowired
    private RestTemplate enderecoRaimbow;

    public List<ClienteDTO> listarTodos() {
        List<ClienteDTO> dtos = new ArrayList<>();
        for (Cliente cliente: clienteRepository.findAll()){
            EnderecoDTO enderecoDTO = buscarEnderecoPorID(cliente.getEndereco_id());
            ClienteDTO clienteDTO = new ClienteDTO(cliente, enderecoDTO);
            dtos.add(clienteDTO);
        }
        return dtos;
    }
    // Abstração do Feign
    private EnderecoDTO buscarEnderecoPorID(Long id) {
        return enderecoClient.buscarPorId(id);
    }

    // Utilizado no para comunicação, o Feign monta isso para nós
    // Utilizado na resolução da atividade
    private EnderecoDTO buscarEnderecoPorIDRaimbow(Long id) {

        ResponseEntity<EnderecoDTO> exchange = enderecoRaimbow.
                exchange("http://endereco/end/id/" + id,
                HttpMethod.GET, null, EnderecoDTO.class);
        return exchange.getBody();
    }
    // Abstração do Feign
    private EnderecoDTO buscarEnderecoPorCep(Integer cep) {
        return enderecoClient.buscarPorCep(cep);
    }
    // Utilizado no para comunicação, o Feign monta isso para nós
    // Utilizado na resolução da atividade
    private EnderecoDTO buscarEnderecoPorCepRaimbow(Integer cep) {
        ResponseEntity<EnderecoDTO> exchange = enderecoRaimbow.exchange("http://endereco/end/" + cep,
                HttpMethod.GET, null, EnderecoDTO.class);
        return exchange.getBody();
    }

    public void registrarCliente(ClienteDTO dto) {
        dto.setEndereco(buscarEnderecoPorCep(dto.getCep()));
        Cliente cliente = dto.converterParaCliente();
        clienteRepository.save(cliente);
    }
}
