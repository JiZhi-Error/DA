package com.tencent.mm.plugin.webview.ui.tools.floatball;

import android.os.Bundle;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/floatball/JSApiInfo;", "", "id", "", "bundle", "Landroid/os/Bundle;", "(ILandroid/os/Bundle;)V", "getBundle", "()Landroid/os/Bundle;", "getId", "()I", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-webview_release"})
public final class a {
    public final Bundle bundle;
    public final int id;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (kotlin.g.b.p.j(r3.bundle, r4.bundle) != false) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 210489(0x33639, float:2.94958E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x001e
            boolean r0 = r4 instanceof com.tencent.mm.plugin.webview.ui.tools.floatball.a
            if (r0 == 0) goto L_0x0023
            com.tencent.mm.plugin.webview.ui.tools.floatball.a r4 = (com.tencent.mm.plugin.webview.ui.tools.floatball.a) r4
            int r0 = r3.id
            int r1 = r4.id
            if (r0 != r1) goto L_0x0023
            android.os.Bundle r0 = r3.bundle
            android.os.Bundle r1 = r4.bundle
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0023
        L_0x001e:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0022:
            return r0
        L_0x0023:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.floatball.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(210488);
        int i2 = this.id * 31;
        Bundle bundle2 = this.bundle;
        int hashCode = (bundle2 != null ? bundle2.hashCode() : 0) + i2;
        AppMethodBeat.o(210488);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(210487);
        String str = "JSApiInfo(id=" + this.id + ", bundle=" + this.bundle + ")";
        AppMethodBeat.o(210487);
        return str;
    }

    public a(int i2, Bundle bundle2) {
        p.h(bundle2, "bundle");
        AppMethodBeat.i(210486);
        this.id = i2;
        this.bundle = bundle2;
        AppMethodBeat.o(210486);
    }
}
