import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;


import java.io.File;
import java.io.IOException;
public class Encryption {

    public static void main(String[] args)throws IOException {

        ///Loading an existing file, and access the permission
        File file = new File("C://Test.pdf");
        PDDocument document = PDDocument.load(file);
        AccessPermission permission = new AccessPermission();
        StandardProtectionPolicy key = new StandardProtectionPolicy("1234", "wxyz", permission);

        ///Setting the length of the encryption key
        key.setEncryptionKeyLength(128);
        ///Setting the access permissions
        key.setPermissions(permission);
        document.protect(key);

        System.out.println("************************");
        System.out.println("PDF Document encrypted!!!!.");
        System.out.println("*************************");
        //Closing the document
        document.close();
    }
}