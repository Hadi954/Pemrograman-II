<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html>
<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kalkulator Sederhana</title>
    </head>
    <body>
        <h1>Kalkulator Sederhana</h1>
        
        <html:form action="/calculate">
            <table border="0">
                <tr>
                    <td>Angka 1:</td>
                    <td><html:text property="number1" /></td>
                </tr>
                <tr>
                    <td>Angka 2:</td>
                    <td><html:text property="number2" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <html:submit value="Tambah" />
                    </td>
                </tr>
            </table>
        </html:form>

        <hr/>

        <logic:greaterThan name="CalculatorForm" property="result" value="0">
            <h3>Hasil Penjumlahan: <bean:write name="CalculatorForm" property="result" /></h3>
        </logic:greaterThan>

        <html:errors/>
        
        <br/>
        <a href="Welcome.do">Kembali ke Menu Utama</a>
    </body>
</html:html>
