CREATE DATABASE IF NOT EXISTS db_lottemart;
USE db_lottemart;

CREATE TABLE IF NOT EXISTS karyawan (
    nip VARCHAR(20) PRIMARY KEY,
    nama VARCHAR(100),
    jabatan VARCHAR(50),
    jenis_kelamin VARCHAR(20),
    agama VARCHAR(20),
    status VARCHAR(50),
    alamat TEXT
);

INSERT INTO karyawan (nip, nama, jabatan, jenis_kelamin, agama, status, alamat) VALUES
('1105224', 'Ilham Firmansyah', 'Kasir', 'Laki-Laki', 'Islam', 'Belum Menikah', 'Ciputat'),
('1103189', 'Adi Pratama', 'Kasir', 'Laki-Laki', 'Islam', 'Belum Menikah', 'Jakarta Barat'),
('1102577', 'Maria Chintia', 'Finance', 'Perempuan', 'Kristen', 'Menikah', 'Pamulang'),
('1102536', 'Nanang Setiawan', 'Customer Service', 'Laki-Laki', 'Islam', 'Belum Menikah', 'Jakarta Selatan'),
('1106845', 'Astri Tiar', 'Kasir', 'Perempuan', 'Kristen', 'Menikah', 'Tangerang');
