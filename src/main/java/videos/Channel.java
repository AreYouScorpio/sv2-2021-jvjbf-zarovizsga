package videos;

public class Channel {

    private String channelName;
    private int subscriber;
    private int numberOfVideos;

    public Channel(String channelName, int subscriber, int numberOfVideos) {
        this.channelName = channelName;
        this.subscriber = subscriber;
        this.numberOfVideos = numberOfVideos;
    }

    public String getChannelName() {
        return channelName;
    }

    public int getSubscriber() {
        return subscriber;
    }

    public int getNumberOfVideos() {
        return numberOfVideos;
    }
}
