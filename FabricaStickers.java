import java.io.BufferedInputStream;

import java.io.File;
import javax.imageio.ImageIO;

public class FabricaStickers {

    public void gerar(InputStream inputStream, String nomeArquivo) throws Exception {

        // leitura da imagem
        // InputStream
        BufferedImage imagemOriginal = ImagemIO.read(inputStream);

        // cria uma nova imagem com tranparência e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImagem

    }
}
