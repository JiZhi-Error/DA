package com.tencent.mm.live.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jm\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u000bHÖ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006*"}, hxF = {"Lcom/tencent/mm/live/model/FinderLiveAcceptLiveMicInfo;", "", "liveId", "", "objectId", "acceptMicSdkUserId", "", "acceptMicSdkLiveId", "acceptMicFinderUsername", "liveMicId", "scene", "", "businessType", "sdkPkSign", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getAcceptMicFinderUsername", "()Ljava/lang/String;", "getAcceptMicSdkLiveId", "getAcceptMicSdkUserId", "getBusinessType", "()I", "getLiveId", "()J", "getLiveMicId", "getObjectId", "getScene", "getSdkPkSign", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-logic_release"})
public final class g {
    public final int businessType;
    public final long hFK;
    public final String hFL;
    public final String hFM;
    public final String hFN;
    public final String hFO;
    public final String hFP;
    public final long liveId;
    public final int scene;

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
        if (kotlin.g.b.p.j(r5.hFP, r6.hFP) != false) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.b.g.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(207565);
        long j2 = this.liveId;
        long j3 = this.hFK;
        int i3 = ((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str = this.hFL;
        int hashCode = ((str != null ? str.hashCode() : 0) + i3) * 31;
        String str2 = this.hFM;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.hFN;
        int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31;
        String str4 = this.hFO;
        int hashCode4 = ((((((str4 != null ? str4.hashCode() : 0) + hashCode3) * 31) + this.scene) * 31) + this.businessType) * 31;
        String str5 = this.hFP;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i4 = hashCode4 + i2;
        AppMethodBeat.o(207565);
        return i4;
    }

    public final String toString() {
        AppMethodBeat.i(207564);
        String str = "FinderLiveAcceptLiveMicInfo(liveId=" + this.liveId + ", objectId=" + this.hFK + ", acceptMicSdkUserId=" + this.hFL + ", acceptMicSdkLiveId=" + this.hFM + ", acceptMicFinderUsername=" + this.hFN + ", liveMicId=" + this.hFO + ", scene=" + this.scene + ", businessType=" + this.businessType + ", sdkPkSign=" + this.hFP + ")";
        AppMethodBeat.o(207564);
        return str;
    }

    public g(long j2, long j3, String str, String str2, String str3, String str4, int i2, int i3, String str5) {
        this.liveId = j2;
        this.hFK = j3;
        this.hFL = str;
        this.hFM = str2;
        this.hFN = str3;
        this.hFO = str4;
        this.scene = i2;
        this.businessType = i3;
        this.hFP = str5;
    }
}
