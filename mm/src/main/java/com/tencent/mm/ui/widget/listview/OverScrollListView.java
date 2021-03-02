package com.tencent.mm.ui.widget.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.as;

public class OverScrollListView extends ListView {
    private int QRz;
    private float y1;
    private float y2;

    public OverScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OverScrollListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(198352);
        switch (motionEvent.getAction()) {
            case 0:
                this.y1 = motionEvent.getY(0);
                break;
            case 2:
                this.y2 = motionEvent.getY(0);
                this.QRz = (int) Math.abs(this.y2 - this.y1);
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(198352);
        return onTouchEvent;
    }

    /* access modifiers changed from: protected */
    public boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        AppMethodBeat.i(198353);
        as.d("OverScrollListView", "dancy test maxOverScrollYDis: %s", Integer.valueOf(this.QRz));
        boolean overScrollBy = super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, this.QRz / 2, z);
        AppMethodBeat.o(198353);
        return overScrollBy;
    }
}
