package com.tencent.mm.plugin.recordvideo.background.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.c;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b5\n\u0002\u0010\t\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b¢\u0006\u0002\u0010\u0014J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u000eHÆ\u0003J\t\u00109\u001a\u00020\u000bHÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010;\u001a\u00020\bHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010=\u001a\u00020\u000bHÆ\u0003J\t\u0010>\u001a\u00020\u000bHÆ\u0003J\t\u0010?\u001a\u00020\u000eHÆ\u0003J\t\u0010@\u001a\u00020\u0010HÆ\u0003J\t\u0010A\u001a\u00020\u0010HÆ\u0003J\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000bHÆ\u0001J\u0013\u0010C\u001a\u00020\u00102\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020FJ\t\u0010H\u001a\u00020\u000eHÖ\u0001J\b\u0010I\u001a\u00020\u000bH\u0016R\u001a\u0010\u0013\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010.\"\u0004\b2\u00100R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001e\"\u0004\b6\u0010 ¨\u0006J"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/data/VideoMixData;", "", "captureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "drawingRect", "", "validRect", "mixVideoPath", "", "mixThumbPath", "retryTime", "", "useSoftEncode", "", "enableHevc", "thumbShortSide", "blurBgPath", "(Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;Ljava/util/List;[F[FLjava/lang/String;Ljava/lang/String;IZZILjava/lang/String;)V", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "getCaptureInfo", "()Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "getEnableHevc", "()Z", "setEnableHevc", "(Z)V", "getMixThumbPath", "setMixThumbPath", "getMixVideoPath", "setMixVideoPath", "getRetryTime", "()I", "setRetryTime", "(I)V", "getThumbShortSide", "setThumbShortSide", "getUseSoftEncode", "setUseSoftEncode", "getValidRect", "setValidRect", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "getEndTimeMs", "", "getStartTimeMs", "hashCode", "toString", "plugin-recordvideo_release"})
public final class a {
    public c BKI;
    public float[] BKV;
    public float[] BKW;
    public String BKX;
    public String BKY;
    public int BKZ;
    public String BLa;
    private int ibF;
    public boolean iiC;
    public boolean iiD;
    public List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> rpx;

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006a, code lost:
        if (kotlin.g.b.p.j(r3.BLa, r4.BLa) != false) goto L_0x006c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
        // Method dump skipped, instructions count: 118
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.background.a.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 1;
        int i3 = 0;
        AppMethodBeat.i(237252);
        c cVar = this.BKI;
        int hashCode = (cVar != null ? cVar.hashCode() : 0) * 31;
        List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> list = this.rpx;
        int hashCode2 = ((list != null ? list.hashCode() : 0) + hashCode) * 31;
        float[] fArr = this.BKV;
        int hashCode3 = ((fArr != null ? Arrays.hashCode(fArr) : 0) + hashCode2) * 31;
        float[] fArr2 = this.BKW;
        int hashCode4 = ((fArr2 != null ? Arrays.hashCode(fArr2) : 0) + hashCode3) * 31;
        String str = this.BKX;
        int hashCode5 = ((str != null ? str.hashCode() : 0) + hashCode4) * 31;
        String str2 = this.BKY;
        int hashCode6 = ((((str2 != null ? str2.hashCode() : 0) + hashCode5) * 31) + this.ibF) * 31;
        boolean z = this.iiC;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (i4 + hashCode6) * 31;
        boolean z2 = this.iiD;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        int i8 = (((i7 + i2) * 31) + this.BKZ) * 31;
        String str3 = this.BLa;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        int i9 = i8 + i3;
        AppMethodBeat.o(237252);
        return i9;
    }

    private a(c cVar, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> list, float[] fArr, float[] fArr2, String str, String str2, int i2, boolean z, boolean z2, int i3, String str3) {
        p.h(cVar, "captureInfo");
        p.h(list, "editorItems");
        p.h(fArr, "drawingRect");
        p.h(str, "mixVideoPath");
        p.h(str2, "mixThumbPath");
        p.h(str3, "blurBgPath");
        AppMethodBeat.i(237250);
        this.BKI = cVar;
        this.rpx = list;
        this.BKV = fArr;
        this.BKW = fArr2;
        this.BKX = str;
        this.BKY = str2;
        this.ibF = i2;
        this.iiC = z;
        this.iiD = z2;
        this.BKZ = i3;
        this.BLa = str3;
        AppMethodBeat.o(237250);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ a(com.tencent.mm.plugin.recordvideo.b.c r14, java.util.List r15, float[] r16, float[] r17, java.lang.String r18, java.lang.String r19, int r20, boolean r21, boolean r22, int r23, java.lang.String r24, int r25) {
        /*
            r13 = this;
            r1 = r25 & 8
            if (r1 == 0) goto L_0x0050
            r5 = 0
        L_0x0005:
            r1 = r25 & 64
            if (r1 == 0) goto L_0x004d
            r8 = 1
        L_0x000a:
            r0 = r25
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x004a
            r9 = 0
        L_0x0011:
            r0 = r25
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0047
            r10 = 0
        L_0x0018:
            r0 = r25
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0044
            r11 = 0
        L_0x001f:
            r0 = r25
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0041
            java.lang.String r12 = ""
        L_0x0028:
            r1 = r13
            r2 = r14
            r3 = r15
            r4 = r16
            r6 = r18
            r7 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r1 = 237251(0x39ec3, float:3.3246E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            r1 = 237251(0x39ec3, float:3.3246E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return
        L_0x0041:
            r12 = r24
            goto L_0x0028
        L_0x0044:
            r11 = r23
            goto L_0x001f
        L_0x0047:
            r10 = r22
            goto L_0x0018
        L_0x004a:
            r9 = r21
            goto L_0x0011
        L_0x004d:
            r8 = r20
            goto L_0x000a
        L_0x0050:
            r5 = r17
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.background.a.a.<init>(com.tencent.mm.plugin.recordvideo.b.c, java.util.List, float[], float[], java.lang.String, java.lang.String, int, boolean, boolean, int, java.lang.String, int):void");
    }

    public final void aLn(String str) {
        AppMethodBeat.i(237249);
        p.h(str, "<set-?>");
        this.BKX = str;
        AppMethodBeat.o(237249);
    }

    public final String toString() {
        AppMethodBeat.i(237248);
        StringBuilder append = new StringBuilder("VideoMixData(captureInfo=").append(this.BKI).append(", editorItems=").append(this.rpx).append(", drawingRect=");
        String arrays = Arrays.toString(this.BKV);
        p.g(arrays, "java.util.Arrays.toString(this)");
        String sb = append.append(arrays).append(", mixVideoPath='").append(this.BKX).append("', mixThumbPath='").append(this.BKY).append("', retryTime=").append(this.ibF).append(", useSoftEncode=").append(this.iiC).append(", enableHevc=").append(this.iiD).append(", thumbShortSide=").append(this.BKZ).append(", blurBgPath='").append(this.BLa).append("')").toString();
        AppMethodBeat.o(237248);
        return sb;
    }
}
