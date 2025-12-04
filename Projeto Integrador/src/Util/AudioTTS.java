package Util;

import java.io.IOException;

public class AudioTTS {

    public static void ler(String texto, String arquivoSaida) {
        try {
            String comando = String.format(
                    "python -c \"from gtts import gTTS; gTTS('%s', lang='pt').save('%s')\"",
                    texto.replace("'", "\\'"),
                    arquivoSaida
            );

            Process processo = Runtime.getRuntime().exec(comando);

            processo.waitFor();
            System.out.println("Áudio gerado: " + arquivoSaida);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
