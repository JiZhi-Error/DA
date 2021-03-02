package com.tencent.magicbrush;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.aa;
import kotlin.g.b.u;
import kotlin.l.b;
import kotlin.l.d;
import kotlin.l.h;

/* access modifiers changed from: package-private */
@kotlin.l(hxD = {1, 1, 16})
public final /* synthetic */ class l extends u {
    public static final h cMy = new l();

    static {
        AppMethodBeat.i(140112);
        AppMethodBeat.o(140112);
    }

    l() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(140113);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(140113);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "screen_width_";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getScreen_width_()I";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(140114);
        Integer valueOf = Integer.valueOf(((MBRuntime.MBParams) obj).screen_width_);
        AppMethodBeat.o(140114);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(140115);
        ((MBRuntime.MBParams) obj).screen_width_ = ((Number) obj2).intValue();
        AppMethodBeat.o(140115);
    }
}
