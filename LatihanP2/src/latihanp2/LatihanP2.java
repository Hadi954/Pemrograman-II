/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanp2;

import java.util.Scanner;

/**
 *
 * @author Hadi
 */

public class LatihanP2 {

    public static void main(String[] args) {
        // Membuat objek Scanner untuk input dari keyboard
        Scanner input = new Scanner(System.in);
        
        // Membuat objek dari class Barang
        Barang jualan = new Barang();
        
        // Input data
        System.out.print("Masukkan Kode Barang: ");
        jualan.kodeBarang = input.nextLine();
        
        System.out.print("Masukkan Nama Barang: ");
        jualan.namaBarang = input.nextLine();
        
        System.out.print("Masukkan Harga: ");
        jualan.harga = input.nextDouble();
        
        System.out.print("Masukkan Jumlah: ");
        jualan.jumlah = input.nextInt();
        
        System.out.println(); // Baris baru
        
        // Memanggil method untuk menampilkan hasil
        jualan.tampilData();
    }
    
}
