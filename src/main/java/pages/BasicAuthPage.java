package pages;

import java.io.File;
import java.io.IOException;

import static helpers.Helper.executeScriptCmd;

public class BasicAuthPage {
    private static final String CMD_PROGRAM = "./src/main/resources/ch_baw.exe";
    private static File file = new File("./src/main/resources/data.txt");
    private static final String ACCOUNT_DATA = file.getAbsolutePath();

    public static void authorization() throws IOException {
        executeScriptCmd(CMD_PROGRAM, ACCOUNT_DATA);
    }
}
