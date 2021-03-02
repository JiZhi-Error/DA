package com.tencent.magicbrush;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.aa;
import kotlin.g.b.u;
import kotlin.l;
import kotlin.l.b;
import kotlin.l.d;
import kotlin.l.h;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16})
public final /* synthetic */ class ac extends u {
    public static final h cMy = new ac();

    static {
        AppMethodBeat.i(206829);
        AppMethodBeat.o(206829);
    }

    ac() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(206830);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(206830);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "revert_cpu_optimizer_test";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getRevert_cpu_optimizer_test()Z";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(206831);
        Boolean valueOf = Boolean.valueOf(((MBRuntime.MBParams) obj).revert_cpu_optimizer_test);
        AppMethodBeat.o(206831);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(206832);
        ((MBRuntime.MBParams) obj).revert_cpu_optimizer_test = ((Boolean) obj2).booleanValue();
        AppMethodBeat.o(206832);
    }
}
