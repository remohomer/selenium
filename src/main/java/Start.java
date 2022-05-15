import baselinker.BlBot;
import baselinker.EmailTemplate;
import baselinker.LanguageType;
import baselinker.SmsTemplate;
import bot.CookieManager;
import bot.HiddenChrome;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) throws InterruptedException {

        BlBot bot = new BlBot(new HiddenChrome());
        ChromeDriver driver = bot.getHiddenChrome().getDriver();
        bot.getBlActions().logIn("email", "haslo");
        bot.getBlActions().randomDelayLikeHuman();


        // ---------- BASELINKER ---------- //

        List<baselinker.EmailTemplate> listOfEmailTemplates = new ArrayList<>();
        listOfEmailTemplates.add(new baselinker.EmailTemplate(baselinker.LanguageType.PL, "rrem0h@gmail.com", "ALLEGRO rrem0h", "remoh"));
        listOfEmailTemplates.add(new baselinker.EmailTemplate(baselinker.LanguageType.PL, "lesiogotuje@gmail.com", "WORDPRESS lesiogotuje.pl", "Lesio Gotuje"));
        listOfEmailTemplates.add(new baselinker.EmailTemplate(baselinker.LanguageType.US, "abfksds", "EBAY remoh", "remoh"));
        listOfEmailTemplates.add(new baselinker.EmailTemplate(baselinker.LanguageType.US, "rrem0h@gmail.com", "AMAZON remoh", "remoh"));
        EmailTemplate.addTemplatesToBl(bot, listOfEmailTemplates);


        List<SmsTemplate> listOfSmsTemplates = new ArrayList<>();
        listOfSmsTemplates.add(new SmsTemplate(LanguageType.PL, "rrem0h@gmail.com", "ALLEGRO rrem0h", "remoh", "REMOH"));
        listOfSmsTemplates.add(new SmsTemplate(LanguageType.PL, "lesiogotuje@gmail.com", "WORDPRESS lesiogotuje.pl", "Lesio Gotuje", "LG"));
        listOfSmsTemplates.add(new SmsTemplate(LanguageType.US, "abfksds", "EBAY remoh", "remoh", "REMOH"));
        listOfSmsTemplates.add(new SmsTemplate(LanguageType.US, "rrem0h@gmail.com", "AMAZON remoh", "remoh", "REMOH"));
        SmsTemplate.addTemplatesToBl(bot, listOfSmsTemplates);
//
//
//        Countries countries = new Countries(bot);
//        countries.copyChangeAndSave();


//        bot.getBlActions().addNewOrderMacro();
//        bot.getBlActions().typeStringToElement(FindElementBy.X_PATH,
//                "//*[@id=\"conditionContainerTemplate_-1\"]/div[2]/table/tbody/tr/td[1]/span/span[1]/span/ul/li/input",
//                "rrem0h" + Keys.ENTER,
//                false);

//        WebElement orderSource = driver.findElement(By.className("select2-search__field"));
//        orderSource.sendKeys("rrem0h");
//        orderSource.sendKeys(Keys.ENTER);

//        Select dropdown = new Select(driver.findElement(By.id("filter_trigger_type")));
//        dropdown.selectByVisibleText("Wystawiono paragon");

//        baselinkerOrderMacros.selectMacroConditions();
//        baselinkerOrderMacros.selectGroupOfConditions();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Save Cookies? [Y/N]: ");

        if (scanner.nextLine().toLowerCase(Locale.ROOT).equals("y")) {
            CookieManager cookieManager = new CookieManager(bot);
            cookieManager.save();
        }

        System.out.println("Exit Chrome? [Y/N]: ");
        if (scanner.nextLine().toLowerCase(Locale.ROOT).equals("y")) {
            driver.quit();
        }
    }


}
