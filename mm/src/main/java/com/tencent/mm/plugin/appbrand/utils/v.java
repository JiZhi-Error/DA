package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.h.a;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/utils/LuggageUIUtilsBridge;", "Lcom/tencent/luggage/util/UIUtilsInterface;", "()V", "TAG", "", "getCutOutHeight", "", "context", "Landroid/content/Context;", "getDarkModeColor", "originalColor", "getStableStatusBarHeight", "hasCutOut", "", "hasHuaweiMagicWindowFeature", "huaweiSpecial", "isDarkMode", "isHuaweiFold", "plugin-luggage-wechat-impl_release"})
public final class v implements k {
    public static final v ohj = new v();

    static {
        AppMethodBeat.i(174557);
        AppMethodBeat.o(174557);
    }

    private v() {
    }

    @Override // com.tencent.luggage.h.k
    public final int hT(int i2) {
        AppMethodBeat.i(174553);
        int hT = ao.hT(i2);
        AppMethodBeat.o(174553);
        return hT;
    }

    @Override // com.tencent.luggage.h.k
    public final boolean isDarkMode() {
        AppMethodBeat.i(174554);
        boolean isDarkMode = ao.isDarkMode();
        AppMethodBeat.o(174554);
        return isDarkMode;
    }

    @Override // com.tencent.luggage.h.k
    public final int aP(Context context) {
        AppMethodBeat.i(174555);
        int aP = ao.aP(context);
        AppMethodBeat.o(174555);
        return aP;
    }

    @Override // com.tencent.luggage.h.k
    public final boolean aQ(Context context) {
        AppMethodBeat.i(174556);
        boolean aQ = ao.aQ(context);
        AppMethodBeat.o(174556);
        return aQ;
    }

    @Override // com.tencent.luggage.h.k
    public final int aR(Context context) {
        int i2;
        AppMethodBeat.i(182443);
        p.h(context, "context");
        try {
            Context applicationContext = context.getApplicationContext();
            p.g(applicationContext, "context.applicationContext");
            Resources resources = applicationContext.getResources();
            p.g(resources, "resources");
            i2 = a.cR(((float) resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"))) * (com.tencent.mm.cc.a.gvp() / resources.getDisplayMetrics().density));
        } catch (Throwable th) {
            Log.e("MicroMsg.LuggageUIUtilsBridge", "getStableStatusBarHeight e=".concat(String.valueOf(th)));
            i2 = 0;
        }
        AppMethodBeat.o(182443);
        return i2;
    }

    @Override // com.tencent.luggage.h.k
    public final boolean Pi() {
        AppMethodBeat.i(204359);
        boolean Pi = ao.Pi();
        AppMethodBeat.o(204359);
        return Pi;
    }

    @Override // com.tencent.luggage.h.k
    public final boolean Pk() {
        AppMethodBeat.i(204360);
        boolean z = false;
        try {
            z = w.Pk();
        } catch (Throwable th) {
            Log.e("MicroMsg.LuggageUIUtilsBridge", "hasHuaweiMagicWindowFeature" + th.getMessage());
        }
        Log.i("MicroMsg.LuggageUIUtilsBridge", "hasHuaweiMagicWindowFeature: ".concat(String.valueOf(z)));
        AppMethodBeat.o(204360);
        return z;
    }

    @Override // com.tencent.luggage.h.k
    public final boolean Pj() {
        AppMethodBeat.i(204361);
        if (ao.gJK() || ao.gJL()) {
            AppMethodBeat.o(204361);
            return true;
        }
        AppMethodBeat.o(204361);
        return false;
    }
}
