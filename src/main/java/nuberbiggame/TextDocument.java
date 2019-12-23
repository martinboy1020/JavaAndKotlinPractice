package nuberbiggame;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextDocument extends PlainDocument {
    private int maxLength;

    public TextDocument(int newMaxLength) {
        super();
        maxLength = newMaxLength;
    }

    public TextDocument() {
        this(10);
    }

    public void insertString(int offset, String str, javax.swing.text.AttributeSet a) throws BadLocationException {

        Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");

        if (getLength() + str.length() > maxLength) {
            return;
        } else {

            Matcher isNum = pattern.matcher(str);

            if(isNum.matches()) {
                super.insertString(offset, str, a);
            }

        }
    }
}