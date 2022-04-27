package packageMap;

import java.util.*;

public class FilmTahmin_Project2 {

    static Map<Integer, String> filmMap = new HashMap<>();
    static Scanner scan = new Scanner(System.in);

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


        System.out.println("~~~FILM TAHMIN OYUNUNA HOSGELDINIZ~~~");
        int secimIndex = -1;
        String film = "";
        int kalanhak = -1;
        String tahmin = "";
        int dogruTahmin = 0;

        filmMap.put(1, "JOKER");
        filmMap.put(2, "INCEPTION");
        filmMap.put(3, "GREENMILE");
        filmMap.put(4, "LEON");
        filmMap.put(5, "GODFATHER");
        filmMap.put(6, "JURASSICPARK");
        filmMap.put(7, "TITANIC");

        do {
            System.out.println("Bitirmek için 0'a basınız.");
            System.out.print("1-" + filmMap.size() + " arasinda bir sayi giriniz \n\nSecim : ");
            try {
                secimIndex = scan.nextInt();
                if (secimIndex < 0 || secimIndex > filmMap.size()) {
                    throw new ArithmeticException();
                }
            } catch (ArithmeticException e) {
                System.out.println("1 ile " + filmMap.size() + " arasında bir seçim yapmalısınız...");
            } catch (InputMismatchException e) {
                String str = scan.nextLine();
                System.out.println("Hatalı bir giris yaptiniz... Tekrar deneyin..");
            }

            if (secimIndex >0 && secimIndex <= filmMap.size()) {
                film = filmMap.get(secimIndex);
                System.out.println("Seçtiğiniz film " + film.length() + " harften oluşmaktadır.");
                System.out.println(film.replaceAll("\\w", "(-)"));
                kalanhak = film.length()*2;
                String[] kriptedFilm = new String[film.length()];
                List<String> tahminHarfler = new ArrayList<>();

                System.out.println("3 harf tahmin hakkınız var: ");
                for (int i = 1; i <= 3; i++) {
                    System.out.print(i + ". harf tahmini :");
                    String tahminedilenHarf = scan.next();
                    if (tahminHarfler.contains(tahminedilenHarf)) {
                        System.out.println(tahminedilenHarf + " harfi zaten tahmin edildi.");
                        i--;
                    } else {
                        tahminHarfler.add(tahminedilenHarf);
                    }
                }
                System.out.println(tahminHarfler);

                for (int i = 0; i < film.length(); i++) {
                    for (int j = 0; j < tahminHarfler.size(); j++) {
                        if (film.substring(i, i + 1).equals(tahminHarfler.get(j))) {
                            kriptedFilm[i] = "(" + tahminHarfler.get(j) + ")";
                            dogruTahmin++;
                            break;
                        } else {
                            kriptedFilm[i] = "(-)";
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
                        System.out.println();
                        break;
                    } else {
                        kalanhak -= 1;
                        if (kalanhak == 0) {
                            System.out.println(" Maalesef hakkınız kalmadı .");
                            System.out.println(" Tahmni etmeniz gereken film : " + film);
                            break;
                        }
                    }
                }
            }
        } while (secimIndex != 0);
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