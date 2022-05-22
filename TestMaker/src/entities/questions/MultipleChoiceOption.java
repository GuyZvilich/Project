package entities.questions;

import java.io.Serializable;

public class MultipleChoiceOption implements Serializable {

    private static final long serialVersionUID = -9149657649401128626L;

    private String optionText;
    private boolean correctOption;

    public MultipleChoiceOption(String optionText, boolean correctOption) {
        this.optionText = optionText;
        this.correctOption = correctOption;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public boolean isCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(boolean correctOption) {
        this.correctOption = correctOption;
    }

    @Override
    public String toString() {
        return "MultipleChoiceOption{" +
                "optionText='" + optionText + '\'' +
                ", correctOption=" + correctOption +
                '}';
    }

    @Override
    public boolean equals(Object other){
        if(!(other instanceof MultipleChoiceOption))
            return false;
        MultipleChoiceOption mco = (MultipleChoiceOption)other;
        return this.optionText.equals(mco.getOptionText());
    }

}
