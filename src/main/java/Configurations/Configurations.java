package Configurations;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurations {
    public String getNumbersOnlyRegex() {
        return numbersOnlyRegex;
    }

    private String numbersOnlyRegex;

    public Configurations(){
        String appConfigPath="src/main/java/Configurations/Configurations.properties";
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        }
        catch (IOException io){
            //write to log and return
            return;
        }
        this.numbersOnlyRegex = appProps.getProperty("numbersOnlyRegex");

    }
}
