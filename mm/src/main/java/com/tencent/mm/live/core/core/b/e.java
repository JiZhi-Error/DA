package com.tencent.mm.live.core.core.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012$\b\u0002\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003`\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007¢\u0006\u0002\u0010\u0015J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0007HÆ\u0003J%\u0010<\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003`\u0012HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0007HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0007HÆ\u0003J\t\u0010E\u001a\u00020\rHÆ\u0003J\t\u0010F\u001a\u00020\u0007HÆ\u0003J©\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072$\b\u0002\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003`\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0007HÆ\u0001J\u0013\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0012\u0010K\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010L\u001a\u00020\u0007J\t\u0010M\u001a\u00020\u0007HÖ\u0001J\u0010\u0010N\u001a\u00020\u00072\b\u0010O\u001a\u0004\u0018\u00010\u0003J\t\u0010P\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001a\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u001a\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R6\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003`\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001b\"\u0004\b1\u0010\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0017\"\u0004\b3\u0010\u0019R\u001a\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001f\"\u0004\b5\u0010!R\u001a\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001f\"\u0004\b7\u0010!R\u001a\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001b\"\u0004\b9\u0010\u001d¨\u0006Q"}, hxF = {"Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "", "liveName", "", "liveId", "", "audienceMode", "", "anchorUserId", "appId", "bizId", "liveScene", "cdnSwitchMode", "Lcom/tencent/mm/live/core/core/model/CdnSwitchMode;", "cdnQualitySvrcfg", "cdnH265BackCfg", "cdnUrlMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "startTime", "seiMode", "(Ljava/lang/String;JILjava/lang/String;JJILcom/tencent/mm/live/core/core/model/CdnSwitchMode;IILjava/util/HashMap;JI)V", "getAnchorUserId", "()Ljava/lang/String;", "setAnchorUserId", "(Ljava/lang/String;)V", "getAppId", "()J", "setAppId", "(J)V", "getAudienceMode", "()I", "setAudienceMode", "(I)V", "getBizId", "setBizId", "getCdnH265BackCfg", "setCdnH265BackCfg", "getCdnQualitySvrcfg", "setCdnQualitySvrcfg", "getCdnSwitchMode", "()Lcom/tencent/mm/live/core/core/model/CdnSwitchMode;", "setCdnSwitchMode", "(Lcom/tencent/mm/live/core/core/model/CdnSwitchMode;)V", "getCdnUrlMap", "()Ljava/util/HashMap;", "setCdnUrlMap", "(Ljava/util/HashMap;)V", "getLiveId", "setLiveId", "getLiveName", "setLiveName", "getLiveScene", "setLiveScene", "getSeiMode", "setSeiMode", "getStartTime", "setStartTime", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "getCdnUrl", "cdnQualityTag", "hashCode", "indexOfUrl", "url", "toString", "plugin-core_release"})
public final class e {
    public long appId;
    private String hwb;
    public int hzl;
    public String hzm;
    public long hzn;
    public int hzo;
    public a hzp;
    public int hzq;
    public int hzr;
    public HashMap<Integer, String> hzs;
    public long liveId;
    public long startTime;
    public int uEz;

    public e() {
        this(null, 0, 0, null, 0, 0, 0, null, null, 0, 8191);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0072, code lost:
        if (r5.uEz == r6.uEz) goto L_0x0074;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.core.core.b.e.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(196461);
        String str = this.hwb;
        int hashCode = str != null ? str.hashCode() : 0;
        long j2 = this.liveId;
        int i3 = ((((hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.hzl) * 31;
        String str2 = this.hzm;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        long j3 = this.appId;
        long j4 = this.hzn;
        int i4 = (((((((hashCode2 + i3) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.hzo) * 31;
        a aVar = this.hzp;
        int hashCode3 = ((((((aVar != null ? aVar.hashCode() : 0) + i4) * 31) + this.hzq) * 31) + this.hzr) * 31;
        HashMap<Integer, String> hashMap = this.hzs;
        if (hashMap != null) {
            i2 = hashMap.hashCode();
        }
        long j5 = this.startTime;
        int i5 = ((((hashCode3 + i2) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.uEz;
        AppMethodBeat.o(196461);
        return i5;
    }

    public final String toString() {
        AppMethodBeat.i(196460);
        String str = "LiveRoomInfo(liveName=" + this.hwb + ", liveId=" + this.liveId + ", audienceMode=" + this.hzl + ", anchorUserId=" + this.hzm + ", appId=" + this.appId + ", bizId=" + this.hzn + ", liveScene=" + this.hzo + ", cdnSwitchMode=" + this.hzp + ", cdnQualitySvrcfg=" + this.hzq + ", cdnH265BackCfg=" + this.hzr + ", cdnUrlMap=" + this.hzs + ", startTime=" + this.startTime + ", seiMode=" + this.uEz + ")";
        AppMethodBeat.o(196460);
        return str;
    }

    private e(String str, long j2, int i2, String str2, long j3, long j4, int i3, a aVar, HashMap<Integer, String> hashMap, long j5) {
        p.h(str, "liveName");
        p.h(aVar, "cdnSwitchMode");
        p.h(hashMap, "cdnUrlMap");
        AppMethodBeat.i(196458);
        this.hwb = str;
        this.liveId = j2;
        this.hzl = i2;
        this.hzm = str2;
        this.appId = j3;
        this.hzn = j4;
        this.hzo = i3;
        this.hzp = aVar;
        this.hzq = 0;
        this.hzr = 0;
        this.hzs = hashMap;
        this.startTime = j5;
        this.uEz = 0;
        AppMethodBeat.o(196458);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ e(java.lang.String r19, long r20, int r22, java.lang.String r23, long r24, long r26, int r28, com.tencent.mm.live.core.core.b.a r29, java.util.HashMap r30, long r31, int r33) {
        /*
        // Method dump skipped, instructions count: 129
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.core.core.b.e.<init>(java.lang.String, long, int, java.lang.String, long, long, int, com.tencent.mm.live.core.core.b.a, java.util.HashMap, long, int):void");
    }

    public final void Gn(String str) {
        AppMethodBeat.i(196456);
        p.h(str, "<set-?>");
        this.hwb = str;
        AppMethodBeat.o(196456);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(196457);
        p.h(aVar, "<set-?>");
        this.hzp = aVar;
        AppMethodBeat.o(196457);
    }

    public final String qr(int i2) {
        AppMethodBeat.i(196455);
        Log.i("LiveRoomInfo", "getCdnUrl cdnQualitySvrcfg".concat(String.valueOf(i2)));
        String str = this.hzs.get(Integer.valueOf(i2));
        if (str == null) {
            str = this.hzs.get(0);
        }
        AppMethodBeat.o(196455);
        return str;
    }
}
