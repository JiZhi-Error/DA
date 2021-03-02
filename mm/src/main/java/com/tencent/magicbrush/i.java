package com.tencent.magicbrush;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.aa;
import kotlin.g.b.u;
import kotlin.l;
import kotlin.l.b;
import kotlin.l.d;
import kotlin.l.h;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16})
public final /* synthetic */ class i extends u {
    public static final h cMy = new i();

    static {
        AppMethodBeat.i(140104);
        AppMethodBeat.o(140104);
    }

    i() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(140105);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(140105);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "animationFrameHandlerStrategy";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getAnimationFrameHandlerStrategy()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        return ((MBRuntime.MBParams) obj).animationFrameHandlerStrategy;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        ((MBRuntime.MBParams) obj).animationFrameHandlerStrategy = (a.b) obj2;
    }
}
