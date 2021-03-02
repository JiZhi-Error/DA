package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\bi\b\b\u0018\u00002\u00020\u0001B\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010 J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0005HÆ\u0003J\t\u0010^\u001a\u00020\u0011HÆ\u0003J\t\u0010_\u001a\u00020\bHÆ\u0003J\t\u0010`\u001a\u00020\bHÆ\u0003J\t\u0010a\u001a\u00020\nHÆ\u0003J\t\u0010b\u001a\u00020\nHÆ\u0003J\t\u0010c\u001a\u00020\bHÆ\u0003J\t\u0010d\u001a\u00020\bHÆ\u0003J\t\u0010e\u001a\u00020\bHÆ\u0003J\t\u0010f\u001a\u00020\bHÆ\u0003J\t\u0010g\u001a\u00020\u0005HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010k\u001a\u00020\bHÆ\u0003J\t\u0010l\u001a\u00020\bHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010n\u001a\u00020\u0005HÆ\u0003J\t\u0010o\u001a\u00020\bHÆ\u0003J\t\u0010p\u001a\u00020\nHÆ\u0003J\t\u0010q\u001a\u00020\nHÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010s\u001a\u00020\bHÆ\u0003J\t\u0010t\u001a\u00020\u0005HÆ\u0003J\u0002\u0010u\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010v\u001a\u00020\u00112\b\u0010w\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010x\u001a\u00020\bHÖ\u0001J\t\u0010y\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u001d\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\u001a\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u00105\"\u0004\b6\u00107R\u001a\u0010\u0019\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\"\"\u0004\b9\u0010$R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010&\"\u0004\b;\u0010(R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00102\"\u0004\b=\u00104R\u001a\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010,\"\u0004\b?\u0010.R\u001a\u0010\u0018\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\"\"\u0004\bA\u0010$R\u001a\u0010\u0017\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\"\"\u0004\bC\u0010$R\u001a\u0010\u001e\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\"\"\u0004\bE\u0010$R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010&\"\u0004\bG\u0010(R\u001a\u0010\u0016\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\"\"\u0004\bI\u0010$R\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\"\"\u0004\bK\u0010$R\u001a\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00102\"\u0004\bM\u00104R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010&\"\u0004\bO\u0010(R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010,\"\u0004\bQ\u0010.R\u001a\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010,\"\u0004\bS\u0010.R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010&\"\u0004\bU\u0010(R\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00102\"\u0004\bW\u00104R\u001a\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\"\"\u0004\bY\u0010$R\u001a\u0010\u0013\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\"\"\u0004\b[\u0010$¨\u0006z"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "", "sessionId", "", "startExposureMs", "", "endExposureMs", "disAppearType", "", "itemExposureAreaWeigth", "", "screenExposureAreaWeigth", "contextId", "scene", "updateTimeMs", "itemExposureTimeMs", "isShowing", "", "x", "y", "height", "width", "position", "itemPosition", "itemPos", "itemArrayIndex", "feedId", "userName", "nickName", "commentCount", "likeCount", "itemBufffer", "(Ljava/lang/String;JJIFFLjava/lang/String;IJJZIIFFIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getCommentCount", "()I", "setCommentCount", "(I)V", "getContextId", "()Ljava/lang/String;", "setContextId", "(Ljava/lang/String;)V", "getDisAppearType", "setDisAppearType", "getEndExposureMs", "()J", "setEndExposureMs", "(J)V", "getFeedId", "setFeedId", "getHeight", "()F", "setHeight", "(F)V", "()Z", "setShowing", "(Z)V", "getItemArrayIndex", "setItemArrayIndex", "getItemBufffer", "setItemBufffer", "getItemExposureAreaWeigth", "setItemExposureAreaWeigth", "getItemExposureTimeMs", "setItemExposureTimeMs", "getItemPos", "setItemPos", "getItemPosition", "setItemPosition", "getLikeCount", "setLikeCount", "getNickName", "setNickName", "getPosition", "setPosition", "getScene", "setScene", "getScreenExposureAreaWeigth", "setScreenExposureAreaWeigth", "getSessionId", "setSessionId", "getStartExposureMs", "setStartExposureMs", "getUpdateTimeMs", "setUpdateTimeMs", "getUserName", "setUserName", "getWidth", "setWidth", "getX", "setX", "getY", "setY", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-expt_release"})
public final class i {
    private int commentCount;
    public boolean ddZ;
    public String feedId;
    public float height;
    public int kf;
    private int likeCount;
    public String nickName;
    public int position;
    public long sGJ;
    public float sGL;
    public float sGM;
    public String sGQ;
    public String sGR;
    int sGS;
    public long sHt;
    public long sHu;
    public int sHv;
    public long sHw;
    public int sHx;
    public int scene;
    public String sessionId;
    String userName;
    public float width;
    public int x;
    public int y;

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d2, code lost:
        if (kotlin.g.b.p.j(r5.sGR, r6.sGR) != false) goto L_0x00d4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 222
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.b.d.i.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(221099);
        String str = this.sessionId;
        int hashCode = str != null ? str.hashCode() : 0;
        long j2 = this.sHt;
        long j3 = this.sHu;
        int floatToIntBits = ((((((((((hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.sHv) * 31) + Float.floatToIntBits(this.sGL)) * 31) + Float.floatToIntBits(this.sGM)) * 31;
        String str2 = this.sGQ;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        long j4 = this.sGJ;
        long j5 = this.sHw;
        int i3 = (((((((hashCode2 + floatToIntBits) * 31) + this.scene) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        boolean z = this.ddZ;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int floatToIntBits2 = (((((((((((((((((i4 + i3) * 31) + this.x) * 31) + this.y) * 31) + Float.floatToIntBits(this.height)) * 31) + Float.floatToIntBits(this.width)) * 31) + this.position) * 31) + this.kf) * 31) + this.sHx) * 31) + this.sGS) * 31;
        String str3 = this.feedId;
        int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + floatToIntBits2) * 31;
        String str4 = this.userName;
        int hashCode4 = ((str4 != null ? str4.hashCode() : 0) + hashCode3) * 31;
        String str5 = this.nickName;
        int hashCode5 = ((((((str5 != null ? str5.hashCode() : 0) + hashCode4) * 31) + this.commentCount) * 31) + this.likeCount) * 31;
        String str6 = this.sGR;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i7 = hashCode5 + i2;
        AppMethodBeat.o(221099);
        return i7;
    }

    public final String toString() {
        AppMethodBeat.i(221098);
        String str = "WaterFeed(sessionId=" + this.sessionId + ", startExposureMs=" + this.sHt + ", endExposureMs=" + this.sHu + ", disAppearType=" + this.sHv + ", itemExposureAreaWeigth=" + this.sGL + ", screenExposureAreaWeigth=" + this.sGM + ", contextId=" + this.sGQ + ", scene=" + this.scene + ", updateTimeMs=" + this.sGJ + ", itemExposureTimeMs=" + this.sHw + ", isShowing=" + this.ddZ + ", x=" + this.x + ", y=" + this.y + ", height=" + this.height + ", width=" + this.width + ", position=" + this.position + ", itemPosition=" + this.kf + ", itemPos=" + this.sHx + ", itemArrayIndex=" + this.sGS + ", feedId=" + this.feedId + ", userName=" + this.userName + ", nickName=" + this.nickName + ", commentCount=" + this.commentCount + ", likeCount=" + this.likeCount + ", itemBufffer=" + this.sGR + ")";
        AppMethodBeat.o(221098);
        return str;
    }

    private i() {
        this.sessionId = null;
        this.sHt = 0;
        this.sHu = 0;
        this.sHv = 0;
        this.sGL = 0.0f;
        this.sGM = 0.0f;
        this.sGQ = null;
        this.scene = 0;
        this.sGJ = 0;
        this.sHw = 0;
        this.ddZ = false;
        this.x = 0;
        this.y = 0;
        this.height = 0.0f;
        this.width = 0.0f;
        this.position = -1;
        this.kf = -1;
        this.sHx = -1;
        this.sGS = -1;
        this.feedId = null;
        this.userName = null;
        this.nickName = null;
        this.commentCount = 0;
        this.likeCount = 0;
        this.sGR = null;
    }

    public /* synthetic */ i(byte b2) {
        this();
    }
}
