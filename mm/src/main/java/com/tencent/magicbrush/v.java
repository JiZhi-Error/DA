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
public final /* synthetic */ class v extends u {
    public static final h cMy = new v();

    static {
        AppMethodBeat.i(140152);
        AppMethodBeat.o(140152);
    }

    v() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(140153);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(140153);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "enable_window_attributes_alpha";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getEnable_window_attributes_alpha()Z";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(140154);
        Boolean valueOf = Boolean.valueOf(((MBRuntime.MBParams) obj).enable_window_attributes_alpha);
        AppMethodBeat.o(140154);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(140155);
        ((MBRuntime.MBParams) obj).enable_window_attributes_alpha = ((Boolean) obj2).booleanValue();
        AppMethodBeat.o(140155);
    }
}
