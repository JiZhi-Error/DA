package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/StickerApplyParams;", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "path", "", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-appbrand-integration_release"})
public final class m {
    final l.c oGU;
    final String path;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (kotlin.g.b.p.j(r3.path, r4.path) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 229751(0x38177, float:3.2195E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0022
            boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.xweb_ext.a.m
            if (r0 == 0) goto L_0x0027
            com.tencent.mm.plugin.appbrand.xweb_ext.a.m r4 = (com.tencent.mm.plugin.appbrand.xweb_ext.a.m) r4
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l$c r0 = r3.oGU
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l$c r1 = r4.oGU
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r3.path
            java.lang.String r1 = r4.path
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0027
        L_0x0022:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0026:
            return r0
        L_0x0027:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.xweb_ext.a.m.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(229750);
        l.c cVar = this.oGU;
        int hashCode = (cVar != null ? cVar.hashCode() : 0) * 31;
        String str = this.path;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(229750);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(229749);
        String str = "StickerApplyParams(type=" + this.oGU + ", path=" + this.path + ")";
        AppMethodBeat.o(229749);
        return str;
    }

    public m(l.c cVar, String str) {
        p.h(cVar, "type");
        p.h(str, "path");
        AppMethodBeat.i(229748);
        this.oGU = cVar;
        this.path = str;
        AppMethodBeat.o(229748);
    }
}
