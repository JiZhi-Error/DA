package com.tencent.magicbrush;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.u;
import kotlin.l;
import kotlin.l.b;
import kotlin.l.d;
import kotlin.l.h;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16})
public final /* synthetic */ class aa extends u {
    public static final h cMy = new aa();

    static {
        AppMethodBeat.i(140166);
        AppMethodBeat.o(140166);
    }

    aa() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(140167);
        b bp = kotlin.g.b.aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(140167);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "is_game";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "is_game()Z";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(140168);
        Boolean valueOf = Boolean.valueOf(((MBRuntime.MBParams) obj).is_game);
        AppMethodBeat.o(140168);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(140169);
        ((MBRuntime.MBParams) obj).is_game = ((Boolean) obj2).booleanValue();
        AppMethodBeat.o(140169);
    }
}
