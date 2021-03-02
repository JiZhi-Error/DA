package com.tencent.magicbrush;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.aa;
import kotlin.l;
import kotlin.l.b;
import kotlin.l.d;
import kotlin.l.h;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16})
public final /* synthetic */ class u extends kotlin.g.b.u {
    public static final h cMy = new u();

    static {
        AppMethodBeat.i(140148);
        AppMethodBeat.o(140148);
    }

    u() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(140149);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(140149);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "enable_request_animation_frame";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getEnable_request_animation_frame()Z";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(140150);
        Boolean valueOf = Boolean.valueOf(((MBRuntime.MBParams) obj).enable_request_animation_frame);
        AppMethodBeat.o(140150);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(140151);
        ((MBRuntime.MBParams) obj).enable_request_animation_frame = ((Boolean) obj2).booleanValue();
        AppMethodBeat.o(140151);
    }
}
