package com.tencent.mm.plugin.eggspring.c;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\b\b\u0018\u0000 #2\u00020\u0001:\u0001#BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JK\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\tHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000f¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "", "keyword", "", "traceId", "appId", "hasLuckyBag", "", "interval", "", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getHasLuckyBag", "()Z", "getInterval", "()I", "getKeyword", "getTraceId", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "Companion", "plugin-eggspring_release"})
public final class c {
    public static final a qVf = new a((byte) 0);
    public String appId;
    public final String dDv;
    public final int gTn;
    public final String kZe;
    private final boolean qVe;
    public String url;

    static {
        AppMethodBeat.i(108152);
        AppMethodBeat.o(108152);
    }

    public c() {
        this(null, null, null, false, 0, 63);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (kotlin.g.b.p.j(r3.url, r4.url) != false) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 194573(0x2f80d, float:2.72655E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0042
            boolean r0 = r4 instanceof com.tencent.mm.plugin.eggspring.c.c
            if (r0 == 0) goto L_0x0047
            com.tencent.mm.plugin.eggspring.c.c r4 = (com.tencent.mm.plugin.eggspring.c.c) r4
            java.lang.String r0 = r3.dDv
            java.lang.String r1 = r4.dDv
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0047
            java.lang.String r0 = r3.kZe
            java.lang.String r1 = r4.kZe
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0047
            java.lang.String r0 = r3.appId
            java.lang.String r1 = r4.appId
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0047
            boolean r0 = r3.qVe
            boolean r1 = r4.qVe
            if (r0 != r1) goto L_0x0047
            int r0 = r3.gTn
            int r1 = r4.gTn
            if (r0 != r1) goto L_0x0047
            java.lang.String r0 = r3.url
            java.lang.String r1 = r4.url
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0047
        L_0x0042:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0046:
            return r0
        L_0x0047:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0046
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.eggspring.c.c.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(194572);
        String str = this.dDv;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.kZe;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.appId;
        int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31;
        boolean z = this.qVe;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (((i3 + hashCode3) * 31) + this.gTn) * 31;
        String str4 = this.url;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i7 = i6 + i2;
        AppMethodBeat.o(194572);
        return i7;
    }

    public final String toString() {
        AppMethodBeat.i(108151);
        String str = "LuckyBagInfo(keyword=" + this.dDv + ", traceId=" + this.kZe + ", appId=" + this.appId + ", hasLuckyBag=" + this.qVe + ", interval=" + this.gTn + ", url=" + this.url + ")";
        AppMethodBeat.o(108151);
        return str;
    }

    private c(String str, String str2, String str3, boolean z, int i2) {
        p.h(str, "keyword");
        AppMethodBeat.i(259483);
        this.dDv = str;
        this.kZe = str2;
        this.appId = str3;
        this.qVe = z;
        this.gTn = i2;
        this.url = null;
        AppMethodBeat.o(259483);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ c(java.lang.String r8, java.lang.String r9, java.lang.String r10, boolean r11, int r12, int r13) {
        /*
            r7 = this;
            r3 = 0
            r6 = 259484(0x3f59c, float:3.63615E-40)
            r0 = r13 & 1
            if (r0 == 0) goto L_0x0032
            java.lang.String r1 = ""
        L_0x000b:
            r0 = r13 & 2
            if (r0 == 0) goto L_0x0030
            r2 = r3
        L_0x0010:
            r0 = r13 & 4
            if (r0 == 0) goto L_0x002e
        L_0x0014:
            r0 = r13 & 8
            if (r0 == 0) goto L_0x002c
            r4 = 0
        L_0x0019:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x002a
            r5 = 10
        L_0x001f:
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x002a:
            r5 = r12
            goto L_0x001f
        L_0x002c:
            r4 = r11
            goto L_0x0019
        L_0x002e:
            r3 = r10
            goto L_0x0014
        L_0x0030:
            r2 = r9
            goto L_0x0010
        L_0x0032:
            r1 = r8
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.eggspring.c.c.<init>(java.lang.String, java.lang.String, java.lang.String, boolean, int, int):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo$Companion;", "", "()V", "HAS_LUCKY_BAG", "", "NO_LUCKY_BAG", "plugin-eggspring_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
