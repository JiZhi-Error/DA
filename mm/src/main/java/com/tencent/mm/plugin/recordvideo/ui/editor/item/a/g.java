package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010+\u001a\u00020,H\u0016J\u0018\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001fH\u0016J\u0010\u00101\u001a\u00020,2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00102\u001a\u00020,H\u0002J\u0010\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020\u000bH\u0002J\b\u00105\u001a\u00020,H\u0016J\b\u00106\u001a\u00020,H\u0002J\b\u00107\u001a\u00020\u000bH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0004¢\u0006\u0004\n\u0002\u0010'R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "lyricsBitmaps", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorInfo;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/util/List;Landroid/graphics/Matrix;)V", "DP_1", "", "LAST_INTERVAL", "", "LYRICS_PRE_NEXT", "LYRICS_VERTICAL_OFFSET", "", "TRANS_TIME", "WAVE_DECREMENT", "WAVE_INCREMENT", "WAVE_INVALIDAT_INTERVAL", "WAVE_RECT_COUNT", "WAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "alpha", "curIndex", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "getLyricsBitmaps", "()Ljava/util/List;", "waveAlpha", "wavePaint", "Landroid/graphics/Paint;", "getWavePaint", "()Landroid/graphics/Paint;", "setWavePaint", "(Landroid/graphics/Paint;)V", "waveRects", "", "Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "", "waveTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "drawWave", "fillAlpha", "fillWaveAlpha", "appearTime", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "nextIndex", "prepareNext", "plugin-recordvideo_release"})
public final class g extends a {
    private long CfC;
    private int CfD;
    private final long CfE = 50;
    private final long CfF = 200;
    private final long CfG = 3000;
    private final int CfH = 11;
    private final float CfI = (((float) this.qfm) * 1.5f);
    private final float CfJ = (((float) this.qfm) * 9.0f);
    private final int CfK = this.qfm;
    private final float CfL = (((float) this.qfm) * 1.5f);
    private final float CfM = (((float) this.qfm) * 12.0f);
    private final float CfN = (((float) this.qfm) * 2.0f);
    private final int CfO = this.qfm;
    private final RectF[] CfP;
    private final float[] CfQ;
    private Paint CfU;
    private final long Cgs = 16;
    private final List<f> Cgt;
    private int alpha;
    private long duration;
    private final int qfm = at.fromDPToPix(MMApplicationContext.getContext(), 1);
    private int sTB;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(List<f> list, Matrix matrix) {
        super(matrix);
        p.h(list, "lyricsBitmaps");
        p.h(matrix, "matrix");
        AppMethodBeat.i(237868);
        this.Cgt = list;
        int i2 = this.CfH;
        RectF[] rectFArr = new RectF[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            rectFArr[i3] = new RectF();
        }
        this.CfP = rectFArr;
        this.CfQ = new float[this.CfH];
        this.CfU = new Paint();
        AppMethodBeat.o(237868);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void init() {
        AppMethodBeat.i(237866);
        this.CfU.setColor(Color.parseColor("#CCFFFFFF"));
        AppMethodBeat.o(237866);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void draw(Canvas canvas, Paint paint) {
        long j2;
        float max;
        ckm ckm;
        ckm ckm2;
        AppMethodBeat.i(237867);
        p.h(canvas, "canvas");
        p.h(paint, "paint");
        canvas.save();
        Bitmap bitmap = this.Cgt.get(this.sTB).bitmap;
        if (bitmap != null) {
            this.duration += this.rpy;
            f fVar = (f) j.L(this.Cgt, this.sTB + 1);
            if (fVar == null || (ckm2 = fVar.Cgr) == null) {
                j2 = this.Cgt.get(this.sTB).Cgr.startTime + this.CfG;
            } else {
                j2 = ckm2.startTime;
            }
            if (this.duration >= j2) {
                this.sTB++;
                if (this.sTB >= this.Cgt.size()) {
                    this.sTB = 0;
                    this.duration = 0;
                    this.CfC = 0;
                }
            }
            if (this.sTB < this.Cgt.size()) {
                long j3 = this.Cgt.get(this.sTB).Cgr.startTime;
                f fVar2 = (f) j.L(this.Cgt, this.sTB + 1);
                long j4 = (fVar2 == null || (ckm = fVar2.Cgr) == null) ? this.Cgt.get(this.sTB).Cgr.startTime + this.CfG : ckm.startTime;
                long j5 = this.CfF;
                long j6 = this.duration - j3;
                if (0 <= j6 && j5 >= j6) {
                    this.alpha = (int) ((255.0f * ((float) (this.duration - j3))) / ((float) this.CfF));
                } else {
                    long j7 = this.CfF;
                    long j8 = j4 - this.duration;
                    if (0 <= j8 && j7 >= j8) {
                        this.alpha = (int) ((((float) (j4 - this.duration)) / ((float) this.CfF)) * 255.0f);
                    } else if (this.duration - j3 > this.CfF && j4 - this.duration > this.CfF) {
                        this.alpha = 255;
                    }
                }
            }
            paint.setAlpha(this.alpha);
            canvas.concat(this.gT);
            if (!this.Cgt.isEmpty()) {
                if (this.CfC == 0 || this.duration - this.CfC > this.CfE) {
                    this.CfC = this.duration;
                    RectF[] rectFArr = this.CfP;
                    int i2 = 0;
                    int length = rectFArr.length;
                    int i3 = 0;
                    float f2 = 0.0f;
                    while (i3 < length) {
                        RectF rectF = rectFArr[i3];
                        int i4 = i2 + 1;
                        float height = rectF.height();
                        if (height <= ((float) this.CfK)) {
                            this.CfQ[i2] = (float) (((double) this.CfJ) * Math.random());
                        } else if (height >= this.CfQ[i2]) {
                            this.CfQ[i2] = (float) this.CfK;
                        }
                        if (height <= this.CfQ[i2]) {
                            max = Math.min(height + this.CfN, this.CfJ);
                        } else {
                            max = Math.max(height - ((float) this.CfO), (float) this.CfK);
                        }
                        rectF.set(this.CfL + f2, (this.CfJ / 2.0f) - (max / 2.0f), f2 + this.CfL + this.CfI, (max / 2.0f) + (this.CfJ / 2.0f));
                        f2 = rectF.right;
                        i3++;
                        i2 = i4;
                    }
                }
                long j9 = this.Cgt.get(0).Cgr.startTime;
                if (this.CfD < 255) {
                    long j10 = this.CfF;
                    long j11 = this.duration - j9;
                    if (0 <= j11 && j10 >= j11) {
                        this.CfD = (int) ((((float) (this.duration - j9)) * 255.0f) / ((float) this.CfF));
                    } else if (this.duration - j9 > this.CfF) {
                        this.CfD = 255;
                    }
                }
                this.CfU.setAlpha(this.CfD);
                for (RectF rectF2 : this.CfP) {
                    canvas.drawRect(rectF2, this.CfU);
                }
            }
            canvas.drawBitmap(bitmap, 0.0f, this.CfM, paint);
            paint.setAlpha(255);
        }
        canvas.restore();
        AppMethodBeat.o(237867);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final long eMv() {
        return this.Cgs;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
    public final void destroy() {
    }
}
