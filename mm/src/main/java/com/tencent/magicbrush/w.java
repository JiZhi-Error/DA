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
public final /* synthetic */ class w extends u {
    public static final h cMy = new w();

    static {
        AppMethodBeat.i(140156);
        AppMethodBeat.o(140156);
    }

    w() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(140157);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(140157);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "enable_wxbindcanvastexture";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getEnable_wxbindcanvastexture()Z";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(140158);
        Boolean valueOf = Boolean.valueOf(((MBRuntime.MBParams) obj).enable_wxbindcanvastexture);
        AppMethodBeat.o(140158);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(140159);
        ((MBRuntime.MBParams) obj).enable_wxbindcanvastexture = ((Boolean) obj2).booleanValue();
        AppMethodBeat.o(140159);
    }
}
