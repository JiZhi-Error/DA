package com.tencent.mm.plugin.finder.event.base;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dataPos", "", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;ILcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getDataPos", "()I", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
public final class g {
    public final bo tIu;
    public final int tIv;
    public i tIw;

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (kotlin.g.b.p.j(r3.tIw, r4.tIw) != false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 243466(0x3b70a, float:3.41169E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0028
            boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.event.base.g
            if (r0 == 0) goto L_0x002d
            com.tencent.mm.plugin.finder.event.base.g r4 = (com.tencent.mm.plugin.finder.event.base.g) r4
            com.tencent.mm.plugin.finder.model.bo r0 = r3.tIu
            com.tencent.mm.plugin.finder.model.bo r1 = r4.tIu
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x002d
            int r0 = r3.tIv
            int r1 = r4.tIv
            if (r0 != r1) goto L_0x002d
            com.tencent.mm.view.recyclerview.i r0 = r3.tIw
            com.tencent.mm.view.recyclerview.i r1 = r4.tIw
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x002d
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.event.base.g.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(243465);
        bo boVar = this.tIu;
        int hashCode = (((boVar != null ? boVar.hashCode() : 0) * 31) + this.tIv) * 31;
        i iVar = this.tIw;
        if (iVar != null) {
            i2 = iVar.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(243465);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(243464);
        String str = "FlowScrollEventFeedData(feed=" + this.tIu + ", dataPos=" + this.tIv + ", showInfo=" + this.tIw + ")";
        AppMethodBeat.o(243464);
        return str;
    }

    private g(bo boVar, int i2) {
        p.h(boVar, "feed");
        AppMethodBeat.i(243463);
        this.tIu = boVar;
        this.tIv = i2;
        this.tIw = null;
        AppMethodBeat.o(243463);
    }

    public /* synthetic */ g(bo boVar, int i2, byte b2) {
        this(boVar, i2);
    }
}
