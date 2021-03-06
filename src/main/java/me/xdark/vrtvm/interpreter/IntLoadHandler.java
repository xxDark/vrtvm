package me.xdark.vrtvm.interpreter;

import me.xdark.vrtvm.VMContext;
import org.objectweb.asm.tree.VarInsnNode;

public final class IntLoadHandler implements InstructionInterpreter<VarInsnNode> {
    @Override
    public void process(VMContext ctx, VarInsnNode insn) {
        ctx.stack.push(ctx.locals.load(insn.var));
    }
}
