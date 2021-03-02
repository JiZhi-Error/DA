package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class ChatFooterBottom extends FrameLayout {
    private boolean eea = false;

    public ChatFooterBottom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChatFooterBottom(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(31719);
        super.draw(canvas);
        AppMethodBeat.o(31719);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(31720);
        Log.d("MicroMsg.ChatFooterBottom", "jacks onMeasure  width:%d, height:%d, isHide: %B", Integer.valueOf(View.MeasureSpec.getSize(i2)), Integer.valueOf(View.MeasureSpec.getSize(i3)), Boolean.valueOf(this.eea));
        if (this.eea) {
            setVisibility(8);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i3 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(31720);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(31721);
        Log.d("MicroMsg.ChatFooterBottom", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(31721);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(31722);
        super.onDraw(canvas);
        AppMethodBeat.o(31722);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(31723);
        Log.d("MicroMsg.ChatFooterBottom", "jacks onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        super.onSizeChanged(i2, i3, i4, i5);
        AppMethodBeat.o(31723);
    }

    public void setIsHide(boolean z) {
        this.eea = z;
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(31724);
        if (i2 == 0) {
            this.eea = false;
        }
        super.setVisibility(i2);
        AppMethodBeat.o(31724);
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(31725);
        super.setLayoutParams(layoutParams);
        AppMethodBeat.o(31725);
    }

    public ViewGroup.LayoutParams getLayoutParams() {
        AppMethodBeat.i(31726);
        ViewGroup.LayoutParams layoutParams = super.getLayoutParams();
        AppMethodBeat.o(31726);
        return layoutParams;
    }

    public final boolean grr() {
        AppMethodBeat.i(31727);
        if (this.eea || getVisibility() != 0) {
            AppMethodBeat.o(31727);
            return true;
        }
        AppMethodBeat.o(31727);
        return false;
    }
}
