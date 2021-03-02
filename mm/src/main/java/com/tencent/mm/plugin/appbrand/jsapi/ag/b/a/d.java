package com.tencent.mm.plugin.appbrand.jsapi.ag.b.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.xweb.skia_canvas.SkiaCanvasApp;
import com.tencent.xweb.skia_canvas.SkiaCanvasView;

public class d extends TextureView {
    private SkiaCanvasApp mApp;
    private String mAppId;
    private SkiaCanvasView mJD;
    private a mJE;
    private int mViewId;

    public interface a {
        void onReady();
    }

    public d(Context context, SkiaCanvasApp skiaCanvasApp, int i2, String str) {
        super(context);
        AppMethodBeat.i(215834);
        this.mApp = skiaCanvasApp;
        this.mViewId = i2;
        this.mAppId = str;
        setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.d.AnonymousClass2 */

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                AppMethodBeat.i(139457);
                Log.i("Luggage.SkiaCanvasTextureView", "surface:%s width:%d height:%d viewId%d", surfaceTexture, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(d.this.mViewId));
                if (d.this.mJD == null) {
                    d.this.mJD = new SkiaCanvasView(d.this.mApp, surfaceTexture, d.this.mAppId, (long) d.this.mViewId);
                    if (d.this.mJE != null) {
                        d.this.mJE.onReady();
                    }
                    b.a(d.this.mViewId, d.this.mJD);
                }
                AppMethodBeat.o(139457);
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
                AppMethodBeat.i(139458);
                Log.i("Luggage.SkiaCanvasTextureView", "onSurfaceTextureSizeChanged:%s width:%d height:%d viewId%d", surfaceTexture, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(d.this.mViewId));
                AppMethodBeat.o(139458);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(139459);
                Log.i("Luggage.SkiaCanvasTextureView", "onSurfaceTextureDestroyed:%s", surfaceTexture);
                if (d.this.mJD != null) {
                    d.this.mJD.recycle();
                }
                AppMethodBeat.o(139459);
                return true;
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
        setOpaque(false);
        AppMethodBeat.o(215834);
    }

    public void setOnReadyListener(a aVar) {
        AppMethodBeat.i(139461);
        this.mJE = aVar;
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(139456);
                if (!(d.this.mJD == null || d.this.mJE == null)) {
                    d.this.mJE.onReady();
                }
                AppMethodBeat.o(139456);
            }
        });
        AppMethodBeat.o(139461);
    }

    public final void notifyVisibilityChanged(boolean z) {
        AppMethodBeat.i(215835);
        if (this.mJD != null) {
            this.mJD.notifyVisibilityChanged(z);
        }
        AppMethodBeat.o(215835);
    }

    public final void release() {
        AppMethodBeat.i(215836);
        if (this.mJD != null) {
            this.mJD.recycle();
            b.remove(this.mViewId);
        }
        AppMethodBeat.o(215836);
    }
}
