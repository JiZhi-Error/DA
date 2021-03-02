package com.tencent.mm.plugin.finder.feed.model.internal;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003JA\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000e¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "", "insertIndex", "", "insertCount", "changeIndex", "Ljava/util/LinkedList;", "isRemoveBeforeInsert", "", "dataReplace", "(IILjava/util/LinkedList;ZZ)V", "getChangeIndex", "()Ljava/util/LinkedList;", "getDataReplace", "()Z", "setDataReplace", "(Z)V", "getInsertCount", "()I", "setInsertCount", "(I)V", "getInsertIndex", "component1", "component2", "component3", "component4", "component5", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
public final class k {
    final int tYC;
    public int tYD;
    final LinkedList<Integer> tYE;
    final boolean tYF;
    public boolean tYG;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r3.tYG == r4.tYG) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 245029(0x3bd25, float:3.43359E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0030
            boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.feed.model.internal.k
            if (r0 == 0) goto L_0x0035
            com.tencent.mm.plugin.finder.feed.model.internal.k r4 = (com.tencent.mm.plugin.finder.feed.model.internal.k) r4
            int r0 = r3.tYC
            int r1 = r4.tYC
            if (r0 != r1) goto L_0x0035
            int r0 = r3.tYD
            int r1 = r4.tYD
            if (r0 != r1) goto L_0x0035
            java.util.LinkedList<java.lang.Integer> r0 = r3.tYE
            java.util.LinkedList<java.lang.Integer> r1 = r4.tYE
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0035
            boolean r0 = r3.tYF
            boolean r1 = r4.tYF
            if (r0 != r1) goto L_0x0035
            boolean r0 = r3.tYG
            boolean r1 = r4.tYG
            if (r0 != r1) goto L_0x0035
        L_0x0030:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0034:
            return r0
        L_0x0035:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.model.internal.k.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 1;
        AppMethodBeat.i(245028);
        int i3 = ((this.tYC * 31) + this.tYD) * 31;
        LinkedList<Integer> linkedList = this.tYE;
        int hashCode = ((linkedList != null ? linkedList.hashCode() : 0) + i3) * 31;
        boolean z = this.tYF;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (i4 + hashCode) * 31;
        boolean z2 = this.tYG;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        int i8 = i7 + i2;
        AppMethodBeat.o(245028);
        return i8;
    }

    public final String toString() {
        AppMethodBeat.i(245027);
        String str = "MergeResult(insertIndex=" + this.tYC + ", insertCount=" + this.tYD + ", changeIndex=" + this.tYE + ", isRemoveBeforeInsert=" + this.tYF + ", dataReplace=" + this.tYG + ")";
        AppMethodBeat.o(245027);
        return str;
    }

    public k(int i2, int i3, LinkedList<Integer> linkedList, boolean z, boolean z2) {
        p.h(linkedList, "changeIndex");
        AppMethodBeat.i(245026);
        this.tYC = i2;
        this.tYD = i3;
        this.tYE = linkedList;
        this.tYF = z;
        this.tYG = z2;
        AppMethodBeat.o(245026);
    }

    public /* synthetic */ k(LinkedList linkedList) {
        this(-1, 0, linkedList, false, false);
    }
}
