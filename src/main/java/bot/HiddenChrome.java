package bot;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class HiddenChrome {
    private ChromeOptions options;
    private ChromeDriver driver;

    public HiddenChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
        initStandardOptions();
        driver = new ChromeDriver(options);
    }

    HiddenChrome(String profileName) {
        initStandardOptions();
        addProfileOptions(profileName, "C:/BrowserDrivers/User Data");
    }

    HiddenChrome(String profileName, String profilePath) {
        initStandardOptions();
        addProfileOptions(profileName, profilePath);
    }

    private void addProfileOptions(String profileName, String profilePath) {
        options.addArguments(
                "--user-data-dir=" + profilePath,
                "--profile-directory=" + profileName);
    }

    public void initStandardOptions() {
//            System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
            options = new ChromeOptions();
            options.addArguments(
                    "start-maximized",
                    "disable-infobars",
                    "user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36",
                    "--disable-extensions",
                    "--disable-blink-features=AutomationControlled"
            );
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);

            options.setExperimentalOption("prefs", prefs);
    }

    public ChromeDriver getDriver() {
        return driver;
    }

    public ChromeOptions getOptions() {
        return options;
    }
}
