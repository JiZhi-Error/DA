package com.tencent.mm.plugin.finder.live.viewmodel;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0010J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00105\u001a\u00020\u000bHÆ\u0003J\t\u00106\u001a\u00020\u000bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u000bHÖ\u0001J\t\u0010=\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLinkMicUser;", "", "liveId", "", "objectId", "liveMicId", "", "finderUsername", "sdkLiveId", "sdkUserId", "scene", "", "businessType", "pkSign", "avatarUrl", "finderNickname", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "getBusinessType", "()I", "setBusinessType", "(I)V", "getFinderNickname", "setFinderNickname", "getFinderUsername", "setFinderUsername", "getLiveId", "()J", "setLiveId", "(J)V", "getLiveMicId", "setLiveMicId", "getObjectId", "setObjectId", "getPkSign", "setPkSign", "getScene", "setScene", "getSdkLiveId", "setSdkLiveId", "getSdkUserId", "setSdkUserId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-finder_release"})
public final class b {
    public int businessType;
    public String finderUsername;
    public long hFK;
    public String hFO;
    public String kog;
    public long liveId;
    public int scene;
    public String uCn;
    public String uCo;
    public String uCp;
    public String uCq;

    public b() {
        this(0, 0, null, null, null, null, 0, 0, null, null, null, 2047);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006e, code lost:
        if (kotlin.g.b.p.j(r5.uCq, r6.uCq) != false) goto L_0x0070;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 122
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.viewmodel.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(247872);
        long j2 = this.liveId;
        long j3 = this.hFK;
        int i3 = ((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str = this.hFO;
        int hashCode = ((str != null ? str.hashCode() : 0) + i3) * 31;
        String str2 = this.finderUsername;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.uCn;
        int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31;
        String str4 = this.uCo;
        int hashCode4 = ((((((str4 != null ? str4.hashCode() : 0) + hashCode3) * 31) + this.scene) * 31) + this.businessType) * 31;
        String str5 = this.uCp;
        int hashCode5 = ((str5 != null ? str5.hashCode() : 0) + hashCode4) * 31;
        String str6 = this.kog;
        int hashCode6 = ((str6 != null ? str6.hashCode() : 0) + hashCode5) * 31;
        String str7 = this.uCq;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        int i4 = hashCode6 + i2;
        AppMethodBeat.o(247872);
        return i4;
    }

    public final String toString() {
        AppMethodBeat.i(247871);
        String str = "FinderLinkMicUser(liveId=" + this.liveId + ", objectId=" + this.hFK + ", liveMicId=" + this.hFO + ", finderUsername=" + this.finderUsername + ", sdkLiveId=" + this.uCn + ", sdkUserId=" + this.uCo + ", scene=" + this.scene + ", businessType=" + this.businessType + ", pkSign=" + this.uCp + ", avatarUrl=" + this.kog + ", finderNickname=" + this.uCq + ")";
        AppMethodBeat.o(247871);
        return str;
    }

    private b(long j2, long j3, String str, String str2, String str3, String str4, int i2, int i3, String str5, String str6, String str7) {
        this.liveId = j2;
        this.hFK = j3;
        this.hFO = str;
        this.finderUsername = str2;
        this.uCn = str3;
        this.uCo = str4;
        this.scene = i2;
        this.businessType = i3;
        this.uCp = str5;
        this.kog = str6;
        this.uCq = str7;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(long j2, long j3, String str, String str2, String str3, String str4, int i2, int i3, String str5, String str6, String str7, int i4) {
        this((i4 & 1) != 0 ? 0 : j2, (i4 & 2) != 0 ? 0 : j3, (i4 & 4) != 0 ? "" : str, (i4 & 8) != 0 ? "" : str2, (i4 & 16) != 0 ? "" : str3, (i4 & 32) != 0 ? "" : str4, (i4 & 64) != 0 ? 0 : i2, (i4 & 128) != 0 ? 0 : i3, (i4 & 256) != 0 ? "" : str5, (i4 & 512) != 0 ? "" : str6, (i4 & 1024) != 0 ? "" : str7);
        AppMethodBeat.i(247870);
        AppMethodBeat.o(247870);
    }
}
