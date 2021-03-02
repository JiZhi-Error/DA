package com.tencent.mm.plugin.finder.storage.data;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002'(B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ$\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ@\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cJ\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0006\u0010 \u001a\u00020\u0010J\u000e\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u0018\u0010#\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\bX\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cacheBulletSubtitleComments", "", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$CacheKey;", "", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "cacheCommentExtras", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$Extra;", "cacheComments", "addBulletSubtitleComments", "", "feedId", "", "refCommentId", "comments", "addCommentsCache", "addExtraCache", "pos", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "upContinue", "", "downContinue", "hasExpand", "clearBulletSubtitleCache", "clearCache", "getBulletSubtitleComments", "getComments", "getExtra", com.tencent.mm.plugin.appbrand.jsapi.storage.f.NAME, "Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage;", "markUnsentCommentsCanRemove", "CacheKey", "Extra", "plugin-finder_release"})
public final class f {
    private static final String TAG = TAG;
    private static final Map<a, List<an>> vGa = new LinkedHashMap();
    private static final Map<a, b> vGb = new LinkedHashMap();
    public static final Map<a, List<an>> vGc = new LinkedHashMap();
    public static final f vGd = new f();

    static {
        AppMethodBeat.i(167059);
        AppMethodBeat.o(167059);
    }

    private f() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$CacheKey;", "", "feedId", "", "refCommentId", "(JJ)V", "getFeedId", "()J", "getRefCommentId", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class a {
        final long feedId;
        private final long tuj;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (!(this.feedId == aVar.feedId && this.tuj == aVar.tuj)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            long j2 = this.feedId;
            long j3 = this.tuj;
            return (((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }

        public final String toString() {
            AppMethodBeat.i(167048);
            String str = "CacheKey(feedId=" + this.feedId + ", refCommentId=" + this.tuj + ")";
            AppMethodBeat.o(167048);
            return str;
        }

        public a(long j2, long j3) {
            this.feedId = j2;
            this.tuj = j3;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$Extra;", "", "pos", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "upContinue", "", "downContinue", "hasExpand", "(ILcom/tencent/mm/protobuf/ByteString;ZZZ)V", "getDownContinue", "()Z", "getHasExpand", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPos", "()I", "getUpContinue", "component1", "component2", "component3", "component4", "component5", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
    public static final class b {
        public final com.tencent.mm.bw.b lastBuffer;
        public final int pos;
        public final boolean tMT;
        public final boolean tMU;
        public final boolean vGe;

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
            if (r3.vGe == r4.vGe) goto L_0x0030;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 167051(0x28c8b, float:2.34088E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0030
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.storage.data.f.b
                if (r0 == 0) goto L_0x0035
                com.tencent.mm.plugin.finder.storage.data.f$b r4 = (com.tencent.mm.plugin.finder.storage.data.f.b) r4
                int r0 = r3.pos
                int r1 = r4.pos
                if (r0 != r1) goto L_0x0035
                com.tencent.mm.bw.b r0 = r3.lastBuffer
                com.tencent.mm.bw.b r1 = r4.lastBuffer
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0035
                boolean r0 = r3.tMT
                boolean r1 = r4.tMT
                if (r0 != r1) goto L_0x0035
                boolean r0 = r3.tMU
                boolean r1 = r4.tMU
                if (r0 != r1) goto L_0x0035
                boolean r0 = r3.vGe
                boolean r1 = r4.vGe
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
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.storage.data.f.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 1;
            AppMethodBeat.i(167050);
            int i3 = this.pos * 31;
            com.tencent.mm.bw.b bVar = this.lastBuffer;
            int hashCode = ((bVar != null ? bVar.hashCode() : 0) + i3) * 31;
            boolean z = this.tMT;
            if (z) {
                z = true;
            }
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = (i4 + hashCode) * 31;
            boolean z2 = this.tMU;
            if (z2) {
                z2 = true;
            }
            int i8 = z2 ? 1 : 0;
            int i9 = z2 ? 1 : 0;
            int i10 = z2 ? 1 : 0;
            int i11 = (i8 + i7) * 31;
            boolean z3 = this.vGe;
            if (!z3) {
                i2 = z3 ? 1 : 0;
            }
            int i12 = i11 + i2;
            AppMethodBeat.o(167050);
            return i12;
        }

        public final String toString() {
            AppMethodBeat.i(167049);
            String str = "Extra(pos=" + this.pos + ", lastBuffer=" + this.lastBuffer + ", upContinue=" + this.tMT + ", downContinue=" + this.tMU + ", hasExpand=" + this.vGe + ")";
            AppMethodBeat.o(167049);
            return str;
        }

        public b(int i2, com.tencent.mm.bw.b bVar, boolean z, boolean z2, boolean z3) {
            this.pos = i2;
            this.lastBuffer = bVar;
            this.tMT = z;
            this.tMU = z2;
            this.vGe = z3;
        }
    }

    public final void a(long j2, long j3, List<an> list) {
        AppMethodBeat.i(167052);
        p.h(list, "comments");
        synchronized (this) {
            try {
                vGd.S(j2, j3);
                vGa.put(new a(j2, j3), list);
            } finally {
                AppMethodBeat.o(167052);
            }
        }
    }

    public final void a(long j2, long j3, int i2, com.tencent.mm.bw.b bVar, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(178422);
        synchronized (this) {
            try {
                vGb.put(new a(j2, j3), new b(i2, bVar, z, z2, z3));
            } finally {
                AppMethodBeat.o(178422);
            }
        }
    }

    private void S(long j2, long j3) {
        AppMethodBeat.i(167054);
        synchronized (this) {
            try {
                vGa.remove(new a(j2, j3));
                vGb.remove(new a(j2, j3));
            } finally {
                AppMethodBeat.o(167054);
            }
        }
    }

    public final void FF(long j2) {
        AppMethodBeat.i(167055);
        synchronized (this) {
            try {
                Map<a, List<an>> map = vGa;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<a, List<an>> entry : map.entrySet()) {
                    if (entry.getKey().feedId != j2) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                vGa.clear();
                vGa.putAll(linkedHashMap);
                Map<a, b> map2 = vGb;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry<a, b> entry2 : map2.entrySet()) {
                    if (entry2.getKey().feedId != j2) {
                        linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                    }
                }
                vGb.clear();
                vGb.putAll(linkedHashMap2);
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(167055);
            }
        }
    }

    public final void clearCache() {
        AppMethodBeat.i(167056);
        Log.i(TAG, "clearCache all");
        synchronized (this) {
            try {
                vGa.clear();
                vGb.clear();
                vGc.clear();
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(167056);
            }
        }
    }

    public final List<an> T(long j2, long j3) {
        List<an> list;
        AppMethodBeat.i(167057);
        synchronized (this) {
            try {
                list = vGa.get(new a(j2, j3));
            } finally {
                AppMethodBeat.o(167057);
            }
        }
        return list;
    }

    public final b U(long j2, long j3) {
        b bVar;
        AppMethodBeat.i(167058);
        synchronized (this) {
            try {
                bVar = vGb.get(new a(j2, j3));
            } finally {
                AppMethodBeat.o(167058);
            }
        }
        return bVar;
    }

    public final List<an> FG(long j2) {
        List<an> list;
        AppMethodBeat.i(251981);
        synchronized (this) {
            try {
                list = vGc.get(new a(j2, 0));
            } finally {
                AppMethodBeat.o(251981);
            }
        }
        return list;
    }
}
