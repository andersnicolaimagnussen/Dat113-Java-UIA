package Models;

public class AppUser {

    public String getConsumerKey() {
        return ConsumerKey;
    }

    public void setConsumerKey(String consumerKey) {
        ConsumerKey = consumerKey;
    }

    public String getApiSecret() {
        return ApiSecret;
    }

    public void setApiSecret(String apiSecret) {
        ApiSecret = apiSecret;
    }

    private String ConsumerKey = "UviomhjcTancy3POn4pBdNZvv";
    private String ApiSecret = "jVsPZ4N3HDE9Bq24oXpimeCtjEea2bOOWrlvyWSh5ca9fQplvX";

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }

    private String AccessToken = "820264180469133312-2gUISSewZED3ssjmH3liN6ZhseW4KSj";

    public String getAccessTokenSecret() {
        return AccessTokenSecret;
    }

    public void setAccessTokenSecret(String accessTokenSecret) {
        AccessTokenSecret = accessTokenSecret;
    }

    private String AccessTokenSecret = "75zPZ0yoGxCWJl9dznqMMYuQLXFTPEx0dCI8C86H2xJ05";

    public String getNamedTweets() {
        return namedTweets;
    }

    public void setNamedTweets(String namedTweets) {
        this.namedTweets = namedTweets;
    }

    private String namedTweets = "dat113";


}
