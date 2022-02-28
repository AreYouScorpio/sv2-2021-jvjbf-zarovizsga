package sentences;

public class SentenceTransformer {


    public String shortenSentence(String sentence) {
        String result = "";
        String firstWord = "";
        String lastWord = "";

        int counter = 0;
        char[] chars = sentence.toCharArray();
        char c=chars[chars.length - 1];
        if (!(chars[0] >= 'A' && chars[0] <= 'Z'))
            throw new IllegalArgumentException("Must start with capital letter!");
        else if (!(c == '.' || c == '!' || c == '?'))
            throw new IllegalArgumentException("Must end with . ! or ?");

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == ' ') {
                counter += 1;
            }
            lastWord += chars[i];
            if (chars[i] == ' ') {
                lastWord = "";
            }
            if (counter == 0) firstWord = firstWord + chars[i];

        }

        if (counter < 4) result = sentence;
        else {


            result = firstWord + " ... " + lastWord;
        }

        return result;

    }
}

