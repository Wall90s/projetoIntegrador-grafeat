package org.generation.grafeat.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.generation.grafeat.model.Vendedor;
import org.generation.grafeat.model.VendedorLogin;
import org.generation.grafeat.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VendedorService {
	@Autowired
    private VendedorRepository vendedorRepository;

    public Optional<Vendedor> cadastrarVendedor(Vendedor vendedor) {

        if (vendedorRepository.findByUsuario(vendedor.getUsuario()).isPresent())
            return Optional.empty();

        vendedor.setSenha(criptografarSenha(vendedor.getSenha()));

        return Optional.of(vendedorRepository.save(vendedor));
    
    }

    public Optional<Vendedor> atualizarVendedor(Vendedor vendedor) {
        
        if(vendedorRepository.findById(vendedor.getId()).isPresent()) {

            Optional<Vendedor> buscaVendedor = vendedorRepository.findByUsuario(vendedor.getUsuario());

            if ( (buscaVendedor.isPresent()) && ( buscaVendedor.get().getId() != vendedor.getId()))
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Vendedor já existe!", null);

            vendedor.setSenha(criptografarSenha(vendedor.getSenha()));

            return Optional.ofNullable(vendedorRepository.save(vendedor));
            
        }

        return Optional.empty();
    
    }   

    public Optional<VendedorLogin> autenticarVendedor(Optional<VendedorLogin> vendedorLogin) {

        Optional<Vendedor> vendedor = vendedorRepository.findByUsuario(vendedorLogin.get().getUsuario());

        if (vendedor.isPresent()) {

            if (compararSenhas(vendedorLogin.get().getSenha(), vendedor.get().getSenha())) {

                vendedorLogin.get().setId(vendedor.get().getId());
                vendedorLogin.get().setUsuario(vendedor.get().getUsuario());
                vendedorLogin.get().setFoto(vendedor.get().getFoto());
                vendedorLogin.get().setToken(gerarBasicToken(vendedorLogin.get().getUsuario(),        vendedorLogin.get().getSenha()));
                vendedorLogin.get().setSenha(vendedor.get().getSenha());

                return vendedorLogin;

            }
        }   

        return Optional.empty();
        
    }

    private String criptografarSenha(String senha) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        return encoder.encode(senha);

    }
    
    private boolean compararSenhas(String senhaDigitada, String senhaBanco) {
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        return encoder.matches(senhaDigitada, senhaBanco);

    }

    private String gerarBasicToken(String usuario, String senha) {

        String token = usuario + ":" + senha;
        byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII")));
        return "Basic " + new String(tokenBase64);

    }

}