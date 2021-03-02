package android.support.v4.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class c {
    private final a Pq;

    interface a {
        boolean onTouchEvent(MotionEvent motionEvent);
    }

    static class b implements a {
        private static final int Pv = ViewConfiguration.getLongPressTimeout();
        private static final int Pw = ViewConfiguration.getTapTimeout();
        private static final int Px = ViewConfiguration.getDoubleTapTimeout();
        boolean PA;
        boolean PB;
        boolean PC;
        private boolean PD;
        private boolean PE;
        MotionEvent PF;
        private MotionEvent PG;
        private boolean PH;
        private float PI;
        private float PJ;
        private float PK;
        private float PL;
        private boolean PM;
        private int Pr;
        private int Ps;
        private int Pt;
        private int Pu;
        final GestureDetector.OnGestureListener Py;
        GestureDetector.OnDoubleTapListener Pz;
        final Handler mHandler = new a();
        private VelocityTracker mVelocityTracker;

        class a extends Handler {
            a() {
            }

            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.Py.onShowPress(b.this.PF);
                        return;
                    case 2:
                        b bVar = b.this;
                        bVar.mHandler.removeMessages(3);
                        bVar.PB = false;
                        bVar.PC = true;
                        bVar.Py.onLongPress(bVar.PF);
                        return;
                    case 3:
                        if (b.this.Pz == null) {
                            return;
                        }
                        if (!b.this.PA) {
                            b.this.Pz.onSingleTapConfirmed(b.this.PF);
                            return;
                        } else {
                            b.this.PB = true;
                            return;
                        }
                    default:
                        throw new RuntimeException("Unknown message ".concat(String.valueOf(message)));
                }
            }
        }

        b(Context context, GestureDetector.OnGestureListener onGestureListener) {
            this.Py = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                this.Pz = (GestureDetector.OnDoubleTapListener) onGestureListener;
            }
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.Py == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            } else {
                this.PM = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.Pt = viewConfiguration.getScaledMinimumFlingVelocity();
                this.Pu = viewConfiguration.getScaledMaximumFlingVelocity();
                this.Pr = scaledTouchSlop * scaledTouchSlop;
                this.Ps = scaledDoubleTapSlop * scaledDoubleTapSlop;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:48:0x0114  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0133  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x014c  */
        @Override // android.support.v4.view.c.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouchEvent(android.view.MotionEvent r14) {
            /*
            // Method dump skipped, instructions count: 724
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.c.b.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    /* renamed from: android.support.v4.view.c$c  reason: collision with other inner class name */
    static class C0038c implements a {
        private final GestureDetector PO;

        C0038c(Context context, GestureDetector.OnGestureListener onGestureListener) {
            this.PO = new GestureDetector(context, onGestureListener, null);
        }

        @Override // android.support.v4.view.c.a
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            GestureDetector gestureDetector = this.PO;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "android/support/v4/view/GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            return com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "android/support/v4/view/GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        }
    }

    public c(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, (byte) 0);
    }

    private c(Context context, GestureDetector.OnGestureListener onGestureListener, byte b2) {
        if (Build.VERSION.SDK_INT > 17) {
            this.Pq = new C0038c(context, onGestureListener);
        } else {
            this.Pq = new b(context, onGestureListener);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.Pq.onTouchEvent(motionEvent);
    }
}
