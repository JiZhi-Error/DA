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
public final /* synthetic */ class s extends u {
    public static final h cMy = new s();

    static {
        AppMethodBeat.i(140140);
        AppMethodBeat.o(140140);
    }

    s() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(140141);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(140141);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "enable_gfx";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getEnable_gfx()Z";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(140142);
        Boolean valueOf = Boolean.valueOf(((MBRuntime.MBParams) obj).enable_gfx);
        AppMethodBeat.o(140142);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(140143);
        ((MBRuntime.MBParams) obj).enable_gfx = ((Boolean) obj2).booleanValue();
        AppMethodBeat.o(140143);
    }
}
