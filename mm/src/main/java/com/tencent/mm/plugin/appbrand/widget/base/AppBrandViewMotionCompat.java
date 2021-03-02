package com.tencent.mm.plugin.appbrand.widget.base;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.os.Looper;
import android.support.annotation.Keep;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;

public final class AppBrandViewMotionCompat {
    private static int[] omA;
    private static MotionEvent.PointerCoords[] omy;
    private static MotionEvent.PointerProperties[] omz;

    public static boolean cM(View view) {
        AppMethodBeat.i(140870);
        if (view == null || !(view instanceof c) || !((c) view).caj()) {
            AppMethodBeat.o(140870);
            return false;
        }
        AppMethodBeat.o(140870);
        return true;
    }

    public static boolean cN(View view) {
        AppMethodBeat.i(140871);
        if (view.getVisibility() == 0 || view.getAnimation() != null) {
            AppMethodBeat.o(140871);
            return true;
        }
        AppMethodBeat.o(140871);
        return false;
    }

    @TargetApi(11)
    public static boolean a(ViewGroup viewGroup, float f2, float f3, View view) {
        AppMethodBeat.i(140872);
        float[] fArr = {0.0f, 0.0f};
        fArr[0] = ((float) (viewGroup.getScrollX() - view.getLeft())) + f2;
        fArr[1] = ((float) (viewGroup.getScrollY() - view.getTop())) + f3;
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            matrix.invert(matrix);
            matrix.mapPoints(fArr);
        }
        if (fArr[0] < 0.0f || fArr[1] < 0.0f || fArr[0] >= ((float) (view.getRight() - view.getLeft())) || fArr[1] >= ((float) (view.getBottom() - view.getTop()))) {
            AppMethodBeat.o(140872);
            return false;
        }
        AppMethodBeat.o(140872);
        return true;
    }

    @TargetApi(11)
    public static boolean cO(View view) {
        AppMethodBeat.i(174627);
        boolean isIdentity = view.getMatrix().isIdentity();
        AppMethodBeat.o(174627);
        return isIdentity;
    }

    public static Matrix cP(View view) {
        AppMethodBeat.i(174628);
        if (view == null) {
            AppMethodBeat.o(174628);
            return null;
        }
        Matrix matrix = (Matrix) view.getTag(R.id.th);
        if (matrix == null) {
            matrix = new Matrix();
            view.setTag(R.id.th, matrix);
        }
        view.getMatrix().invert(matrix);
        AppMethodBeat.o(174628);
        return matrix;
    }

    @TargetApi(5)
    public static int J(MotionEvent motionEvent) {
        AppMethodBeat.i(174629);
        int pointerCount = motionEvent.getPointerCount();
        int i2 = 0;
        int i3 = 0;
        while (i2 < pointerCount) {
            i2++;
            i3 = (1 << motionEvent.getPointerId(i2)) | i3;
        }
        AppMethodBeat.o(174629);
        return i3;
    }

    private static void zQ(int i2) {
        AppMethodBeat.i(174630);
        if (omy == null || omy.length < i2) {
            int length = omy != null ? omy.length : 8;
            while (length < i2) {
                length *= 2;
            }
            MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[length];
            for (int i3 = 0; i3 < length; i3++) {
                pointerCoordsArr[i3] = new MotionEvent.PointerCoords();
            }
            omy = pointerCoordsArr;
            omz = zR(length);
            omA = new int[length];
        }
        AppMethodBeat.o(174630);
    }

    private static MotionEvent.PointerProperties[] zR(int i2) {
        AppMethodBeat.i(174631);
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            pointerPropertiesArr[i3] = new MotionEvent.PointerProperties();
        }
        AppMethodBeat.o(174631);
        return pointerPropertiesArr;
    }

    @TargetApi(14)
    public static MotionEvent g(MotionEvent motionEvent, int i2) {
        AppMethodBeat.i(174632);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            RuntimeException runtimeException = new RuntimeException("Should be called on main-thread");
            AppMethodBeat.o(174632);
            throw runtimeException;
        }
        int pointerCount = motionEvent.getPointerCount();
        zQ(pointerCount);
        MotionEvent.PointerProperties[] pointerPropertiesArr = omz;
        MotionEvent.PointerCoords[] pointerCoordsArr = omy;
        int[] iArr = omA;
        int action = motionEvent.getAction();
        int i3 = action & 255;
        int i4 = (65280 & action) >> 8;
        int i5 = -1;
        int i6 = 0;
        for (int i7 = 0; i7 < pointerCount; i7++) {
            motionEvent.getPointerProperties(i7, pointerPropertiesArr[i6]);
            if (((1 << pointerPropertiesArr[i6].id) & i2) != 0) {
                if (i7 == i4) {
                    i5 = i6;
                }
                iArr[i6] = i7;
                i6++;
            }
        }
        if (i6 == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("idBits did not match any ids in the event");
            AppMethodBeat.o(174632);
            throw illegalArgumentException;
        }
        if (i3 == 5 || i3 == 6) {
            if (i5 < 0) {
                action = 2;
            } else if (i6 == 1) {
                action = i3 == 5 ? 0 : 1;
            } else {
                action = i3 | (i5 << 8);
            }
        }
        MotionEvent motionEvent2 = null;
        int historySize = motionEvent.getHistorySize();
        int i8 = 0;
        while (i8 <= historySize) {
            int i9 = i8 == historySize ? Integer.MIN_VALUE : i8;
            for (int i10 = 0; i10 < i6; i10++) {
                motionEvent.getHistoricalPointerCoords(iArr[i10], i9, pointerCoordsArr[i10]);
            }
            long historicalEventTime = motionEvent.getHistoricalEventTime(i9);
            if (i8 == 0) {
                motionEvent2 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), action, i6, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                motionEvent2.offsetLocation(motionEvent2.getX() - motionEvent2.getRawX(), motionEvent2.getY() - motionEvent2.getRawY());
            } else {
                motionEvent2.addBatch(historicalEventTime, pointerCoordsArr, 0);
            }
            i8++;
        }
        AppMethodBeat.o(174632);
        return motionEvent2;
    }

    @Keep
    @TargetApi(11)
    public static boolean dispatchTransformedTouchEvent(ViewGroup viewGroup, MotionEvent motionEvent, boolean z, View view, int i2) {
        MotionEvent g2;
        AppMethodBeat.i(140873);
        if (viewGroup == null || motionEvent == null) {
            AppMethodBeat.o(140873);
            return false;
        }
        int action = motionEvent.getAction();
        if (z || action == 3) {
            motionEvent.setAction(3);
            if (view == null) {
                AppMethodBeat.o(140873);
                return false;
            }
            boolean dispatchTouchEvent = view.dispatchTouchEvent(motionEvent);
            motionEvent.setAction(action);
            AppMethodBeat.o(140873);
            return dispatchTouchEvent;
        }
        int J = J(motionEvent);
        int i3 = J & i2;
        if (i3 == 0) {
            AppMethodBeat.o(140873);
            return false;
        }
        if (i3 != J) {
            try {
                g2 = g(motionEvent, i3);
            } catch (IllegalArgumentException e2) {
                Log.w("MicroMsg.AppBrandViewMotionCompat", "dispatchTransformedTouchEvent e=%s", e2.getMessage());
                AppMethodBeat.o(140873);
                return false;
            }
        } else if (view != null && !view.getMatrix().isIdentity()) {
            g2 = MotionEvent.obtain(motionEvent);
        } else if (view == null) {
            AppMethodBeat.o(140873);
            return false;
        } else {
            float scrollX = (float) (viewGroup.getScrollX() - view.getLeft());
            float scrollY = (float) (viewGroup.getScrollY() - view.getTop());
            motionEvent.offsetLocation(scrollX, scrollY);
            boolean dispatchTouchEvent2 = view.dispatchTouchEvent(motionEvent);
            motionEvent.offsetLocation(-scrollX, -scrollY);
            AppMethodBeat.o(140873);
            return dispatchTouchEvent2;
        }
        if (view == null) {
            AppMethodBeat.o(140873);
            return false;
        }
        g2.offsetLocation((float) (viewGroup.getScrollX() - view.getLeft()), (float) (viewGroup.getScrollY() - view.getTop()));
        if (!view.getMatrix().isIdentity()) {
            Matrix matrix = view.getMatrix();
            matrix.invert(matrix);
            g2.transform(matrix);
        }
        boolean dispatchTouchEvent3 = view.dispatchTouchEvent(g2);
        g2.recycle();
        AppMethodBeat.o(140873);
        return dispatchTouchEvent3;
    }
}
