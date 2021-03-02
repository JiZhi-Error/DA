package com.tencent.mm.plugin.appbrand.jsapi.ag.e.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b.c;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "", "mrDevice", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "(Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;)V", "isConnectSuccess", "", "()Z", "setConnectSuccess", "(Z)V", "isConnecting", "setConnecting", "isSelected", "setSelected", "getMrDevice", "()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "luggage-xweb-ext_release"})
public final class e {
    boolean hmV;
    boolean isSelected;
    boolean mLF;
    final c mLG;

    public e(c cVar) {
        p.h(cVar, "mrDevice");
        AppMethodBeat.i(139687);
        this.mLG = cVar;
        AppMethodBeat.o(139687);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(139684);
        if (this == obj) {
            AppMethodBeat.o(139684);
            return true;
        }
        if (!p.j(getClass(), obj != null ? obj.getClass() : null)) {
            AppMethodBeat.o(139684);
            return false;
        } else if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.xwebplugin.video.cast.MRDeviceWithStatus");
            AppMethodBeat.o(139684);
            throw tVar;
        } else if (!p.j(this.mLG, ((e) obj).mLG)) {
            AppMethodBeat.o(139684);
            return false;
        } else {
            AppMethodBeat.o(139684);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(139685);
        int hashCode = this.mLG.hashCode();
        AppMethodBeat.o(139685);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(139686);
        String str = "MRDeviceWithStatus(mrDevice=" + this.mLG + ", isSelected=" + this.isSelected + ", isConnectSuccess=" + this.mLF + ", isConnecting=" + this.hmV + ')';
        AppMethodBeat.o(139686);
        return str;
    }
}
