package org.example;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CompareIMG {
    File A;
    File B;
    BufferedImage img1;
    BufferedImage img2;
    public boolean compareFiles() throws IOException {
        // Сравниваем размер файлов
        File file1 = this.A, file2 = this.B;
        if (file1.length() != file2.length()) {
            return false; // Размеры различаются, файлы не равны
        }

        // Сравниваем время последней модификации

        // Сравнение содержимого файлов
        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {
            byte[] buffer1 = new byte[1024];
            byte[] buffer2 = new byte[1024];
            int bytesRead1;
            int bytesRead2;

            while ((bytesRead1 = fis1.read(buffer1)) != -1) {
                bytesRead2 = fis2.read(buffer2);
                if (bytesRead2 == -1 || bytesRead1 != bytesRead2) {
                    return false; // Количество считанных байтов различается
                }
                // Сравнение содержимого
                for (int i = 0; i < bytesRead1; i++) {
                    if (buffer1[i] != buffer2[i]) {
                        return false; // Найдено различие
                    }
                }
            }

            // Проверяем, закончился ли файл fis2
            if (fis2.read() != -1) {
                return false; // file2 длиннее, чем file1
            }
        }

        return true; // Файлы равны
    }
    public boolean comp(BufferedImage A, BufferedImage B)throws IOException{
        if (A.getWidth() != B.getWidth() || A.getHeight() != B.getHeight()) {
            return false; // Изображения разных размеров
        }

        // Проходим по каждому пикселю и сравниваем их
        for (int y = 0; y < A.getHeight(); y++) {
            for (int x = 0; x < B.getWidth(); x++) {
                if (A.getRGB(x, y) != B.getRGB(x, y)) {
                    return false; // Найдено различие в пикселе
                }
            }
        }

        return true; // Изображения равны
    }
    public CompareIMG(File C, File D){
        this.A = C;
        this.B = D;
    }
    public CompareIMG(BufferedImage img1, BufferedImage img2){
    this.img1 = img1;
    this.img2 = img2;
    }
}
