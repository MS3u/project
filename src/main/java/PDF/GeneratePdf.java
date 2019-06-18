package PDF;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;

public class GeneratePdf {

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekt1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @FXML
    public void generateRaport(ActionEvent event , Stage stage) throws FileNotFoundException, DocumentException, SQLException {
        String fileName = takePath(stage) + "\\reports.pdf";
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(fileName));
        document.open();

        GeneratePdf pdf = new GeneratePdf();
        Connection connection = pdf.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String orderQuery = "select nrZlecenia, dataPrzyjecia, imie, nazwisko ,nazwisko , NIP  ,opis from  orders ";

        ps = connection.prepareStatement(orderQuery);
        rs = ps.executeQuery();
        PdfPTable table = new PdfPTable(6);
        createCells(table);
        table.setHeaderRows(1);

        while (rs.next()) {
            table.addCell(rs.getString("nrZlecenia"));
            table.addCell(rs.getString("dataPrzyjecia"));
            table.addCell(rs.getString("imie"));
            table.addCell(rs.getString("nazwisko"));
            table.addCell(rs.getString("NIP"));
            table.addCell(rs.getString("opis"));
        }
        document.add(table);
        document.newPage();
        document.close();
    }

    private void createCells(PdfPTable table) {
        createSingleCell(table, "Nr Zlecenia");
        createSingleCell(table, "Data Przyjęcia");
        createSingleCell(table, "Imie");
        createSingleCell(table, "Nazwisko");
        createSingleCell(table, "NIP");
        createSingleCell(table, "Opis usterki");
    }

    /**
     * Metoda do tworzenia pojedynczej komórki w pliku pdf
     *
     * @param table
     * @param tableName
     */
    private void createSingleCell(PdfPTable table, String tableName) {
        PdfPCell c1 = new PdfPCell(new Phrase(tableName));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
    }

    private String takePath(Stage stage) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(stage);

        if (selectedDirectory == null) {
            //No Directory selected
            return null;
        } else {
            System.out.println(selectedDirectory.getAbsolutePath());
        }
        return selectedDirectory.getAbsolutePath();
    }
}