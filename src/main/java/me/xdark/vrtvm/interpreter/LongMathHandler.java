package me.xdark.vrtvm.interpreter;

import me.xdark.vrtvm.JavaValue;
import me.xdark.vrtvm.VMContext;
import me.xdark.vrtvm.VMStack;
import org.objectweb.asm.tree.AbstractInsnNode;

public final class LongMathHandler implements InstructionInterpreter<AbstractInsnNode> {
    private final LongMathFunction mathFunction;

    public LongMathHandler(LongMathFunction mathFunction) {
        this.mathFunction = mathFunction;
    }

    @Override
    public void process(VMContext ctx, AbstractInsnNode insn) {
        VMStack stack = ctx.stack;
        JavaValue value2 = stack.pop();
        JavaValue value1 = stack.pop();
        stack.pushTop(ctx.vm.newLong(mathFunction.apply(value1.longValue(), value2.longValue())));
    }

    @FunctionalInterface
    public interface LongMathFunction {
        long apply(long v1, long v2);
    }
}
