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
public final /* synthetic */ class ai extends u {
    public static final h cMy = new ai();

    static {
        AppMethodBeat.i(206849);
        AppMethodBeat.o(206849);
    }

    ai() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(206850);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(206850);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "sync_surface_destroy";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getSync_surface_destroy()Z";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(206851);
        Boolean valueOf = Boolean.valueOf(((MBRuntime.MBParams) obj).sync_surface_destroy);
        AppMethodBeat.o(206851);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(206852);
        ((MBRuntime.MBParams) obj).sync_surface_destroy = ((Boolean) obj2).booleanValue();
        AppMethodBeat.o(206852);
    }
}
