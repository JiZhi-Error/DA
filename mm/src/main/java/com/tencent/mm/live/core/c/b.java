package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fq;
import com.tencent.mm.live.core.core.e;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000bJ\u001e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/live/core/report/LiveKVReporter;", "", "()V", "liveId64", "", "scene", "", "visitorMode", "reportDecodeErr", "", "moduleName", "", "eventCode", "eventMsg", "setup", "liveId", "plugin-core_release"})
public final class b {
    private static int hEH = e.a.aCe();
    private static long hEI;
    public static final b hEJ = new b();
    private static int scene = e.f.aCO();

    static {
        AppMethodBeat.i(196714);
        e.f fVar = e.f.hxS;
        e.a aVar = e.a.hxc;
        AppMethodBeat.o(196714);
    }

    private b() {
    }

    public static void d(int i2, int i3, long j2) {
        scene = i2;
        hEH = i3;
        hEI = j2;
    }

    public static void h(String str, int i2, String str2) {
        AppMethodBeat.i(196713);
        fq fqVar = new fq();
        fqVar.sD(str);
        fqVar.pg((long) i2);
        fqVar.sE(str2);
        fqVar.pi(fqVar.agC());
        fqVar.pj((long) hEH);
        fqVar.ph(hEI);
        fqVar.bfK();
        AppMethodBeat.o(196713);
    }
}
