package FilmTahminProjesi;

import java.util.*;

public class FilmTahmin_Project1 {

    static List<String> filmList = new ArrayList<>(Arrays.asList("JOKER", "INCEPTION", "PIYANIST", "GREENMILE", "LEON", "GODFATHER", "JURASSICPARK", "TITANIC"));
/*
 TASK :
  yukarıdaki film listinde bulunan filmlerden herhangi birisini kullanıcının filim ismini  görmeden
  filmin index nosuna göre sectiriniz
  seçilen filmin  ismini filmin harf saysının 2 katı kadar hak tanıyarak tahmin etmesini
  sağlayan method create ediniz...
  Ahanda TRICK...
  kullanıcının sectiği filmin harf sayısını  console yazdırınız.
  kullanıcının sectiği film için tahmin hakkını  console yazdırınız.
  kullanıcının her tahmininde kalan hak sayısını console yazdırınız.
  kullanıcının her tahmininde doğru ve yanlış tahmin  sayısını console yazdırınız.
  kullanıcının kaybedip veya kazandığını ve tahmin etmesi gereken filmin ismini  console yazdırınız.

 */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("~~~FILM TAHMIN OYUNUNA HOSGELDINIZ~~~");
        int secimIndex = -1;
        String film = "";
        int kalanhak = -1;
        String tahmin = "";
        char devamke = ' ';
        int dogruTahmin = -1;


        System.out.println("1-" + (filmList.size()) + " arasinda bir sayi giriniz");
        secimIndex = scan.nextInt();
        film = filmList.get(secimIndex - 1);
        System.out.println(film.replaceAll("\\w", "-"));
        kalanhak = film.length();
        String[] kriptedFilm = new String[film.length()];
        List<String> tahminHarfler = new ArrayList<>();

        System.out.println("3 harf tahmin hakkınız var: ");
        for (int i = 1; i <= 3; i++) {
            System.out.print(i +". harf tahmini :");
            tahminHarfler.add(scan.next());
        }
        System.out.println(tahminHarfler);

        for (int i = 0; i < film.length(); i++) {
            for (int j = 0; j < tahminHarfler.size(); j++) {
                if (film.substring(i,i+1).equals(tahminHarfler.get(j))) {
                    kriptedFilm[i] = tahminHarfler.get(j);
                    dogruTahmin++;
                    break;
                } else {
                    kriptedFilm[i] = "-";
                }
            }
        }

        System.out.println(dogruTahmin + " harfi dogru tahmin ettiniz...");
        System.out.print("Tahmin etmeniz gereken film : ");
        for (int i = 0; i < kriptedFilm.length; i++) {
            System.out.print(kriptedFilm[i]);
        }

        System.out.println();

        while (true) {
            System.out.println(" Kalan Hak : " + kalanhak);
            System.out.print("Tahmin : ");
            tahmin = scan.next();
            if (tahmin.equalsIgnoreCase(film)) {
                System.out.println(" Tebrikler. Bildiniz. ");
                break;
            } else {
                kalanhak -=1;
                if (kalanhak == 0) {
                    System.out.println(" Maalesef hakkınız kalmadı .");
                    System.out.println(" Film : " + film);
                    break;
                }
            }
        }
    }
}

        /*  System.out.println(isim.replaceAll("\\s", "*"));
        System.out.println(isim.replaceAll("\\S", "/"));
        System.out.println(isim.replaceAll("\\w", "+"));
        System.out.println(isim.replaceAll("\\W", "-"));
        System.out.println(isim.replaceAll("\\d", "?"));
        System.out.println(isim.replaceAll("\\D", "!"));

        // REGULAR EXPRESSIONS.
        // \\s space. Space'leri
        // \\S bosluk dısındaki tum karakterler;
        // \\w harfler ve rakamlar.
        // \\W harf ve rakamlar dışındaki her şey
        // \\d rakamlar (0-9)
        // \\D rakamlar dışındaki tüm karakterler space de dahil. */