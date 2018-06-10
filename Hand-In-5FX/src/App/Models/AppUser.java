package App.Models;


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

    private String ConsumerKey = "secret";
    private String ApiSecret = "secret";

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }

    private String AccessToken = "secret";

    public String getAccessTokenSecret() {
        return AccessTokenSecret;
    }

    public void setAccessTokenSecret(String accessTokenSecret) {
        AccessTokenSecret = accessTokenSecret;
    }

    private String AccessTokenSecret = "secret";

    public String getNamedTweets() {
        return namedTweets;
    }

    public void setNamedTweets(String namedTweets) {
        this.namedTweets = namedTweets;
    }

    private String namedTweets = "dat113";


}
