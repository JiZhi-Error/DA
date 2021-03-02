package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.support.v4.view.c;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class FoldableChatTextItemView extends LinearLayout {
    private a PGk;
    private c aAy;
    private int maxHeight;

    public interface a {
    }

    public FoldableChatTextItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FoldableChatTextItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(36699);
        setTagObject(motionEvent);
        if (this.aAy != null) {
            this.aAy.onTouchEvent(motionEvent);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(36699);
        return onTouchEvent;
    }

    private void setTagObject(MotionEvent motionEvent) {
        AppMethodBeat.i(36700);
        setTag(R.id.iu_, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
        AppMethodBeat.o(36700);
    }

    public void setMaxHeight(int i2) {
        this.maxHeight = i2;
    }

    public void setOnGestureListener(GestureDetector.OnGestureListener onGestureListener) {
        AppMethodBeat.i(36701);
        this.aAy = new c(getContext(), onGestureListener);
        AppMethodBeat.o(36701);
    }

    public void setFoldTextListener(a aVar) {
        this.PGk = aVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(36702);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(36702);
    }
}
