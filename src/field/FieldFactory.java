package field;

import io.OutputRole;

import java.io.Serializable;

public class FieldFactory implements FieldFactoryRole, Serializable {

    private OutputRole output;

    public FieldFactory(OutputRole otherOutput) {
        this.output = otherOutput;
    }

    @Override
    public FieldRole build() {
        return new Field(output);
    }
}
