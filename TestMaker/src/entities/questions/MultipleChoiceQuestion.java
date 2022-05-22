package entities.questions;

import entities.Set;

import java.io.Serializable;

public class MultipleChoiceQuestion extends Question implements Serializable {

    private static final long serialVersionUID = -3513802003997353630L;

    private Set<MultipleChoiceOption> options;

    public MultipleChoiceQuestion(String text, Set<MultipleChoiceOption> options){
        super(text);
        if(options.getSize() <= 10)
            this.options = options;
        else{
            Set<MultipleChoiceOption> subOptions = new Set<>(MultipleChoiceOption.class);
            for(int i=0; i< 10; i++){
                subOptions.add(options.get(i));
            }
            this.options = subOptions;
        }
    }

    public boolean addOption(MultipleChoiceOption mco){
        this.options.add(mco);
        return true;
    }

    public boolean removeOption(int index){
        this.options.remove(index, MultipleChoiceOption.class);
        return true;
    }

    public Set<MultipleChoiceOption> getOptions(){
        return this.options;
    }

    public boolean setOptions(Set<MultipleChoiceOption> options) {
        this.options = options;
        return true;
    }

    public int getAnswerLength() {
    	int num=0;
    	for(MultipleChoiceOption option: this.options.getSet()){
    	    if(option != null)
    	        num += option.getOptionText().length();
        }
    	return num;
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder(super.toString() + "\nThe options are:\n");
        int num = 1;
        for(MultipleChoiceOption option: this.options.getSet()){
            if(option != null){
                ret.append(num).append(") ").append(option.getOptionText());
                if(option.isCorrectOption())
                    ret.append(" - Correct");
                else
                    ret.append(" - Incorrect");
                if(num != this.options.getSize())
                    ret.append("\n");
                num++;
            }
        }
        return ret.toString();
    }

    @Override
    public String noAnswer() {
        StringBuilder ret = new StringBuilder(super.toString() + "\nThe options are:\n");
        int num = 1;
        for(MultipleChoiceOption option: this.options.getSet()){
            if(option != null){
                ret.append(num).append(") ").append(option.getOptionText());
                if(num != this.options.getSize())
                    ret.append("\n");
                num++;
            }
        }
        return ret.toString();
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof MultipleChoiceQuestion))
            return false;
        MultipleChoiceQuestion mcq = (MultipleChoiceQuestion)other;
        return (mcq.text.equals(this.text))&&(this.options.equals(mcq.getOptions()));
    }


}
