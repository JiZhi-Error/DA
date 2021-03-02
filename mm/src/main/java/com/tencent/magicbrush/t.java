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
public final /* synthetic */ class t extends u {
    public static final h cMy = new t();

    static {
        AppMethodBeat.i(140144);
        AppMethodBeat.o(140144);
    }

    t() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(140145);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(140145);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "allow_opengl3";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getAllow_opengl3()Z";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(140146);
        Boolean valueOf = Boolean.valueOf(((MBRuntime.MBParams) obj).allow_opengl3);
        AppMethodBeat.o(140146);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(140147);
        ((MBRuntime.MBParams) obj).allow_opengl3 = ((Boolean) obj2).booleanValue();
        AppMethodBeat.o(140147);
    }
}
