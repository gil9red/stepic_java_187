package stepic.solutions_14513_step_9;

/**
 * Created by ipetrash on 21.09.2016.
 */

// TooLongTextAnalyzer должен конструироваться от int'а с максимальной допустимой длиной комментария. Объект этого
// класса должен сохранять в своем состоянии это число в приватном поле maxLength.
public class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        return text.length() > maxLength ? Label.TOO_LONG : Label.OK;
    }
}
