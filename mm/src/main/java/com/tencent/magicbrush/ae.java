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
public final /* synthetic */ class ae extends u {
    public static final h cMy = new ae();

    static {
        AppMethodBeat.i(206833);
        AppMethodBeat.o(206833);
    }

    ae() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(206834);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(206834);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "support_client_vertex_buffer";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getSupport_client_vertex_buffer()Z";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(206835);
        Boolean valueOf = Boolean.valueOf(((MBRuntime.MBParams) obj).support_client_vertex_buffer);
        AppMethodBeat.o(206835);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(206836);
        ((MBRuntime.MBParams) obj).support_client_vertex_buffer = ((Boolean) obj2).booleanValue();
        AppMethodBeat.o(206836);
    }
}
