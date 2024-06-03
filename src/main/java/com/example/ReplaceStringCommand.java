package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceStringCommand implements Command<List<ProcessLog>> {
    private static final Pattern pattern = Pattern.compile("([a-z])\\1{2,}");
    private String input;

    public ReplaceStringCommand(String input) {
        this.input = input;
    }

    @Override
    public List<ProcessLog> execute() {
        List<ProcessLog> result = new ArrayList<>();
        String remaining = input;
        while (true) {
            ProcessLog log = processString(remaining);
            if (remaining.equals(log.getOutput())) {
                break;
            }
            result.add(log);
            remaining = log.getOutput();
        }
        return result;
    }

    private ProcessLog processString(final String input) {
        Matcher matcher = pattern.matcher(input);
        ProcessLog log = new ProcessLog(input, input, "", "", false);

        if (matcher.find()) {
            String group = matcher.group();
            String beforeChar = beforeChar(group);
            log.setTarget(group);
            log.setReplacement(beforeChar);
            log.setOutput(input.replaceAll(group, beforeChar));
        }
        return log;
    }

    private String beforeChar(String ch) {
        char c = ch.charAt(0);
        if (c - 1 < 'a') {
            return "";
        } else {
            return String.valueOf((char) (c - 1));
        }
    }
}
