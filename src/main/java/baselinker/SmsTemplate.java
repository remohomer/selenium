package baselinker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import bot.FindElementBy;

import java.util.ArrayList;
import java.util.List;

public class SmsTemplate {
    private final String emailAddress;
    private final String accountName;
    private final String shopName;
    private String sender;

    private final List<String> displayName;
    private final List<String> message;

    public SmsTemplate(LanguageType language, String emailAddress, String accountName, String shopName, String sender) {
        this.emailAddress = emailAddress;
        this.accountName = accountName;
        this.shopName = shopName;
        this.sender = sender;

        displayName = new ArrayList<>();
        message = new ArrayList<>();

        init(language);
    }

    public void init( LanguageType languageType) {
        switch (languageType) {
            case PL -> initPL();
            case US -> initUS();
        }
    }

    private void initPL() {

        // zamówienia pobraniowe
        displayName.add(accountName + " - zamówienie pobraniowe");
        message.add(
                "Dziękujemy za zakup w naszym sklepie :) \n" +
                "Zweryfikuj swoje dane: \n" +
                "[imie_nazwisko][adres][kod_pocztowy][miasto] \n" +
                "w razie czego pisz na adres email: " + emailAddress + "\n" +
                "Ekipa " + shopName
        );

        // wysłanie zamówienia
        displayName.add(accountName + " - wysłane pobranie");
        message.add("" +
                "Twoja przesyłka jest już w drodze - przygotuj pieniądze \n" +
                "KASA KASA KASA \n" +
                "Do zapłaty: [laczna_cena] \n" +
                "w razie czego pisz na adres email: " + emailAddress + "\n" +
                "Ekipa " + shopName
        );
    }

    private void initUS() {

        // zamówienia pobraniowe
        displayName.add(accountName + " - zamówienie pobraniowe");
        message.add("" +
                "Thank you for buying in our store :) \n" +
                "Verify your data: \n" +
                "[Name_Nazwisko] [Address] [Code_Pocztt] [City] \n" +
                "If necessary, write to the email address:" + emailAddress + "\n" +
                "Team " + shopName
        );

        // wysłanie zamówienia
        displayName.add(accountName + " - wysłane pobranie");
        message.add("" +
                "Your shipment is on the way - prepare money \n" +
                "Kasa Kasa Kasa \n" +
                "To pay: [laczna_cena] \n" +
                "If necessary, write to the email address:" + emailAddress + "\n" +
                "Team" + shopName
        );
    }

    public static void addTemplatesToBl(BlBot bot, List<SmsTemplate> listOfSmsTemplates) throws InterruptedException {
        bot.getBlActions().loadOrderEmailsPage();

        ChromeDriver driver = bot.getHiddenChrome().getDriver();

        for (SmsTemplate smsTemplate : listOfSmsTemplates) {

            for (int i = 0; i < smsTemplate.getDisplayName().size(); i++) {
                bot.getBlActions().addNewSmsTemplate();

                WebElement displayName = driver.findElement(By.id("display_name"));
                displayName.sendKeys(smsTemplate.getDisplayName().get(i));
                bot.getBlActions().randomDelayLikeHuman(200, 300);

                bot.getBlActions().typeStringToElement(FindElementBy.ID, "body", smsTemplate.getMessage().get(i), false);
                bot.getBlActions().randomDelayLikeHuman(200, 300);

                bot.getBlActions().typeStringToElement(FindElementBy.ID, "sender", smsTemplate.getSender(), false);
                bot.getBlActions().randomDelayLikeHuman(200, 300);


                bot.getBlActions().clickToWebElement(FindElementBy.X_PATH, "//button[contains(text(),'Zapisz')]");
                bot.getBlActions().randomDelayLikeHuman(500, 1000);

                bot.getBlActions().clickToWebElement(FindElementBy.X_PATH,"//button[contains(text(),'Zamknij')]");

                bot.getBlActions().randomDelayLikeHuman(3000, 4000);
            }
        }
    }

    public List<String> getMessage() {
        return message;
    }

    public List<String> getDisplayName() {
        return displayName;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getShopName() {
        return shopName;
    }

    public String getSender() {
        return sender;
    }
}
