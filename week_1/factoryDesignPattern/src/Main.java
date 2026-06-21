// Main.java
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Testing Factory Method Pattern ===");

        DocumentFactory wordFactory = new WordFactory();
        Document myWordDoc = wordFactory.createDocument();
        myWordDoc.open();

        System.out.println("------------------------------------");

        DocumentFactory pdfFactory = new PdfFactory();
        Document myPdfDoc = pdfFactory.createDocument();
        myPdfDoc.open();

        System.out.println("------------------------------------");

        DocumentFactory excelFactory = new ExcelFactory();
        excelFactory.createDocument().open();
    }
}