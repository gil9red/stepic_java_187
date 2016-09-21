package stepic.solutions_14513_step_9;

/**
 * Created by ipetrash on 21.09.2016.
 */
public abstract class KeywordAnalyzer implements TextAnalyzer {
    abstract protected String[] getKeywords();
    abstract protected Label getLabel();

    public Label processText(String text) {
        // Поиск слова в getKeywords и возврат getLabel, если нашли
        for (String word : getKeywords()) {
            if (text.contains(word)) {
                return getLabel();
            }
        }

        return Label.OK;
    }
}
