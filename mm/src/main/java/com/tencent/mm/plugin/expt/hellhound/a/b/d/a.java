package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\bH\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n¢\u0006\u0002\u0010\u0017J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\nHÆ\u0003J\t\u0010E\u001a\u00020\nHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010I\u001a\u00020\nHÆ\u0003J\t\u0010J\u001a\u00020\nHÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010O\u001a\u00020\nHÆ\u0003J\t\u0010P\u001a\u00020\fHÆ\u0003J\t\u0010Q\u001a\u00020\fHÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J¿\u0001\u0010S\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\nHÆ\u0001J\u0013\u0010T\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010W\u001a\u00020\nHÖ\u0001J\t\u0010X\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\r\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001bR\u001a\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R\u001a\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010'\"\u0004\b1\u0010)R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001bR\u001a\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010'\"\u0004\b5\u0010)R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010'\"\u0004\b7\u0010)R\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010#\"\u0004\b9\u0010%R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0019\"\u0004\b;\u0010\u001bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0019\"\u0004\b=\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001d\"\u0004\b?\u0010\u001fR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010#\"\u0004\bA\u0010%¨\u0006Y"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "", "height", "", "width", "sessionId", "", "clickFeedId", "nickName", "scene", "", "updateTimeMs", "", "clickTimeMs", "itemExposureAreaWeigth", "screenExposureAreaWeigth", "itemDirection", "itemIndex", "shotScreenJson", "contextId", "itemBufffer", "itemArrayIndex", "position", "(FFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJFFIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getClickFeedId", "()Ljava/lang/String;", "setClickFeedId", "(Ljava/lang/String;)V", "getClickTimeMs", "()J", "setClickTimeMs", "(J)V", "getContextId", "setContextId", "getHeight", "()F", "setHeight", "(F)V", "getItemArrayIndex", "()I", "setItemArrayIndex", "(I)V", "getItemBufffer", "setItemBufffer", "getItemDirection", "setItemDirection", "getItemExposureAreaWeigth", "setItemExposureAreaWeigth", "getItemIndex", "setItemIndex", "getNickName", "setNickName", "getPosition", "setPosition", "getScene", "setScene", "getScreenExposureAreaWeigth", "setScreenExposureAreaWeigth", "getSessionId", "setSessionId", "getShotScreenJson", "setShotScreenJson", "getUpdateTimeMs", "setUpdateTimeMs", "getWidth", "setWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-expt_release"})
public final class a {
    public float height;
    public String nickName;
    public int position;
    public String sGI;
    public long sGJ;
    public long sGK;
    public float sGL;
    public float sGM;
    public int sGN;
    public int sGO;
    public String sGP;
    public String sGQ;
    public String sGR;
    public int sGS;
    public int scene;
    public String sessionId;
    public float width;

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009e, code lost:
        if (r5.position == r6.position) goto L_0x00a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 170
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.b.d.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(221032);
        int floatToIntBits = ((Float.floatToIntBits(this.height) * 31) + Float.floatToIntBits(this.width)) * 31;
        String str = this.sessionId;
        int hashCode = ((str != null ? str.hashCode() : 0) + floatToIntBits) * 31;
        String str2 = this.sGI;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.nickName;
        int hashCode3 = str3 != null ? str3.hashCode() : 0;
        long j2 = this.sGJ;
        long j3 = this.sGK;
        int floatToIntBits2 = (((((((((((((((hashCode3 + hashCode2) * 31) + this.scene) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + Float.floatToIntBits(this.sGL)) * 31) + Float.floatToIntBits(this.sGM)) * 31) + this.sGN) * 31) + this.sGO) * 31;
        String str4 = this.sGP;
        int hashCode4 = ((str4 != null ? str4.hashCode() : 0) + floatToIntBits2) * 31;
        String str5 = this.sGQ;
        int hashCode5 = ((str5 != null ? str5.hashCode() : 0) + hashCode4) * 31;
        String str6 = this.sGR;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i3 = ((((hashCode5 + i2) * 31) + this.sGS) * 31) + this.position;
        AppMethodBeat.o(221032);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(221031);
        String str = "ClickFeed(height=" + this.height + ", width=" + this.width + ", sessionId=" + this.sessionId + ", clickFeedId=" + this.sGI + ", nickName=" + this.nickName + ", scene=" + this.scene + ", updateTimeMs=" + this.sGJ + ", clickTimeMs=" + this.sGK + ", itemExposureAreaWeigth=" + this.sGL + ", screenExposureAreaWeigth=" + this.sGM + ", itemDirection=" + this.sGN + ", itemIndex=" + this.sGO + ", shotScreenJson=" + this.sGP + ", contextId=" + this.sGQ + ", itemBufffer=" + this.sGR + ", itemArrayIndex=" + this.sGS + ", position=" + this.position + ")";
        AppMethodBeat.o(221031);
        return str;
    }

    private a() {
        this.height = 0.0f;
        this.width = 0.0f;
        this.sessionId = null;
        this.sGI = null;
        this.nickName = null;
        this.scene = 0;
        this.sGJ = 0;
        this.sGK = 0;
        this.sGL = 0.0f;
        this.sGM = 0.0f;
        this.sGN = 0;
        this.sGO = 0;
        this.sGP = null;
        this.sGQ = null;
        this.sGR = null;
        this.sGS = 0;
        this.position = 0;
    }

    public /* synthetic */ a(byte b2) {
        this();
    }
}
