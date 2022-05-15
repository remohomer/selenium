package bot;

public class Bot {

    protected HiddenChrome hiddenChrome;
    protected BotActions actions;
    protected CookieManager cookieManager;

    public Bot(HiddenChrome hiddenChrome) throws InterruptedException {
        this.hiddenChrome = hiddenChrome;
        actions = new BotActions(hiddenChrome.getDriver());
        cookieManager = new CookieManager(this);
    }

    public BotActions getActions() {
        return actions;
    }

    public CookieManager getCookieManager() {
        return cookieManager;
    }

    public HiddenChrome getHiddenChrome() {
        return hiddenChrome;
    }

}