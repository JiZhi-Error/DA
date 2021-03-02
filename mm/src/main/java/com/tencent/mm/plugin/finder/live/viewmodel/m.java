package com.tencent.mm.plugin.finder.live.viewmodel;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J%\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/LuckyMoneyLiveData;", "", "chatroomList", "Ljava/util/LinkedList;", "", "clientBuff", "(Ljava/util/LinkedList;Ljava/lang/String;)V", "getChatroomList", "()Ljava/util/LinkedList;", "setChatroomList", "(Ljava/util/LinkedList;)V", "getClientBuff", "()Ljava/lang/String;", "setClientBuff", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-finder_release"})
public final class m {
    public LinkedList<String> Mpi;
    public String UQM;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (kotlin.g.b.p.j(r3.UQM, r4.UQM) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 261116(0x3fbfc, float:3.65901E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0022
            boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.live.viewmodel.m
            if (r0 == 0) goto L_0x0027
            com.tencent.mm.plugin.finder.live.viewmodel.m r4 = (com.tencent.mm.plugin.finder.live.viewmodel.m) r4
            java.util.LinkedList<java.lang.String> r0 = r3.Mpi
            java.util.LinkedList<java.lang.String> r1 = r4.Mpi
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r3.UQM
            java.lang.String r1 = r4.UQM
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.viewmodel.m.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(261115);
        LinkedList<String> linkedList = this.Mpi;
        int hashCode = (linkedList != null ? linkedList.hashCode() : 0) * 31;
        String str = this.UQM;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(261115);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(261114);
        String str = "LuckyMoneyLiveData(chatroomList=" + this.Mpi + ", clientBuff=" + this.UQM + ")";
        AppMethodBeat.o(261114);
        return str;
    }

    public /* synthetic */ m() {
        this(new LinkedList());
        AppMethodBeat.i(261113);
        AppMethodBeat.o(261113);
    }

    private m(LinkedList<String> linkedList) {
        p.h(linkedList, "chatroomList");
        AppMethodBeat.i(261112);
        this.Mpi = linkedList;
        this.UQM = null;
        AppMethodBeat.o(261112);
    }
}
