package ViewModel;

import twitter4j.Status;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class TwitterViewModel {

    public static ArrayList<Status> getTweetList() {
        return tweetList;
    }

    public void setTweetList(ArrayList<Status> tweetList) {
        this.tweetList = tweetList;
    }

    public TwitterViewModel(){

        tweetList = new ArrayList<Status>();

    }

    private static ArrayList<Status> tweetList;


}
