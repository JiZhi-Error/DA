package com.tencent.mm.danmaku.render;

import android.graphics.Canvas;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.e.e;
import com.tencent.mm.danmaku.f.a;
import com.tencent.mm.danmaku.f.c;
import com.tencent.mm.danmaku.render.d;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

public final class f implements SurfaceHolder.Callback, d {
    private d.a gQa;
    private SurfaceHolder gQc;
    private volatile ReentrantLock gQd;
    private volatile Object gQe;
    private volatile boolean gQf;
    private volatile Object gQg;
    private volatile boolean gQh = false;
    private SurfaceView mSurfaceView;

    private void atf() {
        AppMethodBeat.i(241710);
        this.gQe = c.b(SurfaceView.class, "mDrawingStopped", this.mSurfaceView);
        this.gQg = c.b(SurfaceView.class, "mWindow", this.mSurfaceView);
        if (this.gQe instanceof Boolean) {
            this.gQf = ((Boolean) this.gQe).booleanValue();
        }
        AppMethodBeat.o(241710);
    }

    public f(SurfaceView surfaceView) {
        AppMethodBeat.i(241711);
        this.mSurfaceView = surfaceView;
        this.mSurfaceView.setWillNotCacheDrawing(true);
        this.mSurfaceView.setDrawingCacheEnabled(false);
        this.mSurfaceView.setWillNotDraw(true);
        this.mSurfaceView.setZOrderMediaOverlay(true);
        this.gQc = this.mSurfaceView.getHolder();
        this.gQc.addCallback(this);
        this.gQc.setFormat(-2);
        AppMethodBeat.o(241711);
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final Canvas lockCanvas() {
        AppMethodBeat.i(241712);
        if (this.gQh) {
            Canvas lockHardwareCanvas = lockHardwareCanvas();
            AppMethodBeat.o(241712);
            return lockHardwareCanvas;
        }
        Canvas lockCanvas = this.gQc.lockCanvas();
        AppMethodBeat.o(241712);
        return lockCanvas;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Canvas lockHardwareCanvas() {
        /*
            r5 = this;
            r1 = 0
            r4 = 241713(0x3b031, float:3.38712E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            boolean r0 = com.tencent.mm.danmaku.f.a.atq()
            if (r0 == 0) goto L_0x0017
            android.view.SurfaceHolder r0 = r5.gQc
            android.graphics.Canvas r1 = r0.lockHardwareCanvas()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0016:
            return r1
        L_0x0017:
            java.util.concurrent.locks.ReentrantLock r0 = r5.gQd
            r0.lock()
            r5.atf()
            boolean r0 = r5.gQf
            if (r0 != 0) goto L_0x0048
            java.lang.Object r0 = r5.gQg
            if (r0 == 0) goto L_0x0048
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x003e }
            r2 = 23
            if (r0 < r2) goto L_0x0048
            android.view.SurfaceHolder r0 = r5.gQc     // Catch:{ Exception -> 0x003e }
            android.view.Surface r0 = r0.getSurface()     // Catch:{ Exception -> 0x003e }
            android.graphics.Canvas r0 = r0.lockHardwareCanvas()     // Catch:{ Exception -> 0x003e }
        L_0x0037:
            if (r0 == 0) goto L_0x004a
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            r1 = r0
            goto L_0x0016
        L_0x003e:
            r0 = move-exception
            java.lang.String r2 = "SurfaceDanmakuView"
            java.lang.String r3 = "Exception locking surface"
            com.tencent.mm.danmaku.e.e.e(r2, r3, r0)
        L_0x0048:
            r0 = r1
            goto L_0x0037
        L_0x004a:
            java.util.concurrent.locks.ReentrantLock r0 = r5.gQd
            r0.unlock()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.danmaku.render.f.lockHardwareCanvas():android.graphics.Canvas");
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final void unlockCanvasAndPost(Canvas canvas) {
        AppMethodBeat.i(241714);
        if (!this.gQh) {
            this.gQc.unlockCanvasAndPost(canvas);
            AppMethodBeat.o(241714);
        } else if (a.atq()) {
            this.gQc.unlockCanvasAndPost(canvas);
            AppMethodBeat.o(241714);
        } else {
            this.gQc.getSurface().unlockCanvasAndPost(canvas);
            if (this.gQd != null) {
                this.gQd.unlock();
            }
            AppMethodBeat.o(241714);
        }
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final void a(d.a aVar) {
        this.gQa = aVar;
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(241715);
        this.mSurfaceView.setOnTouchListener(onTouchListener);
        AppMethodBeat.o(241715);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        if (r0 == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        if (com.tencent.mm.danmaku.f.a.atq() != false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        r0 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void surfaceCreated(android.view.SurfaceHolder r7) {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.danmaku.render.f.surfaceCreated(android.view.SurfaceHolder):void");
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        AppMethodBeat.i(241717);
        if (this.gQa != null) {
            this.gQa.ash();
        }
        e.i("SurfaceDanmakuView", "surfaceChanged, width = " + i3 + ", height = " + i4);
        AppMethodBeat.o(241717);
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final float atd() {
        AppMethodBeat.i(241718);
        float y = this.mSurfaceView.getY();
        AppMethodBeat.o(241718);
        return y;
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final void unlock() {
        AppMethodBeat.i(241719);
        ReentrantLock reentrantLock = (ReentrantLock) c.b(SurfaceView.class, "mSurfaceLock", this.mSurfaceView);
        Surface surface = this.mSurfaceView.getHolder().getSurface();
        try {
            Method declaredMethod = Surface.class.getDeclaredMethod("nativeRelease", Long.TYPE);
            declaredMethod.setAccessible(true);
            Field declaredField = Surface.class.getDeclaredField("mLockedObject");
            declaredField.setAccessible(true);
            Long l = (Long) declaredField.get(surface);
            e.i("surface_lock", "SurfaceDanmakuView unlock lockObjectValue = ".concat(String.valueOf(l)));
            if (l.longValue() != 0) {
                declaredMethod.invoke(null, l);
            }
            declaredField.setLong(surface, 0);
            e.d("surface_lock", "SurfaceDanmakuView unlock: release success");
            e.i("surface_lock", "SurfaceDanmakuView unlock surfaceLock = ".concat(String.valueOf(reentrantLock)));
            if (reentrantLock != null && reentrantLock.isLocked()) {
                e.i("surface_lock", "SurfaceDanmakuView unlock");
                reentrantLock.unlock();
                AppMethodBeat.o(241719);
                return;
            }
        } catch (Exception e2) {
            e.e("surface_lock", "SurfaceDanmakuView unlock:release failed", e2);
            e.i("surface_lock", "SurfaceDanmakuView unlock surfaceLock = ".concat(String.valueOf(reentrantLock)));
            if (reentrantLock != null && reentrantLock.isLocked()) {
                e.i("surface_lock", "SurfaceDanmakuView unlock");
                reentrantLock.unlock();
                AppMethodBeat.o(241719);
                return;
            }
        } catch (Throwable th) {
            e.i("surface_lock", "SurfaceDanmakuView unlock surfaceLock = ".concat(String.valueOf(reentrantLock)));
            if (reentrantLock != null && reentrantLock.isLocked()) {
                e.i("surface_lock", "SurfaceDanmakuView unlock");
                reentrantLock.unlock();
            }
            AppMethodBeat.o(241719);
            throw th;
        }
        AppMethodBeat.o(241719);
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final void a(d.b bVar) {
        AppMethodBeat.i(241720);
        if (bVar != null) {
            bVar.l(null);
        }
        AppMethodBeat.o(241720);
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(241721);
        if (this.gQa != null) {
            this.gQa.asi();
        }
        e.i("SurfaceDanmakuView", "surfaceDestroyed");
        AppMethodBeat.o(241721);
    }
}
