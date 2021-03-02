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
public final /* synthetic */ class o extends u {
    public static final h cMy = new o();

    static {
        AppMethodBeat.i(140124);
        AppMethodBeat.o(140124);
    }

    o() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(140125);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(140125);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "enable_2d";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getEnable_2d()Z";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(140126);
        Boolean valueOf = Boolean.valueOf(((MBRuntime.MBParams) obj).enable_2d);
        AppMethodBeat.o(140126);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(140127);
        ((MBRuntime.MBParams) obj).enable_2d = ((Boolean) obj2).booleanValue();
        AppMethodBeat.o(140127);
    }
}
