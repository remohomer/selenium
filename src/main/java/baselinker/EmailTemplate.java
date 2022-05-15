package baselinker;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import bot.FindElementBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EmailTemplate {
    private String emailAddress;
    private String accountName;
    private String shopName;

    private List<String> displayName;
    private List<String> subject;
    private List<String> message;

    public EmailTemplate(LanguageType language, String emailAddress, String accountName, String shopName) {
        this.emailAddress = emailAddress;
        this.accountName = accountName;
        this.shopName = shopName;

        displayName = new ArrayList<>();
        subject = new ArrayList<>();
        message = new ArrayList<>();

        init(language);
    }

    public void init(LanguageType languageType) {
        switch (languageType) {
            case PL -> initPL();
            case US -> initUS();
        }
    }

    private void initPL() {

        // zamówienia pobraniowe
        displayName.add(accountName + " - zamówienie pobraniowe [email]");
        subject.add("[" + shopName.toUpperCase(Locale.ROOT) + "] Dziękujemy za zakup w naszym sklepie :)");
        message.add("" +
                "<p>Dziękujemy za zakup w naszym sklepie :)</p>" +
                "<p>Zweryfikuj swoje dane:</p>" +
                "<p>[imie_nazwisko][adres][kod_pocztowy][miasto]</p>" +
                "<p>w razie czego pisz na adres email: <strong><a href=\"mailto:" + emailAddress + "\">" + emailAddress + "</a></p></strong>" +
                "<p>Ekipa <strong>" + shopName + "</strong>"
        );

        // wysłanie zamówienia
        displayName.add(accountName + " - wysłane pobranie [email]");
        subject.add("[" + shopName.toUpperCase(Locale.ROOT) + "] Twoja przesyłka jest już w drodze - przygotuj pieniądze");
        message.add("" +
                "<p>Twoja przesyłka jest już w drodze - przygotuj pieniądze</p>" +
                "<p>KASA KASA KASA</p>" +
                "<p>Do zapłaty: [laczna_cena]</p>" +
                "<p>w razie czego pisz na adres email: <strong><a href=\"mailto:" + emailAddress + "\">" + emailAddress + "</a></p></strong>" +
                "<p>Ekipa <strong>" + shopName + "</strong>"
        );
    }

    private void initUS() {

        // zamówienia pobraniowe
        displayName.add(accountName + " - zamówienie pobraniowe [email]");
        subject.add("[" + shopName.toUpperCase(Locale.ROOT) + "] Thank you for purchasing in our store :)");
        message.add("" +
                "<p> Thank you for purchasing in our store :) </p>" +
                "<p> Verify your details: </p>" +
                "<p> [name] [address] [postcode] [city] </p>" +
                "<p> if necessary, write to the following email address: <strong> <a href=\"mailto:" + emailAddress + "\">" + emailAddress + "</a> </p> </strong>" +
                "<p> The team <strong>" + shopName + "</strong>"
        );

        // wysłanie zamówienia
        displayName.add(accountName + " - wysłane pobranie [email]");
        subject.add("[" + shopName.toUpperCase(Locale.ROOT) + "] Your package is on its way - prepare your money");
        message.add("" +
                "<p> Your package is on its way - prepare your money</p>" +
                "<p>MONEY MONEY MONEY</p>" +
                "<p> To be paid: [total_price] </p>" +
                "<p> if necessary, write to the following email address: <strong> <a href=\"mailto:" + emailAddress + "\">" + emailAddress + "</a> </p> </strong>" +
                "<p> The team <strong>" + shopName + "</strong>"
        );
    }

    public static void addTemplatesToBl(BlBot bot, List<EmailTemplate> listOfEmailTemplates) throws InterruptedException {
        bot.getBlActions().loadOrderEmailsPage();

        ChromeDriver driver = bot.getHiddenChrome().getDriver();

        for (EmailTemplate emailTemplate : listOfEmailTemplates) {
            for (int i = 0; i < emailTemplate.getDisplayName().size(); i++) {

                bot.getBlActions().addNewEmailTemplate();
                try {
                    WebElement displayName = driver.findElement(By.id("display_name"));
                    displayName.sendKeys(emailTemplate.getDisplayName().get(i));
                    bot.getBlActions().randomDelayLikeHuman(200, 300);

                    WebElement subject = driver.findElement(By.id("subject"));
                    subject.sendKeys(emailTemplate.getSubject().get(i));
                    bot.getBlActions().randomDelayLikeHuman(200, 300);

                    WebElement codeHtml = driver.findElement(By.xpath("//span[contains(text(),'Kod HTML')]"));
                    codeHtml.click();

                    bot.getBlActions().typeStringToElement(FindElementBy.ID, "body", emailTemplate.getMessage().get(i), false);
                    bot.getBlActions().randomDelayLikeHuman(200, 300);

                    Select chooseEmail = new Select(driver.findElement(By.id("email_account_id")));
                    List<WebElement> emailListFromSelect = chooseEmail.getOptions();


                    for (int j = 0; j < emailListFromSelect.size(); j++) {
                        if (emailListFromSelect.get(j).getText().contains(emailTemplate.getEmailAddress())) {
                            chooseEmail.selectByVisibleText(emailListFromSelect.get(j).getText());
                            break;
                        }
                        if (j == emailListFromSelect.size() - 1 && !emailListFromSelect.get(j).getText().contains(emailTemplate.getEmailAddress())) {
                            chooseEmail.selectByVisibleText(emailListFromSelect.get(emailListFromSelect.size() - 1).getText());
                        }
                    }

                    bot.getBlActions().randomDelayLikeHuman(200, 300);

                    bot.getBlActions().clickToWebElement(FindElementBy.ID, "email-template-save");
                    bot.getBlActions().randomDelayLikeHuman(400, 500);

                    WebElement closeTemplate = driver.findElement(By.xpath("//button[contains(text(),'Zamknij')]"));
                    closeTemplate.click();

                    bot.getBlActions().randomDelayLikeHuman(3000, 4000);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error on: " + emailTemplate.getDisplayName().get(i));
                }
            }
        }
    }

    public static void AddMacrosToSendEmails(BlBot bot, List<EmailTemplate> listOfEmailTemplates) throws InterruptedException {
        bot.getBlActions().loadOrderMacrosPage();

        for (int i = 0; i < listOfEmailTemplates.size(); i++) {
            try {

                WebElement copyActionButton = bot.getDriver().findElement(By.xpath("//*[@id=\"cellActionsContainer_92052\"]/table/tbody/tr/td[3]/a/i"));

                copyActionButton.click();
                bot.getBlActions().randomDelayLikeHuman(2000 + (i * 10), 3000 + i * (10));

                WebElement addNewCondition = bot.getDriver().findElement(By.xpath("//div[contains(text(),'Dodaj warunek')]"));


                //*[@id="cellEditionContainer_92074"]/div[1]/div[4]
                addNewCondition.click();
                bot.getBlActions().randomDelayLikeHuman(200, 300);


                WebElement typeAdditionalCondition = bot.getDriver().findElement(By.xpath("//input[@placeholder='Źródło zamówienia']"));
                typeAdditionalCondition.sendKeys(Keys.BACK_SPACE);
                typeAdditionalCondition.clear();
                typeAdditionalCondition.sendKeys(listOfEmailTemplates.get(i).getShopName());
                bot.getBlActions().randomDelayLikeHuman(250, 500);

                Thread.sleep(200000);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error on the: " + i + ". [" + listOfEmailTemplates.get(i).getDisplayName());
                bot.getDriver().get("https://panel-d.baselinker.com/logout.php");
                break;
            }
        }
    }

    public List<String> getMessage() {
        return message;
    }

    public List<String> getDisplayName() {
        return displayName;
    }

    public List<String> getSubject() {
        return subject;
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
}
