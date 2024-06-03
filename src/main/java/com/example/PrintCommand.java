package com.example;

import java.util.List;

public class PrintCommand implements Command<Void> {
    private List<ProcessLog> logs;

    public PrintCommand(List<ProcessLog> logs) {
        this.logs = logs;
    }

    @Override
    public Void execute() {
        // if not empty, print each line
        if (logs != null && logs.size() > 0) {
            System.out.println("Output:");
            ProcessLog log = null;
            for (int i = 0; i < logs.size(); i++) {
                log = logs.get(i);
                System.out.println("-> " + log.getOutput()
                        + (log.isRemove() ? "" :
                            ("".equals(log.getReplacement()) ? "" :
                                    " " + log.getTarget() + " is replaced by " + log.getReplacement())));
            }
        }
        return null;
    }
}
