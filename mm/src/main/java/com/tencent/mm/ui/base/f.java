package com.tencent.mm.ui.base;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    private static boolean gKq() {
        return Build.VERSION.SDK_INT >= 5;
    }

    private static boolean ag(MotionEvent motionEvent) {
        AppMethodBeat.i(141641);
        if (!gKq()) {
            AppMethodBeat.o(141641);
            return false;
        } else if (motionEvent.getPointerCount() >= 2) {
            AppMethodBeat.o(141641);
            return true;
        } else {
            AppMethodBeat.o(141641);
            return false;
        }
    }

    public static float ah(MotionEvent motionEvent) {
        AppMethodBeat.i(141642);
        float j2 = j(motionEvent, 0) - j(motionEvent, 1);
        float k = k(motionEvent, 0) - k(motionEvent, 1);
        float sqrt = (float) Math.sqrt((double) ((j2 * j2) + (k * k)));
        AppMethodBeat.o(141642);
        return sqrt;
    }

    public static void a(PointF pointF, MotionEvent motionEvent) {
        AppMethodBeat.i(141643);
        if (pointF == null || motionEvent == null) {
            AppMethodBeat.o(141643);
            return;
        }
        pointF.set((j(motionEvent, 0) + j(motionEvent, 1)) / 2.0f, (k(motionEvent, 0) + k(motionEvent, 1)) / 2.0f);
        AppMethodBeat.o(141643);
    }

    public static void a(PointF pointF, Bitmap bitmap) {
        AppMethodBeat.i(141644);
        if (pointF == null || bitmap == null) {
            AppMethodBeat.o(141644);
            return;
        }
        pointF.set(((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        AppMethodBeat.o(141644);
    }

    public static float j(MotionEvent motionEvent, int i2) {
        AppMethodBeat.i(141645);
        if (ag(motionEvent)) {
            new e();
            float x = motionEvent.getX(i2);
            AppMethodBeat.o(141645);
            return x;
        }
        float x2 = motionEvent.getX();
        AppMethodBeat.o(141645);
        return x2;
    }

    public static float k(MotionEvent motionEvent, int i2) {
        AppMethodBeat.i(141646);
        if (ag(motionEvent)) {
            new e();
            float y = motionEvent.getY(i2);
            AppMethodBeat.o(141646);
            return y;
        }
        float y2 = motionEvent.getY();
        AppMethodBeat.o(141646);
        return y2;
    }

    public static int ai(MotionEvent motionEvent) {
        AppMethodBeat.i(141647);
        if (gKq()) {
            new e();
            int pointerCount = motionEvent.getPointerCount();
            AppMethodBeat.o(141647);
            return pointerCount;
        }
        AppMethodBeat.o(141647);
        return 1;
    }

    public static void f(KeyEvent keyEvent) {
        AppMethodBeat.i(141648);
        if (gKq()) {
            new e();
            keyEvent.startTracking();
        }
        AppMethodBeat.o(141648);
    }

    public static boolean g(KeyEvent keyEvent) {
        AppMethodBeat.i(141649);
        if (gKq()) {
            new e();
            boolean isTracking = keyEvent.isTracking();
            AppMethodBeat.o(141649);
            return isTracking;
        }
        AppMethodBeat.o(141649);
        return false;
    }

    public static boolean h(KeyEvent keyEvent) {
        AppMethodBeat.i(141650);
        if (gKq()) {
            new e();
            boolean isCanceled = keyEvent.isCanceled();
            AppMethodBeat.o(141650);
            return isCanceled;
        }
        AppMethodBeat.o(141650);
        return false;
    }
}
