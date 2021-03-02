package com.tencent.mm.plugin.ad;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003JG\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\tHÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "", "domain", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "manifest", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", IssueStorage.COLUMN_EXT_INFO, "", "bizScene", "", "subBizScene", "debug", "", "(Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;Ljava/lang/String;IIZ)V", "getBizScene", "()I", "setBizScene", "(I)V", "getDebug", "()Z", "getDomain", "()Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "(Ljava/lang/String;)V", "getManifest", "()Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "getSubBizScene", "setSubBizScene", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "webview-sdk_release"})
public final class a {
    public final bhc ICs;
    public final bhd ICt;
    public final boolean aXs;
    public String extInfo;
    public int hDa;
    public int pmN;

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        if (r3.aXs == r4.aXs) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 224908(0x36e8c, float:3.15163E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x003e
            boolean r0 = r4 instanceof com.tencent.mm.plugin.ad.a
            if (r0 == 0) goto L_0x0043
            com.tencent.mm.plugin.ad.a r4 = (com.tencent.mm.plugin.ad.a) r4
            com.tencent.mm.protocal.protobuf.bhc r0 = r3.ICs
            com.tencent.mm.protocal.protobuf.bhc r1 = r4.ICs
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0043
            com.tencent.mm.protocal.protobuf.bhd r0 = r3.ICt
            com.tencent.mm.protocal.protobuf.bhd r1 = r4.ICt
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0043
            java.lang.String r0 = r3.extInfo
            java.lang.String r1 = r4.extInfo
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0043
            int r0 = r3.hDa
            int r1 = r4.hDa
            if (r0 != r1) goto L_0x0043
            int r0 = r3.pmN
            int r1 = r4.pmN
            if (r0 != r1) goto L_0x0043
            boolean r0 = r3.aXs
            boolean r1 = r4.aXs
            if (r0 != r1) goto L_0x0043
        L_0x003e:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0042:
            return r0
        L_0x0043:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0042
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ad.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(224907);
        bhc bhc = this.ICs;
        int hashCode = (bhc != null ? bhc.hashCode() : 0) * 31;
        bhd bhd = this.ICt;
        int hashCode2 = ((bhd != null ? bhd.hashCode() : 0) + hashCode) * 31;
        String str = this.extInfo;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = (((((hashCode2 + i2) * 31) + this.hDa) * 31) + this.pmN) * 31;
        boolean z = this.aXs;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = i4 + i3;
        AppMethodBeat.o(224907);
        return i7;
    }

    public final String toString() {
        AppMethodBeat.i(224906);
        String str = "PrefetchManifest(domain=" + this.ICs + ", manifest=" + this.ICt + ", extInfo=" + this.extInfo + ", bizScene=" + this.hDa + ", subBizScene=" + this.pmN + ", debug=" + this.aXs + ")";
        AppMethodBeat.o(224906);
        return str;
    }

    private a(bhc bhc, bhd bhd, boolean z) {
        p.h(bhc, "domain");
        p.h(bhd, "manifest");
        AppMethodBeat.i(224904);
        this.ICs = bhc;
        this.ICt = bhd;
        this.extInfo = null;
        this.hDa = 0;
        this.pmN = 0;
        this.aXs = z;
        AppMethodBeat.o(224904);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(bhc bhc, bhd bhd, boolean z, int i2) {
        this(bhc, bhd, (i2 & 32) != 0 ? false : z);
        AppMethodBeat.i(224905);
        AppMethodBeat.o(224905);
    }
}
