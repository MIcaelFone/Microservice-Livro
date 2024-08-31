package APi_BookNowService_livro.BookNow.model.Livro;

import APi_BookNowService_livro.BookNow.DTO.DadosAtualizarLivros;
import APi_BookNowService_livro.BookNow.DTO.DadosCadastrarLivros;
import APi_BookNowService_livro.BookNow.model.Arquivos.ArquivosLivro;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "livros")
@Table(name = "livros")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@Builder
public class LivroClasse {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String classificacao_livro;
    private String autor;
    private Date datapublicacao;
    @Embedded
    private ArquivosLivro arquivos;
    private Integer pontos;

    public LivroClasse(DadosCadastrarLivros dados) {
        this.id=dados.id();
        this.nome=dados.nome();
        this.descricao=dados.descricao();
        this.classificacao_livro=dados.classificacao_livro();
        this.autor=dados.autor();
        this.datapublicacao=dados.datapublicacao();
        this.arquivos=dados.arquivos();
        this.pontos=dados.pontos();
    }



    public void atualiza(DadosAtualizarLivros dados) {
        if(dados.nome()!=null){
            this.nome=dados.nome();
        }
        if(dados.descricao()!=null){
            this.descricao=dados.descricao();
        }
        if(dados.arquivos()!=null){
            this.arquivos=dados.arquivos();
        }
        if(dados.pontos()!=null) {
            this.pontos=dados.pontos();
        }
    }
}
