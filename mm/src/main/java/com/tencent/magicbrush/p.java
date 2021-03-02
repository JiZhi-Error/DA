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
public final /* synthetic */ class p extends u {
    public static final h cMy = new p();

    static {
        AppMethodBeat.i(140128);
        AppMethodBeat.o(140128);
    }

    p() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(140129);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(140129);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "allow_antialias_";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getAllow_antialias_()Z";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(140130);
        Boolean valueOf = Boolean.valueOf(((MBRuntime.MBParams) obj).allow_antialias_);
        AppMethodBeat.o(140130);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(140131);
        ((MBRuntime.MBParams) obj).allow_antialias_ = ((Boolean) obj2).booleanValue();
        AppMethodBeat.o(140131);
    }
}
