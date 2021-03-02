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
public final /* synthetic */ class ad extends u {
    public static final h cMy = new ad();

    static {
        AppMethodBeat.i(175883);
        AppMethodBeat.o(175883);
    }

    ad() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(175884);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(175884);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "sdcard_path";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getSdcard_path()Ljava/lang/String;";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        return ((MBRuntime.MBParams) obj).sdcard_path;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        ((MBRuntime.MBParams) obj).sdcard_path = (String) obj2;
    }
}
