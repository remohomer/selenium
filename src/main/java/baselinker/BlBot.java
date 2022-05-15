package baselinker;

import org.openqa.selenium.chrome.ChromeDriver;
import bot.HiddenChrome;
import bot.Bot;

public class BlBot extends Bot {
    protected BlActions blActions;
    protected Countries countries;
    protected ChromeDriver driver;

    public BlBot(HiddenChrome hiddenChrome) throws InterruptedException {
        super(hiddenChrome);
        blActions = new BlActions(hiddenChrome.getDriver());
        driver = hiddenChrome.getDriver();
    }

    public BlActions getBlActions() {
        return blActions;
    }

    public ChromeDriver getDriver() {
        return driver;
    }
}
