package stepic.solutions_14513_step_9;

/**
 * Created by ipetrash on 21.09.2016.
 */
public class TestMain {
    @org.junit.Test
    public void testSpam() throws Exception {
        TextAnalyzer spam = new SpamAnalyzer("заработать денег", "увеличить член", "взять ипотеку");
        String comment = "Можно много заработать денег и увеличить член, если взять ипотеку.";

        Label result = Main.checkLabels(new TextAnalyzer[] { spam }, comment);
        if (result != Label.SPAM) {
            throw new Error(String.format("Text: '%s', result: '%s', check: result != Label.SPAM", comment, result));
        }

        comment = "Спасибо за коммент!";
        result = Main.checkLabels(new TextAnalyzer[] { spam }, comment);
        if (result != Label.OK) {
            throw new Error(String.format("Text: '%s', result: '%s', result != Label.OK", comment, result));
        }

        comment = "Спасибо за коммент!";
        result = Main.checkLabels(new TextAnalyzer[] { }, comment);
        if (result != Label.OK) {
            throw new Error(String.format("Text: '%s', result: '%s', result != Label.OK", comment, result));
        }
    }

    @org.junit.Test
    public void testNegative() throws Exception {
        NegativeTextAnalyzer negative = new NegativeTextAnalyzer();

        String comment = ":(";
        Label result = Main.checkLabels(new TextAnalyzer[] { negative }, comment);
        if (result != Label.NEGATIVE_TEXT) {
            throw new Error(String.format("Text: '%s', result: '%s', check: result != Label.NEGATIVE_TEXT", comment, result));
        }

        comment = ":)";
        result = Main.checkLabels(new TextAnalyzer[] { negative }, comment);
        if (result != Label.OK) {
            throw new Error(String.format("Text: '%s', result: '%s', check: result != Label.OK", comment, result));
        }

        comment = ":(:):(";
        result = Main.checkLabels(new TextAnalyzer[] { negative }, comment);
        if (result != Label.NEGATIVE_TEXT) {
            throw new Error(String.format("Text: '%s', result: '%s', check: result != Label.NEGATIVE_TEXT", comment, result));
        }
    }

    @org.junit.Test
    public void testTooLongText() throws Exception {
        String comment = ":(";
        Label result = Main.checkLabels(new TextAnalyzer[] { new TooLongTextAnalyzer(1) }, comment);
        if (result != Label.TOO_LONG) {
            throw new Error(String.format("Text: '%s', result: '%s', check: result != Label.TOO_LONG", comment, result));
        }

        result = Main.checkLabels(new TextAnalyzer[] { new TooLongTextAnalyzer(100) }, comment);
        if (result != Label.OK) {
            throw new Error(String.format("Text: '%s', result: '%s', check: result != Label.OK", comment, result));
        }

        result = Main.checkLabels(new TextAnalyzer[] { new TooLongTextAnalyzer(comment.length()) }, comment);
        if (result != Label.OK) {
            throw new Error(String.format("Text: '%s', result: '%s', check: result != Label.OK", comment, result));
        }
    }

    @org.junit.Test
    public void testSpam_TooLongText() throws Exception {
        TextAnalyzer spam = new SpamAnalyzer("заработать денег", "увеличить член", "взять ипотеку");
        String comment = "Можно много заработать денег и увеличить член, если взять ипотеку.";

        Label result = Main.checkLabels(new TextAnalyzer[] { spam, new TooLongTextAnalyzer(1) }, comment);
        if (result != Label.SPAM) {
            throw new Error(String.format("Text: '%s', result: '%s', check: result != Label.SPAM", comment, result));
        }

        result = Main.checkLabels(new TextAnalyzer[] { new TooLongTextAnalyzer(1), spam }, comment);
        if (result != Label.TOO_LONG) {
            throw new Error(String.format("Text: '%s', result: '%s', check: result != Label.TOO_LONG", comment, result));
        }

        comment = "Спасибо за коммент!";
        result = Main.checkLabels(new TextAnalyzer[] { spam, new TooLongTextAnalyzer(100) }, comment);
        if (result != Label.OK) {
            throw new Error(String.format("Text: '%s', result: '%s', check: result != Label.OK", comment, result));
        }

        comment = "Спасибо за коммент!";
        result = Main.checkLabels(new TextAnalyzer[] { spam, new TooLongTextAnalyzer(comment.length()) }, comment);
        if (result != Label.OK) {
            throw new Error(String.format("Text: '%s', result: '%s', check: result != Label.OK", comment, result));
        }
    }

    @org.junit.Test
    public void testNegative_TooLongText() throws Exception {
        NegativeTextAnalyzer negative = new NegativeTextAnalyzer();
        String comment = "Можно много заработать денег и увеличить член, если взять ипотеку.";

        Label result = Main.checkLabels(new TextAnalyzer[] { negative, new TooLongTextAnalyzer(1) }, comment);
        if (result != Label.TOO_LONG) {
            throw new Error(String.format("Text: '%s', result: '%s', check: result != Label.TOO_LONG", comment, result));
        }

        comment = ":|";
        result = Main.checkLabels(new TextAnalyzer[] { negative, new TooLongTextAnalyzer(1) }, comment);
        if (result != Label.NEGATIVE_TEXT) {
            throw new Error(String.format("Text: '%s', result: '%s', check: result != Label.NEGATIVE_TEXT", comment, result));
        }

        comment = "Все ок!";
        result = Main.checkLabels(new TextAnalyzer[] { negative, new TooLongTextAnalyzer(10) }, comment);
        if (result != Label.OK) {
            throw new Error(String.format("Text: '%s', result: '%s', check: result != Label.OK", comment, result));
        }
    }

    @org.junit.Test
    public void testSpam_Negative_TooLongText() throws Exception {
        NegativeTextAnalyzer negative = new NegativeTextAnalyzer();
        TextAnalyzer spam = new SpamAnalyzer("заработать денег", "увеличить член", "взять ипотеку");

        String comment = "Можно много заработать денег и увеличить член, если взять ипотеку.";

        Label result = Main.checkLabels(new TextAnalyzer[] { negative, spam, new TooLongTextAnalyzer(1) }, comment);
        if (result != Label.SPAM) {
            throw new Error(String.format("Text: '%s', result: '%s', "
                    + "check: result != Label.SPAM", comment, result));
        }

        result = Main.checkLabels(new TextAnalyzer[] { new TooLongTextAnalyzer(1), negative, spam }, comment);
        if (result != Label.TOO_LONG) {
            throw new Error(String.format("Text: '%s', result: '%s', "
                    + "check: result != Label.TOO_LONG", comment, result));
        }

        comment += "  :(";
        result = Main.checkLabels(new TextAnalyzer[] { negative, new TooLongTextAnalyzer(1), spam }, comment);
        if (result != Label.NEGATIVE_TEXT) {
            throw new Error(String.format("Text: '%s', result: '%s', "
                    + "check: result != Label.NEGATIVE_TEXT", comment, result));
        }

        comment = "Все хорошо!";
        result = Main.checkLabels(new TextAnalyzer[] { negative, new TooLongTextAnalyzer(5), spam }, comment);
        if (result != Label.TOO_LONG) {
            throw new Error(String.format("Text: '%s', result: '%s', "
                    + "check: result != Label.TOO_LONG", comment, result));
        }

        comment = "Все хорошо!";
        result = Main.checkLabels(new TextAnalyzer[] { negative, new TooLongTextAnalyzer(100), spam }, comment);
        if (result != Label.OK) {
            throw new Error(String.format("Text: '%s', result: '%s', "
                    + "check: result != Label.OK", comment, result));
        }
    }

}