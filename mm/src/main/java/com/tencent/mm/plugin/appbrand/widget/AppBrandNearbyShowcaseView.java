package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public final class AppBrandNearbyShowcaseView extends FrameLayout {
    private int ojY = a.fromDPToPix(getContext(), 25);
    private int ojZ = a.fromDPToPix(getContext(), 19);

    public AppBrandNearbyShowcaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(121094);
        AppMethodBeat.o(121094);
    }

    public AppBrandNearbyShowcaseView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(121095);
        AppMethodBeat.o(121095);
    }

    public final void setIconSize(int i2) {
        AppMethodBeat.i(121096);
        if (i2 > 0 && i2 != this.ojY) {
            this.ojY = i2;
            bZU();
        }
        AppMethodBeat.o(121096);
    }

    public final void setIconGap(int i2) {
        AppMethodBeat.i(121097);
        if (i2 >= 0 && this.ojZ != i2) {
            this.ojZ = i2;
            bZU();
        }
        AppMethodBeat.o(121097);
    }

    private void bZU() {
        AppMethodBeat.i(121098);
        if (getChildCount() > 0) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                int i2 = this.ojY;
                layoutParams2.height = i2;
                layoutParams.width = i2;
                ((FrameLayout.LayoutParams) childAt.getLayoutParams()).gravity |= 5;
                ((FrameLayout.LayoutParams) childAt.getLayoutParams()).rightMargin = this.ojZ * childCount;
            }
            requestLayout();
            invalidate();
        }
        AppMethodBeat.o(121098);
    }

    public final void setIconLayerCount(int i2) {
        AppMethodBeat.i(121099);
        if (i2 >= 0 && i2 != getChildCount()) {
            if (i2 > getChildCount()) {
                int childCount = i2 - getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View imageView = new ImageView(getContext());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.ojY, this.ojY);
                    layoutParams.gravity = 16;
                    addViewInLayout(imageView, 0, layoutParams, true);
                }
            } else if (i2 < getChildCount()) {
                removeViewsInLayout(0, getChildCount() - i2);
            }
            bZU();
        }
        AppMethodBeat.o(121099);
    }

    public final ImageView zK(int i2) {
        AppMethodBeat.i(121100);
        ImageView imageView = (ImageView) getChildAt((getChildCount() - 1) - i2);
        AppMethodBeat.o(121100);
        return imageView;
    }

    public final void bZV() {
        AppMethodBeat.i(184009);
        if (getChildCount() > 1) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                childAt.setTranslationX((float) ((FrameLayout.LayoutParams) childAt.getLayoutParams()).rightMargin);
            }
        }
        AppMethodBeat.o(184009);
    }

    public final void bZW() {
        AppMethodBeat.i(201285);
        if (getChildCount() > 1) {
            int i2 = 200;
            for (int i3 = 1; i3 < getChildCount(); i3++) {
                getChildAt(i3).animate().setDuration((long) i2).translationX(0.0f).start();
                i2 += 50;
            }
        }
        AppMethodBeat.o(201285);
    }

    public final int getExpandDuration() {
        AppMethodBeat.i(121103);
        if (getChildCount() <= 1) {
            AppMethodBeat.o(121103);
            return 0;
        }
        int childCount = ((getChildCount() - 2) * 50) + 200;
        AppMethodBeat.o(121103);
        return childCount;
    }
}
