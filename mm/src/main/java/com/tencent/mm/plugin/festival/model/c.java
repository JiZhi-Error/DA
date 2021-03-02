package com.tencent.mm.plugin.festival.model;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalCompatibilityConfig;", "", "()V", "canDrawWishButtonDynamicEffect", "", "getCanDrawWishButtonDynamicEffect", "()Z", "canUseBlurBitmap", "getCanUseBlurBitmap", "canUseLargeSizeShadowLayer", "getCanUseLargeSizeShadowLayer", "plugin-festival_release"})
public final class c {
    public static final c UxA = new c();

    static {
        AppMethodBeat.i(262896);
        AppMethodBeat.o(262896);
    }

    private c() {
    }

    public static boolean gFg() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean gFh() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean gFi() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
