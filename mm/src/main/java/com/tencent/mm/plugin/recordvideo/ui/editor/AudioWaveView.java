package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ&\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020BJ\b\u0010D\u001a\u00020<H\u0002J\u0010\u0010E\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0015J(\u0010F\u001a\u00020<2\u0006\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\tH\u0014J\u000e\u0010K\u001a\u00020<2\u0006\u0010L\u001a\u00020*J\u000e\u0010K\u001a\u00020<2\u0006\u0010M\u001a\u00020\tJ\u0010\u0010N\u001a\u00020<2\u0006\u0010O\u001a\u00020\fH\u0016J\u000e\u0010P\u001a\u00020<2\u0006\u0010Q\u001a\u00020\fJ\b\u0010R\u001a\u00020<H\u0002R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR\u0011\u00102\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001aR(\u00106\u001a\u0004\u0018\u0001052\b\u00104\u001a\u0004\u0018\u000105@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006S"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isPlayerLoading", "", "()Z", "setPlayerLoading", "(Z)V", "isRunningShow", "setRunningShow", "mRandom", "", "getMRandom", "()D", "setMRandom", "(D)V", "mRectCount", "getMRectCount", "()I", "setMRectCount", "(I)V", "mRectHeight", "getMRectHeight", "setMRectHeight", "mRectWidth", "getMRectWidth", "setMRectWidth", "mWavePaint", "Landroid/graphics/Paint;", "getMWavePaint", "()Landroid/graphics/Paint;", "setMWavePaint", "(Landroid/graphics/Paint;)V", "mWavePatinColorState", "Landroid/content/res/ColorStateList;", "getMWavePatinColorState", "()Landroid/content/res/ColorStateList;", "setMWavePatinColorState", "(Landroid/content/res/ColorStateList;)V", "mWidth", "getMWidth", "setMWidth", "offset", "getOffset", "value", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "drawRoundRect", "", "canvas", "Landroid/graphics/Canvas;", "rectF", "Landroid/graphics/RectF;", "r1", "", "r2", "initView", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setColor", "colorStateList", "color", "setSelected", "selected", "setShow", "isShow", "updateColors", "plugin-recordvideo_release"})
public final class AudioWaveView extends View {
    private int Caf;
    private Paint Cag;
    private ColorStateList Cah;
    private int Cai;
    private double Caj;
    private boolean Cak;
    private boolean Cal = true;
    private v hWJ;
    private int mWidth;
    private final int offset = com.tencent.mm.cb.a.E(getContext(), 3);
    private int qSb;

    public final int getMWidth() {
        return this.mWidth;
    }

    public final void setMWidth(int i2) {
        this.mWidth = i2;
    }

    public final int getMRectWidth() {
        return this.qSb;
    }

    public final void setMRectWidth(int i2) {
        this.qSb = i2;
    }

    public final int getMRectHeight() {
        return this.Caf;
    }

    public final void setMRectHeight(int i2) {
        this.Caf = i2;
    }

    public final Paint getMWavePaint() {
        return this.Cag;
    }

    public final void setMWavePaint(Paint paint) {
        this.Cag = paint;
    }

    public final ColorStateList getMWavePatinColorState() {
        return this.Cah;
    }

    public final void setMWavePatinColorState(ColorStateList colorStateList) {
        this.Cah = colorStateList;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final int getMRectCount() {
        return this.Cai;
    }

    public final void setMRectCount(int i2) {
        this.Cai = i2;
    }

    public final double getMRandom() {
        return this.Caj;
    }

    public final void setMRandom(double d2) {
        this.Caj = d2;
    }

    public final void setRunningShow(boolean z) {
        this.Cak = z;
    }

    public final void setPlayerLoading(boolean z) {
        this.Cal = z;
    }

    public final v getPlayer() {
        return this.hWJ;
    }

    public final void setPlayer(v vVar) {
        AppMethodBeat.i(75895);
        if (vVar != null) {
            this.hWJ = vVar;
            v vVar2 = this.hWJ;
            if (vVar2 != null) {
                vVar2.a(new a(this));
                AppMethodBeat.o(75895);
                return;
            }
        }
        AppMethodBeat.o(75895);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH\u0016J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\u0014H\u0016¨\u0006\u0015"}, hxF = {"com/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView$player$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onLoadingChanged", "", "p0", "", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "plugin-recordvideo_release"})
    public static final class a implements q.a {
        final /* synthetic */ AudioWaveView Cam;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(AudioWaveView audioWaveView) {
            this.Cam = audioWaveView;
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void b(p pVar) {
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void tz() {
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void a(e eVar) {
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void aR(boolean z) {
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void tA() {
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void aA(int i2) {
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void ty() {
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void c(boolean z, int i2) {
            AppMethodBeat.i(75894);
            if (i2 == 3) {
                this.Cam.setPlayerLoading(false);
            }
            AppMethodBeat.o(75894);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AudioWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(attributeSet, "attrs");
        AppMethodBeat.i(75901);
        initView();
        AppMethodBeat.o(75901);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AudioWaveView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(attributeSet, "attrs");
        AppMethodBeat.i(75902);
        initView();
        AppMethodBeat.o(75902);
    }

    private final void initView() {
        AppMethodBeat.i(75896);
        this.Cai = 20;
        this.Cag = new Paint();
        Paint paint = this.Cag;
        if (paint == null) {
            kotlin.g.b.p.hyc();
        }
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = this.Cag;
        if (paint2 == null) {
            kotlin.g.b.p.hyc();
        }
        paint2.setColor(-3355444);
        Paint paint3 = this.Cag;
        if (paint3 == null) {
            kotlin.g.b.p.hyc();
        }
        paint3.setAntiAlias(true);
        AppMethodBeat.o(75896);
    }

    public final void setColor(int i2) {
        AppMethodBeat.i(75897);
        Paint paint = this.Cag;
        if (paint == null) {
            kotlin.g.b.p.hyc();
        }
        paint.setColor(i2);
        AppMethodBeat.o(75897);
    }

    public final void setColor(ColorStateList colorStateList) {
        AppMethodBeat.i(237574);
        kotlin.g.b.p.h(colorStateList, "colorStateList");
        this.Cah = colorStateList;
        eLH();
        AppMethodBeat.o(237574);
    }

    public final void setSelected(boolean z) {
        AppMethodBeat.i(237575);
        super.setSelected(z);
        eLH();
        AppMethodBeat.o(237575);
    }

    private final void eLH() {
        int i2 = 0;
        AppMethodBeat.i(237576);
        Paint paint = this.Cag;
        if (paint == null) {
            kotlin.g.b.p.hyc();
        }
        ColorStateList colorStateList = this.Cah;
        if (colorStateList != null) {
            i2 = colorStateList.getColorForState(getDrawableState(), 0);
        }
        paint.setColor(i2);
        AppMethodBeat.o(237576);
    }

    public final void setShow(boolean z) {
        this.Cak = z;
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(75898);
        super.onSizeChanged(i2, i3, i4, i5);
        this.mWidth = getWidth();
        this.Caf = getHeight() / 2;
        this.qSb = this.mWidth / (this.Cai * 2);
        AppMethodBeat.o(75898);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(75899);
        kotlin.g.b.p.h(canvas, "canvas");
        super.onDraw(canvas);
        canvas.translate((float) (getWidth() / 2), (float) getHeight());
        int i2 = this.Cai;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.Cak) {
                this.Caj = Math.random();
                a(canvas, new RectF((float) (((double) (this.qSb * i3)) + ((double) this.offset)), 0.0f, (float) (this.qSb * (i3 + 1)), -((float) (((double) this.Caf) * this.Caj))));
            } else {
                a(canvas, new RectF((float) (((double) (this.qSb * i3)) + ((double) this.offset)), 0.0f, (float) (this.qSb * (i3 + 1)), -0.5f));
            }
        }
        postInvalidateDelayed(100);
        AppMethodBeat.o(75899);
    }

    private void a(Canvas canvas, RectF rectF) {
        AppMethodBeat.i(75900);
        kotlin.g.b.p.h(canvas, "canvas");
        kotlin.g.b.p.h(rectF, "rectF");
        Paint paint = this.Cag;
        if (paint == null) {
            kotlin.g.b.p.hyc();
        }
        canvas.drawRect(rectF, paint);
        AppMethodBeat.o(75900);
    }
}
