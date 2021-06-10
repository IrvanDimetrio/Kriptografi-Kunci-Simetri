package com.kriptorio.kriptografikuncisimetri;
// Dibuat Oleh : M.Irvan Dimetrio(18360018)

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.crypto.NoSuchPaddingException;
import org.apache.commons.codec.binary.Base64;

public class App {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException {
        String lanjut;
        System.out.println("Demo Kriptografi Kunci Simetris");
        SymetricCrypto symetricCrypto = new SymetricCrypto("RC6");
        Scanner inputKeyboard = new Scanner(System.in);
        System.out.println("Masukkan plaintext : ");
        String plaintext = inputKeyboard.nextLine();
        System.out.println("Masukkan password : ");
        String paswdEnkrip = inputKeyboard.nextLine();
        do {
            try {
                String hasilEnkrip = symetricCrypto.encrypt(plaintext, paswdEnkrip);
                System.out.println("Ciphertext in Base64 : " + hasilEnkrip);
                System.out.println("Ciphertext in hexa : " + Convert.byteArrayToHexString(Base64.decodeBase64(hasilEnkrip)));
                System.out.println("Cihpertext in byte : " + Convert.byteArrayToBytesString(Base64.decodeBase64(hasilEnkrip)));
                System.out.println("Anda ingin mendekripsi (y/n) ? ");
                String inginDekrip = inputKeyboard.nextLine();
                if (inginDekrip.equalsIgnoreCase("y")) {
                    System.out.println("Masukkan ciphertext (dalam Base64) : ");
                    String ciphertext = inputKeyboard.nextLine();
                    System.out.println("Masukkan password : ");
                    String paswdDekrip = inputKeyboard.nextLine();
                    String hasilDekrip = symetricCrypto.decrypt(ciphertext, paswdDekrip);
                    System.out.println("Plaintext hasil dekripsi : " + hasilDekrip);
                }
            } catch (Exception e) {
                System.out.println("MAAF!! ciphertext atau password salah.");
                System.out.println(e.toString());
            }
            System.out.println("Anda ingin melanjutkan melakukan enkripsi lainnya (y/n) ? ");
            lanjut = inputKeyboard.nextLine();
        } while (lanjut.equalsIgnoreCase("y"));
        inputKeyboard.close();
    }
}
