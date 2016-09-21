package stepic.solutions_14513_step_9;

/**
 * Created by ipetrash on 21.09.2016.
 */

// SpamAnalyzer должен конструироваться от массива строк с ключевыми словами. Объект этого класса должен сохранять
// в своем состоянии этот массив строк в приватном поле keywords.
public class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords;

    public SpamAnalyzer(String... keywords) {
        this.keywords = keywords.clone();
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }
}
