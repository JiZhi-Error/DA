package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.local.a;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "", "effect", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "selected", "", "(Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;Z)V", "getEffect", "()Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "setEffect", "(Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;)V", "getSelected", "()Z", "setSelected", "(Z)V", "component1", "component2", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-vlog_release"})
public final class d {
    a.C1849a GNZ;
    boolean uOQ;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (r3.uOQ == r4.uOQ) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 192014(0x2ee0e, float:2.69069E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x001e
            boolean r0 = r4 instanceof com.tencent.mm.plugin.vlog.ui.plugin.transition.d
            if (r0 == 0) goto L_0x0023
            com.tencent.mm.plugin.vlog.ui.plugin.transition.d r4 = (com.tencent.mm.plugin.vlog.ui.plugin.transition.d) r4
            com.tencent.mm.plugin.vlog.model.local.a$a r0 = r3.GNZ
            com.tencent.mm.plugin.vlog.model.local.a$a r1 = r4.GNZ
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0023
            boolean r0 = r3.uOQ
            boolean r1 = r4.uOQ
            if (r0 != r1) goto L_0x0023
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.ui.plugin.transition.d.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(192013);
        a.C1849a aVar = this.GNZ;
        int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        boolean z = this.uOQ;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = i2 + hashCode;
        AppMethodBeat.o(192013);
        return i5;
    }

    public final String toString() {
        AppMethodBeat.i(192012);
        String str = "TransitionItem(effect=" + this.GNZ + ", selected=" + this.uOQ + ")";
        AppMethodBeat.o(192012);
        return str;
    }

    public d(a.C1849a aVar) {
        this.GNZ = aVar;
        this.uOQ = false;
    }

    public /* synthetic */ d() {
        this(null);
    }
}
