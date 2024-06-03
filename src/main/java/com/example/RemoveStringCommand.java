package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveStringCommand implements Command<List<ProcessLog>> {
    private static  final Pattern pattern = Pattern.compile("([a-z])\\1{2,}");
    private String input;
    public RemoveStringCommand(String input) {
        this.input = input;
    }

    @Override
    public List<ProcessLog> execute() {
        List<ProcessLog> result = new ArrayList<>();
        String remaining = input;
        while (true) {
            ProcessLog log = processString(remaining);
            result.add(log);

            // if no more consecutive characters, break
            if (remaining.equals(log.getOutput())) {
                result.remove(result.size() - 1);
                break;
            }

            // next input is the output of the previous process
            remaining = log.getOutput();
        }
        return result;
    }

    // remove consecutive characters and record log
    private ProcessLog processString(final String input) {
        Matcher matcher = pattern.matcher(input);
        ProcessLog log = new ProcessLog(input, input,"","");
        String processed = input;
        while (matcher.find()) {
            String group = matcher.group();
            processed = processed.replaceAll(group, "");
        }
        log.setOutput(processed);
        return log;
    }
}
