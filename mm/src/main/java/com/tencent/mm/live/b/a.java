package com.tencent.mm.live.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b)\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0013HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J¨\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u00020\u00132\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\bHÖ\u0001J\t\u0010;\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001a¨\u0006<"}, hxF = {"Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "", "liveId", "", "micId", "", "userId", "sdkAppId", "", "roleId", "sdkLiveId", "userSig", "privateMapKey", "expireForPmk", "sdkParam", "micType", "seq", "pkSign", "isAnchorPk", "", "(JLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;JLjava/lang/String;Z)V", "getExpireForPmk", "()J", "()Z", "getLiveId", "getMicId", "()Ljava/lang/String;", "getMicType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPkSign", "getPrivateMapKey", "getRoleId", "()I", "getSdkAppId", "getSdkLiveId", "getSdkParam", "getSeq", "getUserId", "getUserSig", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;JLjava/lang/String;Z)Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-logic_release"})
public final class a {
    public final int hFA;
    public final int hFB;
    public final long hFC;
    public final String hFD;
    public final Integer hFE;
    public final String hFz;
    public final long liveId;
    public final String privateMapKey;
    public final int sdkAppId;
    private final long seq;
    public final String uCp;
    public final String userId;
    public final String userSig;
    public final boolean vae;

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0082, code lost:
        if (r5.vae == r6.vae) goto L_0x0084;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 142
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.b.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(207551);
        long j2 = this.liveId;
        int i3 = ((int) (j2 ^ (j2 >>> 32))) * 31;
        String str = this.hFz;
        int hashCode = ((str != null ? str.hashCode() : 0) + i3) * 31;
        String str2 = this.userId;
        int hashCode2 = ((((((((str2 != null ? str2.hashCode() : 0) + hashCode) * 31) + this.sdkAppId) * 31) + this.hFA) * 31) + this.hFB) * 31;
        String str3 = this.userSig;
        int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31;
        String str4 = this.privateMapKey;
        int hashCode4 = str4 != null ? str4.hashCode() : 0;
        long j3 = this.hFC;
        int i4 = (((hashCode4 + hashCode3) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str5 = this.hFD;
        int hashCode5 = ((str5 != null ? str5.hashCode() : 0) + i4) * 31;
        Integer num = this.hFE;
        int hashCode6 = num != null ? num.hashCode() : 0;
        long j4 = this.seq;
        int i5 = (((hashCode6 + hashCode5) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        String str6 = this.uCp;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i6 = (i5 + i2) * 31;
        boolean z = this.vae;
        if (z) {
            z = true;
        }
        int i7 = z ? 1 : 0;
        int i8 = z ? 1 : 0;
        int i9 = z ? 1 : 0;
        int i10 = i7 + i6;
        AppMethodBeat.o(207551);
        return i10;
    }

    public final String toString() {
        AppMethodBeat.i(207550);
        String str = "AcceptLiveMicInfo(liveId=" + this.liveId + ", micId=" + this.hFz + ", userId=" + this.userId + ", sdkAppId=" + this.sdkAppId + ", roleId=" + this.hFA + ", sdkLiveId=" + this.hFB + ", userSig=" + this.userSig + ", privateMapKey=" + this.privateMapKey + ", expireForPmk=" + this.hFC + ", sdkParam=" + this.hFD + ", micType=" + this.hFE + ", seq=" + this.seq + ", pkSign=" + this.uCp + ", isAnchorPk=" + this.vae + ")";
        AppMethodBeat.o(207550);
        return str;
    }

    public a(long j2, String str, String str2, int i2, int i3, int i4, String str3, String str4, long j3, String str5, Integer num, long j4, String str6, boolean z) {
        this.liveId = j2;
        this.hFz = str;
        this.userId = str2;
        this.sdkAppId = i2;
        this.hFA = i3;
        this.hFB = i4;
        this.userSig = str3;
        this.privateMapKey = str4;
        this.hFC = j3;
        this.hFD = str5;
        this.hFE = num;
        this.seq = j4;
        this.uCp = str6;
        this.vae = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(long j2, String str, String str2, int i2, int i3, int i4, String str3, String str4, long j3, String str5, Integer num, long j4, int i5) {
        this(j2, str, str2, i2, i3, i4, str3, str4, j3, str5, (i5 & 1024) != 0 ? 0 : num, (i5 & 2048) != 0 ? 0 : j4, null, false);
        AppMethodBeat.i(259540);
        AppMethodBeat.o(259540);
    }
}
