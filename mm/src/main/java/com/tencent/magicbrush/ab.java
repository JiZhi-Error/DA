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
public final /* synthetic */ class ab extends u {
    public static final h cMy = new ab();

    static {
        AppMethodBeat.i(206827);
        AppMethodBeat.o(206827);
    }

    ab() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(206828);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(206828);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "render_thread_name";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getRender_thread_name()Ljava/lang/String;";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        return ((MBRuntime.MBParams) obj).render_thread_name;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        ((MBRuntime.MBParams) obj).render_thread_name = (String) obj2;
    }
}
