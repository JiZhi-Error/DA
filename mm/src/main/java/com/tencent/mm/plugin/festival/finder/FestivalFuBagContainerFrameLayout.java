package com.tencent.mm.plugin.festival.finder;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J0\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0014J\u0012\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010 \u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFuBagContainerFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "GLOW_BLUR_RADIUS", "", "fuBagView", "Landroid/view/View;", "fuBagViewRect", "Landroid/graphics/RectF;", "glowPaint", "Landroid/graphics/Paint;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "left", "top", "right", "bottom", "onViewAdded", "child", "onViewRemoved", "plugin-festival_release"})
public final class FestivalFuBagContainerFrameLayout extends FrameLayout {
    private final float Uwm = 40.0f;
    private View Uwn;
    private final RectF Uwo = new RectF();
    private final Paint Uwp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FestivalFuBagContainerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(262799);
        Paint paint = new Paint(1);
        paint.setMaskFilter(new BlurMaskFilter(this.Uwm, BlurMaskFilter.Blur.NORMAL));
        paint.setColor(Color.argb(77, 255, 250, 210));
        paint.setStyle(Paint.Style.FILL);
        this.Uwp = paint;
        setWillNotDraw(false);
        setLayerType(1, null);
        AppMethodBeat.o(262799);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FestivalFuBagContainerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(262800);
        Paint paint = new Paint(1);
        paint.setMaskFilter(new BlurMaskFilter(this.Uwm, BlurMaskFilter.Blur.NORMAL));
        paint.setColor(Color.argb(77, 255, 250, 210));
        paint.setStyle(Paint.Style.FILL);
        this.Uwp = paint;
        setWillNotDraw(false);
        setLayerType(1, null);
        AppMethodBeat.o(262800);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(262795);
        p.h(canvas, "canvas");
        if (!this.Uwo.isEmpty()) {
            canvas.drawOval(this.Uwo, this.Uwp);
        }
        AppMethodBeat.o(262795);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(262796);
        super.onLayout(z, i2, i3, i4, i5);
        View view = this.Uwn;
        if (view != null) {
            this.Uwo.set((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
            AppMethodBeat.o(262796);
            return;
        }
        AppMethodBeat.o(262796);
    }

    public final void onViewRemoved(View view) {
        AppMethodBeat.i(262797);
        super.onViewRemoved(view);
        if (p.j(view, this.Uwn)) {
            this.Uwn = null;
            this.Uwo.setEmpty();
        }
        AppMethodBeat.o(262797);
    }

    public final void onViewAdded(View view) {
        AppMethodBeat.i(262798);
        super.onViewAdded(view);
        if (view != null) {
            if (R.id.juy == view.getId()) {
                this.Uwn = view;
            }
            AppMethodBeat.o(262798);
            return;
        }
        AppMethodBeat.o(262798);
    }
}
