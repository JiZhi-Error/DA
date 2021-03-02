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
public final /* synthetic */ class y extends u {
    public static final h cMy = new y();

    static {
        AppMethodBeat.i(206823);
        AppMethodBeat.o(206823);
    }

    y() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(206824);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(206824);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "force_run_v8_microtasks";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getForce_run_v8_microtasks()Z";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(206825);
        Boolean valueOf = Boolean.valueOf(((MBRuntime.MBParams) obj).force_run_v8_microtasks);
        AppMethodBeat.o(206825);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(206826);
        ((MBRuntime.MBParams) obj).force_run_v8_microtasks = ((Boolean) obj2).booleanValue();
        AppMethodBeat.o(206826);
    }
}
