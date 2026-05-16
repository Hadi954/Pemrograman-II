<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="net.sf.jasperreports.engine.*"%>
<%@page import="net.sf.jasperreports.engine.util.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.unpam.model.Koneksi"%>

<%
    try {
        // 1. Ambil Parameter Jenis Laporan
        String jenis = request.getParameter("jenis");
        String reportName = "";
        
        if ("barang".equals(jenis)) {
            reportName = "reportBarang.jrxml";
        } else if ("transaksi".equals(jenis)) {
            reportName = "reportTransaksi.jrxml";
        } else {
            out.println("Jenis laporan tidak dikenal.");
            return;
        }

        // 2. Tentukan Path File JRXML
        // Mengambil path absolut dari folder src/java/report (atau lokasi setelah dideploy)
        String reportPath = application.getRealPath("/WEB-INF/classes/report/" + reportName);
        
        // Cek jika path null (biasanya di beberapa server/IDE)
        if (reportPath == null) {
            // Coba alternatif path jika folder belum di-deploy sempurna
            reportPath = application.getRealPath("/") + "report/" + reportName;
        }

        File reportFile = new File(reportPath);
        if (!reportFile.exists()) {
             out.println("File laporan tidak ditemukan di: " + reportPath + "<br>");
             out.println("Pastikan lo udah Clean and Build project-nya!");
             return;
        }

        // 3. Ambil Koneksi Database
        Connection conn = new Koneksi().getConnection();

        // 4. Compile dan Fill Report
        JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), conn);

        // 5. Export ke PDF dan tampilkan di Browser
        byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);
        
        response.setContentType("application/pdf");
        response.setContentLength(pdfBytes.length);
        ServletOutputStream outStream = response.getOutputStream();
        outStream.write(pdfBytes);
        outStream.flush();
        outStream.close();
        
        conn.close();

    } catch (Exception e) {
        out.println("Error saat mencetak laporan: " + e.getMessage());
        e.printStackTrace();
    }
%>
