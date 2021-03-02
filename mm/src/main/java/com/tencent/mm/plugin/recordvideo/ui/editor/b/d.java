package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b.\b\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0011HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\tHÆ\u0003J\t\u00106\u001a\u00020\tHÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\t\u00109\u001a\u00020\u000fHÆ\u0003Ju\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010;\u001a\u00020\u000f2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\tHÖ\u0001J\b\u0010>\u001a\u00020\u0011H\u0016R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\n\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010#\"\u0004\b$\u0010%R\u001a\u0010\r\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010 \"\u0004\b'\u0010\"R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR\u001a\u0010\f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010 \"\u0004\b/\u0010\"¨\u0006?"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverData;", "", "drawingRect", "", "validRect", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "width", "", "height", "videoWidth", "videoHeight", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "isForMix", "", "blurBgPath", "", "([F[FLjava/util/List;IIIIIZLjava/lang/String;)V", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "getHeight", "()I", "setHeight", "(I)V", "()Z", "setForMix", "(Z)V", "getRotate", "setRotate", "getValidRect", "setValidRect", "getVideoHeight", "setVideoHeight", "getVideoWidth", "setVideoWidth", "getWidth", "setWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-recordvideo_release"})
public final class d {
    float[] BKV;
    float[] BKW;
    String BLa;
    boolean CgB;
    int dYT;
    int height;
    List<a> rpx;
    int videoHeight;
    int videoWidth;
    int width;

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        if (kotlin.g.b.p.j(r3.BLa, r4.BLa) != false) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 237907(0x3a153, float:3.33379E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x005a
            boolean r0 = r4 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.b.d
            if (r0 == 0) goto L_0x005f
            com.tencent.mm.plugin.recordvideo.ui.editor.b.d r4 = (com.tencent.mm.plugin.recordvideo.ui.editor.b.d) r4
            float[] r0 = r3.BKV
            float[] r1 = r4.BKV
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x005f
            float[] r0 = r3.BKW
            float[] r1 = r4.BKW
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x005f
            java.util.List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> r0 = r3.rpx
            java.util.List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> r1 = r4.rpx
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x005f
            int r0 = r3.width
            int r1 = r4.width
            if (r0 != r1) goto L_0x005f
            int r0 = r3.height
            int r1 = r4.height
            if (r0 != r1) goto L_0x005f
            int r0 = r3.videoWidth
            int r1 = r4.videoWidth
            if (r0 != r1) goto L_0x005f
            int r0 = r3.videoHeight
            int r1 = r4.videoHeight
            if (r0 != r1) goto L_0x005f
            int r0 = r3.dYT
            int r1 = r4.dYT
            if (r0 != r1) goto L_0x005f
            boolean r0 = r3.CgB
            boolean r1 = r4.CgB
            if (r0 != r1) goto L_0x005f
            java.lang.String r0 = r3.BLa
            java.lang.String r1 = r4.BLa
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x005f
        L_0x005a:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x005e:
            return r0
        L_0x005f:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x005e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.ui.editor.b.d.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(237906);
        float[] fArr = this.BKV;
        int hashCode = (fArr != null ? Arrays.hashCode(fArr) : 0) * 31;
        float[] fArr2 = this.BKW;
        int hashCode2 = ((fArr2 != null ? Arrays.hashCode(fArr2) : 0) + hashCode) * 31;
        List<a> list = this.rpx;
        int hashCode3 = ((((((((((((list != null ? list.hashCode() : 0) + hashCode2) * 31) + this.width) * 31) + this.height) * 31) + this.videoWidth) * 31) + this.videoHeight) * 31) + this.dYT) * 31;
        boolean z = this.CgB;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (i3 + hashCode3) * 31;
        String str = this.BLa;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i7 = i6 + i2;
        AppMethodBeat.o(237906);
        return i7;
    }

    public d(float[] fArr, float[] fArr2, List<a> list, int i2, int i3, int i4, int i5, int i6, boolean z, String str) {
        p.h(fArr, "drawingRect");
        p.h(list, "editorItems");
        p.h(str, "blurBgPath");
        AppMethodBeat.i(237904);
        this.BKV = fArr;
        this.BKW = fArr2;
        this.rpx = list;
        this.width = i2;
        this.height = i3;
        this.videoWidth = i4;
        this.videoHeight = i5;
        this.dYT = i6;
        this.CgB = z;
        this.BLa = str;
        AppMethodBeat.o(237904);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ d(float[] r13, float[] r14, java.util.List r15, int r16, int r17, int r18, int r19, int r20, boolean r21, java.lang.String r22, int r23) {
        /*
            r12 = this;
            r1 = r23 & 2
            if (r1 == 0) goto L_0x0038
            r3 = 0
        L_0x0005:
            r0 = r23
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0035
            r10 = 0
        L_0x000c:
            r0 = r23
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0032
            java.lang.String r11 = ""
        L_0x0015:
            r1 = r12
            r2 = r13
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r1 = 237905(0x3a151, float:3.33376E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            r1 = 237905(0x3a151, float:3.33376E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return
        L_0x0032:
            r11 = r22
            goto L_0x0015
        L_0x0035:
            r10 = r21
            goto L_0x000c
        L_0x0038:
            r3 = r14
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.ui.editor.b.d.<init>(float[], float[], java.util.List, int, int, int, int, int, boolean, java.lang.String, int):void");
    }

    public final String toString() {
        String str;
        AppMethodBeat.i(237903);
        StringBuilder sb = new StringBuilder("RetrieverData(drawingRect=");
        String arrays = Arrays.toString(this.BKV);
        p.g(arrays, "java.util.Arrays.toString(this)");
        StringBuilder append = sb.append(arrays).append(", validRect=");
        float[] fArr = this.BKW;
        if (fArr != null) {
            str = Arrays.toString(fArr);
            p.g(str, "java.util.Arrays.toString(this)");
        } else {
            str = null;
        }
        String sb2 = append.append(str).append(", editorItems=").append(this.rpx).append(", width=").append(this.width).append(", height=").append(this.height).append(", videoWidth=").append(this.videoWidth).append(", videoHeight=").append(this.videoHeight).append(", rotate=").append(this.dYT).append(", isForMix=").append(this.CgB).append(", blurBgPath='").append(this.BLa).append("')").toString();
        AppMethodBeat.o(237903);
        return sb2;
    }
}
