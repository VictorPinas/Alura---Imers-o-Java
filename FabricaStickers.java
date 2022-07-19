
//import java.io.BufferedInputStream;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class FabricaStickers {

    public void gerar(InputStream inputStream, String nomeArquivo) throws Exception {

        // leitura da imagem
        // InputStream
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria uma nova imagem com tranparência e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar fonte
        var fonte = new Font(Font.SANS_SERIF, Font.ITALIC, 24);
        graphics.setColor(Color.MAGENTA);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("Imagem obtida", 100, novaAltura - 100);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        var fabrica = new FabricaStickers();
        fabrica.gerar(null, null);
    }
}
