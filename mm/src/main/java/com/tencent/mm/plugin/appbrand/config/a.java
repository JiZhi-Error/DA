package com.tencent.mm.plugin.appbrand.config;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/ActionSheetControlIndex;", "", FirebaseAnalytics.b.INDEX, "", "(Ljava/lang/String;II)V", "getIndex", "()I", "setIndex", "(I)V", "getControlByte", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "ShareToWeWork", "ShareToFriend", "CopyShortLink", "plugin-appbrand-integration_release"})
public enum a {
    ShareToWeWork(0),
    ShareToFriend(1),
    CopyShortLink(2);
    
    private int index;

    public static a valueOf(String str) {
        AppMethodBeat.i(228165);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(228165);
        return aVar;
    }

    private a(int i2) {
        this.index = i2;
    }

    static {
        AppMethodBeat.i(228162);
        AppMethodBeat.o(228162);
    }

    public final int a(AppBrandSysConfigWC appBrandSysConfigWC) {
        boolean z;
        byte b2;
        AppMethodBeat.i(228163);
        p.h(appBrandSysConfigWC, "config");
        byte[] bArr = appBrandSysConfigWC.leL;
        if (bArr == null) {
            z = true;
        } else {
            z = false;
        }
        if (z || bArr.length - 1 < this.index) {
            b2 = 0;
        } else {
            b2 = bArr[this.index];
            if (b2 < 0 || 2 < b2) {
                b2 = 0;
            }
        }
        Log.i("MicroMsg.ActionSheetControlIndex", "getControlByte for " + name() + " [" + ((int) b2) + ']');
        AppMethodBeat.o(228163);
        return b2;
    }
}
