import java.util.ArrayList;

public class ExtratorDeConteudoDoIMDB {
    public List<Conteudo> extraiConteudos(String json) {
        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new Jsonparser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a minha lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image")
                    .replaceAll("(@+)(.*).jpg$", "$1.jpg");
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }
        return conteudos;
    }
}
