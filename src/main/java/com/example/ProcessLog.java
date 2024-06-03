package com.example;

public class ProcessLog {
    public ProcessLog(String input, String output, String target, String replacement) {
        this.input = input;
        this.output = output;
        this.target = target;
        this.replacement = replacement;
    }
    public ProcessLog(String input, String output, String target, String replacement,boolean remove) {
        this.input = input;
        this.output = output;
        this.target = target;
        this.replacement = replacement;
        this.remove = remove;
    }

    private String input;
    private String output;
    private String target;
    private String replacement;
    private boolean remove = true;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getReplacement() {
        return replacement;
    }

    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }

    public boolean isRemove() {
        return remove;
    }
}
