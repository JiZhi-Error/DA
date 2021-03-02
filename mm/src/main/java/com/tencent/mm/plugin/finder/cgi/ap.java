package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/MegaVideoBaseRequestFactory;", "", "()V", "create", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBaseRequest;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-finder_release"})
public final class ap {
    public static final ap tuF = new ap();

    static {
        AppMethodBeat.i(242330);
        AppMethodBeat.o(242330);
    }

    private ap() {
    }

    public static /* synthetic */ cnh cYc() {
        AppMethodBeat.i(242329);
        cnh b2 = b(null);
        AppMethodBeat.o(242329);
        return b2;
    }

    public static cnh b(bbn bbn) {
        AppMethodBeat.i(242328);
        cnh cnh = new cnh();
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        cnh.MtN = aAh.azQ().getInt(ar.a.USERINFO_FINDER_USER_VERSION_INT_SYNC, 0);
        if (bbn != null) {
            cnh.scene = bbn.tCE;
        }
        AppMethodBeat.o(242328);
        return cnh;
    }
}
