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
public final /* synthetic */ class q extends u {
    public static final h cMy = new q();

    static {
        AppMethodBeat.i(140132);
        AppMethodBeat.o(140132);
    }

    q() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(140133);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(140133);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "use_command_buffer";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getUse_command_buffer()Z";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(140134);
        Boolean valueOf = Boolean.valueOf(((MBRuntime.MBParams) obj).use_command_buffer);
        AppMethodBeat.o(140134);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(140135);
        ((MBRuntime.MBParams) obj).use_command_buffer = ((Boolean) obj2).booleanValue();
        AppMethodBeat.o(140135);
    }
}
