package br.com.api.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.repositorio.produtoRepositorio;

@Service
public class ProdutoServico {

    @Autowired
    private produtoRepositorio pr;

    @Autowired
    private RespostaModelo rm;

    //Metodo para listar todos os produtos
    public Iterable<ProdutoModelo> listar(){
        return pr.findAll();
    }

   //Metodo para cadastrar ou alterar produtos
   public ResponseEntity<?> cadastrarAlterar(ProdutoModelo pm, String acao){

    if (pm.getNome().equals("")) {
        rm.setMensagem("O nome do Produto é obrigatrorio");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
    }else if (pm.getMarca().equals("")) {
        rm.setMensagem("O nome da marca é obrigatoria");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        
    }else{
       if (acao.equals("cadasstrar")) {
            return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
       }else{
            return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);
       }

    }
   
   }

   //Metodo para remover produtos
   public ResponseEntity<RespostaModelo> deletar(long codigo){

    pr.deleteById(codigo);
    rm.setMensagem("O produto foi removido com sucesso");
    return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);

   }
    
}
