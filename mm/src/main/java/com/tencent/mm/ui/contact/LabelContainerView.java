package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMTagPanelScrollView;

public class LabelContainerView extends MMTagPanelScrollView {
    boolean PD = true;
    float PI;
    float PJ;
    float PK;
    float PL;
    boolean PVX = false;
    boolean PVY = true;
    boolean PVZ = false;
    float PWa;
    float PWb;
    float PWc;
    float PWd;
    private a PWe;
    private int Pr;

    public interface a {
        void cIi();

        void cIj();
    }

    public LabelContainerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(102844);
        cMT();
        AppMethodBeat.o(102844);
    }

    public LabelContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(102845);
        cMT();
        AppMethodBeat.o(102845);
    }

    public void setOnLabelContainerListener(a aVar) {
        this.PWe = aVar;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(102846);
        int action = motionEvent.getAction();
        boolean z = (action & 255) == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (actionIndex != i2) {
                f3 += motionEvent.getX(i2);
                f2 += motionEvent.getY(i2);
            }
        }
        int i3 = z ? pointerCount - 1 : pointerCount;
        float f4 = f3 / ((float) i3);
        float f5 = f2 / ((float) i3);
        switch (action) {
            case 0:
                this.PVY = true;
                this.PWb = f4;
                this.PWa = f4;
                this.PWd = f5;
                this.PWc = f5;
                this.PVZ = true;
                break;
            case 1:
            case 3:
                this.PVY = true;
                this.PVZ = false;
                break;
            case 2:
                int i4 = (int) (f4 - this.PWa);
                int i5 = (int) (f5 - this.PWc);
                if ((i5 * i5) + (i4 * i4) > this.Pr) {
                    this.PVY = false;
                    AppMethodBeat.o(102846);
                    return true;
                }
                break;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(102846);
        return onInterceptTouchEvent;
    }

    private void cMT() {
        AppMethodBeat.i(102847);
        int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.Pr = scaledTouchSlop * scaledTouchSlop;
        AppMethodBeat.o(102847);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(102848);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(102848);
        return dispatchTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(102849);
        int action = motionEvent.getAction();
        boolean z = (action & 255) == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (actionIndex != i2) {
                f3 += motionEvent.getX(i2);
                f2 += motionEvent.getY(i2);
            }
        }
        int i3 = z ? pointerCount - 1 : pointerCount;
        float f4 = f3 / ((float) i3);
        float f5 = f2 / ((float) i3);
        switch (action) {
            case 0:
                this.PD = true;
                this.PI = f4;
                this.PK = f4;
                this.PJ = f5;
                this.PL = f5;
                this.PVX = true;
                break;
            case 1:
            case 3:
                if ((this.PD || !this.PVX) && this.PWe != null) {
                    this.PWe.cIi();
                }
                this.PD = true;
                this.PVX = false;
                break;
            case 2:
                if (!this.PVX) {
                    this.PD = true;
                    this.PI = f4;
                    this.PK = f4;
                    this.PJ = f5;
                    this.PL = f5;
                    this.PVX = true;
                }
                if (this.PWe != null) {
                    this.PWe.cIj();
                }
                int i4 = (int) (f4 - this.PK);
                int i5 = (int) (f5 - this.PL);
                if ((i5 * i5) + (i4 * i4) > this.Pr) {
                    this.PD = false;
                    break;
                }
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(102849);
        return onTouchEvent;
    }

    public final void cIi() {
        AppMethodBeat.i(102850);
        this.PWe.cIi();
        AppMethodBeat.o(102850);
    }
}
