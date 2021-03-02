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
public final /* synthetic */ class n extends u {
    public static final h cMy = new n();

    static {
        AppMethodBeat.i(140120);
        AppMethodBeat.o(140120);
    }

    n() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(140121);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(140121);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "device_pixel_ratio_";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getDevice_pixel_ratio_()F";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(140122);
        Float valueOf = Float.valueOf(((MBRuntime.MBParams) obj).device_pixel_ratio_);
        AppMethodBeat.o(140122);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(140123);
        ((MBRuntime.MBParams) obj).device_pixel_ratio_ = ((Number) obj2).floatValue();
        AppMethodBeat.o(140123);
    }
}
