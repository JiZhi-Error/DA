package com.tencent.mm.plugin.appbrand.appstorage.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\n¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/TransferTaskResult;", "", "isTaskSuccess", "", "isTaskNeedTransfer", OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "", "(ZZLjava/lang/String;)V", "getErrorMsg", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-appbrand-integration_release"})
public final class e {
    private final String errorMsg;
    final boolean kTW;
    private final boolean kTX;

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (kotlin.g.b.p.j(r3.errorMsg, r4.errorMsg) != false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 175131(0x2ac1b, float:2.45411E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0024
            boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.appstorage.b.e
            if (r0 == 0) goto L_0x0029
            com.tencent.mm.plugin.appbrand.appstorage.b.e r4 = (com.tencent.mm.plugin.appbrand.appstorage.b.e) r4
            boolean r0 = r3.kTW
            boolean r1 = r4.kTW
            if (r0 != r1) goto L_0x0029
            boolean r0 = r3.kTX
            boolean r1 = r4.kTX
            if (r0 != r1) goto L_0x0029
            java.lang.String r0 = r3.errorMsg
            java.lang.String r1 = r4.errorMsg
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0029
        L_0x0024:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0028:
            return r0
        L_0x0029:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appstorage.b.e.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 1;
        AppMethodBeat.i(175130);
        boolean z = this.kTW;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = i3 * 31;
        boolean z2 = this.kTX;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        int i7 = (i6 + i2) * 31;
        String str = this.errorMsg;
        int hashCode = (str != null ? str.hashCode() : 0) + i7;
        AppMethodBeat.o(175130);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(175129);
        String str = "TransferTaskResult(isTaskSuccess=" + this.kTW + ", isTaskNeedTransfer=" + this.kTX + ", errorMsg=" + this.errorMsg + ")";
        AppMethodBeat.o(175129);
        return str;
    }

    public e(boolean z, boolean z2, String str) {
        p.h(str, OpenSDKTool4Assistant.EXTRA_ERROR_MSG);
        AppMethodBeat.i(175127);
        this.kTW = z;
        this.kTX = z2;
        this.errorMsg = str;
        AppMethodBeat.o(175127);
    }

    public /* synthetic */ e(boolean z, boolean z2) {
        this(z, z2, "no error.");
        AppMethodBeat.i(228123);
        AppMethodBeat.o(228123);
    }
}
