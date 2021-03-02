package com.tencent.magicbrush;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.aa;
import kotlin.g.b.u;
import kotlin.l;
import kotlin.l.b;
import kotlin.l.d;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16})
public final /* synthetic */ class h extends u {
    public static final kotlin.l.h cMy = new h();

    static {
        AppMethodBeat.i(140100);
        AppMethodBeat.o(140100);
    }

    h() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(140101);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(140101);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "adjust_thread_priority";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getAdjust_thread_priority()Z";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(140102);
        Boolean valueOf = Boolean.valueOf(((MBRuntime.MBParams) obj).adjust_thread_priority);
        AppMethodBeat.o(140102);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(140103);
        ((MBRuntime.MBParams) obj).adjust_thread_priority = ((Boolean) obj2).booleanValue();
        AppMethodBeat.o(140103);
    }
}
