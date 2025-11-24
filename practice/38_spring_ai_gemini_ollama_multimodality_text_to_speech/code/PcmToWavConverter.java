package it.venis.ai.spring.demo.util;

...

public class PcmToWavConverter {
    
    public static byte[] pcmToWav(byte[] pcmData, float sampleRate, int sampleSizeInBits, 
                                  int channels, boolean signed, boolean bigEndian) throws IOException {
        
        // Crea la specifica del formato audio
        AudioFormat audioFormat = new AudioFormat(
            sampleRate,           // Frequenza di campionamento (Hz)
            sampleSizeInBits,     // Dimensione del campione in bit
            channels,             // Numero di canali
            signed,               // Con segno o senza segno
            bigEndian             // Big-endian o little-endian
        );
        
        // Racchiude i dati PCM in un ByteArrayInputStream
        ByteArrayInputStream pcmInputStream = new ByteArrayInputStream(pcmData);
        
        // Calcola la lunghezza del frame
        long frameLength = pcmData.length / audioFormat.getFrameSize();
        
        // Crea un AudioInputStream dai dati PCM
        AudioInputStream audioInputStream = new AudioInputStream(
            pcmInputStream,
            audioFormat,
            frameLength
        );
    ...
}