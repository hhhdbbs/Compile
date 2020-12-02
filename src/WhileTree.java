import java.util.ArrayList;
import java.util.List;

public class WhileTree {
    BooleanTree booleanTree;
    public void setBooleanTree(BooleanTree booleanTree) {
        this.booleanTree = booleanTree;
    }

    public List<Instruction> generate() {
        List<Instruction> instructions=new ArrayList<>();
        instructions.add(new Instruction(Operation.br,(long)0));

        instructions.addAll(booleanTree.getInstructions());

        booleanTree.setTrueOffset(1);
        instructions.add(booleanTree.getOffset());

        instructions.add(new Instruction(Operation.br,(long)booleanTree.getTrueInstructions().size()+1));

        instructions.addAll(booleanTree.getTrueInstructions());

        booleanTree.setJump(-(booleanTree.size()+1));
        instructions.add(booleanTree.getJump());
        return instructions;
    }
}
