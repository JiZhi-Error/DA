package com.tencent.magicbrush;

import android.content.res.AssetManager;
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
public final /* synthetic */ class j extends u {
    public static final h cMy = new j();

    static {
        AppMethodBeat.i(140106);
        AppMethodBeat.o(140106);
    }

    j() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(140107);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(140107);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "asset_manager";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getAsset_manager()Landroid/content/res/AssetManager;";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        return ((MBRuntime.MBParams) obj).asset_manager;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        ((MBRuntime.MBParams) obj).asset_manager = (AssetManager) obj2;
    }
}
