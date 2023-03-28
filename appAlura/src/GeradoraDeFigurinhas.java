import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;


public class GeradoraDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // Leitura da imagem

            // BufferedImage imagemOriginal = ImageIO
            //         .read(new File("C:/Users/mjk_a/OneDrive/LAVANDERIA/Java-Alura/ALURA-JAVA/appAlura/entrada/filme.jpg"));

            // InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();

            BufferedImage imagemOriginal = ImageIO.read(inputStream);
        // Cria uma nova imagem em memória com transparência e tamanho novo

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // Copiar a imagem original em nova imagem (em memória)

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // Configurar a fonte

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        graphics.setFont(fonte);
        graphics.setColor(Color.ORANGE);

        var fontMetrics = graphics.getFontMetrics(fonte);
        var texto = "Recomendado";
        var larguraTexto = fontMetrics.stringWidth(texto);

        var horizontal = largura / 2;
        var vertical = novaAltura - 100;
        

        // Escrever uma frase na nova imagem
        graphics.drawString(texto, horizontal - larguraTexto/2, vertical);

        // Escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png",
                new File(nomeArquivo));

    }

}
