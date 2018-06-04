package App.Controllers;

import App.Services.Service;
import App.ViewModel.TwitterViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.User;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TwitterController implements Initializable {

    public Label topLabel;
    @FXML
    public TextField searchInput;
    public Button lastTweetBtn;
    public Button searchNowBtn;
    public TextArea textOutput;
    public VBox centerBox;
    public TextField newTweet;
    public Button newTweetBtn;
    public Label userStatus;
    private Service _service;
    private Label error;
    private StringBuilder sb;
    public TwitterController() throws TwitterException {
        _service = new Service();
    }

    public void showLatestTweets(ActionEvent actionEvent) {
        if(TwitterViewModel.getTweetList() == null){
            //topLabel.setText("No old Tweets, search for some?");
            //topLabel.textProperty().bind(searchInput.textProperty());
            //JOptionPane.showMessageDialog(null,"The history is empty, make a change .. search now");
            error = new Label("The history is empty, make a change .. search now");
            centerBox.getChildren().add(error);
            topLabel.textProperty().bind(searchInput.textProperty());

        }
        else {
            textOutput.setPrefSize(600.0, 500.0);

            for (Status s : TwitterViewModel.getTweetList()) {

                System.out.println(s.getText());
                textOutput.appendText(sb.toString());


            }


        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        topLabel.textProperty().bind(searchInput.textProperty());
        //searchInput.textProperty().bind(searchInput.textProperty());
        System.out.println(searchInput.getText());
        try {
            User instanceUser = _service.getTwitter().showUser(_service.getTwitter().getScreenName());
            String name = instanceUser.getName();
            userStatus.textProperty().bind(new SimpleStringProperty("Logged in " +name));
        } catch (TwitterException e) {
            e.printStackTrace();
        }

    }

    public void searchForQuery(ActionEvent actionEvent) {
        System.out.println(topLabel.getText());
        try {
            _service.searchTwitter(topLabel.getText());
        } catch (TwitterException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        displayResult();
        topLabel.textProperty().bind(searchInput.textProperty());
        error.setText("");

        // Bind text to list
    }



    public void displayResult() {
        emptyResult(null);
            sb = new StringBuilder();
            for (Status msg : TwitterViewModel.getTweetList()) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(msg.getText());
                sb.append(msg.getUser().getName());
                textOutput.appendText(sb.toString());
                System.out.println(msg.getUser().getName() + msg.getText());
                textOutput.setPrefSize(600.0, 500.0);


            }
    }

    public void emptyResult(ActionEvent actionEvent) {
        if(textOutput != null)
            textOutput.setText("");

        textOutput.setText("");
        textOutput.setPrefSize(600.0, 200.0);
    }

    public void postNewTweet(ActionEvent actionEvent) throws TwitterException {
        String statusPost = newTweet.getText();
        _service.postNewTweet(statusPost);
    }
}
