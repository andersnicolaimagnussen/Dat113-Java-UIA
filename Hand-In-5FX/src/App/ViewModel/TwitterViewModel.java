package App.ViewModel;


import twitter4j.Status;

import java.util.ArrayList;

public class TwitterViewModel {



    public TwitterViewModel(){

        tweetList = new ArrayList<Status>();
    }


    public static ArrayList<Status> getTweetList() {
        return tweetList;
    }

    public static void setTweetList(ArrayList<Status> tweetList) {
        TwitterViewModel.tweetList = tweetList;
    }

    private static ArrayList<Status> tweetList;
}
