import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

//import javax.print.event.PrintEvent;

public class App {
    private static Path createDirectories;

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        // String url =
        // "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        var http = new Cliente();
        String json = http.buscaDados(url);

        // extrair só os dados que interessam (título, poster, classificação)
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var fabrica = new FabricaStickers();

        // exibir e manipular os dados
        for (int i = 0; i < 3; i++) {
            Conteudo conteudo = conteudos.get(i);

            InputStream InputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            Path saida = Paths.get(nomeArquivo);
            saida = Files.createDirectories(saida);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}