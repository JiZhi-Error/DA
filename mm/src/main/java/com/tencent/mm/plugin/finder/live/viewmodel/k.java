package com.tencent.mm.plugin.finder.live.viewmodel;

import android.os.Bundle;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\b\u0010\u001d\u001a\u00020\u0003H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/EventWrapper;", "", "event", "", "bundle", "Landroid/os/Bundle;", "anyData", "(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/Object;)V", "getAnyData", "()Ljava/lang/Object;", "setAnyData", "(Ljava/lang/Object;)V", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "getEvent", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-finder_release"})
public final class k {
    public Object UPL;
    public Bundle bundle;
    public String event;

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        if (kotlin.g.b.p.j(r3.UPL, r4.UPL) != false) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 261042(0x3fbb2, float:3.65798E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x002c
            boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.live.viewmodel.k
            if (r0 == 0) goto L_0x0031
            com.tencent.mm.plugin.finder.live.viewmodel.k r4 = (com.tencent.mm.plugin.finder.live.viewmodel.k) r4
            java.lang.String r0 = r3.event
            java.lang.String r1 = r4.event
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0031
            android.os.Bundle r0 = r3.bundle
            android.os.Bundle r1 = r4.bundle
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.Object r0 = r3.UPL
            java.lang.Object r1 = r4.UPL
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0031
        L_0x002c:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0030:
            return r0
        L_0x0031:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.viewmodel.k.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(261041);
        String str = this.event;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Bundle bundle2 = this.bundle;
        int hashCode2 = ((bundle2 != null ? bundle2.hashCode() : 0) + hashCode) * 31;
        Object obj = this.UPL;
        if (obj != null) {
            i2 = obj.hashCode();
        }
        int i3 = hashCode2 + i2;
        AppMethodBeat.o(261041);
        return i3;
    }

    public k(String str, Bundle bundle2, Object obj) {
        this.event = str;
        this.bundle = bundle2;
        this.UPL = obj;
    }

    public final String toString() {
        AppMethodBeat.i(261040);
        String str = "StateWrapper:" + this.event + ',' + this.bundle;
        AppMethodBeat.o(261040);
        return str;
    }
}
