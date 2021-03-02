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
public final /* synthetic */ class ag extends u {
    public static final h cMy = new ag();

    static {
        AppMethodBeat.i(206841);
        AppMethodBeat.o(206841);
    }

    ag() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(206842);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(206842);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "support_hardware_decode";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getSupport_hardware_decode()Z";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(206843);
        Boolean valueOf = Boolean.valueOf(((MBRuntime.MBParams) obj).support_hardware_decode);
        AppMethodBeat.o(206843);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(206844);
        ((MBRuntime.MBParams) obj).support_hardware_decode = ((Boolean) obj2).booleanValue();
        AppMethodBeat.o(206844);
    }
}
