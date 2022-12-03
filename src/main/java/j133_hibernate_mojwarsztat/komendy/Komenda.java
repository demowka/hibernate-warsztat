package j133_hibernate_mojwarsztat.komendy;

import java.util.Scanner;

public interface Komenda {
    public static final Scanner scanner = new Scanner(System.in);

    String getKomenda();
    void obsluga();
}
