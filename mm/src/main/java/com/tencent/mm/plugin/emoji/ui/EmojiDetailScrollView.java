package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class EmojiDetailScrollView extends ScrollView {
    private boolean rgt;

    public EmojiDetailScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmojiDetailScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(108929);
        this.rgt = true;
        setFadingEdgeLength(0);
        AppMethodBeat.o(108929);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
    }

    public void requestLayout() {
        AppMethodBeat.i(108930);
        this.rgt = false;
        super.requestLayout();
        AppMethodBeat.o(108930);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(108931);
        this.rgt = false;
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(108931);
    }

    public void scrollTo(int i2, int i3) {
        this.rgt = true;
    }

    public void scrollBy(int i2, int i3) {
    }

    public void requestChildFocus(View view, View view2) {
    }

    public void setScrollEnable(boolean z) {
        this.rgt = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(108932);
        if (!this.rgt) {
            AppMethodBeat.o(108932);
            return false;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(108932);
        return onInterceptTouchEvent;
    }
}
