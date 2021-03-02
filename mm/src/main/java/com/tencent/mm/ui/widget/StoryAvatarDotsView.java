package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public final class StoryAvatarDotsView extends FrameLayout {
    private int ojY = a.fromDPToPix(getContext(), 25);
    private int ojZ = a.fromDPToPix(getContext(), 19);

    public StoryAvatarDotsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143459);
        AppMethodBeat.o(143459);
    }

    public StoryAvatarDotsView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(143460);
        AppMethodBeat.o(143460);
    }

    public final void setIconSize(int i2) {
        AppMethodBeat.i(143461);
        if (i2 > 0 && i2 != this.ojY) {
            this.ojY = i2;
            bZU();
        }
        AppMethodBeat.o(143461);
    }

    public final void setIconGap(int i2) {
        AppMethodBeat.i(143462);
        if (i2 >= 0 && this.ojZ != i2) {
            this.ojZ = i2;
            bZU();
        }
        AppMethodBeat.o(143462);
    }

    private void bZU() {
        AppMethodBeat.i(143463);
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
        AppMethodBeat.o(143463);
    }

    public final void setIconLayerCount(int i2) {
        AppMethodBeat.i(143464);
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
        AppMethodBeat.o(143464);
    }

    public final ImageView zK(int i2) {
        AppMethodBeat.i(143465);
        ImageView imageView = (ImageView) getChildAt((getChildCount() - 1) - i2);
        AppMethodBeat.o(143465);
        return imageView;
    }

    public final int getExpandDuration() {
        AppMethodBeat.i(143466);
        if (getChildCount() <= 1) {
            AppMethodBeat.o(143466);
            return 0;
        }
        int childCount = ((getChildCount() - 2) * 50) + 200;
        AppMethodBeat.o(143466);
        return childCount;
    }
}
