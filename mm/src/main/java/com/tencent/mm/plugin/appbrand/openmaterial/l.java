package com.tencent.mm.plugin.appbrand.openmaterial;

import android.view.ContextMenu;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

/* access modifiers changed from: package-private */
@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/RawFunctionName2Show;", "Landroid/view/ContextMenu$ContextMenuInfo;", "line1", "", "line2", "needEllipsize", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "functionName2Show", "getFunctionName2Show", "()Ljava/lang/String;", "getLine1", "getLine2", "getNeedEllipsize", "()Z", "component1", "component2", "component3", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
public final class l implements ContextMenu.ContextMenuInfo {
    final String line1;
    final String line2;
    final String nll;
    final boolean nlm;

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r3.nlm == r4.nlm) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 229133(0x37f0d, float:3.21084E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0028
            boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.openmaterial.l
            if (r0 == 0) goto L_0x002d
            com.tencent.mm.plugin.appbrand.openmaterial.l r4 = (com.tencent.mm.plugin.appbrand.openmaterial.l) r4
            java.lang.String r0 = r3.line1
            java.lang.String r1 = r4.line1
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = r3.line2
            java.lang.String r1 = r4.line2
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x002d
            boolean r0 = r3.nlm
            boolean r1 = r4.nlm
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.openmaterial.l.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(229132);
        String str = this.line1;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.line2;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode + i2) * 31;
        boolean z = this.nlm;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = i4 + i3;
        AppMethodBeat.o(229132);
        return i7;
    }

    public final String toString() {
        AppMethodBeat.i(229131);
        String str = "RawFunctionName2Show(line1=" + this.line1 + ", line2=" + this.line2 + ", needEllipsize=" + this.nlm + ")";
        AppMethodBeat.o(229131);
        return str;
    }

    public l(String str, String str2, boolean z) {
        p.h(str, "line1");
        AppMethodBeat.i(229129);
        this.line1 = str;
        this.line2 = str2;
        this.nlm = z;
        this.nll = this.line2 == null ? this.line1 : this.line1 + "\n" + this.line2;
        AppMethodBeat.o(229129);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(String str, String str2, int i2) {
        this(str, (i2 & 2) != 0 ? null : str2, false);
        AppMethodBeat.i(229130);
        AppMethodBeat.o(229130);
    }
}
