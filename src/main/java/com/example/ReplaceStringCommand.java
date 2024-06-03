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
            result.add(log);

            if (remaining.equals(log.getOutput())) {
                result.remove(result.size() - 1);
                break;
            }
            remaining = log.getOutput();
        }
        return result;
    }

    private ProcessLog processString(final String input) {
        Matcher matcher = pattern.matcher(input);
        ProcessLog log = new ProcessLog(input, input, "", "", false);
        String processed = input;
        StringBuilder target = new StringBuilder();
        StringBuilder replacement = new StringBuilder();

        while (matcher.find()) {
            String group = matcher.group();
            String beforeChar = beforeChar(group);
            processed = processed.replaceAll(group, beforeChar);

            target.append(group);
            target.append(",");
            replacement.append(beforeChar);
            replacement.append(",");
        }
        if (target.length() > 0) {
            log.setTarget(target.deleteCharAt(target.length() - 1).toString());
        }
        if (replacement.length() > 0) {
            log.setReplacement(replacement.deleteCharAt(replacement.length() - 1).toString());
        }
        log.setOutput(processed);
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
