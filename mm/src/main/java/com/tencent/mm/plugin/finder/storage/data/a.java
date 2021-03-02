package com.tencent.mm.plugin.finder.storage.data;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.arb;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "", "type", "", "name", "", "page", "Lcom/tencent/mm/protocal/protobuf/FinderFirstPage;", "read", "", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderFirstPage;Z)V", "getName", "()Ljava/lang/String;", "getPage", "()Lcom/tencent/mm/protocal/protobuf/FinderFirstPage;", "setPage", "(Lcom/tencent/mm/protocal/protobuf/FinderFirstPage;)V", "getRead", "()Z", "setRead", "(Z)V", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-finder_release"})
public final class a {
    boolean lNl;
    final String name;
    final int type;
    public arb vFP;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        if (r3.lNl == r4.lNl) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 251950(0x3d82e, float:3.53057E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x002e
            boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.storage.data.a
            if (r0 == 0) goto L_0x0033
            com.tencent.mm.plugin.finder.storage.data.a r4 = (com.tencent.mm.plugin.finder.storage.data.a) r4
            int r0 = r3.type
            int r1 = r4.type
            if (r0 != r1) goto L_0x0033
            java.lang.String r0 = r3.name
            java.lang.String r1 = r4.name
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0033
            com.tencent.mm.protocal.protobuf.arb r0 = r3.vFP
            com.tencent.mm.protocal.protobuf.arb r1 = r4.vFP
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0033
            boolean r0 = r3.lNl
            boolean r1 = r4.lNl
            if (r0 != r1) goto L_0x0033
        L_0x002e:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0032:
            return r0
        L_0x0033:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0032
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.storage.data.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(251949);
        int i3 = this.type * 31;
        String str = this.name;
        int hashCode = ((str != null ? str.hashCode() : 0) + i3) * 31;
        arb arb = this.vFP;
        if (arb != null) {
            i2 = arb.hashCode();
        }
        int i4 = (hashCode + i2) * 31;
        boolean z = this.lNl;
        if (z) {
            z = true;
        }
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = z ? 1 : 0;
        int i8 = i5 + i4;
        AppMethodBeat.o(251949);
        return i8;
    }

    public final String toString() {
        AppMethodBeat.i(251948);
        String str = "CachePage(type=" + this.type + ", name=" + this.name + ", page=" + this.vFP + ", read=" + this.lNl + ")";
        AppMethodBeat.o(251948);
        return str;
    }

    private a(int i2, String str, arb arb) {
        p.h(str, "name");
        p.h(arb, "page");
        AppMethodBeat.i(251947);
        this.type = i2;
        this.name = str;
        this.vFP = arb;
        this.lNl = false;
        AppMethodBeat.o(251947);
    }

    public /* synthetic */ a(int i2, String str, arb arb, byte b2) {
        this(i2, str, arb);
    }

    public final void a(arb arb) {
        AppMethodBeat.i(251946);
        p.h(arb, "<set-?>");
        this.vFP = arb;
        AppMethodBeat.o(251946);
    }
}
