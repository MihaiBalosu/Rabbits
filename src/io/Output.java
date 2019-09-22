package io;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Output implements OutputRole, Serializable {

    private List<String> output;
    private String finalOutput;

    public Output() {
        this.output = new ArrayList<>();
        finalOutput = "";
    }

    @Override
    public void add(String message) {
        output.add(message);
    }

    @Override
    public String getOutput() {
        for(String message : output){
        	finalOutput += message;
        	finalOutput += "\n";
        }
        return finalOutput;
    }
}
