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
public final /* synthetic */ class af extends u {
    public static final h cMy = new af();

    static {
        AppMethodBeat.i(206837);
        AppMethodBeat.o(206837);
    }

    af() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(206838);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(206838);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "support_gfximage_share_texture";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getSupport_gfximage_share_texture()I";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(206839);
        Integer valueOf = Integer.valueOf(((MBRuntime.MBParams) obj).support_gfximage_share_texture);
        AppMethodBeat.o(206839);
        return valueOf;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        AppMethodBeat.i(206840);
        ((MBRuntime.MBParams) obj).support_gfximage_share_texture = ((Number) obj2).intValue();
        AppMethodBeat.o(206840);
    }
}
