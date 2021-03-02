package com.tencent.luggage.xweb_ext.extendplugin.component;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class q {
    private static final Field cEl;
    private final List<b> mListeners = new ArrayList();
    private final SurfaceTexture mSurfaceTexture;

    static /* synthetic */ void b(q qVar) {
        AppMethodBeat.i(215553);
        qVar.onFrameAvailable();
        AppMethodBeat.o(215553);
    }

    static {
        AppMethodBeat.i(215554);
        Field field = null;
        try {
            field = SurfaceTexture.class.getDeclaredField("mOnFrameAvailableHandler");
            field.setAccessible(true);
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.SurfaceTextureWrapper", "get mOnFrameAvailableHandler fail since " + e2.toString());
        }
        cEl = field;
        AppMethodBeat.o(215554);
    }

    public static q d(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(215548);
        synchronized (surfaceTexture) {
            try {
                if (cEl == null) {
                    return null;
                }
                try {
                    Handler handler = (Handler) cEl.get(surfaceTexture);
                    if (handler == null) {
                        Log.w("MicroMsg.AppBrand.SurfaceTextureWrapper", "wrap, hookSurfaceTexture, originOnFrameAvailableHandler is null");
                        AppMethodBeat.o(215548);
                        return null;
                    } else if (handler instanceof a) {
                        Log.i("MicroMsg.AppBrand.SurfaceTextureWrapper", "wrap, hookSurfaceTexture, already hook");
                        q qVar = ((a) handler).cEo;
                        AppMethodBeat.o(215548);
                        return qVar;
                    } else {
                        q qVar2 = new q(surfaceTexture);
                        cEl.set(surfaceTexture, new a(handler, qVar2));
                        AppMethodBeat.o(215548);
                        return qVar2;
                    }
                } catch (Exception e2) {
                    Log.w("MicroMsg.AppBrand.SurfaceTextureWrapper", "wrap, hookSurfaceTexture fail since " + e2.toString());
                    AppMethodBeat.o(215548);
                    return null;
                }
            } finally {
                AppMethodBeat.o(215548);
            }
        }
    }

    private q(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(215549);
        this.mSurfaceTexture = surfaceTexture;
        AppMethodBeat.o(215549);
    }

    public final synchronized void a(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, Handler handler) {
        AppMethodBeat.i(215550);
        b bVar = new b(onFrameAvailableListener, handler);
        this.mListeners.remove(bVar);
        this.mListeners.add(bVar);
        AppMethodBeat.o(215550);
    }

    public final synchronized void a(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        AppMethodBeat.i(215551);
        this.mListeners.remove(new b(onFrameAvailableListener, null));
        AppMethodBeat.o(215551);
    }

    private synchronized void onFrameAvailable() {
        AppMethodBeat.i(215552);
        for (final b bVar : this.mListeners) {
            if (bVar.handler == null) {
                bVar.cEq.onFrameAvailable(this.mSurfaceTexture);
            } else {
                bVar.handler.post(new Runnable() {
                    /* class com.tencent.luggage.xweb_ext.extendplugin.component.q.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(215543);
                        bVar.cEq.onFrameAvailable(q.this.mSurfaceTexture);
                        AppMethodBeat.o(215543);
                    }
                });
            }
        }
        AppMethodBeat.o(215552);
    }

    static class a extends Handler {
        public final q cEo;
        private final Handler cEp;

        public a(Handler handler, q qVar) {
            super(handler.getLooper());
            AppMethodBeat.i(215544);
            this.cEp = handler;
            this.cEo = qVar;
            AppMethodBeat.o(215544);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(215545);
            this.cEp.handleMessage(message);
            q.b(this.cEo);
            AppMethodBeat.o(215545);
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        public final SurfaceTexture.OnFrameAvailableListener cEq;
        public final Handler handler;

        public b(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, Handler handler2) {
            this.cEq = onFrameAvailableListener;
            this.handler = handler2;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(215546);
            if (this == obj) {
                AppMethodBeat.o(215546);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.o(215546);
                return false;
            } else {
                boolean equals = this.cEq.equals(((b) obj).cEq);
                AppMethodBeat.o(215546);
                return equals;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(215547);
            int hash = Objects.hash(this.cEq);
            AppMethodBeat.o(215547);
            return hash;
        }
    }
}
