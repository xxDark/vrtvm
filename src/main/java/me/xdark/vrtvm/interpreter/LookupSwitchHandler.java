package me.xdark.vrtvm.interpreter;

import me.xdark.vrtvm.VMContext;
import org.objectweb.asm.tree.LookupSwitchInsnNode;

public final class LookupSwitchHandler implements InstructionInterpreter<LookupSwitchInsnNode> {
    @Override
    public void process(VMContext ctx, LookupSwitchInsnNode insn) {
        int key = ctx.stack.pop().intValue();
        int index = insn.keys.indexOf(key);
        ctx.cursor((index == -1) ? insn.dflt : insn.labels.get(index));
    }
}
