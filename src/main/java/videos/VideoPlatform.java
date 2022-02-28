package videos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {

    private List<Channel> channels = new ArrayList<>();

    public List<Channel> getChannels() {
        return channels;
    }

    public void readDataFromFile(Path inputfile) {

        boolean header = true;
        try (
                BufferedReader br = Files.newBufferedReader(inputfile)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (header)
                    parseHeader(line);
                else
                    parseLine(line);
                header = false;
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot open file for read!");
        }
    }

    private void parseHeader(String line) {
    }

    private void parseLine(String line) {
        String[] temp = line.split(";");
        String channelName = temp[0];
        int subscriptions = Integer.parseInt(temp[1]);
        int numberOfVideos = Integer.parseInt(temp[2]);
        channels.add(new Channel(channelName, subscriptions, numberOfVideos));
    }

    public int calculateSumOfVideos() {
        return channels.stream().mapToInt(x -> x.getNumberOfVideos()).sum();
    }

}
