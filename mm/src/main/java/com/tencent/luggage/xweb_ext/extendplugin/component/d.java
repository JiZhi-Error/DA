package com.tencent.luggage.xweb_ext.extendplugin.component;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Choreographer;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class d<TextureImageViewLike extends View & h> implements com.tencent.mm.plugin.appbrand.jsapi.s.h<TextureImageViewLike> {
    private static com.tencent.mm.plugin.appbrand.jsapi.s.d cDX = new com.tencent.mm.plugin.appbrand.jsapi.s.d() {
        /* class com.tencent.luggage.xweb_ext.extendplugin.component.d.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.d
        public final boolean PB() {
            return true;
        }
    };
    private static Handler sMainHandler = null;
    protected final String cDW = ("MicroMsg.AppBrand.AbsXWebVideoContainerChannel#" + hashCode());
    private SparseArray<TextureView.SurfaceTextureListener> cDY = new SparseArray<>();
    private SparseArray<Pair<Surface, SurfaceTexture>> cDZ = new SparseArray<>();
    private boolean cEa = false;

    /* access modifiers changed from: protected */
    public abstract a c(TextureImageViewLike textureimageviewlike, Runnable runnable);

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.h
    public final void cf(TextureImageViewLike textureimageviewlike) {
        Log.d(this.cDW, "recycleVideoContainerView");
        this.cDY.remove(textureimageviewlike.hashCode());
        textureimageviewlike.setSurfaceTextureListener(null);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.h
    public final com.tencent.mm.plugin.appbrand.jsapi.s.d Pz() {
        return cDX;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.h
    public final void d(TextureImageViewLike textureimageviewlike, Runnable runnable) {
        Log.i(this.cDW, "transferTo, textureImageViewLike: ".concat(String.valueOf(textureimageviewlike)));
        this.cEa = true;
        textureimageviewlike.setImageBitmap(null);
        int hashCode = textureimageviewlike.hashCode();
        TextureView.SurfaceTextureListener surfaceTextureListener = this.cDY.get(hashCode);
        if (surfaceTextureListener != null) {
            Log.w(this.cDW, "transferTo, surfaceTextureListener is not null");
            SurfaceTexture surfaceTexture = textureimageviewlike.getSurfaceTexture();
            if (surfaceTexture != null) {
                surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, textureimageviewlike.getWidth(), textureimageviewlike.getHeight());
            }
            if (runnable != null) {
                Log.i(this.cDW, "transferTo, run afterTransferToTask when surfaceTextureListener is not null");
                runnable.run();
                return;
            }
            return;
        }
        a c2 = c(textureimageviewlike, runnable);
        Log.d(this.cDW, "transferTo, setSurfaceTextureListener");
        textureimageviewlike.setSurfaceTextureListener(c2);
        this.cDY.put(hashCode, c2);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.h
    public void e(TextureImageViewLike textureimageviewlike, Runnable runnable) {
        this.cEa = false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.h
    public final void cg(TextureImageViewLike textureimageviewlike) {
        Log.i(this.cDW, "onPlayEndWorkaround, textureImageViewLike: ".concat(String.valueOf(textureimageviewlike)));
        if (!this.cEa) {
            Log.i(this.cDW, "onPlayEndWorkaround, video is not in pip container");
        }
        Bitmap bitmap = textureimageviewlike.getBitmap();
        if (bitmap == null) {
            Log.w(this.cDW, "onPlayEndWorkaround, bitmap is null");
        } else {
            textureimageviewlike.setImageBitmap(bitmap);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(final Runnable runnable, SurfaceTexture surfaceTexture) {
        Log.i(this.cDW, "scheduleAfterTransferFromTask");
        final q d2 = q.d(surfaceTexture);
        if (d2 != null) {
            Log.i(this.cDW, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback");
            final com.tencent.f.i.d<?> n = com.tencent.f.h.RTc.n(runnable, 600);
            final AnonymousClass3 r2 = new Runnable() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.d.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(215540);
                    Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
                        /* class com.tencent.luggage.xweb_ext.extendplugin.component.d.AnonymousClass3.AnonymousClass1 */
                        private int acf = 0;

                        public final void doFrame(long j2) {
                            AppMethodBeat.i(215539);
                            Log.i(d.this.cDW, "scheduleAfterTransferFromTask, doFrame");
                            this.acf++;
                            if (2 <= this.acf) {
                                n.cancel(true);
                                runnable.run();
                                AppMethodBeat.o(215539);
                                return;
                            }
                            Choreographer.getInstance().postFrameCallback(this);
                            AppMethodBeat.o(215539);
                        }
                    });
                    AppMethodBeat.o(215540);
                }
            };
            d2.a(new SurfaceTexture.OnFrameAvailableListener() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.d.AnonymousClass4 */

                public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    AppMethodBeat.i(215541);
                    Log.i(d.this.cDW, "scheduleAfterTransferFromTask, onFrameAvailable");
                    r2.run();
                    d2.a(this);
                    AppMethodBeat.o(215541);
                }
            }, PA());
            return;
        }
        Log.i(this.cDW, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback when surfaceTextureWrapper is null");
        com.tencent.f.h.RTc.n(runnable, 50);
    }

    private static Handler PA() {
        if (sMainHandler == null) {
            sMainHandler = new Handler(Looper.getMainLooper());
        }
        return sMainHandler;
    }

    public abstract class a<TextureImageViewLike> implements TextureView.SurfaceTextureListener {
        protected final TextureImageViewLike cEi;
        private final int cEj;
        private volatile Runnable cEk;

        /* access modifiers changed from: protected */
        public abstract void PC();

        /* access modifiers changed from: protected */
        public abstract boolean b(Surface surface, int i2, int i3);

        protected a(TextureImageViewLike textureimageviewlike, Runnable runnable) {
            this.cEi = textureimageviewlike;
            this.cEj = textureimageviewlike.hashCode();
            this.cEk = runnable;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Log.d(d.this.cDW, ((Object) this.cEi) + " onSurfaceTextureAvailable, surfaceTexture: %s, width: %d, height: %d", surfaceTexture, Integer.valueOf(i2), Integer.valueOf(i3));
            a(surfaceTexture, i2, i3);
            Runnable runnable = this.cEk;
            this.cEk = null;
            if (runnable != null) {
                d.a(d.this, runnable, surfaceTexture);
            }
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            if (!d.this.cEa) {
                Log.w(d.this.cDW, "onSurfaceTextureSizeChanged, video is not in pip container");
            } else {
                a(surfaceTexture, i2, i3);
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            Log.d(d.this.cDW, ((Object) this.cEi) + " onSurfaceTextureDestroyed, surfaceTexture: " + surfaceTexture);
            PC();
            Pair pair = (Pair) d.this.cDZ.get(this.cEj);
            if (pair != null) {
                d.this.cDZ.remove(this.cEj);
                ((Surface) pair.first).release();
            }
            return true;
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        private void a(SurfaceTexture surfaceTexture, int i2, int i3) {
            Surface surface;
            Pair pair = (Pair) d.this.cDZ.get(this.cEj);
            if (pair == null || pair.second != surfaceTexture) {
                surface = new Surface(surfaceTexture);
                pair = Pair.create(surface, surfaceTexture);
            } else {
                surface = (Surface) pair.first;
            }
            if (b(surface, i2, i3)) {
                d.this.cDZ.put(this.cEj, pair);
            }
        }
    }

    static /* synthetic */ void a(d dVar, final Runnable runnable, SurfaceTexture surfaceTexture) {
        Log.i(dVar.cDW, "scheduleAfterTransferToTask");
        final q d2 = q.d(surfaceTexture);
        final com.tencent.f.i.d<?> n = com.tencent.f.h.RTc.n(runnable, 300);
        if (d2 != null) {
            d2.a(new SurfaceTexture.OnFrameAvailableListener() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.d.AnonymousClass2 */

                public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    AppMethodBeat.i(215538);
                    Log.i(d.this.cDW, "scheduleAfterTransferToTask, onFrameAvailable");
                    n.cancel(true);
                    runnable.run();
                    d2.a(this);
                    AppMethodBeat.o(215538);
                }
            }, PA());
        }
    }
}
