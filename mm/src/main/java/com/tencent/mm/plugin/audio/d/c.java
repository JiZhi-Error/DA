package com.tencent.mm.plugin.audio.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Stack;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/audio/util/EarPieceUtil;", "", "()V", "TAG", "", "releaseEarPieceResource", "", "mDeviceQueue", "Ljava/util/Stack;", "", "requestEarPieceResource", "", "plugin-audio_release"})
public final class c {
    public static final c oIp = new c();

    static {
        AppMethodBeat.i(224025);
        AppMethodBeat.o(224025);
    }

    private c() {
    }

    public static final boolean c(Stack<Integer> stack) {
        Integer lastElement;
        AppMethodBeat.i(224024);
        p.h(stack, "mDeviceQueue");
        Log.i("MicroMsg.EarPieceUtil", " request the earpiece resource");
        if (stack.isEmpty() || (lastElement = stack.lastElement()) == null || lastElement.intValue() != 2) {
            if (stack.contains(2)) {
                stack.removeElement(2);
            }
            stack.push(2);
            AppMethodBeat.o(224024);
            return true;
        }
        AppMethodBeat.o(224024);
        return false;
    }
}
