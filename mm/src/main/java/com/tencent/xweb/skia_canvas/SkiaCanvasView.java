package com.tencent.xweb.skia_canvas;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.skia_canvas.VSyncRenderer;

public class SkiaCanvasView implements VSyncRenderer.PresentCallback {
    private static final String TAG = "SkiaCanvasView";
    private final SkiaCanvasApp mApp;
    private boolean mHasSurfaceSwapped;
    private volatile boolean mIsForeground;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private final String mTag;
    private final long mViewID;

    private native void nativeCreateCanvas(String str, long j2, Surface surface);

    private native void nativeDoPresent(long j2, boolean z);

    private native void nativeRemoveCanvas(long j2);

    private native void nativeSwapSurface(long j2, Surface surface);

    private native boolean nativeUpdateBitmap(long j2, Bitmap bitmap, int i2, int i3, int i4, int i5);

    static /* synthetic */ void access$400(SkiaCanvasView skiaCanvasView, String str, long j2, Surface surface) {
        AppMethodBeat.i(217586);
        skiaCanvasView.nativeCreateCanvas(str, j2, surface);
        AppMethodBeat.o(217586);
    }

    static /* synthetic */ void access$600(SkiaCanvasView skiaCanvasView, long j2) {
        AppMethodBeat.i(217587);
        skiaCanvasView.nativeRemoveCanvas(j2);
        AppMethodBeat.o(217587);
    }

    static /* synthetic */ void access$700(SkiaCanvasView skiaCanvasView, long j2, Surface surface) {
        AppMethodBeat.i(217588);
        skiaCanvasView.nativeSwapSurface(j2, surface);
        AppMethodBeat.o(217588);
    }

    public SkiaCanvasView(SkiaCanvasApp skiaCanvasApp, final SurfaceTexture surfaceTexture, String str, long j2) {
        AppMethodBeat.i(217581);
        new StringBuilder("SkiaCanvasView created ").append(this);
        this.mApp = skiaCanvasApp;
        this.mTag = str;
        this.mViewID = j2;
        checkAndPost(new Runnable() {
            /* class com.tencent.xweb.skia_canvas.SkiaCanvasView.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(217577);
                SkiaCanvasView.this.mSurfaceTexture = surfaceTexture;
                SkiaCanvasView.this.mSurface = new Surface(surfaceTexture);
                SkiaCanvasView.access$400(SkiaCanvasView.this, SkiaCanvasView.this.mTag, SkiaCanvasView.this.mViewID, SkiaCanvasView.this.mSurface);
                SkiaCanvasView.this.mIsForeground = true;
                VSyncRenderer.getInstance().addPresentCallback(SkiaCanvasView.this);
                AppMethodBeat.o(217577);
            }
        });
        AppMethodBeat.o(217581);
    }

    @Override // com.tencent.xweb.skia_canvas.VSyncRenderer.PresentCallback
    public void doPresent() {
        AppMethodBeat.i(217582);
        if (this.mIsForeground) {
            nativeDoPresent(this.mViewID, this.mHasSurfaceSwapped);
            this.mHasSurfaceSwapped = false;
            VSyncRenderer.getInstance().triggerNextVSync();
        }
        AppMethodBeat.o(217582);
    }

    public void notifyVisibilityChanged(boolean z) {
        AppMethodBeat.i(217583);
        if (z != this.mIsForeground) {
            this.mIsForeground = z;
            if (z) {
                checkAndPost(new Runnable() {
                    /* class com.tencent.xweb.skia_canvas.SkiaCanvasView.AnonymousClass2 */

                    public void run() {
                        AppMethodBeat.i(217578);
                        VSyncRenderer.getInstance().triggerNextVSync();
                        AppMethodBeat.o(217578);
                    }
                });
            }
        }
        AppMethodBeat.o(217583);
    }

    private void checkAndPost(Runnable runnable) {
        AppMethodBeat.i(217584);
        this.mApp.checkAndPostOnWorkingThread(runnable);
        AppMethodBeat.o(217584);
    }

    public long getId() {
        return this.mViewID;
    }

    public void recycle() {
        AppMethodBeat.i(4296);
        checkAndPost(new Runnable() {
            /* class com.tencent.xweb.skia_canvas.SkiaCanvasView.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(217579);
                new StringBuilder("SkiaCanvasView recycle ").append(SkiaCanvasView.this);
                SkiaCanvasView.access$600(SkiaCanvasView.this, SkiaCanvasView.this.mViewID);
                VSyncRenderer.getInstance().removePresentCallback(SkiaCanvasView.this);
                AppMethodBeat.o(217579);
            }
        });
        AppMethodBeat.o(4296);
    }

    public void swapSurface(final SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(4297);
        checkAndPost(new Runnable() {
            /* class com.tencent.xweb.skia_canvas.SkiaCanvasView.AnonymousClass4 */

            public void run() {
                AppMethodBeat.i(217580);
                new StringBuilder("SkiaCanvasView swapSurface ").append(SkiaCanvasView.this).append(" old one is ").append(SkiaCanvasView.this.mSurfaceTexture).append(" new  one is ").append(surfaceTexture);
                if (surfaceTexture != SkiaCanvasView.this.mSurfaceTexture) {
                    SkiaCanvasView.this.mSurfaceTexture = surfaceTexture;
                    SkiaCanvasView.this.mSurface = new Surface(surfaceTexture);
                    SkiaCanvasView.access$700(SkiaCanvasView.this, SkiaCanvasView.this.mViewID, SkiaCanvasView.this.mSurface);
                    SkiaCanvasView.this.mHasSurfaceSwapped = true;
                }
                AppMethodBeat.o(217580);
            }
        });
        AppMethodBeat.o(4297);
    }

    public Bitmap getSnapshot(Rect rect) {
        AppMethodBeat.i(217585);
        if (!this.mApp.isRunOnWorkingThread()) {
            IllegalStateException illegalStateException = new IllegalStateException("getSnapshot must be called on js thread.");
            AppMethodBeat.o(217585);
            throw illegalStateException;
        } else if (rect.width() <= 0 || rect.height() <= 0) {
            AppMethodBeat.o(217585);
            return null;
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
            if (nativeUpdateBitmap(this.mViewID, createBitmap, rect.left, rect.top, rect.width(), rect.height())) {
                AppMethodBeat.o(217585);
                return createBitmap;
            }
            AppMethodBeat.o(217585);
            return null;
        }
    }

    private void notifyTextureSizeChanged(int i2, int i3) {
        AppMethodBeat.i(4298);
        if (!this.mApp.isRunOnWorkingThread()) {
            IllegalStateException illegalStateException = new IllegalStateException("notifyTextureSizeChanged must be called on js thread.");
            AppMethodBeat.o(4298);
            throw illegalStateException;
        }
        new StringBuilder("notifyTextureSizeChanged called with ").append(i2).append(" / ").append(i3).append(" this: ").append(this);
        this.mSurfaceTexture.setDefaultBufferSize(i2, i3);
        AppMethodBeat.o(4298);
    }

    public static String version() {
        return "8fda81f789ab1498974995e0c7217754d2c2749e/1.0";
    }
}
