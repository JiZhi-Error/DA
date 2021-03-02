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
public final /* synthetic */ class z extends u {
    public static final h cMy = new z();

    static {
        AppMethodBeat.i(140162);
        AppMethodBeat.o(140162);
    }

    z() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(140163);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(140163);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "gc_factor";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getGc_factor()F";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(140164);
        Float valueOf = Float.valueOf(((MBRuntime.MBParams) obj).gc_factor);
        AppMethodBeat.o(140164);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(140165);
        ((MBRuntime.MBParams) obj).gc_factor = ((Number) obj2).floatValue();
        AppMethodBeat.o(140165);
    }
}
