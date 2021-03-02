package com.tencent.mm.plugin.festival.c;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0006\u0010\u001e\u001a\u00020\u0005J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/festival/util/FestivalHttpsDownloadRequest;", "", "type", "Lcom/tencent/mm/plugin/festival/util/FestivalCdnHttpsRequestType;", "url", "", "queueTimeoutSeconds", "", "transferTimeoutSeconds", "savePath", "(Lcom/tencent/mm/plugin/festival/util/FestivalCdnHttpsRequestType;Ljava/lang/String;JJLjava/lang/String;)V", "getQueueTimeoutSeconds", "()J", "getSavePath", "()Ljava/lang/String;", "getTransferTimeoutSeconds", "getType", "()Lcom/tencent/mm/plugin/festival/util/FestivalCdnHttpsRequestType;", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "infoForLog", "toString", "plugin-festival_release"})
public final class d {
    final c UGi;
    public final long UGj;
    public final long UGk;
    final String savePath;
    final String url;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (kotlin.g.b.p.j(r5.savePath, r6.savePath) != false) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 263486(0x4053e, float:3.69223E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x003c
            boolean r0 = r6 instanceof com.tencent.mm.plugin.festival.c.d
            if (r0 == 0) goto L_0x0041
            com.tencent.mm.plugin.festival.c.d r6 = (com.tencent.mm.plugin.festival.c.d) r6
            com.tencent.mm.plugin.festival.c.c r0 = r5.UGi
            com.tencent.mm.plugin.festival.c.c r1 = r6.UGi
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r5.url
            java.lang.String r1 = r6.url
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0041
            long r0 = r5.UGj
            long r2 = r6.UGj
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0041
            long r0 = r5.UGk
            long r2 = r6.UGk
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0041
            java.lang.String r0 = r5.savePath
            java.lang.String r1 = r6.savePath
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0041
        L_0x003c:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0040:
            return r0
        L_0x0041:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.festival.c.d.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(263485);
        c cVar = this.UGi;
        int hashCode = (cVar != null ? cVar.hashCode() : 0) * 31;
        String str = this.url;
        int hashCode2 = str != null ? str.hashCode() : 0;
        long j2 = this.UGj;
        long j3 = this.UGk;
        int i3 = (((((hashCode2 + hashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str2 = this.savePath;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i4 = i3 + i2;
        AppMethodBeat.o(263485);
        return i4;
    }

    public final String toString() {
        AppMethodBeat.i(263484);
        String str = "FestivalHttpsDownloadRequest(type=" + this.UGi + ", url=" + this.url + ", queueTimeoutSeconds=" + this.UGj + ", transferTimeoutSeconds=" + this.UGk + ", savePath=" + this.savePath + ")";
        AppMethodBeat.o(263484);
        return str;
    }

    public d(c cVar, String str, long j2, long j3, String str2) {
        p.h(cVar, "type");
        AppMethodBeat.i(263483);
        this.UGi = cVar;
        this.url = str;
        this.UGj = j2;
        this.UGk = j3;
        this.savePath = str2;
        AppMethodBeat.o(263483);
    }

    public /* synthetic */ d(c cVar, String str, String str2) {
        this(cVar, str, 60, 60, str2);
    }

    public final String hSt() {
        AppMethodBeat.i(263482);
        String str = "Request{url:" + this.url + ", type:" + this.UGi + '}';
        AppMethodBeat.o(263482);
        return str;
    }
}
