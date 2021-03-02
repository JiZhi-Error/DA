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
public final /* synthetic */ class m extends u {
    public static final h cMy = new m();

    static {
        AppMethodBeat.i(140116);
        AppMethodBeat.o(140116);
    }

    m() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(140117);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(140117);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "cmd_pool_type";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getCmd_pool_type()I";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(140118);
        Integer valueOf = Integer.valueOf(((MBRuntime.MBParams) obj).cmd_pool_type);
        AppMethodBeat.o(140118);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(140119);
        ((MBRuntime.MBParams) obj).cmd_pool_type = ((Number) obj2).intValue();
        AppMethodBeat.o(140119);
    }
}
