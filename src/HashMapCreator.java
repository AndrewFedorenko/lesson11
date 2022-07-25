import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class HashMapCreator {

    private static final String FILENAME = "file.txt";

    public static void main(String[] args) {
        String strFile = new String(readFile(), Charset.defaultCharset());
        String[] rows = strFile.split(";");
        Map<String, String> mapStructure = new HashMap<>();

        for (int i = 0; i <rows.length ; i++) {

            String[] row = rows[i].split(":");
            mapStructure.put(row[0], row[1]);
        }
        System.out.println(mapStructure.toString());
    }
    static byte[] readFile() {
        try (FileInputStream fis = new FileInputStream(FILENAME)) {
            int available = fis.available();
            byte[] buffer = new byte[available];
            fis.read(buffer);
            return buffer;
        } catch (Exception ignored) {
        }
        return new byte[0];

    }

}
