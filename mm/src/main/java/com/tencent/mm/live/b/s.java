package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/live/model/LiveSysMsgNotifierManager;", "", "()V", "notifier", "Lcom/tencent/mm/live/model/ILiveSysMsgNotifier;", "instace", "release", "", "setup", "plugin-logic_release"})
public final class s {
    private static j hIk;
    public static final s hIl = new s();

    static {
        AppMethodBeat.i(207689);
        AppMethodBeat.o(207689);
    }

    private s() {
    }

    public static void a(j jVar) {
        hIk = jVar;
    }

    public static void release() {
        hIk = null;
    }

    public static j aGe() {
        return hIk;
    }
}
