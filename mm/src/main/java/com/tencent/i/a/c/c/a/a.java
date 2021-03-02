package com.tencent.i.a.c.c.a;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.h.c.h;
import com.tencent.i.a.a.c;
import com.tencent.i.a.b.c.b;
import com.tencent.i.a.c.b.i;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class a implements b.AbstractC0143b {
    private c SqM;
    com.tencent.i.a.b.c.a.b SsB;
    private Rect SsC = new Rect();
    private Set<Integer> SsD = new CopyOnWriteArraySet();
    protected b SsE;

    /* access modifiers changed from: protected */
    public abstract void a(MotionEvent motionEvent, b.a aVar);

    public a(c cVar, com.tencent.i.a.b.c.a.b bVar) {
        this.SqM = cVar;
        this.SsB = bVar;
    }

    @Override // com.tencent.i.a.b.c.b.AbstractC0143b
    public final void a(MotionEvent motionEvent, b.a aVar, b bVar) {
        boolean z = false;
        boolean z2 = true;
        this.SsE = bVar;
        if (motionEvent == null) {
            h.i("sensor_AbsTouch", "[method: isMonitorViewTouch ] motionEvent is null");
            z2 = false;
        } else if (this.SsB == null || this.SsB.hqh() == null) {
            h.i("sensor_AbsTouch", "[method: isMonitorViewTouch ] getMasterEngine or getBuilder is null");
        } else {
            View view = this.SsB.hqh().Squ;
            if (view == null) {
                h.i("sensor_AbsTouch", "[method: isMonitorViewTouch ] monitorView is null");
            } else {
                int actionIndex = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex);
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 2) {
                    if (this.SsD.isEmpty() || !this.SsD.contains(Integer.valueOf(pointerId))) {
                        z2 = false;
                    }
                    h.i("sensor_AbsTouch", "[method: isTouchValid ] MotionEvent.ACTION_MOVE : " + z2 + ", pointerId : " + pointerId);
                } else if (actionMasked == 0 || actionMasked == 5) {
                    if (this.SsC.right - this.SsC.left <= 0 || this.SsC.bottom - this.SsC.top <= 0) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        this.SsC.left = iArr[0];
                        this.SsC.top = iArr[1];
                        this.SsC.right = this.SsC.left + view.getWidth();
                        this.SsC.bottom = this.SsC.top + view.getHeight();
                        h.i("sensor_AbsTouch", "[method: isMonitorViewTouch ] init ");
                    }
                    h.i("sensor_AbsTouch", "[method: isViewTouch ] x = " + ((int) motionEvent.getRawX()) + ", y = " + ((int) motionEvent.getRawY()));
                    MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
                    motionEvent.getPointerCoords(actionIndex, pointerCoords);
                    h.i("sensor_AbsTouch", "[method: isViewTouch ] pointer : [" + pointerCoords.x + ", " + pointerCoords.y + "]");
                    z2 = this.SsC.contains((int) pointerCoords.x, (int) pointerCoords.y);
                    h.i("sensor_AbsTouch", "[method: isMonitorViewTouch ] " + this.SsC + ", ret : " + z2);
                    if (z2) {
                        this.SsD.add(Integer.valueOf(pointerId));
                    }
                    h.i("sensor_AbsTouch", "[method: isTouchValid ] MotionEvent.ACTION_DOWN : " + z2 + ", pointerId : " + pointerId);
                } else {
                    if (!this.SsD.isEmpty() && this.SsD.contains(Integer.valueOf(pointerId))) {
                        this.SsD.remove(Integer.valueOf(pointerId));
                        z = true;
                    }
                    h.i("sensor_AbsTouch", "[method: isTouchValid ] MotionEvent.ACTION_UP : " + z + ", pointerId : " + pointerId);
                    z2 = z;
                }
            }
        }
        if (z2) {
            try {
                a(motionEvent, aVar);
            } catch (Throwable th) {
                this.SqM.SqP.b(th, "handleTouch");
            }
        }
    }

    protected static i a(int i2, long j2, float f2, float f3) {
        i iVar = new i();
        iVar.Ssv = i2;
        iVar.Ssw = j2;
        h.i("sensor_AbsTouch", "[method: buildTouchInfo ] touchTimestamp : " + iVar.Ssw);
        iVar.Ssx = f2;
        iVar.Ssy = f3;
        return iVar;
    }
}
