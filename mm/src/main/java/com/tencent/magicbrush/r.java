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
public final /* synthetic */ class r extends u {
    public static final h cMy = new r();

    static {
        AppMethodBeat.i(140136);
        AppMethodBeat.o(140136);
    }

    r() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(140137);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(140137);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "enable_font_batch";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getEnable_font_batch()Z";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(140138);
        Boolean valueOf = Boolean.valueOf(((MBRuntime.MBParams) obj).enable_font_batch);
        AppMethodBeat.o(140138);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(140139);
        ((MBRuntime.MBParams) obj).enable_font_batch = ((Boolean) obj2).booleanValue();
        AppMethodBeat.o(140139);
    }
}
