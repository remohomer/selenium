package baselinker;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Countries {

    private List<Country> listofCountries = new ArrayList<>();
    BlBot bot;
    ChromeDriver driver;

    public Countries(BlBot bot) {
        this.bot = bot;
        driver = bot.getHiddenChrome().getDriver();
        init();
    }

    public void init() {
                listofCountries.add(new Country("Afganistan","AF"));
                listofCountries.add(new Country("Albania","AL"));
                listofCountries.add(new Country("Algieria","DZ"));
                listofCountries.add(new Country("Andora","AD"));
                listofCountries.add(new Country("Angola","AO"));
                listofCountries.add(new Country("Anguilla","AI"));
                listofCountries.add(new Country("Antarktyda","AQ"));
                listofCountries.add(new Country("Antigua i Barbuda","AG"));
                listofCountries.add(new Country("Arabia Saudyjska","SA"));
                listofCountries.add(new Country("Argentyna","AR"));
                listofCountries.add(new Country("Armenia","AM"));
                listofCountries.add(new Country("Aruba","AW"));
                listofCountries.add(new Country("Australia","AU"));
                listofCountries.add(new Country("Austria","AT"));
                listofCountries.add(new Country("Azerbejdżan","AZ"));
                listofCountries.add(new Country("Bahamy","BS"));
                listofCountries.add(new Country("Bahrajn","BH"));
                listofCountries.add(new Country("Bangladesz","BD"));
                listofCountries.add(new Country("Barbados","BB"));
                listofCountries.add(new Country("Belgia","BE"));
                listofCountries.add(new Country("Belize","BZ"));
                listofCountries.add(new Country("Benin","BJ"));
                listofCountries.add(new Country("Bermudy","BM"));
                listofCountries.add(new Country("Bhutan","BT"));
                listofCountries.add(new Country("Białoruś","BY"));
                listofCountries.add(new Country("Boliwia","BO"));
                listofCountries.add(new Country("Bonaire","BQ"));
                listofCountries.add(new Country("Bośnia i Hercegowina","BA"));
                listofCountries.add(new Country("Botswana","BW"));
                listofCountries.add(new Country("Brazylia","BR"));
                listofCountries.add(new Country("Brunei","BN"));
                listofCountries.add(new Country("Brytyjskie Terytorium Oceanu Indyjskiego","IO"));
                listofCountries.add(new Country("Bułgaria","BG"));
                listofCountries.add(new Country("Burkina Faso","BF"));
                listofCountries.add(new Country("Burundi","BI"));
                listofCountries.add(new Country("Chile","CL"));
                listofCountries.add(new Country("Chiny","CN"));
                listofCountries.add(new Country("Curaçao","CW"));
                listofCountries.add(new Country("Chorwacja","HR"));
                listofCountries.add(new Country("Cypr","CY"));
                listofCountries.add(new Country("Czad","TD"));
                listofCountries.add(new Country("Czarnogóra","ME"));
                listofCountries.add(new Country("Czechy","CZ"));
                listofCountries.add(new Country("Dania","DK"));
                listofCountries.add(new Country("Dominika","DM"));
                listofCountries.add(new Country("Dominikana","DO"));
                listofCountries.add(new Country("Dżibuti","DJ"));
                listofCountries.add(new Country("Egipt","EG"));
                listofCountries.add(new Country("Ekwador","EC"));
                listofCountries.add(new Country("Erytrea","ER"));
                listofCountries.add(new Country("Estonia","EE"));
                listofCountries.add(new Country("Etiopia","ET"));
                listofCountries.add(new Country("Falklandy","FK"));
                listofCountries.add(new Country("Fidżi","FJ"));
                listofCountries.add(new Country("Filipiny","PH"));
                listofCountries.add(new Country("Finlandia","FI"));
                listofCountries.add(new Country("Francuskie Terytoria Południowe","TF"));
                listofCountries.add(new Country("Francja","FR"));
                listofCountries.add(new Country("Gabon","GA"));
                listofCountries.add(new Country("Gambia","GM"));
                listofCountries.add(new Country("Ghana","GH"));
                listofCountries.add(new Country("Gibraltar","GI"));
                listofCountries.add(new Country("Grecja","GR"));
                listofCountries.add(new Country("Grenada","GD"));
                listofCountries.add(new Country("Grenlandia","GL"));
                listofCountries.add(new Country("Gruzja","GE"));
                listofCountries.add(new Country("Guam","GU"));
                listofCountries.add(new Country("Gujana","GY"));
                listofCountries.add(new Country("Gwatemala","GT"));
                listofCountries.add(new Country("Gwinea","GN"));
                listofCountries.add(new Country("Gwinea Równikowa","GQ"));
                listofCountries.add(new Country("Gwinea-Bissau","GW"));
                listofCountries.add(new Country("Haiti","HT"));
                listofCountries.add(new Country("Hiszpania","ES"));
                listofCountries.add(new Country("Honduras","HN"));
                listofCountries.add(new Country("Hongkong","HK"));
                listofCountries.add(new Country("Indie","IN"));
                listofCountries.add(new Country("Indonezja","ID"));
                listofCountries.add(new Country("Irak","IQ"));
                listofCountries.add(new Country("Iran","IR"));
                listofCountries.add(new Country("Irlandia","IE"));
                listofCountries.add(new Country("Islandia","IS"));
                listofCountries.add(new Country("Izrael","IL"));
                listofCountries.add(new Country("Jamajka","JM"));
                listofCountries.add(new Country("Japonia","JP"));
                listofCountries.add(new Country("Jemen","YE"));
                listofCountries.add(new Country("Jordania","JO"));
                listofCountries.add(new Country("Kajmany","KY"));
                listofCountries.add(new Country("Kambodża","KH"));
                listofCountries.add(new Country("Kamerun","CM"));
                listofCountries.add(new Country("Kanada","CA"));
                listofCountries.add(new Country("Katar","QA"));
                listofCountries.add(new Country("Kazachstan","KZ"));
                listofCountries.add(new Country("Kenia","KE"));
                listofCountries.add(new Country("Kirgistan","KG"));
                listofCountries.add(new Country("Kiribati","KI"));
                listofCountries.add(new Country("Kolumbia","CO"));
                listofCountries.add(new Country("Komory","KM"));
                listofCountries.add(new Country("Kongo","CG"));
                listofCountries.add(new Country("Kongo, Republika Demokratyczna","CD"));
                listofCountries.add(new Country("Korea Południowa","KP"));
                listofCountries.add(new Country("Kosowo","XK"));
                listofCountries.add(new Country("Kostaryka","CR"));
                listofCountries.add(new Country("Kuba","CU"));
                listofCountries.add(new Country("Kuwejt","KW"));
                listofCountries.add(new Country("Laos","LA"));
                listofCountries.add(new Country("Lesoto","LS"));
                listofCountries.add(new Country("Liban","LB"));
                listofCountries.add(new Country("Liberia","LR"));
                listofCountries.add(new Country("Libia","LY"));
                listofCountries.add(new Country("Liechtenstein","LI"));
                listofCountries.add(new Country("Litwa","LT"));
                listofCountries.add(new Country("Luksemburg","LU"));
                listofCountries.add(new Country("Łotwa","LV"));
                listofCountries.add(new Country("Macedonia","MK"));
                listofCountries.add(new Country("Madagaskar","MG"));
                listofCountries.add(new Country("Majotta","YT"));
                listofCountries.add(new Country("Makau","MO"));
                listofCountries.add(new Country("Malawi","MW"));
                listofCountries.add(new Country("Malediwy","MV"));
                listofCountries.add(new Country("Malezja","MY"));
                listofCountries.add(new Country("Mali","ML"));
                listofCountries.add(new Country("Malta","MT"));
                listofCountries.add(new Country("Mariany Północne","MP"));
                listofCountries.add(new Country("Maroko","MA"));
                listofCountries.add(new Country("Mauretania","MR"));
                listofCountries.add(new Country("Mauritius","MU"));
                listofCountries.add(new Country("Meksyk","MX"));
                listofCountries.add(new Country("Mikronezja","FM"));
                listofCountries.add(new Country("Mołdawia","MD"));
                listofCountries.add(new Country("Mongolia","MN"));
                listofCountries.add(new Country("Montserrat","MS"));
                listofCountries.add(new Country("Mozambik","MZ"));
                listofCountries.add(new Country("Namibia","NA"));
                listofCountries.add(new Country("Nauru","NR"));
                listofCountries.add(new Country("Nepal","NP"));
                listofCountries.add(new Country("Holandia","NL"));
                listofCountries.add(new Country("Niemcy","DE"));
                listofCountries.add(new Country("Niger","NE"));
                listofCountries.add(new Country("Nigeria","NG"));
                listofCountries.add(new Country("Nikaragua","NI"));
                listofCountries.add(new Country("Niue","NU"));
                listofCountries.add(new Country("Norfolk","NF"));
                listofCountries.add(new Country("Norwegia","NO"));
                listofCountries.add(new Country("Nowa Kaledonia","NC"));
                listofCountries.add(new Country("Nowa Zelandia","NZ"));
                listofCountries.add(new Country("Terytoria Palestyńskie","PS"));
                listofCountries.add(new Country("Oman","OM"));
                listofCountries.add(new Country("Pakistan","PK"));
                listofCountries.add(new Country("Palau","PW"));
                listofCountries.add(new Country("Panama","PA"));
                listofCountries.add(new Country("Papua-Nowa Gwinea","PG"));
                listofCountries.add(new Country("Paragwaj","PY"));
                listofCountries.add(new Country("Peru","PE"));
                listofCountries.add(new Country("Pitcairn","PN"));
                listofCountries.add(new Country("Polinezja Francuska","PF"));
                listofCountries.add(new Country("Polska","PL"));
                listofCountries.add(new Country("Republika Południowej Afryki","ZA"));
                listofCountries.add(new Country("Georgia Południowa i Sandwich Południowy","GS"));
                listofCountries.add(new Country("Portugalia","PT"));
                listofCountries.add(new Country("Republika Środkowoafrykańska","CF"));
                listofCountries.add(new Country("Rosja","RU"));
                listofCountries.add(new Country("Rwanda","RW"));
                listofCountries.add(new Country("Sahara Zachodnia","EH"));
                listofCountries.add(new Country("St. Barthelemy","BL"));
                listofCountries.add(new Country("Rumunia","RO"));
                listofCountries.add(new Country("Salwador","SV"));
                listofCountries.add(new Country("Samoa","WS"));
                listofCountries.add(new Country("Samoa Amerykańskie","AS"));
                listofCountries.add(new Country("San Marino","SM"));
                listofCountries.add(new Country("Senegal","SN"));
                listofCountries.add(new Country("Serbia","XS"));
                listofCountries.add(new Country("Seszele","SC"));
                listofCountries.add(new Country("Sierra Leone","SL"));
                listofCountries.add(new Country("Singapur","SG"));
                listofCountries.add(new Country("Suazi","SZ"));
                listofCountries.add(new Country("Słowacja","SK"));
                listofCountries.add(new Country("Słowenia","SI"));
                listofCountries.add(new Country("Somalia","SO"));
                listofCountries.add(new Country("Sri Lanka","LK"));
                listofCountries.add(new Country("Saint Pierre i Miquelon","PM"));
                listofCountries.add(new Country("St. Kitts i Nevis","KN"));
                listofCountries.add(new Country("St. Lucia","LC"));
                listofCountries.add(new Country("St. Vincent i Grenadyny","VC"));
                listofCountries.add(new Country("Stany Zjednoczone","US"));
                listofCountries.add(new Country("Sudan","SD"));
                listofCountries.add(new Country("Surinam","SR"));
                listofCountries.add(new Country("Syria","SY"));
                listofCountries.add(new Country("Szwajcaria","CH"));
                listofCountries.add(new Country("Szwecja","SE"));
                listofCountries.add(new Country("Wyspa Świętej Heleny","SH"));
                listofCountries.add(new Country("Tadżykistan","TJ"));
                listofCountries.add(new Country("Tajlandia","TH"));
                listofCountries.add(new Country("Tajwan","TW"));
                listofCountries.add(new Country("Tanzania","TZ"));
                listofCountries.add(new Country("Togo","TG"));
                listofCountries.add(new Country("Tokelau","TK"));
                listofCountries.add(new Country("Tonga","TO"));
                listofCountries.add(new Country("Trynidad i Tobago","TT"));
                listofCountries.add(new Country("Tunezja","TN"));
                listofCountries.add(new Country("Turcja","TR"));
                listofCountries.add(new Country("Turkmenistan","TM"));
                listofCountries.add(new Country("Turks i Caicos Wyspy","TC"));
                listofCountries.add(new Country("Tuvalu","TV"));
                listofCountries.add(new Country("Uganda","UG"));
                listofCountries.add(new Country("Ukraina","UA"));
                listofCountries.add(new Country("Urugwaj","UY"));
                listofCountries.add(new Country("Uzbekistan","UZ"));
                listofCountries.add(new Country("Vanuatu","VU"));
                listofCountries.add(new Country("Wyspy Wallis i Futuna","WF"));
                listofCountries.add(new Country("Watykan","VA"));
                listofCountries.add(new Country("Wenezuela","VE"));
                listofCountries.add(new Country("Węgry","HU"));
                listofCountries.add(new Country("Wielka Brytania","GB"));
                listofCountries.add(new Country("Wietnam","VN"));
                listofCountries.add(new Country("Włochy","IT"));
                listofCountries.add(new Country("Timor Wschodni","TL"));
                listofCountries.add(new Country("Wybrzeże Kości Słoniowej","CI"));
                listofCountries.add(new Country("Wyspa Bouveta","BV"));
                listofCountries.add(new Country("Wyspa Bożego Narodzenia","CX"));
                listofCountries.add(new Country("Wyspy Cooka","CK"));
                listofCountries.add(new Country("Wyspy Dziewicze (USA)","VI"));
                listofCountries.add(new Country("Bryt. Wyspy Dziewicze","VG"));
                listofCountries.add(new Country("Wyspy Heard i McDonald","HM"));
                listofCountries.add(new Country("Wyspy Kokosowe","CC"));
                listofCountries.add(new Country("Wyspy Owcze","FO"));
                listofCountries.add(new Country("Wyspy Marshalla","MH"));
                listofCountries.add(new Country("Wyspy Salomona","SB"));
                listofCountries.add(new Country("St. Maarten i St. Martin","SX"));
                listofCountries.add(new Country("Wyspy Świętego Tomasza i Książęca","ST"));
                listofCountries.add(new Country("Zambia","ZM"));
                listofCountries.add(new Country("Wyspy Zielonego Przylądka","CV"));
                listofCountries.add(new Country("Zimbabwe","ZW"));
                listofCountries.add(new Country("Zjednoczone Emiraty Arabskie","AE"));
                listofCountries.add(new Country("Irlandia Północna","XI"));
    }

    public void copyChangeAndSave() throws InterruptedException {
        bot.getBlActions().loadOrderMacrosPage();

        for (int i = 0; i < listofCountries.size(); i++) {
            try {
                WebElement copyActionButton = driver.findElement(By.xpath("//*[@id=\"cellActionsContainer_90145\"]/table/tbody/tr/td[3]/a/i"));
                copyActionButton.click();
                bot.getBlActions().randomDelayLikeHuman(2000+ (i*10), 3000 + i*(10));

                WebElement typeCountry = driver.findElement(By.cssSelector(".select2-search__field"));
                bot.getBlActions().randomDelayLikeHuman(50, 100);

                typeCountry.sendKeys(Keys.BACK_SPACE);
                typeCountry.clear();
                typeCountry.sendKeys(getListOfCountries().get(i).getCountryName());
                typeCountry.sendKeys(Keys.ENTER);
                bot.getBlActions().randomDelayLikeHuman(250, 500);

                WebElement typeAdditionalCondition = driver.findElement(By.xpath("//textarea[@placeholder='Zawartość pola dodatkowego']"));
                typeAdditionalCondition.clear();
                typeAdditionalCondition.sendKeys(getListOfCountries().get(i).getCountryCode() + "*[Faktura]");
                bot.getBlActions().randomDelayLikeHuman(250, 500);

                WebElement saveButton = driver.findElement(By.id("btnSaveEdition"));
                saveButton.click();
                bot.getBlActions().randomDelayLikeHuman(1500, 2000);
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("window.scrollTo(0,0)");
                bot.getBlActions().randomDelayLikeHuman(500, 1000);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error on the: " + i + ". [" + listofCountries.get(i).getCountryCode() + "] " + listofCountries.get(i).getCountryName());
                driver.get("https://panel-d.baselinker.com/logout.php");
                break;
            }
        }
    }



    public List<Country> getListOfCountries() {
        return listofCountries;
    }
}
