package com.uniyaz.egitim;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    static ArrayList<Kisiler> rehber = new ArrayList<>();
	private static Scanner tara;
	private static Scanner scanner;
	private static Scanner scanner2;
	private static Scanner scan;
    
    public static void main(String[] args) {

        boolean cikis=false;
        tara = new Scanner(System.in);
        byte secim=0;
        while (!cikis) {
            System.out.println("************* REHBER *************");
            System.out.println("1 - Yeni Kayıt Ekle \n2 - Kişi Güncelle \n3 - Kişi Ara \n4 - Kişi Sil \n5 - Listele\n6 - Çıkış");
            System.out.println(" \n Bir Seçenek Seçiniz : ");
            secim=tara.nextByte();

            switch (secim){
                case 1:
                    yeniKayitEkle();
                    break;
                case 2:
                    kisiGuncelle();
                    break;
                case 3:
                    kisiAra();
                    break;
                case 4:
                    kisiSil();
                    break;
                case 5:
                    listele(rehber);
                    break;
                default:
                    break;

            }

        }

    }
    
    
    
    private static void yeniKayitEkle() {

        Kisiler kisi=new Kisiler();
        scan = new Scanner(System.in);
        System.out.println("Yeni Kişinin Adı : ");kisi.setAd(scan.nextLine());
        System.out.println("Yeni Kişinin Soyadı : ");kisi.setSoyad(scan.nextLine());
        System.out.println("Yeni Kişinin Telefonu : "); kisi.setNumara(scan.nextLine());
        if(rehber.add(kisi)){
            System.out.println("Rehbere Başarı 1 kayıt Eklendi");
        }
    }
    
    
    private static void kisiGuncelle() {
        scanner2 = new Scanner(System.in);
        System.out.println("Lütfen Güncellemek İstediğiniz Kaydın İndex numarasını giriniz");
        int indexNo=scanner2.nextByte();
        Kisiler kisi=rehber.get(indexNo);

        System.out.println("----------  KAYIT GÜNCELLEME ------------");
        System.out.println("Lütfen Yeni İsim Bilgisi Girin");
        kisi.setAd(scanner2.next());
        System.out.println("Lütfen Yeni Soyisim Bilgisi Girin");
        kisi.setSoyad(scanner2.next());
        System.out.println("Lütfen Yeni Numara Bilgisi Girin");
        kisi.setNumara(scanner2.next());
        listele(rehber);
    }
    
    
    
    private static void kisiAra() {
        scanner=new Scanner(System.in);
        System.out.println("Aranacak Kelimeyi Söyleyin");
        String arancakKelime=scanner.next();
        Iterator<Kisiler> kisiIterator=rehber.listIterator();
        ArrayList<Kisiler> sonuclar=new ArrayList<>();
        while (kisiIterator.hasNext()){

            Kisiler kisi=kisiIterator.next();
            if(kisi.getAd().contains(arancakKelime)){
                sonuclar.add(kisi);
            }
        }
        listele(sonuclar);
    }
    
 
    private static void kisiSil() {
        scanner = new Scanner(System.in);
        listele(rehber);
        System.out.println();
        System.out.println("Silinecek Kişinin index No 'sunu gir");
        byte secim=scanner.nextByte();
        rehber.remove(secim);
        listele(rehber);
    }

    private static void listele(ArrayList<Kisiler> rehber)  {

        Iterator<Kisiler> kisiIterator=rehber.listIterator();
        int sayac=0;
        boolean firstTime=true;
        if(rehber.size()>0) {
            while (kisiIterator.hasNext()) {
                sayac++;
                Kisiler kisi = kisiIterator.next();

                if (firstTime) {
                    // Sadece Ekranın En Üst kısmına başlık olarak yazalım
                    System.out.println();
                    System.out.println(" *********************  REHBER'deki TÜM KAYITLAR ****************");
                    System.out.println("\tSIRA NO\t\tADI\t\t\tSOYADI\t\t\t\t NUMARA \t\tIndex_NO        ");
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    System.out.println();
                    firstTime = false;
                }
                System.out.println("\t" +sayac + "\t\t" + kisi.getAd() + "\t\t\t" +  kisi.getSoyad() + "\t\t\t\t" + kisi.getNumara() + "\t\t"+rehber.indexOf(kisi));
            }
            System.out.println();
            System.out.println("Toplamda "+ rehber.size()+" Kayıt Listelendi !");
            devamicinBirTusaBas();
        }
        else
        {
            System.out.println("Listelenecek Herhangi bir Kayıt Bulunamadı");
        }
    }

    private static void devamicinBirTusaBas() {
        System.out.println("Devam etmek için Bir Tuşa basın !");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}