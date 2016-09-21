package stepic.solutions_14513_step_9;

/**
 * Created by ipetrash on 21.09.2016.
 */

enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}

interface TextAnalyzer {
    Label processText(String text);
}
