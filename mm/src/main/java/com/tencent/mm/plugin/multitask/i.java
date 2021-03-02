package com.tencent.mm.plugin.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/multitask/MultiTaskPathRouter;", "", "()V", "multiTaskAccPath", "", "getMultiTaskAccPath", "()Ljava/lang/String;", "multiTaskCoverImgPath", "getMultiTaskCoverImgPath", "plugin-multitask_release"})
public final class i {
    private static String zZo = "";
    private static final String zZp = (eqB() + "coverimg/");
    public static final i zZq = new i();

    static {
        AppMethodBeat.i(200306);
        if (!s.YS(eqB())) {
            s.boN(eqB());
        }
        if (!s.YS(zZp)) {
            s.boN(zZp);
        }
        AppMethodBeat.o(200306);
    }

    private i() {
    }

    private static String eqB() {
        AppMethodBeat.i(200305);
        StringBuilder sb = new StringBuilder();
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String sb2 = sb.append(aAh.getAccPath()).append("multitask/").toString();
        AppMethodBeat.o(200305);
        return sb2;
    }

    public static String eqC() {
        return zZp;
    }
}
