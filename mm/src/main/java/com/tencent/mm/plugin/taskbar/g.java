package com.tencent.mm.plugin.taskbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/TaskBarPathRouter;", "", "()V", "taskBarAccPath", "", "getTaskBarAccPath", "()Ljava/lang/String;", "taskBarCoverImgPath", "getTaskBarCoverImgPath", "plugin-taskbar_release"})
public final class g {
    private static String FSb = "";
    private static final String FSc = (fus() + "coverimg/");
    public static final g FSd = new g();

    static {
        AppMethodBeat.i(238424);
        if (!s.YS(fus())) {
            s.boN(fus());
        }
        if (!s.YS(FSc)) {
            s.boN(FSc);
        }
        AppMethodBeat.o(238424);
    }

    private g() {
    }

    private static String fus() {
        AppMethodBeat.i(238423);
        StringBuilder sb = new StringBuilder();
        e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String sb2 = sb.append(aAh.getAccPath()).append("taskbar/").toString();
        AppMethodBeat.o(238423);
        return sb2;
    }

    public static String fut() {
        return FSc;
    }
}
