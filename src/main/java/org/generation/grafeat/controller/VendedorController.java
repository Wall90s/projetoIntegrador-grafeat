package org.generation.grafeat.controller;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generation.grafeat.model.Vendedor;
import org.generation.grafeat.model.VendedorLogin;
import org.generation.grafeat.repository.VendedorRepository;
import org.generation.grafeat.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendedor")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VendedorController {
	
	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@GetMapping ("/all")
	public ResponseEntity <List<Vendedor>> getAll(){
		return ResponseEntity.ok(vendedorRepository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Vendedor> getById(@PathVariable Long id) {
        return vendedorRepository.findById(id)
            .map(resposta -> ResponseEntity.ok(resposta))
            .orElse(ResponseEntity.notFound().build());
    }
	@PostMapping("/logar")
    public ResponseEntity<VendedorLogin> login(@RequestBody Optional<VendedorLogin> vendedorLogin) {
        return vendedorService.autenticarVendedor(vendedorLogin)
            .map(resposta -> ResponseEntity.ok(resposta))
            .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
	@PostMapping("/cadastrar")
    public ResponseEntity<Vendedor> postUsuario(@Valid @RequestBody Vendedor vendedor) {

        return vendedorService.cadastrarVendedor(vendedor)
            .map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
            .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	@PutMapping("/atualizar")
    public ResponseEntity<Vendedor> putUsuario(@Valid @RequestBody Vendedor vendedor) {
        return vendedorService.atualizarVendedor(vendedor)
            .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}