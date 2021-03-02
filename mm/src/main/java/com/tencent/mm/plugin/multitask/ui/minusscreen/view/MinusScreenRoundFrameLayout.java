package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\u000e\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u001cJ\u000e\u0010'\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\tR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttomOffset", "getButtomOffset", "()I", "gradientButtomDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getGradientButtomDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "setGradientButtomDrawable", "(Landroid/graphics/drawable/GradientDrawable;)V", "gradientTopDrawable", "getGradientTopDrawable", "setGradientTopDrawable", "topOffset", "getTopOffset", "setTopOffset", "(I)V", "useButtomGradient", "", "getUseButtomGradient", "()Z", "setUseButtomGradient", "(Z)V", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "setUseBottomGradient", "bottomGradient", "updateGradientTopOffset", "ui-multitask_release"})
public final class MinusScreenRoundFrameLayout extends FrameLayout {
    private GradientDrawable AeA = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb(166, 0, 0, 0), Color.argb(51, 0, 0, 0), Color.argb(0, 0, 0, 0), Color.argb(0, 0, 0, 0)});
    private GradientDrawable AeB;
    private final int AeC = at.fromDPToPix(MMApplicationContext.getContext(), 40);
    private boolean AeD;
    private int topOffset;

    public final GradientDrawable getGradientTopDrawable() {
        return this.AeA;
    }

    public final void setGradientTopDrawable(GradientDrawable gradientDrawable) {
        this.AeA = gradientDrawable;
    }

    public final GradientDrawable getGradientButtomDrawable() {
        return this.AeB;
    }

    public final void setGradientButtomDrawable(GradientDrawable gradientDrawable) {
        this.AeB = gradientDrawable;
    }

    public final int getButtomOffset() {
        return this.AeC;
    }

    public final boolean getUseButtomGradient() {
        return this.AeD;
    }

    public final void setUseButtomGradient(boolean z) {
        this.AeD = z;
    }

    public final int getTopOffset() {
        return this.topOffset;
    }

    public final void setTopOffset(int i2) {
        this.topOffset = i2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MinusScreenRoundFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(236530);
        GradientDrawable gradientDrawable = this.AeA;
        if (gradientDrawable != null) {
            gradientDrawable.setGradientType(0);
        }
        GradientDrawable gradientDrawable2 = this.AeA;
        if (gradientDrawable2 != null) {
            gradientDrawable2.setGradientCenter(0.5f, 0.4f);
        }
        this.AeB = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.argb(128, 0, 0, 0), Color.argb(0, 0, 0, 0), Color.argb(0, 0, 0, 0)});
        GradientDrawable gradientDrawable3 = this.AeB;
        if (gradientDrawable3 != null) {
            gradientDrawable3.setGradientType(0);
            AppMethodBeat.o(236530);
            return;
        }
        AppMethodBeat.o(236530);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MinusScreenRoundFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(236531);
        GradientDrawable gradientDrawable = this.AeA;
        if (gradientDrawable != null) {
            gradientDrawable.setGradientType(0);
        }
        GradientDrawable gradientDrawable2 = this.AeA;
        if (gradientDrawable2 != null) {
            gradientDrawable2.setGradientCenter(0.5f, 0.4f);
        }
        this.AeB = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.argb(128, 0, 0, 0), Color.argb(0, 0, 0, 0), Color.argb(0, 0, 0, 0)});
        GradientDrawable gradientDrawable3 = this.AeB;
        if (gradientDrawable3 != null) {
            gradientDrawable3.setGradientType(0);
            AppMethodBeat.o(236531);
            return;
        }
        AppMethodBeat.o(236531);
    }

    public final void setUseBottomGradient(boolean z) {
        this.AeD = z;
    }

    public final void RS(int i2) {
        AppMethodBeat.i(236528);
        this.topOffset = i2;
        invalidate();
        AppMethodBeat.o(236528);
    }

    /* access modifiers changed from: protected */
    public final void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(236529);
        super.dispatchDraw(canvas);
        if (canvas != null) {
            GradientDrawable gradientDrawable = this.AeA;
            if (gradientDrawable != null) {
                gradientDrawable.setBounds(0, this.topOffset, getWidth(), getHeight());
            }
            GradientDrawable gradientDrawable2 = this.AeA;
            if (gradientDrawable2 != null) {
                gradientDrawable2.draw(canvas);
            }
            if (this.AeD) {
                GradientDrawable gradientDrawable3 = this.AeB;
                if (gradientDrawable3 != null) {
                    gradientDrawable3.setBounds(0, getHeight() - this.AeC, getWidth(), getHeight());
                }
                GradientDrawable gradientDrawable4 = this.AeB;
                if (gradientDrawable4 != null) {
                    gradientDrawable4.draw(canvas);
                    AppMethodBeat.o(236529);
                    return;
                }
            }
        }
        AppMethodBeat.o(236529);
    }
}
