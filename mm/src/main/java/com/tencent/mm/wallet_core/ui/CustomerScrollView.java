package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomerScrollView extends ScrollView {
    private float RuY;
    private float RuZ;
    private float Rva;
    private float Rvb;

    public CustomerScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public CustomerScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(72898);
        switch (motionEvent.getAction()) {
            case 0:
                this.RuZ = 0.0f;
                this.RuY = 0.0f;
                this.Rva = motionEvent.getX();
                this.Rvb = motionEvent.getY();
                break;
            case 2:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.RuY += Math.abs(x - this.Rva);
                this.RuZ += Math.abs(y - this.Rvb);
                this.Rva = x;
                this.Rvb = y;
                if (this.RuY > this.RuZ) {
                    AppMethodBeat.o(72898);
                    return false;
                }
                break;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(72898);
        return onInterceptTouchEvent;
    }
}
