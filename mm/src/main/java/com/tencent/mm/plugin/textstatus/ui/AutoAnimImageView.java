package com.tencent.mm.plugin.textstatus.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J*\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J*\u0010\u001c\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J*\u0010\u001d\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\b\u0010 \u001a\u00020\u0012H\u0014J\b\u0010!\u001a\u00020\u0012H\u0014J\u000e\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0010R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/AutoAnimImageView;", "Landroid/support/v7/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "setAnimator", "(Landroid/animation/ValueAnimator;)V", "durationMsPerDp", "", "autoAnim", "", "dpFromPx", "", "px", "getHorizontalAnimator", "img", "Landroid/widget/ImageView;", "scale", "dwidth", "vwidth", "getScaleAnimator", "getVerticalAnimator", "dheight", "vheight", "onAttachedToWindow", "onDetachedFromWindow", "setDurationMsPerDp", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "AnimType", "plugin-textstatus_release"})
public final class AutoAnimImageView extends AppCompatImageView {
    private int Gcr = 50;
    private final String TAG = "MicroMsg.TxtStatus.AutoAnimImageView";
    private ValueAnimator animator;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoAnimImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(216346);
        AppMethodBeat.o(216346);
    }

    public final ValueAnimator getAnimator() {
        return this.animator;
    }

    public final void setAnimator(ValueAnimator valueAnimator) {
        this.animator = valueAnimator;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(216344);
        super.onAttachedToWindow();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.resume();
            AppMethodBeat.o(216344);
            return;
        }
        AppMethodBeat.o(216344);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(216345);
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.pause();
            AppMethodBeat.o(216345);
            return;
        }
        AppMethodBeat.o(216345);
    }

    public final void setDurationMsPerDp(int i2) {
        this.Gcr = i2;
    }
}
