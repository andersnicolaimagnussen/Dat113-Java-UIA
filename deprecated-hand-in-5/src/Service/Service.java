package Service;

import Models.AppUser;
import ViewModel.TwitterViewModel;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import javax.swing.*;
import java.util.ArrayList;


public class Service {

    AppUser Anders;
    TwitterViewModel viewModel;
    ArrayList<Status> list = new ArrayList<Status>();
    private Twitter twitter;

    // Inisialisere connection mot APIet
    public Service() throws TwitterException {
        Anders = new AppUser();
        viewModel = new TwitterViewModel();
        authenticateService();
        seachTwitter(Anders.getNamedTweets());
    }

    public void authenticateService() throws TwitterException {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey(Anders.getConsumerKey());
        cb.setOAuthConsumerSecret(Anders.getApiSecret());

        cb.setOAuthAccessToken(Anders.getAccessToken());
        cb.setOAuthAccessTokenSecret(Anders.getAccessTokenSecret());

        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
        seachTwitter(Anders.getNamedTweets());
    }

    public void seachTwitter(String namedTweets) throws TwitterException {

        Query query = new Query("#" + namedTweets);
        GeoLocation geo = new GeoLocation(58.3405000,8.5934300);
        query.setGeoCode(geo, 100.0, Query.KILOMETERS);
        query.setLang("no");
        QueryResult result = twitter.search(query);


        for (Status s : result.getTweets()) {
            //JOptionPane.showMessageDialog(null, s.getText());
            list.add(s);
        }

        viewModel.setTweetList(list);

        for (Object s : viewModel.getTweetList()) {
            //JOptionPane.showMessageDialog(null, s.getText());
            //JOptionPane.showMessageDialog(null, s);
        }
    }

}
