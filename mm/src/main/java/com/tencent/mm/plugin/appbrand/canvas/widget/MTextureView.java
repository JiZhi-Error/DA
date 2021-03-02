package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.plugin.appbrand.canvas.c.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MTextureView extends TextureView implements TextureView.SurfaceTextureListener, a {
    private final b laI = new b(this);
    private final Set<View.OnAttachStateChangeListener> laJ = new LinkedHashSet();
    private volatile MMHandler laM;
    private Runnable laN = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(145497);
            if (!MTextureView.this.isAvailable()) {
                AppMethodBeat.o(145497);
                return;
            }
            Canvas lockCanvas = MTextureView.this.lockCanvas();
            if (lockCanvas == null) {
                AppMethodBeat.o(145497);
                return;
            }
            synchronized (MTextureView.this.mLock) {
                try {
                    MTextureView.this.laP = true;
                } finally {
                    AppMethodBeat.o(145497);
                }
            }
            lockCanvas.drawColor(-1);
            MTextureView.this.o(lockCanvas);
            MTextureView.this.unlockCanvasAndPost(lockCanvas);
            synchronized (MTextureView.this.mLock) {
                try {
                    MTextureView.this.laP = false;
                    MTextureView.this.mLock.notifyAll();
                } finally {
                    AppMethodBeat.o(145497);
                }
            }
        }
    };
    private volatile boolean laP;
    private volatile Object mLock = new Object();

    public MTextureView(Context context) {
        super(context);
        AppMethodBeat.i(145498);
        init();
        AppMethodBeat.o(145498);
    }

    public MTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(145499);
        init();
        AppMethodBeat.o(145499);
    }

    public MTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(145500);
        init();
        AppMethodBeat.o(145500);
    }

    private void init() {
        AppMethodBeat.i(145501);
        setSurfaceTextureListener(this);
        ((Activity) getContext()).getWindow().setFlags(TPMediaCodecProfileLevel.HEVCMainTierLevel62, TPMediaCodecProfileLevel.HEVCMainTierLevel62);
        Paint paint = new Paint();
        paint.setColor(-1);
        this.laI.getDrawContext().kZq = paint;
        AppMethodBeat.o(145501);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public void setTraceId(String str) {
        AppMethodBeat.i(145502);
        this.laI.setTraceId(str);
        AppMethodBeat.o(145502);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public String getTraceId() {
        AppMethodBeat.i(145503);
        String traceId = this.laI.getTraceId();
        AppMethodBeat.o(145503);
        return traceId;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void bzg() {
        AppMethodBeat.i(145504);
        if (this.laM == null) {
            AppMethodBeat.o(145504);
            return;
        }
        this.laM.removeCallbacks(this.laN);
        this.laM.post(this.laN);
        AppMethodBeat.o(145504);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void U(Runnable runnable) {
        AppMethodBeat.i(145505);
        if (this.laM == null) {
            AppMethodBeat.o(145505);
            return;
        }
        this.laM.post(runnable);
        AppMethodBeat.o(145505);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public d getDrawContext() {
        AppMethodBeat.i(145506);
        d drawContext = this.laI.getDrawContext();
        AppMethodBeat.o(145506);
        return drawContext;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public void setDrawActionReportable(a aVar) {
        AppMethodBeat.i(145507);
        this.laI.setDrawActionReportable(aVar);
        AppMethodBeat.o(145507);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final boolean o(Canvas canvas) {
        AppMethodBeat.i(145508);
        boolean o = this.laI.o(canvas);
        AppMethodBeat.o(145508);
        return o;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void a(JSONArray jSONArray, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145509);
        this.laI.a(jSONArray, aVar);
        AppMethodBeat.o(145509);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void b(JSONArray jSONArray, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145510);
        this.laI.b(jSONArray, aVar);
        AppMethodBeat.o(145510);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void a(DrawCanvasArg drawCanvasArg, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145511);
        this.laI.a(drawCanvasArg, aVar);
        AppMethodBeat.o(145511);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void b(DrawCanvasArg drawCanvasArg, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145512);
        this.laI.b(drawCanvasArg, aVar);
        AppMethodBeat.o(145512);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void bzh() {
        AppMethodBeat.i(145513);
        this.laI.bzh();
        AppMethodBeat.o(145513);
    }

    public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(145514);
        if (this.laJ.contains(onAttachStateChangeListener)) {
            AppMethodBeat.o(145514);
            return;
        }
        this.laJ.add(onAttachStateChangeListener);
        super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(145514);
    }

    public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(145515);
        this.laJ.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(145515);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.b
    public final void onResume() {
        AppMethodBeat.i(145516);
        this.laI.onResume();
        AppMethodBeat.o(145516);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.b
    public final boolean isPaused() {
        return this.laI.mPause;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.g
    public String getSessionId() {
        AppMethodBeat.i(145517);
        String sessionId = this.laI.getSessionId();
        AppMethodBeat.o(145517);
        return sessionId;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.g
    public void setSessionId(String str) {
        AppMethodBeat.i(145518);
        this.laI.setSessionId(str);
        AppMethodBeat.o(145518);
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.d
    public void setStartTime(long j2) {
        AppMethodBeat.i(145519);
        this.laI.setStartTime(j2);
        AppMethodBeat.o(145519);
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.d
    public final void bzi() {
        AppMethodBeat.i(145520);
        this.laI.bzi();
        AppMethodBeat.o(145520);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(145521);
        Log.v("MicroMsg.MTextureView", "onSurfaceTextureAvailable");
        if (this.laM == null) {
            HandlerThread hz = com.tencent.f.c.d.hz("MTextureView#Rending-Thread", -19);
            hz.start();
            this.laM = new MMHandler(hz.getLooper());
        }
        Canvas lockCanvas = lockCanvas();
        if (lockCanvas == null) {
            AppMethodBeat.o(145521);
            return;
        }
        lockCanvas.drawColor(-1);
        unlockCanvasAndPost(lockCanvas);
        AppMethodBeat.o(145521);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(145522);
        Log.v("MicroMsg.MTextureView", "onSurfaceTextureSizeChanged");
        AppMethodBeat.o(145522);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(145523);
        Log.v("MicroMsg.MTextureView", "onSurfaceTextureDestroyed");
        this.laM.removeCallbacks(this.laN);
        this.laM.getLooper().quit();
        synchronized (this.mLock) {
            try {
                if (this.laP) {
                    try {
                        this.mLock.wait(1000);
                    } catch (InterruptedException e2) {
                        Log.e("MicroMsg.MTextureView", "await error : %s", android.util.Log.getStackTraceString(e2));
                    }
                }
            } catch (Throwable th) {
                AppMethodBeat.o(145523);
                throw th;
            }
        }
        this.laM = null;
        AppMethodBeat.o(145523);
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
