package com.tencent.mm.plugin.finder.feed.model;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.model.bo;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B9\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0019\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u000bHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "position", "", ch.COL_CUSTOMDATA, "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "(Ljava/util/ArrayList;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/plugin/finder/feed/model/CacheCustom;)V", "getCustomData", "()Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "getDataList", "()Ljava/util/ArrayList;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPosition", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
public final class h {
    public final ArrayList<bo> kgc;
    public final b lastBuffer;
    public final int position;
    public final a tXU;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (kotlin.g.b.p.j(r3.tXU, r4.tXU) != false) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 244937(0x3bcc9, float:3.4323E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0032
            boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.feed.model.h
            if (r0 == 0) goto L_0x0037
            com.tencent.mm.plugin.finder.feed.model.h r4 = (com.tencent.mm.plugin.finder.feed.model.h) r4
            java.util.ArrayList<com.tencent.mm.plugin.finder.model.bo> r0 = r3.kgc
            java.util.ArrayList<com.tencent.mm.plugin.finder.model.bo> r1 = r4.kgc
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0037
            com.tencent.mm.bw.b r0 = r3.lastBuffer
            com.tencent.mm.bw.b r1 = r4.lastBuffer
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0037
            int r0 = r3.position
            int r1 = r4.position
            if (r0 != r1) goto L_0x0037
            com.tencent.mm.plugin.finder.feed.model.a r0 = r3.tXU
            com.tencent.mm.plugin.finder.feed.model.a r1 = r4.tXU
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0037
        L_0x0032:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0036:
            return r0
        L_0x0037:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.model.h.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(244936);
        ArrayList<bo> arrayList = this.kgc;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        b bVar = this.lastBuffer;
        int hashCode2 = ((((bVar != null ? bVar.hashCode() : 0) + hashCode) * 31) + this.position) * 31;
        a aVar = this.tXU;
        if (aVar != null) {
            i2 = aVar.hashCode();
        }
        int i3 = hashCode2 + i2;
        AppMethodBeat.o(244936);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(244935);
        String str = "LoaderCache(dataList=" + this.kgc + ", lastBuffer=" + this.lastBuffer + ", position=" + this.position + ", customData=" + this.tXU + ")";
        AppMethodBeat.o(244935);
        return str;
    }

    public h(ArrayList<bo> arrayList, b bVar, int i2, a aVar) {
        p.h(arrayList, "dataList");
        AppMethodBeat.i(244934);
        this.kgc = arrayList;
        this.lastBuffer = bVar;
        this.position = i2;
        this.tXU = aVar;
        AppMethodBeat.o(244934);
    }
}
