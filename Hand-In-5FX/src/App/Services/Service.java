package App.Services;

import App.Models.AppUser;
import App.ViewModel.TwitterViewModel;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Service {
    AppUser Anders;
    TwitterViewModel viewModel;
    ArrayList<Status> list = new ArrayList<Status>();

    public Twitter getTwitter() {
        return twitter;
    }

    public TwitterFactory getTf() {
        return tf;
    }

    private Twitter twitter;
    private TwitterFactory tf;

    // Inisialisere connection mot APIet
    public Service() throws TwitterException {
        Anders = new AppUser();
        authenticateService();
        //searchTwitter(Anders.getNamedTweets());
    }


    public void authenticateService() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey(Anders.getConsumerKey());
        cb.setOAuthConsumerSecret(Anders.getApiSecret());
        cb.setOAuthAccessToken(Anders.getAccessToken());
        cb.setOAuthAccessTokenSecret(Anders.getAccessTokenSecret());

        tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
        //searchTwitter(Anders.getNamedTweets());
    }


    public void searchTwitter(String namedTweets) throws TwitterException {

        Query query = new Query(namedTweets);
        GeoLocation geo = new GeoLocation(58.3405000, 8.5934300);
        query.setGeoCode(geo, 100.0, Query.KILOMETERS);
        query.setLang("no");
        QueryResult result = twitter.search(query);
        ArrayList<Status> list = new ArrayList<>();
        //JOptionPane.showMessageDialog(null, s.getText());
        for (Status s : result.getTweets()) {
            list.add(s);
            //System.out.println(s.getText());
        }
        TwitterViewModel.setTweetList(list);
    }
    public void postNewTweet(String statusPost) throws TwitterException {
        twitter.updateStatus(statusPost);
    }
}