import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        HttpRequest

        // extrair só os dados que interessam (título, poster, classificação)

        // exibir e manipular os dados
    }
}