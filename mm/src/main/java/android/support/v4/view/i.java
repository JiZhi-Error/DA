package android.support.v4.view;

import android.view.MotionEvent;

public final class i {
    @Deprecated
    public static int e(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    @Deprecated
    public static int f(MotionEvent motionEvent) {
        return motionEvent.getActionIndex();
    }

    @Deprecated
    public static int b(MotionEvent motionEvent, int i2) {
        return motionEvent.findPointerIndex(i2);
    }

    @Deprecated
    public static int c(MotionEvent motionEvent, int i2) {
        return motionEvent.getPointerId(i2);
    }

    @Deprecated
    public static float d(MotionEvent motionEvent, int i2) {
        return motionEvent.getX(i2);
    }

    @Deprecated
    public static float e(MotionEvent motionEvent, int i2) {
        return motionEvent.getY(i2);
    }

    @Deprecated
    public static int g(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    public static boolean h(MotionEvent motionEvent) {
        return (motionEvent.getSource() & 8194) == 8194;
    }
}
