package baselinker;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import bot.BotActions;
import bot.FindElementBy;

public class BlActions extends BotActions {

    private ChromeDriver driver;
    private BotActions botActions;

    public BlActions(ChromeDriver driver) {
        super(driver);
        this.driver = driver;
        botActions = new BotActions(driver);
    }

    public void logIn(String login, String password) throws InterruptedException {
        botActions.loadPage( "https://login.baselinker.com/");
        botActions.typeStringToElement( FindElementBy.ID, "loginField", login, false);
        botActions.typeStringToElement( FindElementBy.ID, "passwordField", password, false);
        botActions.clickToWebElement( FindElementBy.ID, "signinButton");
        botActions.randomDelayLikeHuman();
        botActions.waitForPageLoad();
        botActions.loadPage( "https://login.baselinker.com/");
    }
    public void logOut() {
        driver.get("https://panel-d.baselinker.com/logout.php");
    }

    public void loadOrderMacrosPage() throws InterruptedException {
        driver.get("https://panel-d.baselinker.com/orders_macros.php");
        botActions.waitForPageLoad();
        botActions.randomDelayLikeHuman();
    }

    public void loadOrderEmailsPage() throws InterruptedException {
        driver.get("https://panel-d.baselinker.com/orders_emails.php");
        botActions.waitForPageLoad();
        botActions.randomDelayLikeHuman();
    }

    public void addNewOrderMacro() throws InterruptedException {
        botActions.clickToWebElement(FindElementBy.X_PATH,"//button[contains(text(),'Dodaj automatyczną akcję')]");
        botActions.randomDelayLikeHuman(3000,4000);
    }

    public void addNewEmailTemplate() throws InterruptedException {
        botActions.clickToWebElement(FindElementBy.X_PATH,"//button[contains(text(),'Nowy szablon e-mail')]");
        botActions.randomDelayLikeHuman(1500,2000);
    }

    public void addNewSmsTemplate() throws InterruptedException {
        botActions.clickToWebElement(FindElementBy.X_PATH,"//button[contains(text(),'Nowy szablon sms')]");
        botActions.randomDelayLikeHuman(1500,2000);
    }

    public void selectMacroConditions() throws InterruptedException {
        botActions.clickToWebElement(FindElementBy.CSS_SELECTOR,".select2-selection.select2-selection--single");
    }

    public void selectGroupOfConditions() throws InterruptedException {
        WebElement groupOfCondition = driver.findElement(By.cssSelector(".select2-search__field"));
        botActions.randomDelayLikeHuman(50, 100);

        groupOfCondition.sendKeys("Pobrano zamówienie");
        groupOfCondition.sendKeys(Keys.ENTER);
        botActions.randomDelayLikeHuman(50,100);
    }

    public void selectConditions() throws InterruptedException {
        WebElement condition = driver.findElement(By.id("select2-editorConditionType_1651918011972-container"));
        condition.sendKeys("Źródło zamówienia");
        condition.sendKeys(Keys.ENTER);
        botActions.randomDelayLikeHuman(50,100);
    }

}
