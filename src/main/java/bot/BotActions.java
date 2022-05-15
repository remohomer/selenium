package bot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class BotActions {

    private final ChromeDriver driver;

    public BotActions(ChromeDriver driver) {
        this.driver = driver;
    }

    public void typeStringToElement(FindElementBy type, String elementName, String textToWrite, boolean letterByLetter) throws InterruptedException {

        Random random = new Random();
        WebElement webElement;

        switch (type) {
            case CLASS_NAME -> webElement = driver.findElement(By.className(elementName));
            case CSS_SELECTOR -> webElement = driver.findElement(By.cssSelector(elementName));
            case ID -> webElement = driver.findElement(By.id(elementName));
            case NAME -> webElement = driver.findElement(By.name(elementName));
            case LINK_TEXT -> webElement = driver.findElement(By.linkText(elementName));
            case PARTIAL_LINK_TEXT -> webElement = driver.findElement(By.partialLinkText(elementName));
            case TAG_NAME -> webElement = driver.findElement(By.tagName(elementName));
            case X_PATH -> webElement = driver.findElement(By.xpath(elementName));
            default -> webElement = null;
        }

        if (webElement == null) {
            System.out.println("ERROR: Enum FindElementBy is NULL");
        } else {
            if (letterByLetter) {
                for (int i = 0; i < textToWrite.length(); i++) {
                    webElement.sendKeys("" + textToWrite.charAt(i));
                    randomDelayLikeHuman(75, 250);
                }
            } else {
                webElement.sendKeys("" + textToWrite);
            }
        }
        randomDelayLikeHuman();
    }

    public void randomDelayLikeHuman() throws InterruptedException {
        Random random = new Random();
        int randomInt = random.nextInt(500, 1000);
        System.out.println("delay: " + randomInt);
        Thread.sleep(randomInt);
    }

    public void randomDelayLikeHuman(int min, int max) throws InterruptedException {
        Random random = new Random();
        int randomInt = random.nextInt(min,max);
        System.out.println("delay: " + randomInt);
        Thread.sleep(randomInt);
    }

    public void waitForPageLoad() throws InterruptedException {

        long currentTime = System.currentTimeMillis();
        JavascriptExecutor js;
        String pageLoadStatus;
        do {
            js = (JavascriptExecutor) driver;
            pageLoadStatus = (String) js.executeScript("return document.readyState");
        } while (!pageLoadStatus.equals("complete"));

        long pageLoadTime = System.currentTimeMillis() - currentTime;
        System.out.println("Page Loaded in " + pageLoadTime + " ms");

    }

    public void loadPage(String url) throws InterruptedException {
        driver.get(url);
        waitForPageLoad();
        randomDelayLikeHuman();
    }

    private void selectDropdown(ChromeDriver driver, FindElementBy type, String fieldName, String textToWrite) {
    }

    public void clickToWebElement(FindElementBy type, String elementName) throws InterruptedException {
        WebElement webElement = null;
        switch (type) {
            case CLASS_NAME -> webElement = driver.findElement(By.className(elementName));
            case CSS_SELECTOR -> webElement = driver.findElement(By.cssSelector(elementName));
            case ID -> webElement = driver.findElement(By.id(elementName));
            case NAME -> webElement = driver.findElement(By.name(elementName));
            case LINK_TEXT -> webElement = driver.findElement(By.linkText(elementName));
            case PARTIAL_LINK_TEXT -> webElement = driver.findElement(By.partialLinkText(elementName));
            case TAG_NAME -> webElement = driver.findElement(By.tagName(elementName));
            case X_PATH -> webElement = driver.findElement(By.xpath(elementName));
        }
        if (webElement != null) {
            webElement.click();
            randomDelayLikeHuman(10, 250);
        }
    }

    public void clickToGoogleRecaptcha() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='recaptcha-checkbox-border']"))).click();
        System.out.println("Clicked the Google Recaptcha checkbox");
    }


}
