package latihanp2;

/**
 *
 * @author Hadi
 */

/**
 * Class Barang untuk menyimpan data penjualan
 */
public class Barang {
    // Atribut (Data)
    public String kodeBarang;
    public String namaBarang;
    public double harga;
    public int jumlah;

    // Method untuk menghitung total harga
    public double hitungTotal() {
        return harga * jumlah;
    }

    // Method untuk menampilkan data penjualan
    public void tampilData() {
        System.out.println("--- Data Penjualan Barang ---");
        System.out.println("Kode Barang  : " + kodeBarang);
        System.out.println("Nama Barang  : " + namaBarang);
        System.out.println("Harga Satuan : Rp " + harga);
        System.out.println("Jumlah Beli  : " + jumlah);
        System.out.println("Total Bayar  : Rp " + hitungTotal());
        System.out.println("-----------------------------");
    }
}
