package stepic.solutions_14513_step_9;

/**
 * Created by ipetrash on 21.09.2016.
 */

// NegativeTextAnalyzer должен конструироваться конструктором по-умолчанию.
public class NegativeTextAnalyzer extends KeywordAnalyzer {
    private static String[] keywords = { ":(", "=(", ":|" };

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
