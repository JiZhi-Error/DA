package com.tencent.mm.plugin.appbrand.appusage;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/WxaInfo;", "", "userName", "", "appId", "versionType", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getUserName", "getVersionType", "()I", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-appbrand-integration_release"})
public final class aq {
    final String appId;
    final int iOo;
    final String userName;

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r3.iOo == r4.iOo) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 228134(0x37b26, float:3.19684E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0028
            boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.appusage.aq
            if (r0 == 0) goto L_0x002d
            com.tencent.mm.plugin.appbrand.appusage.aq r4 = (com.tencent.mm.plugin.appbrand.appusage.aq) r4
            java.lang.String r0 = r3.userName
            java.lang.String r1 = r4.userName
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = r3.appId
            java.lang.String r1 = r4.appId
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x002d
            int r0 = r3.iOo
            int r1 = r4.iOo
            if (r0 != r1) goto L_0x002d
        L_0x0028:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x002c:
            return r0
        L_0x002d:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appusage.aq.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(228133);
        String str = this.userName;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.appId;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = ((hashCode + i2) * 31) + this.iOo;
        AppMethodBeat.o(228133);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(228132);
        String str = "WxaInfo(userName=" + this.userName + ", appId=" + this.appId + ", versionType=" + this.iOo + ")";
        AppMethodBeat.o(228132);
        return str;
    }

    public aq(String str, String str2, int i2) {
        p.h(str, "userName");
        p.h(str2, "appId");
        AppMethodBeat.i(228131);
        this.userName = str;
        this.appId = str2;
        this.iOo = i2;
        AppMethodBeat.o(228131);
    }
}
