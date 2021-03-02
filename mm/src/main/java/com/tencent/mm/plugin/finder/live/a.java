package com.tencent.mm.plugin.finder.live;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.awt;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u000eR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache;", "", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache$CacheKey;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache$CacheValue;", "requestInterval", "", "getRequestInterval", "()I", "setRequestInterval", "(I)V", "getNoticeState", "", ch.COL_USERNAME, "", "noticeId", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;", "save", "", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "update", "reserved", "CacheKey", "CacheValue", "plugin-finder_release"})
public final class a {
    private static final ConcurrentHashMap<C1175a, b> cache = new ConcurrentHashMap<>();
    private static int ufh = 60;
    public static final a ufi = new a();

    static {
        AppMethodBeat.i(245785);
        AppMethodBeat.o(245785);
    }

    private a() {
    }

    public static void IV(int i2) {
        ufh = i2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache$CacheKey;", "", ch.COL_USERNAME, "", "noticeId", "(Ljava/lang/String;Ljava/lang/String;)V", "getNoticeId", "()Ljava/lang/String;", "getUsername", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.live.a$a  reason: collision with other inner class name */
    public static final class C1175a {
        private final String dDJ;
        private final String username;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (kotlin.g.b.p.j(r3.dDJ, r4.dDJ) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 245777(0x3c011, float:3.44407E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0022
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.live.a.C1175a
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.plugin.finder.live.a$a r4 = (com.tencent.mm.plugin.finder.live.a.C1175a) r4
                java.lang.String r0 = r3.username
                java.lang.String r1 = r4.username
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.lang.String r0 = r3.dDJ
                java.lang.String r1 = r4.dDJ
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
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.a.C1175a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(245776);
            String str = this.username;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.dDJ;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(245776);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(245775);
            String str = "CacheKey(username=" + this.username + ", noticeId=" + this.dDJ + ")";
            AppMethodBeat.o(245775);
            return str;
        }

        public C1175a(String str, String str2) {
            p.h(str, ch.COL_USERNAME);
            p.h(str2, "noticeId");
            AppMethodBeat.i(245774);
            this.username = str;
            this.dDJ = str2;
            AppMethodBeat.o(245774);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache$CacheValue;", "", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "saveTimeSec", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;I)V", "getNoticeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getSaveTimeSec", "()I", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
    public static final class b {
        final awt ufj;
        final int ufk;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            if (r3.ufk == r4.ufk) goto L_0x001e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 245781(0x3c015, float:3.44413E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x001e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.live.a.b
                if (r0 == 0) goto L_0x0023
                com.tencent.mm.plugin.finder.live.a$b r4 = (com.tencent.mm.plugin.finder.live.a.b) r4
                com.tencent.mm.protocal.protobuf.awt r0 = r3.ufj
                com.tencent.mm.protocal.protobuf.awt r1 = r4.ufj
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0023
                int r0 = r3.ufk
                int r1 = r4.ufk
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
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.a.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(245780);
            awt awt = this.ufj;
            int hashCode = ((awt != null ? awt.hashCode() : 0) * 31) + this.ufk;
            AppMethodBeat.o(245780);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(245779);
            String str = "CacheValue(noticeInfo=" + this.ufj + ", saveTimeSec=" + this.ufk + ")";
            AppMethodBeat.o(245779);
            return str;
        }

        public b(awt awt, int i2) {
            p.h(awt, "noticeInfo");
            AppMethodBeat.i(245778);
            this.ufj = awt;
            this.ufk = i2;
            AppMethodBeat.o(245778);
        }
    }

    public static void a(String str, String str2, awt awt) {
        AppMethodBeat.i(245782);
        p.h(str, ch.COL_USERNAME);
        p.h(str2, "noticeId");
        p.h(awt, "noticeInfo");
        cache.put(new C1175a(str, str2), new b(awt, cl.aWB()));
        AppMethodBeat.o(245782);
    }

    public static void q(String str, String str2, boolean z) {
        awt awt;
        AppMethodBeat.i(245783);
        p.h(str, ch.COL_USERNAME);
        p.h(str2, "noticeId");
        b bVar = cache.get(new C1175a(str, str2));
        if (bVar == null || (awt = bVar.ufj) == null) {
            AppMethodBeat.o(245783);
            return;
        }
        awt.status = z ? 0 : 1;
        AppMethodBeat.o(245783);
    }

    public static Boolean gK(String str, String str2) {
        AppMethodBeat.i(245784);
        p.h(str, ch.COL_USERNAME);
        p.h(str2, "noticeId");
        b bVar = cache.get(new C1175a(str, str2));
        if (bVar == null || cl.aWB() - bVar.ufk >= ufh) {
            AppMethodBeat.o(245784);
            return null;
        }
        Boolean valueOf = Boolean.valueOf(bVar.ufj.status == 0);
        AppMethodBeat.o(245784);
        return valueOf;
    }
}
